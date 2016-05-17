# Anondata Grammar

- To have or not to have:

        app [ ... ]
        app: [ ... ]

  - Show-pro: consistency for the rest of Anondata, simpler dev code
  - Hide-pro: less typing, consistency with Artlang functions(?)


## Sample
Each sample here is roughly equivalent for end use. Different compatible styles are shown.

### A

    ;; A comment
    app [
      name: My App
      version 0.1.0
    ]
    config [
      my-int: 5
    ]

### B

    [; A
       multi-line
       comment
    ;]
    app [
      name: '''
            My
            multi-line App
            Name
            ''',
      version: 0.1.0,
    ]
    config [
      my-int: 5
    ]

### C

  [[;A :';'''comment;]app['name':'My App',version:'0.1.0',],config[my-int:5]]
