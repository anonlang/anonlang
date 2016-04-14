# Syntax: String Concatenation

There are many different ways that programming languages offer the ability to append text.

Here's a quick summary of different syntactic sugar used by some languages:

    Many languages, like Java, overload `+`
    Haskell uses `++`
    PHP uses `.`
    Lua use `..` ([source](http://www.lua.org/pil/3.4.html))
    Lisp uses `(concatenate 'string "all" " " "together" " " "now")`, which gives  "all together now"

The reason some languages choose not to overload `+` for text concatenation is to prevent mistakes by limiting/removing implicit conversions.
