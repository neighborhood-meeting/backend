Prerequisite

1. Docker

1-1. Docker Download for mac

Download https://download.docker.com/mac/stable/Docker.dmg and Install

1-2. pull mysql docker image

docker pull mysql:5.7

1-3. docker container make && run

docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=neighborhood -d mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci

1-4. Nginx Docker Make && Run

docker run -d --net=host --name image-server -v /neighborhood/images:/usr/share/nginx/html:ro -p 80:80 neighborhood-nginx

2. How to know success?

http://localhost:8080/hello