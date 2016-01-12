# Notes about parsing Anonlang #


Big question:
- When converting from Anonlang to HTML, should the html tag be included?
  - If there is only one file, then it would be nice. But, if one file is using another file, then the extra html tags could get in the way. Thus, provide an option for including html tag or not. Perhaps, by default they should be included though because people would like to see that the final code is valid when they practice with the small webpages in tutorials. Also, if one file is using another, then they maybe should be added together first, before doing the html convert, then that way there wouldn't be this problem, and wouldn't need the extra argument for the convert function.
  - Though, then what about when the config fields are included? Extra head tags could get in the way also...

## Vocabulary ##

;; Anonlexer, alternative to Flex
;; \w for whitespace, though real regex uses \s for whitespace and \w for 'word character' and \d for digit
;; Anonlang might instead use: \w for whitespace, \n for number/digit (BUT can't/don't b/c this is new-line!!), \t for text/character
symbol [
  alias alias\w
  blockcomment \[;[*]*;\] ;; Eventually, support for nested block comments may be added. But, blockcommentstart won't be read in a linecomment.
  blockcommentstart \[;
  blockcommentstop ;\]
  blockstart \[
  blockstop \]
  buttonview buttonview\w
  linecomment ;;[*]*\n
  linecommentstart ;;
  linecommentstop \n
  imageview imageview\w ;; Or, use 'mediaview'instead? Or, both? A video could be displayed as image.. =/
  inputview inputview\w
  number [0123456789]+
  show show\w
  usersymbol [a..zA..Z][a..zA..Z0..9]+\w
]

Eventually, support will be added for the following. May need to add tokens above for things like 'textviewblockstart', 'numberviewblockstop'.
- bg for background
  - color
  - media
- fg for foreground
  - color
  - media
- align [rather than snap]
  - top, right, bottom, left, center, top-right, top-left, bottom-right, bottom-left
- span? span-width, span-height?
- margin [the outer-most one, transparent]
- padding [between element and border]
- border [between margin and padding]
- z or z-index [more like v3?]



;; Anonparser, Alternative to Bison and Yacc and BNF: https://en.wikipedia.org/wiki/Backus%E2%80%93Naur_Form
syntax [
  value [
    text
    number
  ]
  expression [
    term operation term
  ]
  package [
    alias usersymbol [
      buttonview
      number
      text
      textview
    ]
    buttonview [
      value
      value onclick
      block [
        value
        onclick
      ]
    ]
    textview [
      value
      block [
        value
      ]
    ]
    show [
      buttonview
      textview
    ]
  ]
]



Things can be written in different ways, so let's provide all the simple test cases:

Test 1

    text-view 'Hello, World!'

Test 1.0.1

    text-view
                     'Hello, World!'

Test 1.1

    alias t 'Hello, World!'
    text-view t

Test 1.2

    text-view [
      value 'Hello, World!'
    ]

Test 1.2.1

    text-view [ value 'Hello, World!' ]

Test 1.2.2

    text-view[value 'Hello, World!']

Test 1.3. Hmmm, maybe always require 'alias' for now to make things simpler, then we can always change later once things are working.

    text-view [
      t = 'Hello, World!'
      value t
    ]

Test 1.3.1

    text-view [ alias t = 'Hello, World!', value t ]

Test 1.3.2

    text-view[alias t='Hello,World!',value t]

Test 1.3.3

    text-view    [    alias   t  =  'Hello, World!'   ,  value   t   ]

Test 1.4

    alias tv text-view [
      value 'Hello, World!'
    ]
    show tv

Test 1.4.1

    alias tv text-view [ value 'Hello, World!' ] show tv

Test 1.4.2

    alias tv text-view[value'Hello, World!']show tv

Test 2

    button-view 'Hello, World!'

Test 2.1

    alias t 'Hello, World!'
    button-view t

Test 2.2

    button-view [
      value 'Hello, World!'
    ]

Test 2.3

    button-view [
      alias t 'Hello, World!'
      value t
    ]

Test 2.3

    alias bv button-view [
      value 'Hello, World!'
    ]
    show bv

Test 3

    button-view 'say hello' prompt 'Hello, World!'

Test 3.1

    alias t 'say hello'
    alias hw 'Hello, World!'
    button-view t prompt hw

Test 3.1.1

    alias t 'say hello', hw 'Hello, World!'
    button-view t prompt hw

Test 3.2

    alias t 'say hello'
    alias hw 'Hello, World!'
    button-view t [
      on-click prompt hw
    ]

Test 3.3

    alias t 'say hello'
    alias hw 'Hello, World!'
    button-view [
      value t
      on-click prompt hw
    ]

Test 3.4

    button-view [
      value 'say hello'
      on-click [
        prompt 'Hello, World!'
      ]
    ]

Test 3.5

    alias bv button-view [
      value 'say hello'
      on-click [
        prompt 'Hello, World!'
      ]
    ]
    show bv

Test 3.5.1

    alias bv button-view [
      value 'say hello'
      on-click [ prompt 'Hello, World!' ]
    ]
    show bv

Test 3.5.2

    alias bv button-view [
      value 'say hello', on-click [ prompt 'Hello, World!' ]
    ]
    show bv

Test 3.5.3

    alias bv button-view [ value 'say hello', on-click [ prompt 'Hello, World!' ] ] show bv

Test 3.5.4

    alias bv button-view[value 'say hello',on-click[prompt 'Hello, World!']]show bv

    alias bv buttonview[value 'say hello',onclick[prompt 'Hello, World!']]show bv

Test 3.5.5. Hmmm, should allow strings after keywords without space in-between?

    alias bv button-view[value'say hello',on-click[prompt'Hello, World!']]show bv

    alias bv buttonview[value'say hello',onclick[prompt'Hello, World!']]show bv

Test 3.6. Hmmm, is this possible in Anonlang? Seems like it could be.. automatic macro.. implicit function call. I'm leaning towards yes to allow it because the alias 'phw' has a valid block scope after it. Hmm, but aliased things are lazy loaded, so how to know, unless compiler checks that...

    alias phw prompt 'Hello, World!'
    alias bv button-view [
      value 'say hello'
      on-click [
        phw
      ]
    ]
    show bv

Test 4

    config [
      name 'My Minimal Website Title'
    ]
    text-view 'Hello, World'

Test 4.1

    config [
      name 'My Minimal Website Title'
      description 'My website description here'
    ]
    text-view 'Hello, World'

Test 5

    textview 5

Test 5.1

    textview 5 + 5

Test 5.1.1

    textview 5+5

Test 5.2

    textview 5 - 5

Test 5.2.1

    textview 5-5

Test 5.3

    alias num 5
    textview num

Test 5.4

    textview 'num: ' ++ 5

Test 5.4.1

    textview 'num: '++5

;; Hmmm, Perhaps don't worry about math for now and for the longest time.
Test 5.5

    alias num 5
    textview num + num

Test 5.5.1

    alias num 5
    textview num+num

Test 5.5.2

    alias num 5
    textview num - num

Test 5.5.3

    alias num 5
    textview num-num

Test 5.6

    alias num 5
    alias num10 num + num
    textview num10

Test 5.7

    textview 5-5-5-5


;; Further Resources
- Great, but old: http://taligarsiel.com/Projects/howbrowserswork1.htm
