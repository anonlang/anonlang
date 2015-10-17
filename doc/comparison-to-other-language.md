# Anonlang Language Comparison #

Anonlang started out as a concept language with the idea of, 'what would the future programming language environment look like if it was designed from scratch with minimal biases?'

Most languages of the past have been designed to overcome the limitations of the past. Anonlang, as a future language, does not share the same limitations. The first concept versions of Anonlang were thought of in a [mostly] vaccuum, separate of all other languages. Then, more research was done to find similarities in other languages to make sure that mistakes of the past wouldn't be repeated.

This file shows the similarities of past languages and can be used to help learn Anonlang if another language is already known.



## Overall Concept ##
Even though Anonlang was made in a [mostly] vaccuum, it shares many commonalities of Lisp, Ruby, Haskell, and Ceylon (and a few more commonalities with other past languages). Though, Anonlang wouldn't have been developed if it was just a simple copy-and-paste of other languages. There are some fundamental changes and differences at the lowest levels and highest levels.


### Target Level ###
Anonlang allows developing at a low level at a high level; The machine's bit-size is abstracted out by default.



## Assignments ##
Anonlang does not differentiate between a 'variable' and 'function'. The keyword 'alias' is used instead. Differentiations are made only between whether the 'alias' should be calculated once or calculated each time the 'alias' is accessed.

Similarly, in Ceylon, a class's variable and zero-argument-function are accessed the same way; Changing the internals doesn't require a change from the API caller. Also, Ruby and other languages that don't require parenthesis for 'functions' have the same look for class attribute and method.

Somewhat similarly, [OCaml's 'let'](http://ocaml.org/learn/tutorials/structure_of_ocaml_programs.html) keyword could be a reference to a 'function' or 'variable', though they have a separate assignment operator for both.


## Garbage Collection ##
Anonlang has optional garbage collection that can be defined for any scope.

Most languages have a binary garbage collector: on for all code or off for all code. Though, D and/or Rust are working on an optional garbage collector.


## Lisp-y Notes ##
Anonlang has a form of prefix expressions, but the operator goes outside of the brackets, while the arguments go inside the brackets (or brackets optional if the number of arguments is known).
