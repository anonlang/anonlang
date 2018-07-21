* Data structure internals

        define Number [
            whole
            part 
            define set [
                input num
                whole num 
                part (num - whole).to-text.remove('0.').to-number
            ]
            define get-sig-figs [
                
            ]
            define to-int [
                output whole
            ]
            define to-text [
                is part:
                    0: output whole
                    : output whole'.'part
            ]
        ]

* All numbers supported

        define a -0.123456
        define b 3_000_000_000

* Math

        define c a + b
        define d Math.add(a, b)
