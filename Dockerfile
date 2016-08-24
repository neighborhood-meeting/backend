FROM java:8
MAINTAINER Neighborhood Backend Server Developer

RUN mkdir -p /neighborhood/images/profile && \
    mkdir -p /neighborhood/images/article

ADD build/libs/* /neighborhood/

WORKDIR /neighborhood

CMD ["java", "-jar", "neighborhood-0.0.1-SNAPSHOT.jar", ">>", "result.log"]

EXPOSE 8080