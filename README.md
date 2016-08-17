Prerequisite

1. Docker

1-1. Docker for mac Download

Download https://download.docker.com/mac/stable/Docker.dmg and Install

1-2. pull mysql docker image

docker pull mysql:5.7

1-3. docker container make && run

docker run -d --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=neighborhood mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci

2. How to know success?

http://localhost:8080/hello