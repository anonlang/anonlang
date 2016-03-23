# Anonlang #

The top priority for this language is developer productivity, and more specifically, quickly getting ideas to implementations and running. Another top focus is typing speed, comfort, and flow, more about that later.

Developers should prefer using the high-level abstractions, but the low-levels are fully accessible if needed.

Some describe Anonlang as having the power of Lisp with readability elegance of Ruby.

<!-- Anonlang: An abstraction of language, that you can program in. -->



## Sample Code for an App ##

    config [
      name 'My Minimal App'
    ]
    alias root layout [
      text 'Hello, World!'
    ]
    show-window root



## Top Reasons To Use Anonlang ##

### A joy to program in ###
Typing comfort is a huge part of Anonlang. There is a minimal need of using the shift-key in the core language. To define blocks/scopes, the square brackets are used instead of parenthesis or curly braces. This makes sense considering how much they are used in every program. Similar decision have been made, where the more often used features are easier to type than lesser used features.

### Quick to learn and get started ###
There are just a few general rules to the language. Also, it's just a small download to run Anonlang programs directly on your computer.


- Three data types:
  - `boolean` which can be `true` or `false`
  - `number` integer or floating, this keeps track of sig figs used
  - `text` is always within single quotes, ex: `'my text'`
    - A variable can be included in text by surrounding it with semi-colons, ex: `hi ;name;!`]
    - Concat text using `++`

- Single-line comments start with `;;`
- Multi-line comments are between `[;` and `;]`


#### Keywords ####

    alias, loop

    Examples:

    alias get-current-time date.now.time ;; Create lazy pointer to something without running it
    alias nodes node-group [
      node [ 'en', 'hello' ]
      node [ 'es', 'hola' ]
      node [ 'jp', 'konnichiwa' ]
    ]

    loop [ ... ] ;; Loop forever
    loop 5 [ ... ] ;; Loop 5 times
    loop count in 1..5 [ output count ] ;; Loop with reference to iteration
    loop node in nodes [ visit node ] ;; Loop over each item
    loop ch in 'hello' [ output ch ] ;; Loop over each character
    loop wd in 'hello world' by r'\w' [ out wd ] ;; Loop over word tokens
    loop is-wait [ sleep 500 ] ;; Loop until is-wait is false, aka while is-wait is true

    loop-parallel [] ;; When order of calls doesn't matter.



## App Lifecycle ##

Apps have a simple life-cycle:

    start
      |
      V
    stop

Apps with GUI have:

    start
      |
      V
    show <--+
      |     |
      V     |
    hide ---+
      |
      V
    stop

Though, simple apps (or scripts) don't need to worry about that:

    ;; A simple app
    input a
    output 'Hello, ;a;!'



## Paradigm ##
Anonlang is not based on any language, but it does share many commonalities with others.

### Everything is a Everything ###

- A variable is a function with zero inputs and one output.
- A function is a class with code on initialization and optional output. Or, another way, a class is a function that returns itself.
- Classes connecting to one another is the basis for a graph data structure, which in turn is the base for trees and linked lists. Arrays could be simulated with a graph or linked list, not paying attention to performance.

These are all first-class citizens in Anonlang.

### What If? ###

- What if there was a programming language where you don't have to worry about performance? Quite different without many different data structures and algorithms?
- What if there was a programming language where the language was designed after the modern standard keyboard layout?
  - Use square bracket more than curly brace and parenthesis?
- What if there was a programming language that had a minimum number of tokens to type? What would it look like? Likely, somewhat declarative.



## Background ##
This is a 10-year project to learn and re-think and re-implement programming. All assumptions will be questioned without bias.

Some ideas about possible generalized axioms:

- Everything has an input and output.





<!-- Design Philosophy: Re-using common syntax is NOT a requirement. -->
