

> We at Google have come up with a solution for this, that I want to introduce to you, which I don’t think we have ever talked about. We invented a new concept. It is called enhance. It is something you use instead of import.
> 
> In fact, it is the opposite of import. It is a reverse dependency. If you enhance a module, you make that module have a dependency on you.
> 
> Looking at the dependency graph, what happens it that there are still the same components, but the arrows point in the opposite direction. So, instead of the router importing the root component, the root components announce themselves using enhance to the router. This means I can get rid of a root component by just deleting the file. Because it is no longer enhancing the router, that is the only operation you have to do to delete the component.
> 
> This is particular bad case of this problem, because the power of enhancing a module, of being able to make everything else in the system have a dependency on you is very powerful and very dangerous if gotten wrong. It is easy to imagine that this might lead to really bad situations. So, at Google we decided it is a nice idea, but we make it illegal, nobody gets to use it–with one exception: generated code. It is a really good fit for generated code actually, and it solves some of the inherent problems of generated code. With generated code you sometimes have to import files you can’t even see, have to guess their names. If, however, the generated file is just there in the shadows and enhances whatever it needs, then you don’t have these problems. You never have to know about these files at all. They just magically enhance the central registry.
>
> No abstraction is better than the wrong abstraction

source: https://medium.com/@cramforce/designing-very-large-javascript-applications-6e013a3291a3
