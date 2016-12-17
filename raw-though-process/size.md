# Size

The memory size of primitives are dynamic. Preferrably at the language level only so that there is a consistency throughout a project.

But, need to make sure that there are no issues between projects/libraries that might be using a different size. So, size of primitives may have to be labelled, like num8, num32, num64, num128, etc.

Hmm, should sizes only be by number of bits? Would a number of digits size be helpful or more hurtful. Well, there would likely be just one or the other to have less language complexity/overhead. Doing by number of digits would be hurtful in cases of changing base?

If users want nums to 'overflow' or 'wrap-around', then maybe that should be explicitly documented of language-suppported in a way: numo or num-w?

## Ideas

    num#    num8, num32, num64, num128...
    num     dynamic? (possibly starting at num32? perhaps language could tell?)
    text#   text10, text100, text1000... (could be useful for automatic efficient database creations?)
    text    dynamic? (possibly starting max length of num32?)
    
    
