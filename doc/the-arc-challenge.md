# [The Arc Challenge](http://www.paulgraham.com/arcchallenge.html)

    ;; In Anonlang
    col [
      in input-view
      button-view 'Submit' nav button-view 'Click here' nav text-view 'You said: ;in.value;'
    ]
    
    ;; In Anonlang expanded
    col [
      in input-view
      button-view 'Submit' [
        on-click nav button-view [
          value 'Click here'
          on-click [
            nav page [
              text-view 'You said: ' ++ in.value
            ]
          ]
        ]
      ]
    ]
    
    
    [; Written in Arc
    (defop said req
      (aform [w/link (pr "You said: " (arg _ "foo")) (pr "Click here")]
        (input "foo")
        (submit)))
    ;]
    
    [; Written in Arc 2009
    (defop said req
      (aform [onlink "click here" (pr "you said: " (arg _ "foo"))]
        (input "foo")
        (submit)))
    ;]
