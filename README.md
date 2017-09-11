# Prime Challenge (2017 version)

[![CircleCI](https://circleci.com/gh/kidpollo/prime-again.svg?style=svg)](https://circleci.com/gh/kidpollo/prime-again)

Prime number multiplication table challenge this time brought to you by Clojurescript, [Lumo](https://github.com/anmonteiro/lumo) and the latest and gratest of the Clojure ecosystem :P

## TL;DR

SO FAST!!!

```shell
brew install lumo
git clone git@github.com:kidpollo/prime-again.git
cd prime-again
lumo -c src -m prime-again.core
```

## Challenge

Write a program that prints out a multiplication table of the first 10 prime numbers. The program must run from the command line and print one table to STDOUT. The first row and column of the table should have the 10 primes, with each cell containing the product of the primes for the corresponding row and column.

## Tests

`lumo -c test:src scripts/test.cljs`

## The boot way

In case you are a boring person and want to do things like its 2016 (ugh!)
You need to install [boot](https://github.com/boot-clj/boot) and [nodejs](https://nodejs.org/en/)

```shell
boot build
cd target
node main.js
```

To run tests (kinda wonky)

```shell
npm install -g phantomjs
boot test
```
