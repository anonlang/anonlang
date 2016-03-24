# Input and Output

Provide input and output for functions and programs.

Rather than using full 'input' and 'output' keywords, the 'in' and 'out' keywords will be used. This is because these keywords will be used a lot and not much readability is reduced. It would be nice to have half to type, though would it be more confusing for new programmers?
  - Hmm, Java kinda has a System.out and System.in that can be written to and read from.



## Usage

    alias my-function [
      in name id
      out id name
    ]



## Discussion

- It would be nice to have the same keywords for function in/out and app (standard) in/out. Perhaps the app can just be seen as one large function.

- There are named inputs, so there could/should also be named outputs!?
- Go lang has this with 'error' at least?
- By default, just use the local variable name? But, then that would break encapsulation. But, it would definitely increase simplicity for simple projects and naming can always be put back in later.

- We could do 'in.a' to distinguish it from other local variables? Meh

- What about functions inside of functions. Need a 'super.in.a'? Meh

          alias my-super [
            input a b c
            alias my-sub [
              input a b c
            ]
          ]

  - Or, maybe just do same as Java.
  - So, probably better to just have more unique names and not allow initializing multiple times?
