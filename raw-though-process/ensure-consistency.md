# Ensure Consistency

In regards to symbols, each should have a well-defined meaning that is easy to explain and not ambiguous in any cases. This page attempts to define all the use cases for each symbol so that we can understand the common meaning.


### backtick ` `` `

Define raw text.

Text between two backticks are not meant to be parsed or have special formating applied to them.


### brackets `[` and `]`

Define the start and stop for a block of code.

An additional symbol can be added to the 'inside' of both brackets to define it as a special block of code, for example block comments start with `[;` and stop with `;]`.


### colon `:`

Provide a reference for an alias.


### comma `,`

Provide separation between items in a list.

This is only needed in cases to avoid ambiguity or to increase readability.


### equals `=`

Assign a value to an alias.

For non-example (because regular assignment would work in this case instead):

- Define constant value `MINUTES_IN_HOUR = 60`
- Define constant value `APP_NAME = 'Fire-flying'`


### period `.`

Provide access to attribute of an alias.

For example:

- Access the last item in an array, `a.-1`
- Access the value matching a key in a map `a.key`
- Access the value matching a text key in a map `a.'key'`
- Access a function from an alias `a.run`
- Access sub packages `com.anonlang.app`
- Access a directory `user.dan.music.play`

Edge cases:

- If a directory contains a file and sub-directory of the same name, then the file will be referenced first. To access the sub-directory, include an extra period at the end.
- An alias may not have multiple attributes of the same name.
- A period can be included in a directory name, and the system will see that as another directory, which may be empty.



### quote or single-quote `'`

Define textual data.

The double-quote `"` is currently not used.


### semicolon `;`

Provide separation between different parts of code.

This is useful to prevent ambiguity.

Two semicolons `;;` together will provide separation between code to the left and a comment to the right.
