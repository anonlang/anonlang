To clarify use of a library, use the keyword `use` then the lib name.

Usage can be declared at the top of files or within any scope that it's needed in.



Raw thoughts:

- How about an 'app' lib?
  - Maybe don't need this because everything is an app?
  - Maybe a 'publish' lib instead?
    - This would recognize more config values.
- Something related to 'file' lib would be 'convert' and 'merge'.
  - Maybe split to 'local-file' and 'remote-file' libs.
  - Still need good functionality for REST/HTTP protocols since those are quite common.
- Eventually, may change to `.lib` extension.


More eventual ideas, maybe:

    ad ;; Nah, don't make a big deal of this. Maybe we could never have ads.
    ai
    billing
    build ;; Or, make
    cache
    concurrent
    crypto ;; Or, call it security?
    data [
      encoding
      format
      zip
    ]
    debug [
      benchmark
      profiler
      test
      trace
    ]
    display
    event-stream [ ;; Things in Anonlang already can be 'rx' without the equals sign.
      count-received
    ]
    game-2d
    game-3d
    layout [
      animation
      menu
      screen
      style
      window
    ]
    macro
    math [
      equation
      expression
      linear-algebra
      log
      prime ;; Possibly include factoring. math.prime.find-prime-factors output prime-number-group
      trigonometry
    ]
    media [
      camera [
        image
        video
      ]
      microphone
      speaker
    ]
    money
    network
    platform
    protocol
    random [ ;; Need a verb? generate, create, new..
      address ;; street-address
      business-idea
      business-name
      cs-idea
      email
      image [input width height]
      quote [
        tag [albert-einstein, productivity, love, oscar-wilde, sarcasm, chuck-norris, business, dev, computer, money, meme]
        output the-quote author tags id sources
      ]
      name
      number [input min max]
      phone-number [input country-iso=us]
      text [input num-chars]
      username
      uuid ;; Not sure that this is the right place..
    ]
    sensor [
      temperature
      humidity
      motion
    ]
    ssh
    storage [
      internal
      external
    ]
    system



### Additional ideas ###
- Ideas for API about data: https://www.dataquest.io/blog/python-vs-r/
- As a data transfer format: https://github.com/cognitect/transit-format
