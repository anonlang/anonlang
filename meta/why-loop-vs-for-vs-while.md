# Using 'loop' vs 'for' vs 'while' vs 'until' #

In various languages, there are plenty of different ways to loop through groups, lists, arrays, and other collections.

Many other languages provide multiple different ways to loop. Some people may use a for-loop, others may prefer a while-loop, and still others may use a lesser known until-loop.

A key theme of Anonlang is 'power through simplicity'. So, there is one way to loop code (besides recursion). The 'loop' keywords shows and tells what the code will be doing. More code across projects and teams will look familiar.

And now, in Anonlang, you don't have to pause to think if you want to use a for-loop or a while-loop.. just go straight to the loop.

    ;; Loop forever
    loop [
      ;; Do something
    ]

    ;; Loop 10 times
    loop 10 [ ... ]

    ;; Nested loops with indexes
    loop i in 1..10 [
      loop j in 1..10 [ ... ]
    ]

    ;; Loop through a group or collection
    loop node in nodes [ ... ]
    loop ch in 'hello' [ ... ]
    loop key, value in my-map [ ... ]

    ;; Loop while a variable is true, aka until a variable is false
    loop is-condition [ ... ]


    ;; Anonlang v2 ideas. These are not finalized APIs yet.
    loop wd in 'hello world' by r' ' [ ... ]
    loop ch in 'alpha bet' by 2
    loop-parallel [ ... ]

Note that in each example, there is minimal extra tokens to type to keep Anonlang code readable and easily maintainable.
