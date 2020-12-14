# Summary 
Hello and welcome to this session of Docker compose. we're go learn about use Docker compose  implement sideCar design pattern.


## What is a sidecar design pattern? 
A sidecar attached to a motorcycle. In the pattern, the sidecar is attached to a parent application and provides supporting features for the application. In my demo, the sidecar provides application war file. I implemented the sidecar design pattern via Data Container. Today, I demo
## How to use Docker compose implement sideCar design pattern?
First, go thought Dockerfile. the file used to  build war file. The Dockerfile include Multi-stage build. and call from docker-compose.yml file
Second, down scource code and upload to my linux box.
Next, go  docker-compose.yml to see the detial.
- docker-compose.yml
 
  - There are two services, warfile and jetty.
  - warfile service 
     warfile build sesection call Dockerfile to build data image. the image only contain war file.
     container_name declare container name warfilev1.
     networks use dataNet
     In volumes sesection, mount contain /var/lib/jetty/webapps folder to war-data volume. this is SHORT SYNTAX. 

  - jetty service  
    container_name is jetty94v1
     Jetty is a web container, it based on  jetty:9.4-jre8-slim image.
     Network is webNet. the dataNet and webNet are bridage type network. they are isolate eatch other.
     depends_on define start up sequence,  warfile service start up first and then start jetty service so jetty service depends_on warfile service
     volumes format is LONG SYNTAX
     ports publish local port 8080 to jetty container port 8080
  - volume   
  - there are two isolate bridge networks
     - webNet 
     - dataNet
 And then, 
- Start Docker Compose   
  `docker-compose  up -d` 
next step    
- Check Docker Compose Status    
  `docker-compose ps`  
     
- Next, Verify Network Isolated  
`docker network ls`     
`docker exec -it -u root jetty94v1 /bin/bash`  
    `apt-get update && apt-get install iputils-ping`   
    `apt-get install net-tools`  
`docker exec -it -u root  warfilev1 /bin/sh`  
    `apk add --no-cache ping`  
`docker network inspect XXX_dataNet`  
`docker network inspect XXX_webNet`  
- Verify Docker Volume   
    `docker volume inspect dockercompose_war-data`  
    `docker container inspect XXX`  
   
- Shutdown   
`docker-compose down -v`
- Combination Command  
`docker-compose down -v && docker-compose build --no-cache && docker-compose up`
    

- TestAPI
  - Add user list  
    `curl -H "Accept: application/json" -H "Content-type: application/json" -d '{"lastName":"lian","firstName":"duan"}' -X POST {your box or VM IP}:8080/demo/users`
  - Get Users  
    `curl {your box or VM IP}:8080/demo/users`


I hope  now you can creat  docker Compose  and Run. 
I will meet you in the next episode of docker，

