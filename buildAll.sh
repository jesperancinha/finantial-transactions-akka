#!/usr/bin/env bash

mvn clean install

cd peixinhos-da-horta-scala

sbt compile test

cd ..

cd peixinhos-da-horta-parallel-scala

sbt compile test

cd ..
