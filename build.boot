(set-env!
 :source-paths #{"src"}
 :dependencies '[[adzerk/boot-cljs            "2.1.3"          :scope "test"]
                 [crisptrutski/boot-cljs-test "0.3.4"          :scope "test"]
                 [org.clojure/clojurescript   "1.9.908"]])

(require
 '[adzerk.boot-cljs      :refer [cljs]]
 '[crisptrutski.boot-cljs-test :refer [test-cljs report-errors!]])


(deftask testing []
  (merge-env! :source-paths #{"test"})
  identity)

(deftask auto-test []
  (comp (testing)
     (watch)
     (speak)
     (test-cljs)))

(deftask dev []
  (comp (watch)
     (speak)
     (cljs :source-map true
           :optimizations :none
           :compiler-options {:target :nodejs
                              :npm-deps {}
                              :install-deps true})
     (target)))

(deftask test []
  (comp (testing)
     (test-cljs :keep-errors? true)
     (report-errors!)))

(deftask build []
  (comp (cljs :optimizations :none
           :compiler-options {:target :nodejs
                              :npm-deps {}
                              :install-deps true})
     (target)))

