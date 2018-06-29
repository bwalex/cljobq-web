# cljobq-web

A web frontend for [cljobq].

```clojure
[cljobq-web "0.1.2"] ; add this to your project.clj
```

## Usage

See the [API documentation][API] for more detailed usage information, including examples.

```clojure
(require 'cljobq-web.core)

;; Create the cljobq-web handler
(def cljobq-handler
  (cljobq-web.core/make-handler
    {:db {:connection-uri \"jdbc:postgresql://localhost:5432/jobqtest?user=test&password=test\"}))

;; Start an HTTP server with the handler (e.g. with http-kit)
(require 'org.httpkit.server)
(org.httpkit.server/run-server cljobq-handler)
```


## Screenshots

Coming soon...


## License

Copyright © 2018 Alex Hornung

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

[API]: https://bwalex.github.io/cljobq-web/cljobq-web.core.html
[cljobq]: https://github.com/bwalex/cljobq
