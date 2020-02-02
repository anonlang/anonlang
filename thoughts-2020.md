# Decision Choices
Goal: Simple consistency throughout the language.

Main components of a language, in rough order of usage (idea: more usage => default and easier to use):
- Variable (aka values)
    - Referencing
    - Declaring
        - Constant (aka: static, for now)
        - Variable
- Function
    - Referencing
        - With parameters
        - Without parameters
    - Declaring
        - Constant (aka: static)
        - Variable
    - Anonymous function
- Module (aka: namespace)
    - Referencing (aka: import)
    - Declaring
        - Constant (aka: util, library)
        - Variable (aka: class, object)

Main types of a language, in rough order of usage:
- Boolean
- String
    - Constant
    - Variable
- Number
    - Integer
        - 'small' numbers
        - Constant
        - Variable
    - Decimal
        - Constant
        - Variable
- List (aka: array)
- Map (aka: dictionary)
- Set
- Object (aka: catch-all)

Most common functionality, in rough order of usage:
- print (aka: log)
- configuation
- storage (aka: cache, database)
- show UI (also: text, image)
- http (aka: REST, Graph QL)
    - receive
    - send
- file (also: path, directory)
- loop (aka: for, for-each, while, until)
- parse JSON
- parse XML
- play media (aka, audio, sound, music, video, gif)
- comparison
    - min, max, mode, median
- math
    - sum
- test

# 'Referencing a function' vs 'calling a function' vs 'calling a function with parameters'
- `funtionName` and `functionName()` and `functionName(param1)`
    - Pro: More continuity across the language, for example: variable names are referenced without `&`
- `&functionName` and `functionName` and `functionName param1`
    - Con: The common task of referencing a variable would also have to be like `&myVar` in order to have continuity. And, there would be no meaning of `myVar()`?
- `functionName.ref` and `functionName.call` and `functionName.callWith param1`
    - Con: Wordy

# Specifying varible types
- `String myVar` and `string myVar` and `val myVar`
    - Pro: Least amount of typing
- `myVar: String` and `myVar:string` and `myVar::string`
- `val myVar: String`
    - Pro: No need to worry about keyword ordering if 'const' is before the variable and the 'type' is after the varible
- `myVar as String`
- `myVar String`
- `myVar.Type = String`
    - Con: Wordy

# Meaning of capitalized letters and words for variables, types, and functions
- `myVar` and `Type`
    - Pro: Easy to see at a glance if something is a variable of type
- `myVar` and `type`
- `MyVar` and `Type`
    - Pro: Too much caps everwhere
    
- `myFunction`
    - Pro: function naming style should match variable naming style because functions can be referenced the same way as variables. Ex: `myVar` and `myVar.myFunction` and `myVar.myFunction()`

# Functions
## Function Declaration
- `myFunction() = ...`
    - Pro: This seems like the minimal amount of code needed for computer and person to easily recognize it as a function declaration
- `def myFunction() = ...` and other keywords (define, fun, func, function, sub)
    - Con: Wordy. Having the same keyword before every function doesn't seem to give much value
    - Possible Pro: Potentially easier to notice at a glance
## Function Parameters
- `myFunction(param)`
- `myFunction(Type param)`
- `myFunction(param: Type)`
## Function Block
- `myFunction() = ...`
- `myFunction() { ... }`
- `myFunction() ... end myFunction`
    - Con: Wordy, more keywords
## Function Reference
- `myFunction`
- `&myFunction`
## Function Lambda
- `{ ... }
- `() => {}


