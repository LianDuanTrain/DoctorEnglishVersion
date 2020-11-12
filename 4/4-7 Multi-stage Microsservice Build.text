Docker CMD
FROM XXXX AS stage name
COPY --from=stage name
TwoStagesDockerFile
    #
    # Microservice Build  
    #
    FROM maven:3.6-jdk-8-openj9 AS build
    MAINTAINER  Lian
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
    # Package stage - Create Microservice Image
    #
    FROM openjdk:8-jre-slim
    MAINTAINER  Lian
    LABEL version="1.0" description="Spring boot microservice - CRUD user" by="Lian"
    #Default value
    ENV APP_Home=/home/microservice
    ENV APP_Build_Home=/home/build
    ARG jarName=demo.jar 
    ENV APP_Name=${jarName}  
    # OS update
    ARG DEBIAN_FRONTEND=noninteractive
    RUN apt-get update && apt-get install --assume-yes apt-utils;
    COPY ${APP_Name} ${APP_Home}/${APP_Name}
    COPY --from=build ${APP_Build_Home}/target/demo-0.0.1-SNAPSHOT.jar ${APP_Home}/${APP_Name}
    RUN groupadd -r microservice && useradd -r -g microservice microservice ; \
                     chown -R microservice:microservice "${APP_Home}";
    USER microservice
    WORKDIR ${APP_Home} 
    EXPOSE 9999
    ENTRYPOINT java -jar ${APP_Name}
Build Docker Image
    docker build --build-arg jarName=demo.jar -f TwoStagesDockerFile  -t microsservic:v4 . 
    docker container run -d --name microsservicv4  -p 9999:9999  microsservic:v4
    docker exec -it microsservicV4 /bin/sh
    docker container rm -f microsservicv4
    docker logs microsservicv4
    