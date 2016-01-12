# Testing in Anonlang

Tests are automatically created from simple syntax in the function comment.

The language tooling also suggest test cases to define and can automatically create the simple testing syntax for function.


    [;
      Require two number inputs, won't compile otherwise in the current state.
      test [
        1 2 -> 3
        -1 1 -> 0
      ]
      test: 1 -> error
      test: -> error
    ;]
    alias my-sum-function [
      input arg1 arg2
      sum = arg1 + arg2
      output sum
    ]

Or, from another file

    test my-sum-function [
      1 2 -> 3
      -1 1 -> 0
      1 -> error
      -> error

      1 2 | 3
      -1 1 | 0
      1 | error
      | error
    ]
