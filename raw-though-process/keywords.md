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
  import
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
  bind/unbind
  create/destroy
  get/set
  hit/miss
  import/export
  * in/out
  input/output
  on/off
  open/close
  push/pull
  set/unset/reset
  * start/stop
  update/revert/undo
  upload/download
]
