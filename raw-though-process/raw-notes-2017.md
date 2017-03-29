It would be nice if the interpreter was able to 'skim' all the top-level names so that they don't have to be defined in a dependent order.
- Would just keep a pointer to the name and not evaluate anything. This is good tradeoff for performance and useability.
  - possible-con: Are files going to have millions or billions of top-level names?
    - Hmm, maybe could save the first million and skim the rest later? Hmm, perhaps concurrent scanning always so that the program always starts immediately.
  
It would be nice if we had the functionality of a full language in each filetype (like Gradle has with Groovy-lang).
- So, top-level can do full-language stuff, then each closure/content would be dependent on what the content or what it is for.
- possible-con: Maybe don't want to interpret any data in a file, so this would mean creating a blank closure, which may be considered boilerplate even if it is short (maybe just enclosed in braces or first line containing something like `[data]`).
