Sidecar Pattern
Dockerfile
docker-compose.yml
    Docker network
    Docker volumes

Dockerfile
    #
    # Microservice Build  as War
    #
    FROM maven:3.6-jdk-8-openj9 AS build
    LABEL version="1.0" description="Microservice build by Maven" by="Lian"  
    ENV APP_Build_Home=/home/build
    COPY src ${APP_Build_Home}/src
    COPY pom.xml ${APP_Build_Home}
    RUN groupadd -r build && useradd -r -g build build ; \
	chown -R build:build "${APP_Build_Home}"; 
    USER build
    WORKDIR ${APP_Build_Home}
    RUN mvn -U -DskipTests=true -f pom.xml clean package
    #
    # War file Container
    #
    FROM gliderlabs/alpine:3.9
    LABEL version="1.0" description="War file Container" by="Lian"
    #Default value
    ENV APP_Home=/var/lib/jetty/webapps
    ENV APP_Build_Home=/home/build
    ARG jarName=demo.jar 
    ENV APP_Name=${jarName}  
    RUN apk add --no-cache bash
    RUN mkdir -p /var/lib/jetty/webapps
    COPY --from=build ${APP_Build_Home}/target/demo.war ${APP_Home}/${APP_Name}
    VOLUME  ${APP_Home}
    ENTRYPOINT /usr/bin/tail -f /dev/null


docker-compose.yml
version: "3.3"
services:
    jetty-war-data:
        build: ./warData
        container_name: wardatav1
        networks:
            - dataNet
        volumes:
            - war-data:/var/lib/jetty/webapps  
    jetty-app:
        container_name: jetty9431v1
        image: jetty:9.4-jre8-slim
        networks:
            - webNet
        depends_on:
            - jetty-war-data
        volumes:
            - type: volume
              source: war-data
              target: /var/lib/jetty/webapps            
        ports:
            - "8080:8080" 
volumes:
    war-data: 
networks:
    webNet:  
    dataNet:    
CMD:
docker-compose  up -d
docker-compose ps
Run Ping CMD:
docker exec -it -u root jetty9431v1 /bin/bash
    apt-get update && apt-get install iputils-ping 
    apt-get install net-tools
docker exec -it -u root  wardatav1 /bin/sh
    apk add --no-cache ping

Inspect container and network:
    docker container inspect jetty9431v1
    docker container inspect wardatav1
    docker network ls
    docker network inspect dockercompose_dataNet
    docker network inspect dockercompose_webNet
    docker volume rm dockercompose_war-data
    docker-compose build --no-cache
    docker-compose down -v && docker-compose build --no-cache && docker-compose up
    docker-compose down -v

Test:
Get user list:
    curl -H "Accept: application/json" -H "Content-type: application/json" -d '{"lastName":"AA3","firstName":"BB3"}' -X POST {your box or VM IP}:8080/demo/users
Add User:
    curl {your box or VM IP}:8080/demo/users

