# Anondata Grammar

- To have or not to have colon:

        app [ ... ]
        app: [ ... ]

  - Show-pro: consistency for the rest of Anondata, simpler implementation code
  - Hide-pro: less typing, consistency with Artlang functions(?)

  - Consistency is probably most key attribute here

- New name:
  - AGN: Artlang Group Notation
  - AG or AGRAM: Artlang Grammar


## Sample
Each sample here is roughly equivalent for end use. Different compatible styles are shown.

### A

    ;; A comment
    app: [
      name: My App
      version 0.1.0
    ]
    config: [
      my-int: 5
    ]

### B

    [; A
       multi-line
       comment
    ;]
    app: [
      name: '''
            My
            multi-line App
            Name
            ''',
      version: 0.1.0,
    ]
    config: [
      my-int: 5
    ]

### C

    [[;A :';'''comment;]app['name':'My App',version:'0.1.0',],config[my-int:5]]

### D

    app:[]
    numbers:[
      1, 2, 3, 4, 5
      6, 7, 8, 9, 10
      11,12,13,14,15
    ]

### Option?

    config:[my-int:5]
    config:[my-int:[5]]
    config:my-int:[5]
    config:my-int:5
    config.my-int:5 ;; Meh, could lead to more duplicate code. Hmm, but easy writing for some automation tools. Meh.
