# Two Stages Docker Build File
# Dockerfile CMDs
# V1 : FROM, LABEL, ADD, EXPOSE, ENTRYPOINT
# V2 : RUN, COPY, USER, WORKDIR, CMD 
# V4 : ARG, ENV
# V5 : FROM XXXX AS stage name, - COPY --from=stage name /file   
# Microservice Build  as War
#
FROM maven:3.6-jdk-8-openj9 AS build
LABEL version="1.0" description="Microservice build by Maven" by="Lian"  
ENV APP_Build_Home=/home/build
COPY ./DockerSpringBootDemo/src ${APP_Build_Home}/src
COPY ./DockerSpringBootDemo/pom.xml ${APP_Build_Home}
RUN groupadd -r build && useradd -r -g build build ; \
chown -R build:build "${APP_Build_Home}"; 
USER build
WORKDIR ${APP_Build_Home}
RUN mvn -U -DskipTests=true -f pom.xml clean package
#
# War file Container
#
FROM alpine:3.12.1
LABEL version="1.0" description="War file Container" by="Lian"
#Default value
ENV APP_Home=/var/lib/jetty/webapps
ENV APP_Build_Home=/home/build
ARG warName=demo.war 
ENV APP_Name=${warName}
RUN apk add --no-cache bash
RUN mkdir -p /var/lib/jetty/webapps
# add user and group
RUN addgroup -g 1000 jetty; 
RUN adduser --system jetty -G jetty; 
RUN chown -R jetty:jetty "${APP_Home}"; 
USER jetty
COPY --from=build ${APP_Build_Home}/target/${APP_Name} ${APP_Home}/${APP_Name}
ENTRYPOINT /usr/bin/tail -f /dev/null