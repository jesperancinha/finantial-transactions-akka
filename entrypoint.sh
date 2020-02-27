#!/usr/bin/env bash

cd peixinhos-da-horta-scala

sbt compile test

cd ..

cd peixinhos-da-horta-parallel-scala

sbt compile test

cd ..

