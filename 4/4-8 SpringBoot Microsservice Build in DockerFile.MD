4-5 Microsservice(SpringBoot) Build in DockerFile       
Dockerfile     
    FROM maven:3.6-jdk-8-openj9
    MAINTAINER  Lian
    LABEL version="1.0" description="microservice build by Maven" by="Lian"
    ENV APP_Home=/home/build   
    COPY src ${APP_Home}/src
    COPY pom.xml ${APP_Home}
    RUN groupadd -r build && useradd -r -g build build ; \
                     chown -R build:build "${APP_Home}"; 
    USER build
    WORKDIR ${APP_Home}
    RUN mvn -U -DskipTests=true -f pom.xml clean package
Build Docker Image   
    docker build -t mvnbuild:v1 . 
    docker container run -d --name mvnbuild --rm  mvnbuild:v1 /bin/bash -c "tail -f /dev/null"   
    docker cp mvnbuild:/home/build/target/demo-0.0.1-SNAPSHOT.jar jar/demo.jar
    docker container stop mvnbuild
    
Debug
    Dockerfile     
        FROM maven:3.6-jdk-8-openj9 AS build
        MAINTAINER  Lian
        LABEL version="1.0" description="microservice build by Maven" by="Lian"
        ENV APP_Home=/home/build   
        COPY src ${APP_Home}/src
        COPY pom.xml ${APP_Home}
        RUN groupadd -r build && useradd -r -g build build ; \
	    chown -R build:build "${APP_Home}"; 
        USER build
        WORKDIR ${APP_Home}
        RUN mvn -U -DskipTests=true -f pom.xml clean package
    Build Docker Image    
            docker build -t mvnbuild:v1 .
            docker run -d --name mvnbuild --rm  mvnbuild:v1 /bin/bash -c "tail -f /dev/null"
            docker run -d --name mvnbuild --rm  mvnbuild:v1 /bin/bash -c "tail -f /dev/null"
            docker exec -it mvnbuild /bin/bash
            docker container stop mvnbuild
       



    