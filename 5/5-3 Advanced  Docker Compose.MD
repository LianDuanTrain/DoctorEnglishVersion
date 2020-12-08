5-3 Advanced  Docker Compose
docker-composeV1.yml
version: "3.7"
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
        image: ${IMAGETAG:-jetty:9.4.31-jdk8-slim} 
        #jetty:9.4.31-jdk8-slim
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
    docker-compose -f  docker-composeV1.yml up  -d 
    docker-compose ps
    docker-compose -f docker-composeV1.yml down -v  
.env file content:
    IMAGETAG=jetty:9.4-jre8-slim
CMD:
    docker-compose -f  docker-composeV1.yml up  -d 


Docker-compose files Merge:
    docker-compose -f  docker-composeV1.yml -f  docker-compose-qaV1.yml  up  -d 
    docker exec -it -u jetty jetty9431v1 /bin/sh
    docker exec -it  wardatav1 /bin/sh
    docker container stop wardata
    docker-compose  up -d --build 
    docker-compose down -v
    docker-compose down -v && docker-compose build --no-cache && docker-compose up

Test:
Get user list:
    curl -H "Accept: application/json" -H "Content-type: application/json" -d '{"lastName":"AA3","firstName":"BB3"}' -X POST {your box or VM IP}:8080/demo/users
Add User:
    curl {your box or VM IP}:8080/demo/users


