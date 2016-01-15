# Anonlang Project Structure #

At first I was considering that all projects must have a `config.anon` file. It seems like it would be useful to define defaults, and it probably will be. But, the quick question is about whether or not the config file should be required for *all* projects.

There are plenty of times when quick snippets and scripts are created. We don't want to force the creation of two files when one would suffice.

Hmmm, that seemed easy enough.. no, the `config.anon` files won't be required, but it would be part of best practices for larger projects.

So, what kind of things would be in the config file? Well, changing project structure should be as easy as possible. Different magnitudes of project sizes require different setups. Though, we can certainly push for something that works for 99% of projects.

Things to specify: (Each are optional and may eventually have defaults)

- Location of main file(?)
- Location of source files to compile, and resources for image/video/audio/raw.
- Location of library (pre-compiled) projects
- Location of local properties and shouldn't be put into version control
- Location of generated files, including compiled code and documentation
- Runtime arguments/configs
- hooks (Anonlang apps also might not need to be compiled first) (Sidenote: Purposely changed from 'pre' and 'post' to 'before' and 'after', to simplify vocabulary and have it better self-documenting for more people, especially beginners)
  - before-compile
  - after-compile
  - before-run
  - after-run

The defaults for each of the above, and possible labels:

- build-type, default='debug,release'
- main, default='./src/main.anon'
- src, default='./src/'
- res, default='./res/'
- lib, default='./lib/'
- out, default='./out/'
- config, default='./config.anon'
- sdk, default=';ANONLANG_DIR;'
- hook, default=''


## Vocabulary ##

Competing vocabulary:

- A "workspace" may contain multiple "projects".
- A "project" may contain multiple "modules".

When I first began my development in a powerful IDE, I didn't understand what a "workspace" was or "module" meant. But, I knew what a "project" was. So, that's my current bases for using "project" as the main term - easier/quicker for beginners to understand.

Also, "manifest" is popular as a root "config" file also.


## Large Projects ##


Here's a sample project structure: (need to change between main and default)

    src/
        default/
        free/
        pro/
    lib/
        default/
        free/
        pro/
    test/
        default/
        free/
        pro/
    out/
        default/
        free/
        pro/

or

    default/
        src/
        lib/
    free/
        src/
        lib/
    pro/
        src/
        lib/
    test/
       src/
       lib/
    out/
        default/
        free/
        pro/



## Sample `config.anon` for one project/module ##

    main 'src/main.anon'
    src 'src/'
    lib [
      src 'lib/cool-lib.anonp', 'lib/awesome-lib.anonp', 'jcenter:com.example:well-tested-lib:v2.1.4'
      compile 'lib/compile/compile-helper.anonp'
      test 'lib/test/auto-tester.anonp'
    ]
    hook [
      before-compile load-more-things, then-another-thing, one-more-cmd
    ]



## Sample `config.anon` with multiple modules ##

    app.name='My Awesome Enterprise App'
    app.version='0.3.1'
    build-type [
      [
        debug minify=false
        release minify=true
      ]
      [
        free app.name=';app.name; Free'
        pro app.name=';app.name; Pro'
      ]
      [mobile,desktop,tv]
    ]
    main 'default/src/main.anon'
    src 'default/src/', ';build-type;/src/'
    lib [
      src  'lib/cool-lib.anonp', 'lib/awesome-lib.anonp', 'jcenter:com.example:well-tested-lib:v2.1.4'
      compile 'lib/compile/compile-helper.anonp'
      test 'lib/test/auto-tester.anonp'
    ]
    out [
      src ';build-type;out/'
      doc ';build-type[2];doc/'
    ]
    hook [
      before-compile load-more-things, then-another-thing, one-more-cmd, minify
      before-run start-timer
      after-run stop-timer
    ]

Sidenote: Is /res/ redundant? Just put all of it in /src/? Hmm, I guess it can be considered at another part of a MVC pattern.



## Modules ##
For naming modules, here's the preferred way. It groups modules together that a dev would want to see at a given time. This organization would minimize scrolling in the IDE's project explorer.

    core-lte-band-lib
    core-signal-lib-android
    core-util-lib-android
    lted-app-android
    lted-app-mobile
    lted-app-pc
    lted-lib
    lted-lib-android
    lted-lib-mobile
    lted-lib-pc
    lted-server-app
    lted-server-lib
    wifid-app-android
    wifid-lib-android
