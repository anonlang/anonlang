# Data Types in Anonlang #

## Core data types ##

- 'byte' for data
- 'boolean' for two-state logic
- 'number' for maths
  - 'integer' for automatic rounding
  - 'float' for real numbers
- 'text' for string of alpha-numeric character
  


## Additional data types provided by plugins ##

- 'bit-group' for memory-constrained apps [based off byte], ex: primes table/sieve
- 'fuzzy-boolean' for fuzzy logic
- 'trilean' for three-state logic [More info](https://en.wikipedia.org/wiki/Three-valued_logic)
- 'number'
  - 'complex' for more engineering [uses two floats]



## Implementation Details ##

    alias byte [
      encoding [ default 'none' ]
      valid-input 0x00..0xFF
      value [ default 0x00 ]
      isTrue value != 0x00
    ]
    alias boolean byte [
      alias false 0x00
      alias true 0x01
      valid-input [ false, true ]
      value [ default false ]
      isTrue value
    ]
    ;; Integers can use up to two byte-groups (one for raw value, one for exponent/shift)
    ;; There is no such thing as 'integer overflow' by default, though a max and min can be specified.
    alias integer byte-group [
      valid-input [ .. ]
      value [ default 0x00, size 0x01 ]
      isTrue value != 0x00
      isNegative value[0] & 0x80 == 0x80
    ]
    alias character byte-group [
      encoding [ default 'utf-8' ]
      value [ default 0x0000, size 0x02 ]
      isTrue value != 0x0000
    ]
    alias text character-group []
    
    alias bit-group byte-group [
      value [ default 0x00000000, size 0x04 ]
      set [ 
        input index, val
      ]
      get [
        input index
        ;; Do work
        output val
      ]
      flip [
        input index
      ]
    ]
    alias trilean byte [
      alias false 0x00
      alias true 0x01
      alias unknown 0x02
      valid-input [ false, true, unknown ]
      value [ default unknown ]
      isTrue value == true
    ]
    
Note: Each of the types has a function for `isTrue()` so that it would work simply in a conditional without manually writing code testing equal to true. Other user-defined types can also have that method to have for simpler conditional checks.
