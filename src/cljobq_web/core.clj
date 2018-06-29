(ns cljobq-web.core
  (:require
    [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
    [cljobq-web.middleware :refer [wrap-context]]
    [cljobq-web.routes :refer [routes-handler]]))

(defn make-handler
  "Returns a Ring handler function providing the cljobq web UI.

  Options:

  - `:db`        A `clojure.java.jdbc` db-spec map. If specified, it is used
                 in preference to the db-spec in the `context`.
  - `:context`   cljobq context created via `cljobq.core/make-context`. If not
                 specified, the implicit `cljobq.core/global-ctx*` atom set
                 using `cljobq.core/set-context!` is used instead. If `:db` is
                 specified, that is used instead of any db-spec in the
                 specified context.
  - `:base-url`  Specify a base url under which cljobq-web is being served.
                 This affects the generated HTML only, e.g. affects links,
                 CSS and JS urls. If omitted, assumes relative links such as
                 `/job/abc` will find their way to cljobq-web. If, however,
                 cljobq-web is being fronted under, say, `/cljobq`,
                 `:base-url` should be set to that.

  Example:

  ```clojure
  (def cljobq-handler
    (cljobq-web.core/make-handler
      {:db {:connection-uri \"jdbc:postgresql://localhost:5432/jobqtest?user=test&password=test\"}))
  ```"
  ([] (make-handler {}))
  ([config]
   (-> routes-handler
       (wrap-context config)
       (wrap-defaults
         (assoc-in site-defaults [:static :resources] "cljobq-web")))))
