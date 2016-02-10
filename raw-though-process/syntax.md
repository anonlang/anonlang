# Syntax #
Sample examples of what it could be. Goal is to limit boilerplate, keep readability.

For each toggle-able feature, there may have to be a token for it:

1. Variable mutable/immutable. Should we have a decision to be able to change name alias? (keyword-final)
2. Run code sync/async? Everything could be event-driven?
3. Run code just once now, or save for later calling arbitrary many time? (the function question)
4. Is a function name being call to run or just as reference? (the lambda question)
5. Force all statements to just one line or allow multi-line? (The semi-colon question)
6. For code that will execute once, do it immediately or lazily (automatically postpone work until actually needed/used)?
7. Visibility of attributes to be local/global?
8. Should attribute be singleton or have multiple instances?
9. Whether or not to store to main memory or local memory? (keyword-volatile)
10. Provide hint to compiler for inlining? (keyword-inline)
10. Tooling support
  1. Note when a function should be overriding a parent function. (keyword-override)
  2. Note when a function should be overridden by a child function. (keyword-abstract)
  3. Note when an attribute should be null or not. (keyword-nullable, keyword-nonnull)






## MVP First Compiler for bootstrapping ##
;; lex
;; Special rule (maybe for v2): \b for non-poping break match, like whitespace or bracket, to maybe help clarify between keywords and text?
ALIAS alias
OUTPUT output
TYPE type
VALUE value
TEXT [a-z]+
;; parse
root statement
statement ALIAS TEXT object
statement TEXT object
statement object
statement output
object TEXT LBRACKET statement* RBRACKET
object TEXT
output OUTPUT object



## Keywords ##

keywords-that-can-be-noun-or-verb [
  alias
  break
  check ;; Rather than if? or switch?
  format
  group
  input
  loop
  output
  prompt
  switch?
  view
]


;; TODO: Search Java keywords to brainstorm more.
keyword [
  reserved [
    anonlang-0 [
      alias ;; Hmm, not really 100% necessary in minimal core, right?
      if
      break
      switch [ case, default ]
      loop
      byte
    ]
    anonlang-1 [
      use
      input
      output
      boolean
      number
      string
      text
    ]
    anonlang-2 [
      create-file
      create-window
    ]
    potential [
      create
      recycle
      destroy
      goto
      final
      const, constant
      static
      global
      animate
      start
      stop
    ]
  ]
]



### Scopes

Scopes are defined between square brackets `[]`. There are special kinds of scopes:

    [  ] for group/scope
    [[  ]] scope inside scope is private to outside direct access, bracket not necessarily next to each other.
    [;  ;] for comment (and included for lang-documentation)
    ['  '] for string
    [`  `] possibly for unescaped strings/text, could also be good for signifying other languages/formats also, somehow. raw strings useful regex. Backticks require shift on some European keyboards? Hmm, though still okay? But, too similar of look to regular string? But, they are very similar functionalities.
    [.  .] unassigned
    [=  =] unassigned, maybe template? macro?
    [-  -] unassigned
    [!  !] unassigned
    [@  @] unassigned
    [#  #] unassigned
    [$  $] unassigned
    [%  %] unassigned
    [/  /] unassigned, no intuitive-ish meaning? JavaScript uses / for regex block
    [\  \] unassigned, no intuitive-ish meaning?
    [,  ,] unassigned, possibly too confusing to use since comma typically means list or pause/short-break
    [[x]  [x]] unassigned, though more confusing to parse, and long to type

Possible scope feature:
- Regex
- Unicode / HTML escapes like `&nbsp;`
- Inserting another language, or rather, just some unparsed text

For the possible scope features, maybe instead of bracket they can just be string with a single letter in front? Maybe like

- `r'regex'` to parse as regex
- `u'unicode'` to parse as unicode (either Number or Text could be accepted)?
- `c'comment'` for comments?

In future, possibly allow spacing to be defined so that brackets would be needed?
Hmm, probably one tab would be fine. That way, people could set spacing on their own IDE. Tab would have to be consistent though.



### Loops ###
Can a language be good without for-loops? (Case study: Haskell)

A basic loop could maybe be done with `loop [ .. ]`, then it would be exited with `break`.

#### Example: Get list of even numbers

    // Imperative
    List<Integer> evens = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
      if (i % 2 == 0) {
        evens.add(i);
      }
    }

    // Declarative (possibile syntax for Anonlang)
    [i 1..10].where i % 2

    // Or,
    [i 1..10 if i % 2]

    // Or,
    [1..10 if % 2]

    // Or, simply let the language fill in the arithmetic pattern.
    [2,4..10]

#### Example: Create primes list

    // Declarative
    [i 1..100].where i is prime

    // Or, more lazy loaded bounds..
    [1.. if prime]


### Data Structure
Current idea is having only one type of data structure, the 'group'. It would be able to have O(1) random access like traditional arrays using index or like certain hash maps using a string. Groups can point to other groups, so that would be like the linked list.

It would have config option to be sorted by key.

#### Implementation ####

    alias group [
        size [ default 1 ]
        type [ default any ]
        isSorted [ default false, key none ]
    ]



### Internet access

    html = async Web.get('http://simplyadvanced.net/');
    html = Web.post('http://simplyadvanced.net/portal/', 5).ok?.is(5) // This could be something for testing also?

