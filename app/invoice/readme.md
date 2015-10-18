This sample app allows you to simply generate invoices from a structured text file.

Currently, there is support for exporting to HTML and PDF.


## Simple Usage ##

1. Create structured text data for invoice

        ;; In 2015-10-company-invoice.anon
        to [
          name John Doe
          company Example, LLC
          email john@example.com
        ]
        from [
          name Ally Smith
          company My Company, LLC
          email name@my-company.com
        ]
        date [
          sent 2015-10-04
          due 2015-10-11
        ]
        sales [
          Description, Unit price, quantity, Line total
          Services rendered for October, $1500
          Overtime support for October, $80, 5
        ]
        terms [
          We accept Square and PayPal (sale@my-company.com).
          2% interest is added every day the payment is late.
        ]
        notes [
          Thank you for your business!
        ]
        
2. Run: `generate-invoice 2015-10-company-invoice.anon pdf` and the default layout will be used and the invoice will be output to the same directory.



## Benefits ##
- Minimal syntax and boilerplate.
- Boilerplate data can be added to a template and easily re-used (just add 'use my-invoice-template.anon' at the top).
- Easily extensible plugin system to fit your exact needs.
- The layout code is separate from the data for easy UI changes.

This can be compared to other invoice creation tools:

- https://github.com/tyler-king/markdown-invoice
- https://www.npmjs.com/package/invoice-ninja
- Square
- PayPal



## How to use templates ##
Templates are a way to extract commmon aspects so that it doesn't have to be re-written each time.

This example has three files: one for the overall company template, one for the individual salesperson template, and one for the simplified final invoice data that uses those templates. 

    ;; In compan-invoice-template.anon
    from [
      name ;; Required
      company Simply Advanced, LLC
      email ;; Required
    ]
    to [
      name ;; Required
      company ;; Required
      email ;; Required
    ]
    date [
      sent ;; Required?
      due ;; Required
      paid
    ]
    sale [
      ;; Required
    ]
    term [
      We accept Square and PayPal (shout@my-company.net).
      2% interest each day payment is late.
    ]
    note [
      Thank you for your business!
    ]

    ;; In personal-invoice-template.anon
    use company-invoice-template
    from [
      name My Name
      email name@my-company.net
    ]

    ;; In final invoice, 2015-10-company-invoice.anon
    use personal-invoice-template
    to [
      name Another Name
      company Another Company, Inc.
      email name@example.com
    ]
    date [
      sent 2015-10-04
      due 2015-10-11
      paid
    ]
    sale [
      Services rendered for October, $1500
      Overtime support for October, $120, 5
    ]



Note: Add this time the template file must already exist locally on the computer. Eventually, there will be a build system built in that can retrieve the template from a remote location.



## Implementation Detail ##
- Currently HTML conversion is supported natively, and [HTML to PDF](http://wkhtmltopdf.org/) is used to then convert to PDF.
