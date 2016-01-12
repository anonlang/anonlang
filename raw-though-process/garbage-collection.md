# Garbage Collection in Anonlang

Optional.

There is a simple flag to toggle the GC (garbage collection) mode.



## The different GC modes

- On by default
  - Config option for using manually free memory code as ignore, hint, or real. Ex: `System.memory.free(object)` and not `System.gc.free(object)`. TODO: Need to figure out about trying to clear object that still has references to it. Should there be a 'forceFree()' or just not free it until all references to it are gone first.
  - Config option for outputting objects that have been freed.
- Ability to print references and scope tree for debugging.
- Coding-time ability to see when objects should be freed.


Or,

Have it both enabled and disabled by default for different scopes.

There should be a clear abstraction level for things that need performance and things that don't matter as much.
