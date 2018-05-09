# Keywords

<pre>
anonlang-symbols [
  =
  ,
  .
  [
  ]
  '
  \
]

anonlang-keywords [
  alias
  config [name, description, version]
  goto ;; reserved
  group
  import ;; use
  in ;; input
  loop
  out ;; output
  start
  stop
]

anonlang-lib-keywords [
  app [ build, deploy, gui [layout, show, hide, page, view] ]
  database/storage
  file [run, read, write, append]
  format
  lang [number, text]
  math
  media [type] ;; media.type would be like png, json, csv, mov, mp3, mp4, gif..
  parse
  system [input, output, packages]
  task
  template
]

potentials [
  * add/remove
  * in/out
  * start/stop
  bind/unbind
  create/destroy
  hit/miss
  import/export/use
  on/off
  push/pull
  update/revert/undo
  upload/download
]

allowed-verbs [
  add
  close
  hide
  open
  remove
  run [maybe: start] [not: execute]
  select
  show [not: display]
  maybe-not [
    get
    set [not: unset, reset]
  ]
]

allowed-nouns [
  app
  file
  in
  input
  number
  out
  output
  page
  text
  view
]
</pre>
