Is it possible to have just one type of data structure used for everything?

Everything is an array because all data is stored in indexed memory.

But, we can add a layer of abstraction on that and provide more power for how that is done.

At a basic level it seems that everything is made up of array or linked list. The linked lists that branch would be called trees and the trees with cycles would be called graphs. Sets, queues, stacks, and such can be implemented with arrays or linked lists.

Others' claims of only one data structure needed:

- [Finger Tree](https://dnovatchev.wordpress.com/2008/07/20/the-swiss-army-knife-of-data-structures-in-c/)
- [UniversalHash](http://elbenshira.com/blog/the-universal-data-structure/)
  - UniversalHash = Hash[String|Int, UniversalHash|String]

Then again, abstractions are supposed to make us developers more productive and have things easier to reason about. Regardless if there is one universal data structure, there would likely be abstractions built on it to make certain structures even more productive to deal with.

Having said that, there is currently only one main data structure abstraction, called 'group'. This core data structure may be considered similar to the 'UniversalHash' as mentioned above or Java's LinkedHashMap.
