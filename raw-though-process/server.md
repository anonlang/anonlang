# Server Config Ideas

Common cases easy? Maybe look at top server questions in Stack Exchange.

    config [
      no-ext html php py ;; URLs tried in order.
      cgi fast-cgi
      cgi-enable php py
      ssl on [ssl-v3 tls-v1 tls-v1.1 tls-v1.2]
      ssl-cert /key/cert.pem
      ssl-cert-key /key/cert.key
    ]

To define server fields:

    ;; Re: 'keyword-redirect'
    redirect [
      ;; pattern action [config? Ex: hide/show extension]
      / index.php
      /api/v1/* [
        package package.php
        user user.php
      ]
    ]

Multiple domains for a server:

    file [ ;; Or, page? ;; Or, continue 'everything is file' paradigm?
      listen 80
      index index.php index.html
      try $uri $uri/ 404 ;; TODO: Need to maybe get rid of shift key use.
      anonsage.com [
        root /var/www/anonsage.com/html
        /git [ out 302 https://github.com/anonsage/ ]
      ]
      ltediscovery.net [
        out 302 simplyadvanced.net/ltediscovery
      ]
      simplyadvanced.net [
        root /var/www/simplyadvanced.net/html
      ]
      www.anonsage.com 302 anonsage.com
      www.ltediscovery.net 302 ltediscovery.net
      www.simplyadvanced.net 302 simplyadvanced.net
      404 /error/404.html
    ]