### Files

    file1 = File.get('src/net/simplyadvanced/myapp/files/data1.sql')
    file2 = File.get('src/net/simplyadvanced/myapp/files/data2.sql', Charset.UTF8)
    file1.add(file2)
    File.save(file1, 'src/net/simplyadvanced/myapp/files/data1and2.sql')


### Website
Goal: Is this the best we can do for modularity, easy sharing, easy replacement, and dynamic changes? Can have more GUI in code?
Possibly use namespace for top-level fields so that they may be easier to find(?) and won't get in the way of user keywords(?). It's optionally, but helpful.

    show(data=default,style=style-a,action=default]

    config [
      name 'Simply Advanced'
      description 'A sample website'
    ]
    default-data data [
        textview 'Simply Advanced'.red.large
        section [
            home [
              navTitle Home
              title Hello World!
              message This is my website made using Anonlang!
              icon assets/img/logo.png
            ]
            about [
              navTitle About Us
              title About
              message Here's a little blurb about us. See our apps (here)[http://play.google.com/apps/].
            ]
            contact [
              navTitle Contact Us
              form [
                name // Leave empty for defaults
                email
                message
                button title=`Submit`,to='feedback@simplyadvanced.net'
              ]
            ]
        ]
    ]

    layout [
      col [
        row [ section.title flex nav ] lock
        row home [
          icon center
          col [ title message ]
        ]
        default about
        row contact [

        ]
        row footer
      ]
    ]

    Web.layout.template section default [
        row [
          icon center
          col [ title message ]
        ]
    ]

    style-a style [
      primary-color blue
      secondary-color custom-green
      accent-color glowing-purple

      windowTitle gradient white blue
      title animate slide-in-from-top 400
      home.title h1
      home.message h3

      contact.form.message optional
      contact.form.message.hint Any specific questions?

      // same as above
      contact.form.message [
        optional
        hint Any specific questions?
      ]
    ]

    action-a action [
      // Okay to leave `form` out because button can be found.
      contact.button {
        on-hover glow
        on-click 'send-email.php'
        on-long-click easter-egg
        on-hold-5000-click action.super-easter-egg
      }
      easter-egg fib
      super-easter-egg {
        alert You found the super easter egg!
      }
    ]



## Playgrounding

Hmm, since everything is a everything.. should be able to provide inputs at the same time as defining function/class.

Hmm, need a new word to represent: attribute, function, class. Perhaps just closure, or object, or function?

Hmm, PATTERN ACTION syntax is powerful.

Hmm, how to do anonymous functions, besides calling it lambda?

    keyword config args:body
    keyword config args[body]

    if args:body
    if args[body]

If brackets:

    ;; Define function
    ;; name config body
    validate[out in]
    validate[in a;out a]
    validate[in a default;out a?a|default]
    validate|lazy[in a default; out a?a|default]

    ;; Call function
    ;; name config args
    validate 'name'
    valid '' 'John Doe'

    ;; Call function while defining it
    ;; visibility name args|config:body
    public validate '' ''|lazy[in a b;out a]

    ;; Control flow
    ;; name args body
    if validate:

If no brackets:

    ;; Define function
    ;; name config body ;; config might also be for super?
    validate:out in
    validate:in a;out a
    validate:in a default;out a?a|default
    validate|lazy:in a default;out a?a|default

    ;; Call function
    ;; name config args
    validate 'name'
    validate '' 'John Doe'

    ;; Inlined function calls
    validate '' validate '' ''

    ;; Call function while defining it
    ;; visibility name args|config:body
    public validate '' ''|lazy:in a b;out a

alias filter
  in list function
  loop item in list function item

alias filter [
  in list function
  new-list
  loop item in list [
    if function item [
      new-list.add item
    ]
  ]
  out new-list
]

alias filter:
  in list function
  new-list
  loop item in list:
    if function item:
      new-list.add item
  out new-list

alias if [
  in a b
  a?b
]

;; Variable assignment vs function call? No variable name and function name could be the same in the same scope?
something value
something value


;; Attribute Config and ArtDoc
;; Hmm, Anonlang should be powerful enough to not need config/annotations?

    ;;; Simple function that does something.
    alias my-function|lazy inline:'sometimes' type[:'format':'art' 'parse':'art' 'encode':'pig':]|:'name''value' [
      in a b
      ;; Do something
    ]

    ;;; Simple function that does something.
    |lazy inline:'sometimes' type[:'format':'art' 'parse':'art' 'encode':'pig':]|
    alias my-function:'name''value' [
      in a b
      ;; Do something
    ]

    [;;Simple function that does something.;]
    [|lazy
      inline:'sometimes'
      type[:'format':'art' 'parse':'art' 'encode':'pig':]
    |]
    alias my-function:'name''value' [
      in a b
      ;; Do something
    ]

;; Should be able to something similar? Though maybe with different syntax

    ;; Access instance initialized in scope's conditional/initializer. Or, making "lazy" function could be essentially the same thing. Maybe there could be 'thread-lazy', 'function-lazy', 'class-lazy', 'timed-lazy' version, where each are calculated once per <modifier>.
    int foo() {
      if ((int a = -1) == -1) {
        out a + 1
      } else if ((int b = getB()) == -2) {
        out b - 2
      }
      out 0
    }
