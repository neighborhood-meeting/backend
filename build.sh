#!/usr/bin/env bash

`pwd`/gradlew build

docker build -t neighborhood:latest .