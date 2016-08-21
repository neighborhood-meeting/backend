FROM nginx:1
MAINTAINER Neighborhood Backend Server Developer

RUN rm /etc/nginx/conf.d/default.conf && \
    mkdir -p /neighborhood/logs

ADD conf/* /etc/nginx/conf.d/