FROM openjdk:8-jre

MAINTAINER Ridhwan Oladejo <ridhwan.oladejo@9mobile.com.ng>

ENV TZ Africa/Lagos

COPY ./target /target
WORKDIR /target

RUN ls

CMD java  -jar crazynaijadeal-0.0.1-SNAPSHOT.jar
