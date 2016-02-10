Major concepts to resolve:

- *Syntax to pass arguments to functions.*
  - Prefer not having to wrap them with brackets because the function body may already be wrapped with brackets.
  - Prefer not to use the shift key. So, that would limit the curly brace and parenthesis.
  - A test for intuitiveness. Ask a non-programmer what some code does.
  - Many people didn't care for Python's required whitespace. On the other hand, many people (less?) like the required similarity of code.
  - The biggest hurdle for compiler is to know
    - When the input parameters stop
    - Is a function passed in as a function pointer or does it take some of the following input parameters?

                ;; math.min might only take two inputs?
                x = math.max 2 3 4 math.min 5 6 7

  - Idea: If the number of inputs were fixed (easy to do), then one of the problems would be solved. But, this idea would prevent variable amount of arguments, which would be a nice feature. Though, it can probably be proven that an extra syntactic token would be required just to support variable-length arguments. Java originally required arbitrary-length arguments to already be wrapped in a collection, but later added varargs because 'usefulness'(?). It really is just syntactic sugar. And, many people do like sugar.
    - Hmm, one reason Java may have added varargs sugar syntax was because creating arrays were difficult. Since it is simple in Anonlang, perhaps the varargs syntax isn't needed. Just us group instead.
  - Idea: A syntax could be used for function as a argument, like calling it 'lambda' or putting an asterisk before the name (like in C). But, I don't care for either of those ideas because it introduces more unnecessary complexity to developers. Prefer complexity done once in the backend rather than new requirement/complexity for each developer using the API.
  - Idea: Functions can be passed as arguments, but they never evaluate inline when they are the arguments. Meh. I would also prefer not to limit devs. I'm sure there is a better way, but it just hasn't been thought of yet.
  - For varargs, Ceylong-lang handles this by accepting 'Iterable' parameter. The syntax is asterisk after the type to mean 'zero or more' and a plus after the type to mean 'one or more'. Ex: 'alias max [ input number+ ]' [source](http://ceylon-lang.org/documentation/1.2/reference/structure/parameter-list/#variadic_methods_and_varargs)

        ;;
        x = math.max 3 4 5

        alias math [
          alias max [
            input a b
            output a > b ? a : b
          ]
          alias max [
            input a b c
            output max a max b c
          ]
          ;; If no overloads, real implementation may be closer to:(?)
          alias max [
            input a b c*
            if c.is-empty [ output a > b ? a : b ]
            output max a > b ? a : b max c.0 c.[1:]
          ]
        ]

  - Are defining function body and scoping arguments mutually exclusive? Aka, are they never needed or used in the same statement?

- *Syntax to end statements or have multiple statements per line*
  - Easiest solution is to not allow multiple statements per line. Thus, an extra trivial 'semi-colon' token wouldn't be required. Hmm, though in languages not requiring the semi-colon ending, the newline is used as the token. Well, at least in the later case there is less typing overall even though it would look the same to the compiler.

- *Syntax to get object from group/array.*
  - Prefer not to use brackets because reader could mix up defining function body and getting.

        ;; Idea 1: Use the dot operator. This could work because keys would be
        ;;         either number or string, and alias/variable/function/class would be direct name starting with letter.
        first-item = my-group.0
        my-value = my-group.'my-key'
        sorted-group = my-group.sort

  - It would have to be non-negative integer keys as only number? Meh, a quick minus sign could be okay, though non-integers could look weird.
  - Then, how to store and reference other objects in groups? Possibly, require a function call to something like 'isContains' and 'getValue'?

- *Syntax of library names and aliases.*
  - Prefer not using shift key. So, that would limit the underscore and camel case. What other choices are there?
  - Best practices could be defined now so that each dev would be on the same page when starting. And, all code easily readable, looking like it was written by the same person.
  - Should everything be lowercase with dashes between words? I think this looks good and clear, but it may look weird when mixed with math's minus sign, especially if a space isn't required on both sides of a minus sign.
  - Should there be a way to distinguish between library call and non-library code? Not really necessary? because dev just wants to know that it works in either case. Then, if they want to explore the function future, then they could realize at that time whether or not it is a library call, at other times it wouldn't matter and would just be noise? Hmm, maybe it could be helpful for debugging so that self-code would be looked at more before library code? Then IDE could help in that regards during debugging time? Or, maybe library APIs would be simple enough for dev to remember? Though, API and libraries would eventually grow very large, even if small at the start.

- *Syntax to handle input of other languages and formats*
  - Ex: How to put Markdown syntax in Anonlang and recognize it as not Anonlang?



# Anonlang #

Art-lang: Make it feel good.

mvp [
  Ability to read, parse, output text in terminal [
    Based on bash may be quickest, but not cross-platform. So, just go straight to Java and piggy-back on JVM until LLVM is setup? Seems good enough. All the front-end will abstracted enough so that the backend can change without affecting any front-end code. Maybe Python would be even easier?
  ]
]

goal [
  Newbie can create an app within one minute (This means small download too)
  The entire language should be easy to hold in head? Well, at least the standard library.
  Any perceived limitation or boilerplate code can be abstracted out
  One main easiest solution to do the most common things
  version-infinity [
    Websites in Anonlang
    package-manager [
      Easy sharing of re-usable code in libraries
      Easy to extend the language
      Ability to rate and comment/review/ask-questions on packages
    ]
    Good IDE and tooling support
    Ability to convert other language into Anonlang or co-op
    Good with all platforms: browser, desktop, mobile, tv, auto, console, terminal, graphics, math, games, microprocessors, security, music, animation, ai.
    Automatic unit test creation with edge cases [and cache results]
    Minimize garbage collection. Reuse and recycle everything. Object pools
    Continuous integration and testing
    Make it easy for apps to have pluggable/replaceable components.
  ]
  maybe [
    Ability to reference libraries in other languages. Maybe just need to link to the other-language-SDK and Anonlang will have the APIs available?
  ]
]

design-thought [
  I will use Anonlang for everything. If there is a use-case that I can't do in less than five minutes, then Anonlang may have that ability added
  question-everything [
    Does text need to be concatenated with `+`? For example, Haskell uses `++` and PHP uses `.`
    Do we need to use IEEE data-types in Anonlang? We could compile to that for necessary hardware
    Is object-oriented design the ultimate paradigm to keep?
    Is a null value needed?
  ]
]


## Thoughts for Design ##
- [!] Perhaps apply another dimension to code editing that allows devs to work in more than just linear text.
  - Anonlang IDE needs to have loads of special support for naming conventions.
- Anonlang and IDE and compiler come together!
  - Hmm, that means IDE needs to be available for every platform easily. Easier than making a plugin for all text-editors and other IDEs?
- Everybody explicitly creates an API to use.
  - Basically, everybody adds to the cloud-backend of Anonlang?
    - When referencing API from cloud, only the explicitly referenced methods would move to client side in order to keep the code clean?
- Data type limitations: https://github.com/hhvm/hack-langspec/blob/master/spec/05-types.md



## Random Thoughts ##
- Create a browser that only allows for the next-gen technologies, aka no HTML/CSS/JS. Then, good open source apps must be created for it. Also, custom links that do everything. Hmm, this would basically be like the beginnings of Chromium except using next-gen languages for everything.
  - Ahh, the browser is the IDE too!?
  - Hmmm, don't think of the program as a browser? How about plug-in system? The entire OS?
  - Everything viewable by people inspecting source or packages should just be bytecode to make it more impossible to sniff/hack/spy.
- Unix philosophy as a programming language. Fully integrated.
  - Each variable/function has input/output



## TODO ##
- Do some more haskell (and other functional language) practice
- Do more general-game programming to see if that can be beneficial to the core.
- Learn: Why does Java have reflection? Why was it added? Find out more than it's a nice feature for analyzing and manipulating code. Was it needed because of limitations of the language?
- See just how similar Groovy is to the syntax I have come up with in `syntax.txt`.
  - Also similar: [ceylon-lang](http://www.ceylon-lang.org/), and [language design FAQs](http://www.ceylon-lang.org/documentation/1.1/faq/language-design/)
- Start building on top of [LLVM](http://llvm.org/) (or similar) for simpler cross-CPU support.
- Read https://en.wikipedia.org/wiki/List_of_programming_languages_by_type and https://en.wikipedia.org/wiki/Category:Declarative_programming_languages



## Open Questions ##
- Should the use of 'alias' keyword be required when defining things? When an unknown keyword turns up, the compiler could assume it is an alias and will look for what it is defining next.. If there isn't a data type or scope after it, then it would be an error. Multiple unknowns could be aliases for a same type or scope. But, the main drawback would be if there is a typo, then could the computer know that? Tooling would try to help by having all unknowns highlighted. Could make the use of 'alias' optional? Hmm, well, reading new code, would it be helpful if alias was always written so that everybody knew exactly when it was being defined? And then, possibly make it so that an alias could only be defined once in scope? Hmm, for variables, many languages just assume an unknown coming up when a type is provided. For functions, many languages have a keyword that says it will be a function.
  - Pro: Provides note to compiler about unknown keyword coming up. Possibly more helpful for people new to reading the code.
  - Con: More typing, which could possibly be unnecessary.
- Instead of 'everything' being Anonlang
  - Cases that might always be reused:
    - Regex
    - Markdown
    - LLVM
  - Cases that might only temporarily be reused: (basically a bridge to help adoption of Anonlang)
    - HTTP
    - PDF, DOCX, PPT (Eventually all go to Markdown or Anonlang)




## Idea ##
- All 'alias' [variables/method/class] are final/constant by default. This is the most safe code by default? Should this be a concern?
  - Use 'var' if can change. What to do about static values? No such thing? (Sidenote: Kotlin gets around this by having a singleton inside a class.)
- Have different abstraction levels for Anonlang. The higher levels maybe would progressively compile to the lower level? Or, maybe the compilers would be combined to not have extra steps? Or, maybe there wouldn't be extra steps if doing each layer one by one, because it may eventually have to be done at some point. Though, maybe a different intermediary format could be useful (though same for all compiler levels).
  - 'anonlang-0' the minimal language and parser itself, where perhaps all the brackets are required so that there are no ambiguities. When parsing at any level, it would eventually have to reach this stage. This language level does nothing itself, it would only be used as intermediary.
  - 'anonlang-1' (assembly-like) for minimal metal-level with only memory pointers and byte references.
  - 'anonlang-2' (c-like) for first abstraction level for primitives like int and char and whatever is typically available for metal. No garbage collection?
  - 'anonlang-3' (java-like) for garbage collection (through optional scopes), and primitive for number and text.
  - 'anonlang-4' (ruby-like, python-like) for more freedom and less to worry about.
  - 'anonlang-5' would be next abstraction level higher than Ruby and Python. Would it be AutoHotkey-like? Or, would those features already be integrated before this level? One thing though is that prototyping would be super-easy. Perhaps non-text would be allowed directly in the source code.
- Never release 'Anonlang'. (It's not even that catchy of a name). Instead, release 'sub-languages' that say they are specifically built for a niche reason. Then, maybe after five years time with cross-niche-developers, it will be figured out that the multiple niche languages are the same and 100% compatible with each other. So, all the code and learned skills are immediately and 100% transferable.
  - Maybe something about 'flow'..
- Maybe each thing in Anonlang, especially GUI widgets, have a standard input and output. This could be a good start for a way to handle functions. This idea is similar to piping in terminals. Though, would be nice to have better tools so input parameters would have to be defined.
  - An alias/method/function could accept arguments/parameters/input, like: `alias foo [ input [arg1, arg2] [; Do something here with variables passed via input. Reference by ;arg1; and ;arg2; syntax? It is still really quick to type. And, I should also consider -arg1- and -arg2- maybe, but I had to pause more than when doing ;arg1; ;] ] `

            some-block [
              input arg1 arg2
              ;; Do stuff, maybe
              output arg2 arg1 ;; A swap
            ]
            alias a 1
            alias b 2
            a, b = some-block a b
            a, b = b, a ;; Another swap

- Built-in support for fuzzy logic. Perhaps have a 'FuzzyBoolean' type.
- Need to call DSL (Domain-Specific Language) something else so that Anonlang can better explain how it isn't needed anymore, yet it is extremely easy to do and is done all the time for all programs.
  - Every program creates a 'program-specific language'
- Reflection shouldn't have a high cost. It is a direct part of the language.
- Have simple symbol overloading/defining. For example, being able to define what `10 \ 2` should do, like return true/false if 10 is divisible by 2. Though, this is a bad example for Anonlang because 10%2 already can work that way.
  - rule \ [`a number \ b number` return a%b==0]
  - So, a parser-generator and grammars built into the language?
- Possibly re-use Haskell's version of comments, the double-dash -- and brace-dash {- to open and -} to close? This would free up semi-colon for variable within string. Or, maybe the dash could be used as variable within string. Need to try creating apps using both methods, then comparing usages.
- Open question: Should scope comments support nesting comments? Aka, is `[; ... [; ... ;] ... ;]` a valid comment?
- Anonlang doesn't need it's own IO built into the language when it could/should(?) be leaning on whatever platform it is on? But, then creating cross-platform code wouldn't be as easy?
- "Since internal DSLs are close to the programming language, this can present a difficulty when you want to express something that doesn't map well to the programming language itself. For example, in Enterprise Applications it's common to have a notion of layers. These layers can be defined to a large extent by using the package construct of the programming language, but it's hard to define the dependency rules between the layers. So you might put all your UI code in MyApp.Presentation and your domain logic in MyApp.Domain but there's no mechanism with an internal DSL to indicate that classes in MyApp.Domain should not reference classes in MyApp.Presentation. To some extent this again reflects the limited dynamism of common languages - this kind of thing was possible in Smalltalk since you have deeper access to the meta-levels." [source](http://www.martinfowler.com/articles/languageWorkbench.html#InternalDsl)
- The extension can define the capability of the file. For example, have Anonlang files that should only be treated as data (i.e. not runnable code) have the '.data' file name extension. Perhaps '.adata' in order to make it have a common theme for for Anonlang-related files. But, then again, we could be more open about a standard for all by using the regular name? Though, that would be a bit up-front.
- Creating a 'UML Diagram'-ish thing as a different paradigm programming language? Minimally define all variables, methods, connections. The editing view can be mostly graphical with implementation details hidden by default.
  - This seems similar to computer engineering when developing VLSI. Though, where that design is typically bottom-up, the programming way could be done bottom-up and/or top-down. And, make sure to create boxes to encapsulate things.
  - In this format, layers are very easy to see.
  - The editor this this paradigm would likely have a window for the overall graph-like view, one text window for seeing implementation details, and  one more text window for editing and adding new implementation details.
  - Method naming would be very important. (isn't it always?)
    - We could integrate the idea of funtion/method/variable are all the same thing like in Anonlang? It is a getting and setter in one?
  - An important feature would be able to keep the graph looking good. And, possibly allow for different view-types for different groups and layers and levels.
  - This could be a 'language-agnostic programming language', at least for OO languages? Would just need to create plugins.
    - Current programs should also be able to be put into this graph format.
    - This is the real intermediary language?
    - Polymorphism with ability to seemlessly switch between different children and siblings.
  - Perhaps a 'test dimension' so that they don't get in the way of development.
- Instead of all things having just an 'input' and 'output', there should probably be: 'data-input', 'data-output', 'view-input' (maybe not this?), 'view-output'. (idea from http://acko.net/blog/on-termkit/)
- Using '=' means assign now. Aliasing without '=' means it should be lazy/dynamically loaded.
- In Anondata, possibly allow a field for 'data-format so that other data formats can be embedded to Anondata, like CSV or other. Though.. for every feature added to Anondata, parsing would get slower. Possibly have a config field at the top of Anondata and/or in the parsers in order to handle which features will be looked for, that way there will always be the best speed.
- Allow underscore in numbers to visually see magnitudes. They would be ignored when compiling.
- Should use 'alias' or 'let' for the variable/method/function naming. 'alias' could be seen as a verb or noun. 'let' is a verb, possibly easier english?, definitely shorter which is good since it would be written a lot.
- Ideas: http://esolangs.org/wiki/List_of_ideas
- Instead of allowing multiple inheritance (or multiple 'implements'), the language could promote more composition instead. Just one superclass so that a 'template design' could be used.
- Make [Fast] Fourier Transforms extremely easy and intuitive.
- The best way to get Anonlang everywhere and people used to it may be to make it a full language for transferring between other languages. Then, eventually, Anonlang itself could just be used one one then both sides.
- Be careful of 'wat's: https://github.com/cosmologicon/pywat and https://www.destroyallsoftware.com/talks/wat
- How to do simple primes? "The APL article on wikipedia has this code to calculate the primes from 1 to R: (∼R∈R∘.×R)/R←1↓⍳R"
- There needs to be another way to abstract the lowest levels besides 'byte'. Even though that measurement is used for all computing stuff that I know of, I have a feeling like the future can have some better metrics than that. So, should I just keep things in terms of just boolean, number, and text only? Or, since 'byte' will last a very long time, that it should just be used in the language. And, then maybe, by the time 'byte' isn't a necessity anymore, then there will be more great ideas to implement alongside. Hmm, yeah, probably better to at least get something started (and maybe not scare people too much).
- Ability for simple email command: `send name@example.com 'Title' 'Body'`
  - Somehow this should be similar with chat command.
  - I'm liking the 'send' command even more now. Hmm, though it doesn't quite fit for phone or voice calls. 'chat' command maybe still works for that?
- Maybe just a single semi-colon to designate a variable/alias in string? And, perhaps no space allowed between them.
- Maybe look into Lojban language more to learn their common root words.
- Easy way to copy entire self file to another file.
- boolean-group should automatically be used as bit size even though boolean takes up one byte? Sure, why not.. or whatever easier is easier at first, not that important for v1.
- Important: Can't tell the difference between a function taking arguments and a function being passed as an argument. More info: http://ll1.ai.mit.edu/marshall.html
  - Perhaps, when a function is being passed as an argument, use `name[]`? This would show that there are no arguments it takes.
- Rather than == for equality, what about =?
  - Ruby has a pattern where they use question marks for boolean methods and exclamation points.
- TextOS, it's not just text.
- Instead of 'alias', perhaps use 'var' for variable and 'val' for constant/final values. Both would still be able to reference fields or functions.
- Each line of terminal app is holding a text-view. This would allow more actions on it.
  - Actually, each line would hold a view or any subclass of that.
- No hardcoded assumptions.
  - All platform-independent (at least as much as possible).
  - Aka, future-proof
- By default, as much is shared as possible [for every object].
- Ability to define a constant amount of 'concurrent' threads the OS should have at any given time. For embedded devices, this might be zero or one.
  - Ability to have no extra apps. [or, whitelist/blacklist apps]
  - Better app and OS integration.
- float
  - Use a number after the 'float' keyword to signify how many decimal points to be accurate to. Ex: 'float2', 'float15', 'float83'. By default, it would be 16?
- Programming language for our 'modern' keyboards.
- Idea: Language config file that says use [] for blocks and allow - for identifiers.
  - Then, lang would be more future-proof and can have config changed. By the time keyboards drastically change, there would be a program created to automatically convert between the different syntax configs.
- Re: Config
  - It will possibly be called '.config', and there would likely be a '.local-config' too to .gitignore.
- When doing integer division, the value and remainder are both returned in the tuple.
- Programming language axioms?
  - Must have code scopes separated by brackets OR be indented
  - To avoid ambiguity in function calling, the arguments must either be wrapped OR not allow inline function calling (ex: `var v = sum 2 mul 2 3 4`) OR accept params in the body of the function (ex: `sum [ input a, b; ... ]`) (note: smali does this).
    - To be un-ambiguous, function calls without wrapped arguments would try to take all on line (or to some next token?).

        ;; Perhaps..
        ;; Function with input
        foo [[input-a input-b]

        ]
        ;; Function without input
        foo2 [

        ]
        ;; Nah, actually doesn't work. We need a way to distinguish defining a function and passing in arguments to an already defined function. Using `[[]]` syntax could mean with inputs and empty function body. Things should be understood locally (aka, without having to look up is a function is already defined. Plus, it could be redefined).

    - Python still uses two tokens to define scope. Bracket method would be two tokens too.
    - Square brackets around arguments, tabs for code. Hmm, would still need to figure in long signatures.
- TODO: Check out how other cross-language frameworks name their widgets and stuff.
- Scopes of applications: (https://www.youtube.com/watch?v=-KqNO_sDqm4)
  - Hardware
  - Driver
  - OS
  - Application
  - Scripting
  - DSL
  - Meta DSL
- No 'switch' keyword, just reuse 'if'.

        if a > 90 [; Do something ;]
           a > 80 [; Do something ;]
           a > 70 [; Do something ;]
           else [; Do something ;]

- The language automatically creates objects pools for each type. Aka, things are entirely garbage collected when they are done [lose reference].
  - Perhaps provide a half-life for them also.
- The niche-most language.
- Programming language that can accept different syntaxes...
  - Hmmm, kinda like LLVM IR?
- It needs to be easy to create and re-use new data types so that devs aren't always using strings/text for everything.
  - Perhaps, need the keyword 'type' or 'datatype' of 'format' in a block/scope.
    - Nah to 'datatype'. We can make it easy to say 'sql-type' and 'date-type' and 'network-type' and 'network-class-type'
- There is 'input' and 'output'.
  - Maybe a 'debug-output' and 'error-output' also?
- Think about bash scripting semantics and syntax when writing Anonlang.
  - Maybe have a special terminal lang?
- Generic programming is what Anonlang is trying to accomplish more of.
- booleans are just 0 and 1, more so.
  - When combining with text, it will say 'true' and 'false'
  - When combining with number, value will be 0 or 1
- Ability to detect possible overflow and underflow for static sized numbers. More info: https://capnproto.org/news/2015-03-02-security-advisory-and-integer-overflow-protection.html
- Interesting idea for serialization: https://capnproto.org/rpc.html
- OS/hardware should allow for more varied clockspeeds?
- For imports, `use number` by default means the same as `use anonlang.number`. Thus, allow other libraries with same name to be used just by changing the top.
- Attributes can be done similar to SXML: https://en.wikipedia.org/wiki/SXML
  - Use @ sign for attribute
  - Instead of going in block, probably should always before the item it is being applied to?
  - Hmmm, maybe don't need attributes at all? At least not in v1 or v2.
  - Useful for meta-programming and/or macros?

            thing [ @background-thread @watermelon [type=big]
              ;; Do something
            ]

            thing [ @[background-thread watermelon[type=big]]

            ]

- Can we view all Anonlang files as 'content', then have other 'build' files interpret that 'content'? Isn't that what all languages do? We can make sure that all of our interpretation is done on an AST is already created so that any tools can easily extend from that.
- 64-bit address space is supposed to last us millions and millions of years? What if every function written had it's own unique address space?
- Spaces needed between '-' so that we can distinguish between minus and part of a symbol (function or variable name) or maybe even date.
  - Then, would probably need to do that with all the basic operators at least? That is how Rebol currently handles it.
- Thought: Within an app, everything is public. To make things private, must put it in a lib that defines what's accessible.
- Thought: Types aren't labeled often because the variable name should be good enough to tell what it is to be used for. No strings have a label because either it's clear or should be using a different data type/structure.
- For GUI, automatically add outside padding/margin so that blank spaces within the layout aren't greater than x. Maybe 20em?
  - Perhaps need to have config toggle for auto-nice or auto-whitespace-help mode.
- TODO: Figure out a good strategy for creating multiple columns on a page where the first column flows to the next. Example use case would be some scholarly articles.
- App can have access to isMutedByUser rather than be blindsided. Maybe have access to system volume levels also.
- Provide users easier ability to see exactly how much data each website is downloading and uploading. And, how much battery is being used, maybe.
- Should it be allowed to have optional named-scope-closer? For example:

        my-scope [
          ;; Do something.
        ] end my-scope
        ] ;; end my-scope

- When sharing documentation, make sure the source code is just one click away also.
- Functions only accept one parameter. 'input' is optionally used to help parse the group that may be passed in.
- When defining Anonlang types, there can be a human-readable-type and simultaneous a storage-type or data-type or computer-type or transfer-type. Thus, use readable 'json' and protobuffers at same time by just defining type. If only one type is defined, then that will be used for both reading and storage and transfer.
  - FileType.Markdown.GitHub or Language.css or A.Lang.Anonlang or A.L.markdown?
- Prepend with 'alias' to just store reference, without 'alias' they would be immediately called. Maybe need 'lazy' tag for that case? But, shouldn't have to worry about that when performance isn't a concern.
- Back to text. Back to editing the raw data. Then, view any way you'd like.
- Something like proguard can be activated by default for production? But, people have many problems with the real ProGuard. Nah, don't have because this language is for the case when people don't have worry about space or performance.
- Blog: Use yes/no or true/false. The later is just good for discrete math, aka boolean algebra and yes/no can be used everywhere else?
- To prevent extra scope brackets, function declarations can have the input parameters defined with the `input` command in the function scope. Though, still need to figure out the calls would be done without extra tokens.
- `alias` always used for non-executed, basically just renaming. `var` for executing. `val` for executing only once when first called.
  - But, some countries don't distinguish between 'v' and 'l', so this wouldn't be so well for that. So, how to use less keywords?
    - 'alias' and 'var' would essentially be the same it seems.
  - Do we need a way to easily change from `val` to a 'lazy-val'? No, if we use the performance / space doesn't matter paradigm. Then, we don't need the 'val' keyword either for that same logic... Great! No constants in Anonlang. But, have a tooling way to help make sure variable doesn't change? Not if everything is immutable! Summary: Everything immutable in Anonlang using 'alias' keyword to show when new names are created.
- Perhaps colon for alias and equal sign for solve once. Unfortunately, the names by themselves wouldn't show which they are. Hmm, maybe that is a good thing to hide implementation details. Oh, people would have a general idea by if the alias name was a noun or verb.
- Create 'fun' library. this is where '99 bottles of beer song can be added', or maybe just add it to lyrics library? Though some fun libraries can also be useful.
- Re: 'keyword-use' 'keyword-import'
  - 'use' is nice that it's short, though it doesn't follow the style of other Anonlang names that could be verb/noun? 'import' could be that verb/noun. Though 'use' is short and sweet.. Hmm, but I guess 'use' could be called without it actually being used.. So, 'import' seems to be the better keyword for now.
  - Need to consider when use/import is done within a smaller scope, like available to only one attribute/function.
  - Perhaps some way to limit more typing when 'use'ing.

            use Anonlang.Layout
            use Anonlang.Layout.Animation
            vs
            use Anonlang [
              output Layout [
                  output Animation
              ]
            ]
            vs
            use Anonlang [
              Layout [
                Animation
              ]
            ]
            ;; But, how to tell Animation is included, but other Layout package would or wouldn't be included? Must be separate lines it seems:
            use Anonlang [
              Layout
              Layout [
                Animation
              ]
            ]

- Feature: Partial/scope compile. Basically, represent Anonlang alias/function in a box that allows easy toggle between different levels of code. The last level edited would become the 'source'. Or, to make that more understandable, perhaps remove the higher level code (or grey it out) once the lower level code is edited.
- If shift keys are used in Anonlang, then what should they be used for? They really are in prime locations.
- Code sure looks nice without brackets everywhere: https://en.wikipedia.org/wiki/Cobra_(programming_language)
  - I also like Cobra's use of brackets as variable identifiers in the string.
- If there is a 'new' operator, then should there be an 'old' operator too?
  - Perhaps, if compiler sees 'old' being used, then it will cache instances that aren't used anymore and reuse them.
  - Though, 'old' really doesn't fit the verb/noun paradigm..
- Re: 'keyword-strict' 'keyword-secure'
  - Maybe this would mean secure(?) as in no eval or other possibly unsafe function can run unless otherwise defined as okay?

            use strict [
              except [
                network anonlang.com
              ]
            ]

  - Perhaps add to config blog instead of creating a new 'use' keyword.
    - A better name for this may be 'static-code'?

- "Things that are different should look different." Common and right things should be short.
- https://en.wikipedia.org/wiki/Zero_one_infinity_rule
- A new thread could be as simple as 'new thread'. A new process could be as simple as 'new process'. Each would take a name in constructor and have a start and stop function.
  - Hmm, actually, if we follow the performance doesn't matter paradigm, then all we would have to specify that a task is a background task? Or, perhaps that could be done automatically as long as it isn't related to UX?
  - Dev shouldn't have to worry about threads? Processes may be important though because they would be used as encapsulation
- Every object has a config attribute? Kinda like a builder(?) so that new classes wouldn't have to be created? This is already implicit?
- Re: 'keyword-input'
  - Final compiled version of input keyword may has argument list in scope.

            alias my-function [
              input a b c
            ]
            alias my-function [
              input [a b c]
            ]

  - This makes more sense so that we can do 'input.a' to distinguish it from other local variables.
  - What about functions inside of functions. Need a 'super.input.a'?

            alias my-super [
              input a b c
              alias my-sub [
                input a b c
              ]
            ]

- There are named inputs, so there should also be named outputs!?
  - By default, just use the local variable name? But, then that would break encapsulation.
- Re: 'keyword-art-lang'
  - Perhaps most files would end with '.art'. Though, if more explicit formatting was wanted, then we could also do '.art-style', '.art-layout', '.art-view', '.art-task', '.art-model'. Though, that meta might instead appear in the actual file name rather than the extension.
- Since Anonlang libraries would be plugin systems. Perhaps make it easy to specify which is used in the config.

        config [
          implementation [
            production [
              http okhttp
            ]
            test [
              http okhttpmock
            ]
          ]
        ]

- Re: 'keyword-input' 'keyword-output'
  - Since input and output keywords would be used very often, should they be shortened to just 'in' and 'out'. It would be nice to have half to type, though would it be more confusing for new programmers?
    - Hmm, Java kinda has a System.out and System.in that can be written to and read from.
    - Note: Doing this would mean overloading 'in': inputs and checks in a loop.
- Create Python function for get-html-from-anonlang
  - Though, should probably be in JavaScript or PHP to get easier Anonlang penetration to web.
  - Possible to go to DOM directly instead of HTML, then DOM?
  - But, HTML would be good for other converters, like invoice project.
  - Perhaps to both DOM and HTML. HTML first! Speed doesn't matter for now. Ping is slower.
  - When parsing, perhaps option to keep comments or not.
- More things to consider:
  - type checking, dynamic storage management, allocation, deallocation, garbage collector, exception handling, multiple assignments, debugger, breakpoints, single step, variable inspection, update, start at arbitrary places, REPL, linker, talk to files with buffered files or 1 char at a time, character representation, large number arithmetic.
- Instead of calling 'super.attribute', could instead use '$.attribute'? Nah, this sugar only later if super is call a lot.
- Re: 'keyword-quicksort'
  - Haskell:

            qsort [] = []
            qsort (x:xs) = qsort (filter (< x) xs) ++ [x] ++ qsort (filter (>= x) xs)

- Re: 'keyword-quine' 'keyword-reflection'
  - Allow in non-strict mode to output code as data.
  - Perhaps, put this quine function in a 'reflect' class like the 'system' class?
- Use 0xx prefix for base-64?
  - Look up how it is typically done. Maybe 10 numbers, 52 letters, dash, and plus/undrescore
- The encoding for the file should be near the front of the file. Should all the file attributes also be encoded into the file instead of as meta-data? We could say that the config section is always utf-8 and it has implicit fields like data and type and stuff. Though, config sections could get big.. is that okay? For the Anonlang paradigm that size and speed doesn't matter, we should add it for the convenience.
  - We would need a new tool for compressing and decompressing so that the beginning isn't messed with too much. We could/should leave everything as one file still though? And, if applicable, have the thumbnail included in the implicit config attribute also?
  - This would mean that every file is non-zero size. And, that's okay because it's always been non-zero size with meta-data in the different file systems?
  - 'meta' would actually be more accurate it seems rather than 'config', but 'config' as a word might make more sense [to newcomers] even though it isn't quite as accurate? Aka, get name metadata from file.meta.name, and not file.config.name. Hmm, should we make a distinction between meta and config? That'll probably be too much nuance. To things a dev would edit, it's configuration. To a user of the file/API, it would all seem as meta data.. Hmm, though 'meta' is shorter.. Things are more beneficial from the perspective of the user? As a dev, I really wouldn't mind too much between editing name and description in a 'meta' attribute as opposed to a 'config' attribute.
  - Okay, 'meta' for things that should be exposed to outside the file. 'config' for things that are internal for the file. So, hopefully, won't need config attribute often.
- The over-arching name for variable/function/class could be called 'pattern'? Then, as a Anonlang description, we can say patterns can have patterns, and patterns can be passed as inputs and outputs. And, on the other side of things are actions. So, Anonlang has just patterns and actions.. though, any of it can be used as raw data also.. though, that data could be seem as patterns and actions. Hmm, though sometimes, actions wouldn't/dont do anything? So, 'action' sounds nice at first, but there could possibly be a better choice.
- For packages (apps and libs), would a 'package.art' config file make more since than being always consistent with 'config' everywhere else? Or, perhaps they should be different names because the top-level config may do some few different things. Hmmm, need to create and use some sample files at each level to extract more details.
  - Different stacks have used 'config', 'package' (Node), 'app'.

            ;; package.art (currently based on Node)
            name 'My App'
            version '0.0.1'
            script
              start 'art ./bin/www'
            dependency
              body-parser:1.13.2
              cookie-parse:1.3.5
              express:4.13.1
              jade:1.11.0
              mongodb:2.0.33

- It seems that there are two major cases for a package manager. One for the system level and one for the development level. Big question: Could just one package manager be enough for both? Wouldn't want unnecessary name conflicts or too easy of misspellings working?

        pm add com.google.chrome.stable
        pm add com.google.chrome.android.stable
        pm add com.google.chrome.ios.stable
        pm add com.google.chrome.corelib:42.132.97

        pm add com.example.android:awesome-app
        pm add com.example.android:awesome-lib
        pm add com.example.ios:awesome-app

  - Something else to determine is when libs should be added local or global, and when an app should be added for just current user or all users. A good/intuitive default should be the same for all so that most people don't need to read any documentation. Even though, some apps/libs make more sense global and some make more sense local.. having a common working theme would be best. Perhaps, keep in mind the idea of least-privilege. So, apps and libs added local for current user.
  - Typically, libs shouldn't be removed so that dependencies wouldn't be broken. But, there are times, like security concerns, that maybe they should be used anymore. What to do in these cases?
    - By default, new and lesser-used (under 1000 downloads?) libs/apps can be removed with no issues.
    - If there are many users of sunsetting package, perhaps make it a minimal cost to remove, as to promote not removing them? $1 per 10,000 (or, 100k) downloads to sunset a package?
  - Need to consider about command line utilities, which should be easy to use. Shouldn't need to type out long name each time. Shouldn't have to manually define each shortcut? Hmm, perhaps use the same idea as in Java.. the full package name could be used, or just the ending. This is the same idea that would/could be used to find packages in the package manager. If there are two packages of the same name, then the full package name would have to be used.
- Attributes/modifiers for attributes/functions could be proceeded by a backslash. Some modifier names would be reserved, others left open to users.

        \global \lazy \singleton \markdown \async my-thing [ ... ]

        \[global lazy singleton markdown async] my-thing [ ... ]

- If settings are created for everything, then it will become like Windows Registry.
- Create M programming language. It's shorter than minimal, mnml, min, mn.
  - Idea: Use fewest tokens as possible to do everything. Readability isn't the biggest goal for this language. Thus, things that could be implicit are implicit, just as long there isn't (too much) ambiguity. The process of going through this will help to design Art and Anonlang by seeing things in a different perspective.
    - Similar to J or other codegolf languages? Kinda, but not really, because those try to have fewest characters/bytes whereas M will attempt to have fewest tokens. The distinction is that tokens can contain multiple characters, which tends to help readability. Maybe more similar to Ruby?
    - Hmm, don't most languages try to have least amount of tokens avoiding ambiguity?
    - The outcome of this project really depends on what the requirements are. How many features should be available? (CSV is good for list of data)
    - Restriction: Limit input to keys found on standard keyboard.
  - Patterns:
    - No need to define parameters. They are just always accessible, if available. (Similar to some shell languages.)
    - No need to use token when returning value if we just return the last line automatically. (Similar to Ruby, and others.)
  - Iffy-patterns:
    - Max length names so that so whitespace isn't needed for next token.
- Colon as assignment, and single equals sign as equality?

        call: 'maybe'
        if call = 'yes' [
          ;; Do something.
        ]

  - It could be possible to not use any extra (non-whitespace) token for assignment.
    - One potential pro of having colon could be to easily have multiple keys for a single value? Hmm, it could be read multiple ways ambiguous, thus not intuitive. Ex: 'k1 k2 k3: val'
    - So, not really any benefit for having an assignment token, besides maybe readability?
  - What would 'a : b : c' mean?
  - Maybe have contextual equal sign like in math? 'Let x = 12. If x = 12, then do something.'
- Using brackets instead of indentation is better (aka, more reliable) when code is being copy+pasted. It's easier to lose indentation than it is to lose brackets.
  - A missing bracket is a syntax error. A missing indentation is wrong code.
- Anonlang standard library always connected in the cloud, always expanding. When they are used in an app, then necessary code could be cached locally.
  - For those that don't want that, a full snapshot of the standard library could be made available offline.
- Ampersand for sugar syntax for hashing.
  - But, ampersand is already too common of usage for bit manipulation.
- There is
  - CRUD: Create Read Update Delete
  - ARGS: Add Remove Get Set
- Re: 'keyword-publish', 'keyword-deploy'
  - 'publish' is more common 'deploy' according to [Google Ngram](https://books.google.com/ngrams/graph?content=deploy%2C+upload%2C+publish&year_start=1800&year_end=2000&corpus=15&smoothing=3&share=&direct_url=t1%3B%2Cdeploy%3B%2Cc0%3B.t1%3B%2Cupload%3B%2Cc0%3B.t1%3B%2Cpublish%3B%2Cc0)
  - Could use 'push test' and 'pull production'?
  - Need an easy way to work offline, then 'publish' the build/project/app/package.

            config [
              alias clean []
              alias build []
              alias publish [
                in dest ;; Either test or production
                build dest
                alias url
                if dest = 'test' [
                  url 'sftp://example.com/test'
                ] else if dest = 'production' [
                  url 'sftp://example.com'
                ]
                ;; TODO: Send build/<dest> folder to defined URL.
              ]
            ]
            config [
              publish-production-url 'sftp://example.com'
              publish-test-url 'sftp://example.com/test'
            ]

  - Possibly only upload changes. Thus, possibly integrate git. Actually, there are standards for 'change' files. So, we could just do a local diff and upload that results. Hmm, though things could change on remote without local knowing.. Perhaps a hash of each folder to know if things were changed? Or, we could just look up the last modified date, though that might be a little more susceptible to being incorrect. So, do both? Or, we can have a remote watcher that takes notes of changes in a file at root. Hmm, basically, we might just be building git here.
    - `art remote add public sftp://example.com && art push public`
    - Hmm, maybe too close to git, it doesn't really imply build and pushing that. So, would maybe need to change it up with 'art push build public'.
- Re: 'keyword-art-init'
  - If there ever is a command to 'art init [<package>]', then there will probably be a directory somewhere full of templates to use and easily edit and share.
    - Each of these templates might even be a package in pmaas.
- Language idea: All language keywords would be symbols, then all letters seen would be from user or library defined things.
- Re: 'lifecycle' 'life-cycle'
  - Non-GUI app: start->stop
  - GUI app: start->show->hide->stop
    - Limiting to these because this is likely the subset that all apps would use. Additional events could be handled separately, like on-focus-change (handled within views?), on-cold-start?, ..
  - When implementing/superclassing/subclassing these, the superclass should be able to define the default location to be called, as in beginning or end of the function. That way, the subclasser doesn't have to worry about manually calling the superclass method. Hmm, maybe kinda like how Java constructors can call a default super().
- Code between square brackets are strictly scoped. Aliases created in the scope can not be accessed outside of the scope.
- Instead of `db.beingTransaction` and `db.endTransaction`, maybe do `db.transation.start` and `db.transaction.stop`.
  - Possibly better: `db.batch [ [; Do stuff to db here. ;] ]`
- Instead of having an app lifecycle with a start and stop function to optionally override, what about a concept of function listeners for all functions? Then, if we want to get a callback and do some work during the app 'start', then we would call `App.onStart [ [; Do something ;] ]` or `app.start.add [ ... ]` with a corresponding 'remove'. To make it look less like a list or group or data object being added too, maybe have a 'callback' keyword available for the function names.
  - Is it good for anybody anywhere to get a callback for any function?
    - Useful for diagnostics that only run in debug/test mode.
    - Kinda like function extensions, but for the inside? or reversed?
- Don't make strong language decision based on performance or space. This language is for a different paradigm. This is likely mentioned elsewhere, though it still good to repeat.
- A global trie tree for all aliases?
- Printing/outputting functions might be as easy as outputting text.
- To call a function, put the equals sign before it. Kinda like a spreadsheet program.
  - Hmm, then back to colon for assigning?
  - Summary: equals-sign to call right side once, colon would mean it's basically okay to inline the right-side everywhere the left-side is called. The language may not actually do that, but it would be similar in that the rhs gets called multiple times. Variable, not value.
- Lazy evaluate by default, then keyword maybe needed for when to calculate immediately. Then, again, lazy eval might just be good enough. Only reason to evaluate early may be to pre-build a cache and prevent long-running code from happening later.
- StandardMessage or AnonMessage
  - Base for things like Android's AlertDialog, Toast, and SnackBar
  - Style can be passive or active
- Anonlang app, every app is the same base, just different styles/plugins applied.
- Rather than just having every UI view have the '-view' suffix, perhaps just putting the alias directly to the layout should work. We could say text goes in a text-view, input numbers into a number-input-view, but what exactly do we gain? Those conversions can likely be done automatically, thus freeing developers from seeing '-view' everywhere in a layout.
  - So, thinking about gains coming from adding the '-view' suffixes.. Would they have more attributes than their 'non-view' makeup/counterpart? 'text' itself doesn't need any styling, it would just be the backing data and very minimal. When putting 'text' in a layout, we may want to add different 'text-style' to it.
  - Or, should we think of it as every use of 'text' is actually using a 'text-view' is diguise?
  - What about things that don't have a 'view' counterpart? Or, are they any such things? Sure, like thread, but maybe those would just be invisible by default.
  - Another consideration, what about when we want to include code in the layout or template? We may need to distinguish between text that shouldn't be shown and text that should be shown. It seems nice to be able to just write a view in a layout and have it appear, rather than having to call show on the view each time.















## Design Pattern ##
Also, need to think about non-gui apps.

Design patterns are overrated. Just provide an interface for things that may change.

    ;; There could be multiple layouts
    ;; There could be multiple styles
    ;; There could be multiple action/dynamics
    ;; There could be multiple data/content
    ;; Layouts might be changed by data and dynamics
    ;; Layout really is a template... though, does it need to be called a template when it is used like that?
    layout-style-dynamics

    controller [
      input layout data style dynamics
      show layout
      layout.add data
      layout.add style
      layout.add dynamics
    ]

    ;; So, a 'reference' app could just have the layout and data.



## Further Resources ##
- [XKCD: Standards](http://xkcd.com/927/)

- [http://en.wikipedia.org/wiki/Haxe](http://en.wikipedia.org/wiki/Haxe): What was done right and wrong? Still viable? Too early?
- to-read: http://en.wikipedia.org/wiki/Cross-platform#Cross-platform_programming
- Nice article: [Web sucks and how to make is awesome](http://www.presslabs.com/blog/web-sucks-how-to-make-it-awesome/)

- [Video: Jon Blow on building a new programming language for games (2014-09)](http://www.gamasutra.com/view/news/226070/Video_Jon_Blow_on_building_a_new_programming_language_for_games.php)
  - His thoughts:
    - Primary goals:
      - friction reducing
      - joy of programming
        - very fast compilation
        - lack of tedium when expressing self in code
        - pleasant and helpful error messages
      - performance
      - simplicity
      - designed for good programmers
    - Many game programmers want the ability to manually do GC because current state isn't good enough.
    - 85% solutions vs "100%" solutions
    - RAII: Resource Acquisition Is Initialization
      - "There is no such thing as 'resource'."
      - "'Resource' really means: Memory , file handle, texture map"
      - RAII are there only because of Exceptions (and they are handled by language).
      - Go-lang does it right, returns error code with the regular result so that 'Exceptions' are skipping around.

- [Single Language Operating System](http://c2.com/cgi/wiki?SingleLanguageOperatingSystem): Author discusses how a higher-level language for OS could be useful. And, projects going in this direction are mentioned. Other interesting ideas are linked:
  - [Languages are Operating Systems](http://c2.com/cgi/wiki?LanguagesAreOperatingSystems)
  - [Steps toward the reinvention of programming](http://c2.com/cgi/wiki?StepsTowardTheReinventionOfProgramming)
  - [New OS Features](http://c2.com/cgi/wiki?NewOsFeatures)
  - [Killer File System](http://c2.com/cgi/wiki?KillerFileSystem)

- [Martin Fowler: Language Workbenches: The Killer-App for Domain Specific Languages?](http://www.martinfowler.com/articles/languageWorkbench.html#HowLanguageWorkbenchesAlterTheTrade-offsForLanguageOrientedProgramming.)
  - "Let's consider one technology that has really succeeded in making lay programmers effective - spreadsheets. Most programmers don't think of spreadsheets as a programming environment. Yet many lay programmers create sophisticated systems using them. Spreadsheets are a fascinating programming environment that suggest characteristics for a lay programming tool might need:"
    - Immediate feedback
    - Deep integration of tool and language
    - No textual source
    - No need to show all information all the time - formulas are only visible when you edit the cell containing them, otherwise the value is shown.
  - "So when we think of the DSLs in a language workbench, we should be thinking less of the kinds of languages I've shown here - or of the graphical languages beloved by modelers. Instead we should be thinking of things like the next generation of spreadsheets."

- [Lisp vs XML](http://c2.com/cgi/wiki?LispVsXml)
- Meh: Somebody trying to create standard language for translating code to others. http://www.codeproject.com/Articles/606610/LLLPG-2cplusLoycplustrees-2cplusandplusLES-2cpluso (2013-06-27)

- [Why do programming languages use curly braces and not square brackets?](http://programmers.stackexchange.com/questions/188455/why-do-programming-languages-especially-c-use-curly-braces-and-not-square-ones)

- Meh: [Bistro (cross b/w Java and Smalltalk)](http://www.drdobbs.com/web-development/the-bistro-programming-language/184405578): A language that somewhat uses square brackets for scopes/blocks, though also more wordy than Anonlang. (Bistro: http://bistro.sourceforge.net/)

- Paul Graham:
  - Great: [Popular Language](http://paulgraham.com/popular.html)
  - Great: [The Hundred-Year Language](http://www.paulgraham.com/hundred.html)

- Maybe: [Programming Language Checklist](http://colinm.org/language_checklist.html)
- Maybe: [Learnable Programming](http://worrydream.com/LearnableProgramming/)
- Maybe: [Reddit: OS Dev](https://www.reddit.com/r/osdev/)
- Maybe: http://wiki.osdev.org/Main_Page
- Maybe: http://c2.com/cgi/wiki?HomoiconicLanguages
- Maybe: http://elm-lang.org/
- Maybe: http://uilang.com/

- Interesting: http://c2.com/cgi/wiki?EverythingIsa

- AWESOME: More ideas for simplicity of language: http://easiestprogramminglanguage.com/easiest_programming_language.html
  - http://re-bol.com/rebol.html
  - http://business-programming.com/business_programming.html
  - keywords: http://www.rebol.com/docs/reference.html
  - quirks: http://blog.hostilefork.com/major-rebol-language-quirks/
  - Similar lang: http://www.red-lang.org/
    - Open source: https://github.com/red/red/tree/android

- https://github.com/rebol/rebol
- Should look through to get a good quick comparison to Rebol: http://www.cis.upenn.edu/~matuszek/Concise%20Guides/Concise%20Rebol.html
- http://blog.hostilefork.com/why-rebol-red-parse-cool/

- Good: OS projects: http://wiki.osdev.org/Projects

- Language design: Video: [Growing a Language, by Guy Steele](https://www.youtube.com/watch?v=_ahvzDzKdB0)
  - Plan language for growth
  - Plan for warts
  - Allow users to help grow language
  - Short words work well if you choose them well

- Rascal lang: http://www.rascal-mpl.org/
  - http://www.rascal-lang.com/
- Good: http://lukeplant.me.uk/blog/posts/less-powerful-languages/

- Re: 'language-awk'
  - Associative array. Awk is great case study and format/pattern/language
    - Pattern -> Action format
    - New Anonlang type: `type pattern-action`
- Re: 'language-erlang'
  - http://c2.com/cgi/wiki?ErlangCodeExamples

- TODO:
  - Read http://lambda-the-ultimate.org/node/3680
  - Read references on http://paulgraham.com/popular.html
  - Read: https://en.wikipedia.org/wiki/Comparison_of_programming_languages_(syntax)
  - Read: http://rigaux.org/language-study/syntax-across-languages/
