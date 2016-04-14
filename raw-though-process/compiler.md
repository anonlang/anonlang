# Anonlang Compiler Notes

Top-Down Operator Precedence
- Simple to understand
- Trivial to implement
- Easy to use
- Extremely efficient
- Very flexible
- Beautiful

Basically, what do we expect to see to the left of the token?
- led : left denotation
- nud : null denotation (for unary operators)

Basically, ([source](https://www.youtube.com/watch?v=Nlqv6NtBXcA))

    var prototype_token = {
      nud: function () {
        this.error("Undefined");
      },
      led: function (left) {
        this.error("Missing operator");
      },
      error: function (message) {
        ...
      },
      lbp: 0 // left binding power
    };

    var symbol_table = {};

    functino symbol(id, bp) {
      var s = symbol_table[id];
      bp = bp || 0;
      if (s) {
        if (bp >= s.lbp) {
          s.lbp = bp;
        }
      } else {
        s = Object.create(prototype_token);
        s.id = s.value = id;
        s.lbp = bp;
        symbol_table[id] = s;
      }
      return s;
    }

    symbol(":");
    symbol(";");
    symbol(",");
    symbol(")");
    symbol("]");
    symbol("}");
    symbol("else");

    symbol("(end)");
    symbol("(word)");

    symbol("+", 60).led = function (left) {
      this.first = left;
      this.second = expression(60);
      this.arity = "binary";
      return this;
    };

    function infix(id, bp, led) {
      var s = symbol(id, bp);
      s.led = led || function (left) {
        this.first = left;
        this.second = expression(bp);
        this.arity = "binary";
        return this;
      };
      return s;
    }
    infix("+", 60);
    infix("-", 60);
    infix("*", 70); //*
    infix("/", 70);
    infix("===", 50);
    infix("!==", 50);
    infix("<", 50);
    infix("<=", 50);
    infix(">", 50);
    infix(">=", 50);
    infix("?", 20, function led(left) {
      this.first = left;
      this.second = expression(0);
      advance(":");
      this.third = expression(0);
      this.arity = "ternary";
      return this;
    });

    function infixr(id, bp, led) {
      var s = symbol(id, bp);
      s.led = led || function (left) {
        this.first = left;
        this.second = epxression(bp - 1);
        this.arity = "binary";
        return this;
      };
      return s;
    }

    function assignment(id) {
      return infixr(id, 10, function (left) {
        if (left.arity !== "name" && left.id !== "." && left.id !== "[") {
          left.error("Bad lvalue.");
        }
        this.first = left;
        this.second = expression(9);
        this.assignment = true;
        this.arity = "binary";
        return this;
      });
    }
    assignment("=");
    assignment("+=");
    assignment("-=");

    function prefix(id, nud) {
      var s = symbol(id);
      s.nud = nud || function () {
        this.first = expression(80);
        this.arity = "unary";
      };
      return s;
    }
    prefix("+");
    prefix("-");
    prefix("!");
    prefix("typeof");
    prefix("(", function () {
      var e = expression(0);
      advance(")");
      return e;
    });

    function statement() {
      var exp, tok = token;
      if (tok.fud) {
        advance();
        return tok.fud();
      }
      exp = expression(0);
      if (!exp.assignment && exp.id !== "(") {
        exp.error("Bad expression statement.");
      }
      advance(";");
      return exp;
    }
    function statements() {
      var array = [];
      while (token.nud || token.fud) {
        a.push(statement());
      }
      return array;
    }
    function block() {
      advance("{");
      var a = statements();
      advance("}");
      return a;
    }

    function stmt(id, f) {
      var s = symbol(id);
      s.fud = f;
      return s;
    }
    stmt("if", function () {
      advance("(");
      this.first = expression(0);
      advance(")");
      this.second = block();
      if (token.id === "else") {
        advance("else");
        this.third = token.id === "if" ? statement() : block();
      }
      this.arity = "statement";
      return this;
    });
    // BCPL
    stmt("if", function () {
      this.first = expression(0);
      this.second = block();
      if token.id === "else" {
        advance("else");
        this.third = token.id === "if" ? statement() : block();
      }
      this.arity = "statement";
      return this;
    });
    // Algol 68
    stmt("if", function () {
      this.first = expression(0);
      advance("then");
      this.second = statements();
      if token.id === "else" then
        advance("else");
        this.third = statements();
      fi
      advance("fi");
      this.arity = "statement";
      return this;
    });

    function expression(rbp) {
      var left, tok = token;
      advance();
      left = tok.nud();
      while (rbp < token.lbp) {
        tok = token;
        advance();
        left = tok.led(left);
      }
      return left;
    }

The above would create a AST similar to:

    // a = b + c;
    {
      id: "=",
      arity: "binary",
      first: {id: "a", arity: "word"},
      second: {
        id: "+",
        arity: "binary",
        first: {id: "b", arity: "word"},
        second: {id: "c", arity: "word"}
      }
    }
