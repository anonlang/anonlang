# Anondata - Minimal syntax structured data #

This is Anonlang with just another name...

This is in direct comparision to JSON for an intermediary human-readable data structure.

There are only a few syntactic changes, but enough to believe that this will be the main data format of the future. (Admittedly, the next few years will still likely be mostly JSON-strong just because of the available libraries and APIs already using it.) Conversion between the Anondata and JSON is trivial. Both follow the key-value paradigm.


Anondata differences compared to JSON:

- No quotation marks required for keys.
- No colon.
- A newline can be used instead of a comma.
- One 'group' data structure, which is like a combination of JSON's 'object' and 'array'.
- Comments are supported
  - `;;` for single-line comments
  - Put multi-line comments between `[;` and `;]`
  - (Sidenote: May eventually change to using dash `-` instead of semi-colon `;`)

Here's what some sample Anondata looks like:

    ;; Some description here.
    menu [
      id 'file'
      value 'File'
      popup [
        menuitem [
          [ value 'New', onclick 'CreateNewDoc()' ]
          [ value 'Open', onclick 'OpenDoc()' ]
          [ value 'Close', onclick 'CloseDoc()' ]
        ]
      ]
    ]

The same data expressed as JSON:

    {
      "menu": {
        "id": "file",
        "value": "File",
        "popup": {
          "menuitem": [
            { "value": "New", "onclick": "CreateNewDoc()" },
            { "value": "Open", "onclick": "OpenDoc()" },
            { "value": "Close", "onclick": "CloseDoc()" }
          ]
        }
      }
    }


Some may notice that this also somewhat resembles cleanliness of Ruby and has more of a lisp-y feel without being over-bearing. I'm sure somebody else has also thought about this style of syntax, but unfortunately I didn't find it in my minimal research. I'd be happy to combine forces for the same syntax (current name is mainly just a placeholder).
