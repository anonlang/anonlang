# Ultimate Internet Browser

Note: Even though I call this an 'internet browser', it may not be solely for the internet.

## Features




## Coding

Login page

    col [
      text 'Username'
      alias username-input text-input ''
      text 'Password'
      alias password-input password-text-input ''
      button 'Enter' show-message ';username-input.get-text;, ;password-input.get-text;'
    ]



## Email / Identity

An email provider could have a unique email address for each third-party site and re-use those for multiple users? Possibly need to attach unique randomly generated ID for user also.

So, eventually, we could/should login into all sites via email provider, though that provides a lot of power to the email provider, thus it should possibly be open source and distributed, with optional capability of having different hosts.



## More Info

- Good
  - http://scottberkun.com/essays/37-how-to-build-a-better-web-browser/
