;; This parser generator can parse this file.

config: [
  is-keep-comments: true
]

token: [
  ASTERISK: *
  BRACKET_START: [
  BRACKET_STOP: ]
  COLON: :
  QUOTE_SINGLE: '
  SEMICOLON_DOUBLE: ;;
]

grammar: [
  program: group (group)*
  group: [
    comment-line
    TEXT COLON block
    value
  ]
  block: [
    BRACKET_START program BRACKET_STOP
    value
  ]
  value: [
    NUMBER
    TEXT
  ]
  comment-line: SEMICOLON_DOUBLE ... NEWLINE
]
