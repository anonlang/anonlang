If we had one top design reasoning/exploration of the main language, then it would be: How would a language look if users didn't have to worry about performance?
- Thus, the focus would be productivity and maintainability.

It would be nice if the interpreter was able to 'skim' all the top-level names so that they don't have to be defined in a dependent order.
- Would just keep a pointer to the name and not evaluate anything. This is good tradeoff for performance and useability.
  - possible-con: Are files going to have millions or billions of top-level names?
    - Hmm, maybe could save the first million and skim the rest later? Hmm, perhaps concurrent scanning always so that the program always starts immediately.
  
It would be nice if we had the functionality of a full language in each filetype (like Gradle has with Groovy-lang).
- So, top-level can do full-language stuff, then each closure/content would be dependent on what the content or what it is for.
- possible-con: Maybe don't want to interpret any data in a file, so this would mean creating a blank closure, which may be considered boilerplate even if it is short (maybe just enclosed in braces or first line containing something like `[data]`).
  - Of course, there would be a 'safe' way of calling all files to look at them, regardless of what context they have.

Core actions (verbs) that can most things (nouns) can perform:
- add, remove, move, copy, rename, find (aka search, is-contain), get, set
- watch?, 

Core attibutes (describers) that can be used on most thing (nouns);
- name, description (comment), size, value, 
- time-last-modified, time-created, is-modifiable?, 

Core actions (verbs) that can be used on actions (verbs): (helpful for aspect-oriented-programming)
- start, stop
- on-start, on-stop, on-begin?, on-end?, on-error?

Core actions (verbs) related to GUI: 
- show, hide, pause, resume

Hmm, based on the keywords above, maybe we don't need input/output? (besides end-user UI)
- Would it be possible to only work with lists (or 'groups')? And, just keep adding and removing from them?
- random-thought: When navigating GUI in OS, we don't need to think in terms of input/output.
- 'add' and 'set' are kinda like 'input'. 'get' is kinda like 'output'.
- 'Piping' seems to have minimal syntax for handling the passing of values.
  - Everything just having an implicit input/output
  
What if every function in code had an implicit input/output (standard IO)
- Each function could accept an arbitrary number of inputs and could have an arbitrary number of outputs
- No duplicate function names in a namespace/context
- Need easy syntax to set inputs unambiguously
  - Possibly: A syntax for either passing in function (aka pointer) or calling the function
    - Some languages use `()` as the syntax for calling the function.
    - Some languages use `&` as the syntax for passing pointer/reference.
    - A syntax that doesn't use 'shift-key' may be easier.
- Need easy syntax to get arbitrary inputs
  
Syntax for 'context' is maybe `/`.
- This is familiar for people typing in file paths or web paths. Maybe too similar since it would be used slightly differently? Maybe close enough usability.
- Key difference may be that `/place/time` would be the same context as `/time/place`.
  - What if `/game/game`? Same as `/game`? Allow the meta? Provide an error?
- Ex: `/place/usa/time.yesterday`, `/time.2016`, `/time.from.2016-01-01.to.2016-12-31`, `/time/2016`
  - Maybe the `.` syntax here would be like calling a method/function/macro and maybe it would be expanded in the context or maybe it would just be used to narrow output (like a 'find').
- If there was only one 'usa' context, then maybe shouldn't have to also type in the 'place' context for it to be understood.
- If there were multiple 'doc' context, then maybe all types would be shown in some order (alphabetical, usage, time).
- What type of data-structure for O(1) access to these different contexts?
  - If data was copied in multiple places, then it would be easy. But, maybe a better way? Would also need to keep them all in sync. Hmm, maybe just a pointer copied in multiple places.
  
  
