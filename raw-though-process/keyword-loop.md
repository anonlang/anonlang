# Loop

Perform a task multiple times or in sequence.



## Usage

    loop [ ... ] ;; Loop forever

    loop 10 [ ... ] ;; Loop 10 times

    loop count in 1..10 [ ;; Inclusive bounds
        ;; Do something, possibly with iteration count
    ]

    loop node in nodes [ visit node ] ;; Loop over each item in a group

    loop ch in 'hello' [ out ch newline ] ;; Loop over each character, output each character with a newline

    loop wd in 'hello world' by r'\w' [ out wd ] ;; Loop over word tokens (Note: The whitespace would be gone in this case when output each word)

    loop is-wait [ sleep 500 ] ;; Loop while is-wait is true, aka until is-wait is false



## Discussion

- There should be a 'loop' keyword in order to distinguish it from a sequence input? Would it be possible leave out and still be understandable? It probably could be understandable after looking at it closely and seeing the two periods, but having the 'loop' keyword makes it more visible at a quick glance and likely better for new-comers.

- What syntax should be used for variable loop bounds? What if that variable value changes during the loop?

- What syntax for looping backwards through numbers/group/collection? Maybe don't need? What if user puts `loop 10..1 [ ... ]`?

- Should support be added for looping through text/characters linearly, as in `a...z`? Or, this might lead to having users being able to define how the looping should be performed. Then, arbitrary start and stop bounds? Maybe the only one supported by core/std-lib/default would be 'number..number'? Especially because it may be hard to do this for every language? Hmm, unless we just convert values to unicode and walk up/down from there? That sounds like a fun idea. But, then do we add support for non-UTF8 also? There are hundreds of different encodings. This brings us back to having a syntax for users being able to define how things loop. Hmm, basically this means a custom 'loop' would just be the syntax for a 'clean' goto call.

- Should there be a `loop-parallel`? If the language paradigm is that space and time isn't of concern, then it wouldn't matter. But, realistically, there are multi-core devices that people want to use. Maybe this loop concurrency would be an implementation detail and compilers should be able to know when things can be done in parallel or not. Addition might be done in groups, possibly looking like a 'tree'.
