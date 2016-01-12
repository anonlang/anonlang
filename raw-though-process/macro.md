


Source: http://c2.com/cgi/wiki?LispVsXml

The whole notion of data vs. programs sucks. XML is based on that notion, sexprs aren't. This is why sexprs are superior. To illustrate this point, here is a macro in Common Lisp:

    (defmacro dictionary (&rest words)
      `(progn
      	(format t "<dictionary>~%")
      	(dolist (word ',words)
      	(format t "  <word>~%")
      	(format t "	<id>~A</id>~%" (first word))
      	(format t "	<def>~S</def>~%" (second word))
      	(format t "  </word>~%"))
      	(format t "</dictionary>~%")))

Now, when I enter the following sexpr...

    (dictionary
      (xml "data language")
      (java "programming language")
      (lisp "programming and data language"))

...I get the following result:

    <dictionary>
    	<word>
    	<id>xml</id>
    	<def>"data language"</def>
    	</word>
    	<word>
    	<id>java</id>
    	<def>"programming language"</def>
    	</word>
    	<word>
    	<id>lisp</id>
    	<def>"programming and data language"</def>
    	</word>
    </dictionary>

Conclusion: sexprs include XML as a subset (or any other representation) qua Lisp. (Note that the macro is also written as an sexpr, and is in fact also just a data structure that is compiled/interpreted by the Lisp runtime. See MetaCircularInterpreter for more insights into the resolution of the prorgram/data dichotomy.)
