# Syntax: Functions



    ;; Different paradigms to try
    pattern action
    input function output
    function input output



## Sample Syntax

### Function Declaration

    function-name [
      in a: 0, b: 0, c: text='error'
      if b = 0 [
        out c
      ] else [
        out b * 10, a - b
      ]
    ]

    join [
      in delimiter, args...
      joined-text: text
      loop a in args [
        joined-text.append[a].append[delimiter]
      ]
      out joined-text
    ]

    max [
      in args...:comparable
      out: comparable
    ]

    max:comparable [ in numbers+:comparable | var m=numbers.0, numbers.reduce-parallel [it > m ? m = it] | out m ]

### Function Calling

    function-name a b
    function-name b: b, a: a

    join a, 'b', c




## Notes

No optional brackets for function calling because it could get confusing:

    log [max 3 4 min [5 6]] ;; Perhaps not the same as `log max 3 4 min [5 6]`
