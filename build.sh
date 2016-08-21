#!/usr/bin/env bash

echo "git pull start!"

git pull

echo "git pull! Success!"

echo "flyway start~!!"

`pwd`/gradlew flywayClean
`pwd`/gradlew flywayMigrate

echo "flyway Success~!!"

`pwd`/gradlew build

docker build -t neighborhood:latest .

docker stop neighborhood-server

docker rm neighborhood-server

docker run -d --net=host --name neighborhood-server -p 8080:8080 neighborhood