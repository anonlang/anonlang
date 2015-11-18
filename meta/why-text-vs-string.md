# Using 'text' vs 'string' for groups of characters #

A character array is nice to have. And, since it is used so much it has become its own first-class data type in many languages. The 'traditional' name of the character array has been 'string'.

Yet, GUI frameworks use a TextView that holds a 'string' datatype. There is a bit of consistency jump there.

To make things more consistent, 'text' goes in a 'text-view'.

Also, the word 'text' has a inherit meaning of characters (and other things that go in SMS).

You can say 'apps show text' or you can say 'apps show strings of characters', though the first one is easier. People send text to each other, not string. We have text-to-speech and speech-to-text systems, not string-to-speech. GUIs have TextViews.

And, to cover more of our bases, sometimes langauges/developers overload the 'string' with other functionality besides text to display, like bits, numbers, base-64 encodings, etc. These things are done due to limitations of languages, libraries, frameworks, and protocols. Each of those mentioned overloaded datatypes for string can have their own separate datatypes, thus allowing the computer help out more in the development process and providing more built-in support, features, functions, parsing, and error checking.

Using 'text' in programming languages is better than using 'string'.
