4-6 Create Microsservice(SpringBoot) Image

DockerFile CMD
-------------------
COPY
USER 
MAINTAINER
LABEL 
ENV
-------------------
ARG
EXPOSE 
ENTRYPOINT 
CMD

MicrosserviceDockerFileV1
    FROM openjdk:8-jre-slim
    MAINTAINER  Lian
    LABEL version="1.0" description="Spring boot microservice - CRUD user" by="Lian"
    ENV APP_Home=/home/microservice
    #Default value
    ARG jarName=demo.jar 
    ENV APP_Name=${jarName} 
    # OS update
    ARG DEBIAN_FRONTEND=noninteractive
    RUN apt-get update && apt-get install --assume-yes apt-utils;
    COPY ${APP_Name} ${APP_Home}/${APP_Name}
    RUN groupadd -r microservice && useradd -r -g microservice microservice ; \
                     chown -R microservice:microservice "${APP_Home}";  
    USER microservice
    WORKDIR ${APP_Home} 
    EXPOSE 9999
    # Below format ENTRYPOINT does not support the ENV parameter 
    # ENTRYPOINT ["java","-jar","${APP_Home}/${APP_Name}"]
    ENTRYPOINT java -jar ${APP_Name}
Build Docker Image
    docker build --build-arg jarName=demo.jar -f MicrosserviceDockerFileV1  -t microsservic:v1 . 
    docker container run -d --name microsservicv1 --rm -p 9999:9999  microsservic:v1 
    docker container run -d --name microsservicv1 -p 9999:9999 microsservic:v1 demo.jar
    docker container run -d --name microsservicv1  microsservic:v1 /bin/bash -c "tail -f /dev/null" 
    docker exec -it microsservicv1 /bin/sh
    docker container rm -f microsservicv1
    docker logs microsservicv1 


MicrosserviceDockerFileV2

    FROM openjdk:8-jre-slim
    MAINTAINER  Lian
    LABEL version="1.0" description="Spring boot microservice - CRUD user" by="Lian"
    ENV APP_Home=/home/microservice
    #Default value
    ARG jarName=demo.jar 
    ENV APP_Name=${jarName}  
    COPY ${APP_Name} ${APP_Home}/${APP_Name}
    RUN groupadd -r microservice && useradd -r -g microservice microservice ; \
                     chown -R microservice:microservice "${APP_Home}";
    USER microservice
    WORKDIR ${APP_Home} 
    EXPOSE 9999
    CMD java -jar ${APP_Name}
Build Docker Image
    docker build --build-arg jarName=demo.jar -f MicrosserviceDockerFileV2  -t microsservic:v2 . 
    docker container run -d --name microsservicv2 -p 9999:9999  microsservic:v2 test.jar
    docker logs microsservicv2
    docker container run -d --name microsservicv2 -p 9999:9999 microsservic:v2 demo.jar
    docker container run -d --name microsservicv2  microsservic:v1 /bin/bash -c "tail -f /dev/null" 
    docker exec -it microsservicv2 /bin/sh
    docker container rm -f microsservicv2
    docker logs microsservicv2 

MicrosserviceDockerFileV3
    FROM openjdk:8-jre-slim
    MAINTAINER  Lian
    LABEL version="1.0" description="Spring boot microservice - CRUD user" by="Lian"
    ENV APP_Home=/home/microservice
    #Default value
    ARG jarName=demo.jar 
    ENV APP_Name=${jarName}  
    COPY ${APP_Name} ${APP_Home}/${APP_Name}
    RUN groupadd -r microservice && useradd -r -g microservice microservice ; \
                     chown -R microservice:microservice "${APP_Home}";
    USER microservice
    WORKDIR ${APP_Home} 
    EXPOSE 9999
    ENTRYPOINT ["java","-jar"]
    CMD demo.jar
Build Docker Image
    docker build --build-arg jarName=demo.jar -f MicrosserviceDockerFileV3  -t microsservic:v3 . 
    docker container run -d --name microsservicv3 -p 9999:9999  microsservic:v3 demo.jar
    docker container rm -f microsservicv3
    test.jar
    docker logs microsservicv3   