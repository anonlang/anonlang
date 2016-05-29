;; Minimal calculator app by Danial Goodwin on 2016-05-13

app [
  name: Minimal Calculator
  id: com.danialgoodwin.minimal-calculator
  version: 0.1.0
  description: A sample calculator with minimal features and code.
]

start [
  show page.main
]

stop [
  ;; Do nothing
]

main app.page [
  cal calculator [
    input-output-view: layout.input-text-view
    output-output-view: layout.output-text-view
  ]
  layout [
    col [
      input-text-view
      output-text-view
      grid-4x4 [
        loop ch in '/', '*', '-', '+', '7', '8', '9', '0' [
          button-view ch cal.calculate ch
        ]

        button-view '4'
        button-view '5'
        button-view '6'
        button-view 'c'

        button-view '1'
        button-view '2'
        button-view '3'
        button-view '='
      ]
    ]
  ]
  menu [
    'Help' show 'This is the help prompt'
    'Close' stop
  ]
]

calculator [
  first-number
  operator
  second-number

  input-output-view
  output-output-view

  calculate [
    in ch
    if ch:
      is-digit:
        if operator.is-empty: input-output-view.add ch
        else: output-output-view.add ch
      '=':
        if output-output-view.text.is-empty: do-nothing
        else: solve '='
      else: operator: ch
        if:
          input-output-view.text.is-empty: do-nothing
          output-output-view.text.is-empty: operator: ch
          else: solve ch
  ]

  solve [
    in ch
    input-output-view.text: math [input-output-view.text operator output-output-view.text]
    output-output-view.text: ''
    operator: if ch =? '=': '' else: ch
  ]
]
