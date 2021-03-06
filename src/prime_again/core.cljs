(ns prime-again.core
  (:require [clojure.pprint :as pprint]))

(def known-primes #{2, 3, 5, 7, 11, 13, 17, 19, 23, 29})

(defn divisible-in?
  "returns true if any of the numbers in the collection are divisible by n"
  [n coll]
  (boolean (some #(= 0 (rem n %)) coll)))

(defn test-primality
  "returns true if n is divisible by one of the known primes or is not divisible by any m from 2 to n - 1"
  [n known-primes]
  (not (or (divisible-in? n known-primes)
           (divisible-in? n (range 2 n)))))

(defn prime?
  "Returns true if n is prime, otherwise false"
  [n]
  (if (> n (apply max known-primes))
    (test-primality n known-primes)
    (boolean (some #{n} known-primes))))

(defn multiplication-table
  "Returns a multiplication table where [a b ...] -> [{nil a, a (* a a), b (* a b)}, {nil b, a (* b a), b (* b b), ... }]"
  [coll]
  (map (fn [prime]
         (assoc
           (into {} (map
                      (fn [p]
                        [p (* p prime)])
                      coll))
           nil
           prime))
       coll))

(defn primes-between
  "Finds prime numbers within a range"
  [range]
  (filter prime? range))

(enable-console-print!)

(defn -main
  [& [args]]
  (let [n (js/parseInt args)
        primes (take n (primes-between (range)))
        rows (multiplication-table primes)]
    (pprint/print-table (into [nil] primes) rows)))

(set! *main-cli-fn* -main)



