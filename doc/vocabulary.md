# Common Vocabulary #
This page hosts some thoughts for what the minimal common language between platforms could be, including for layout, design, style, action, configuration, and meta. These words may be revised as more experience is gained on different platforms.

Different platforms to think about: web, mobile, desktop, terminal, console, tv, automobile, watch, wearables.

Pixels shouldn't be used as a measurement because they are always changing too much. A density-independent 'pixel' can be used instead, which will work more of the time based on device size and resolution, but may be different for projectors, TVs, and automobiles due to distances and safety.


- `config` for meta details about the project/app.
    - `name`
    - `description`
    - `logo`
- `page` for the high-level description of collection of layouts user may see. Similar to a 'webpage' or Android 'Activity'. A page can consist of one or more layouts.
- `layout` for a collection of views or view-groups. Similar to a 'div' or Android 'FrameLayout'.
  - `align` [center, top, right, bottom, left, top-right, top-left, bottom-right, bottom-left]
  - Different types of view-groups:
    - `grid`
      - `row-span`
      - `col-span`
    - `row` shorthand for grid of one row of items, to simplify implementation
    - `col` shorthand for grid of one column of items, to simplify implementation
  - Different types of views:
    - `text-view`
    - `button-view`
    - `input-view`
      - `number-input-view`
      - `email-input-view`
      - `password-input-view`
      - `file-input-view` maybe, if file-uploading gets more popular, though, there are many different ways to show this.
    - `media-view` possibly to include support for different image, gif, video, and audio.
- `style`
  - `bg-color` for background color
  - `fg-color` for foreground color, like for text
  - `bg-media` for background texture/image/video/gif/audio or other supported media
- `action`
  - `on-click` could mean mouse click, finger tap, or enter key press when item is focused
  - `on-long-click`
  - `on-key-click`, `on-key-down`, `on-key-up`
  - `on-finger-click`, `on-finger-down`, `on-finger-up`
  - `on-cursor-click`, `on-cursor-down`, `on-cursor-up`
  - `create`, `destroy`
  - `start`, `stop`



### Vocabulary that may not be common or standard or agreed-upon enough yet ###
The follow may have better alternatives, but not entirely sure yet. Some are almost ready to move to the above section.

    platform
    app [
      price
      license
    ]
    meta
    layout [
      visibility [show, hide]
      transparency [0..100]
      span [0..100] for the percentage an item should span its parent
      divider [show, hide]
      divider-span [0..100] with perhaps a default to 80% or 90% depending on how it looks.
      divider-thickness
    ]
    data [source, value]
    action [name, shortcut]
    
    ;; https://en.wikipedia.org/wiki/ISO_8601
    date [ year, month, week, day
      time [ hour, minute, second, microsecond, nanosecond ]
    ]

## Potential Ideas ##
- Further ideas: 1000 most basic words, just English? Maybe look into Lojban for shared core words?
- https://en.wikipedia.org/wiki/Most_common_words_in_English
- http://www.world-english.org/english500.htm
