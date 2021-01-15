# Summary 
Hello and welcome to this session, we're gonna learn about Create Spring Boot Microservice Docker Images step by step. 

- How to create a runable Springboot Microservice Docker Image?  
- How to enhance Docker image security?  
- How to reduce Docker image size?  
- How to use environment variable in Dockerfile? 

## How to create a runable Springboot Microservice Docker Image?   
In previous session, I create a runable Springboot Microservice jar file. The jar file will be used to create Springboot Microservice Docker Image. when container start,  one thread need to run and listening user request. 
DockerFile has two major parts, Copy jarFile from local to image and Run jarFile
Let's go thought DockerFile to get detail.   

There are commands,  FROM, LABEL, COPY, EXPOSE, ENTRYPOINT in  Dockerfile.
   FROM command decleor  Parent Image , the image is openjdk:8-jdk.
   LABEL command Add metadata to an image, the format is key value pare.
   ADD command has two parts. first , second, target
   EXPOSE command instruction image lister port, the EXPOSE is only decleor port but does not open port. the java code open lister port on 9999 
   ENTRYPOINT command is able to start a thread via java -jar and jar file name, when Container start.
- DockerFile 4-6/v1/Dockerfile
- and then, Build Docker Image 
  `docker build -t microservic:v1 .`  
- next, Check Image detail   
  `docker image inspect microservic:v1`
- then, Start  Container   
  `docker container run -d --name microservicv1 --rm -p 9999:9999  microservic:v1`   
- Check Springboot log for microservic start detail infomation 
`docker logs microservicv1`  
- Go inside container to verify jar file 
`docker exec -it microservicv1 /bin/sh`
- next step, Testing two APIs
    - Add User  
     `curl -H "Accept: application/json" -H "Content-type: application/json" -d '{"lastName":"Duan","firstName":"Lian"}' -X POST 172.17.0.3:9999/users`  
    - Find users  
     `curl 172.17.0.3:9999/users`  
- Stop container       
`docker container stop microservicv1`  

I had a runable Springboot Microservice Docker Image. 

## How to enhance Docker image security? 
- I have a doto list for security 
   - Update OS packages
   - Create a user to run java -jar command, do not run as root user
   - Replace COPY with ADD because COPY is only copy local file, ADD is able to copy file from network.
- Go DockerFile and see the change 4-6/v2/Dockerfile
  There are commands,  RUN, COPY, USER, WORKDIR, CMD in  Dockerfile.
   
   ADD command has two parts. first source file , second, target file
   RUN command  is run in a shell, which by default is /bin/sh  on Linux or cmd /S /C on Windows 
   WORKDIR instruction sets the working directory for any RUN, CMD, ENTRYPOINT
   The main purpose of a CMD is to provide defaults for an executing container.


- Next Build Docker Image   
  `docker build -t microservic:v2 .`     
- And then, start a  Container   
  `docker container run -d --name microservicv2 --rm -p 9999:9999  microservic:v2`   
- Check Springboot log
`docker logs microservicv2`  
- Go inside container to verify jar file   
`docker exec -it microservicv2 /bin/sh`
- next step, Testing two APIs
    - Add User  
     `curl -H "Accept: application/json" -H "Content-type: application/json" -d '{"lastName":"Duan","firstName":"Lian"}' -X POST 172.17.0.3:9999/users`  
    - Find users  
     `curl 172.17.0.3:9999/users`  
- Stop container       
`docker container stop microservicv2`  
- Haskell Dockerfile Linter is security tool, it can verify Dockerfile and give you build best practice recommendation on Docker images.     
  `docker container run --rm -i --name hadolint  hadolint/hadolint:latest-alpine< Dockerfile`

I had a runable and secure  Springboot Microservice Docker Image. 
## How  to hance performance？ reduce Docker image size.
- Todo list:
   - Use small parent image  
   - Reduce docker image layers 
- Go DockerFile and see the change, DockerFile 4-6/v3/Dockerfile
  use openjdk:8-jre-slim image because I do not compile java code, I have a jar file already.
  One RUN command creates one image layer so merge RUN commands to one RUN command.  
- Build Docker image 
  `docker build -t microservic:v3 .` 
- and then, Compare images size  
  `docker images`      
- Next, Run Container   
  `docker container run -d --name microservicv3 --rm -p 9999:9999  microservic:v3`   
- Next step, Check Springboot log
`docker logs microservicv3`  
- Move to, Check jar file step 
`docker exec -it microservicv2 /bin/sh`   
- Stop container       
`docker container stop microservicv3`

I had a runable, secure, and small size  Springboot Microservice Docker Image.
## How to make stable Dockerfile? use environment variable replace hard code items. How to do that?
Read build arguments and pass arguments to environment variable
- Let see the new comamnd ARG and  ENV in DockerFile  
  ARG command defines a variable that users can pass at build-time ans support default value.
  ENV comand instruction sets the environment variable
  Other cmmand can use $ Braces and ENV variable name

- and then , Build docekr image user defaule value  
  `docker build -t microservic:v4 .`     
  next , try change app location folder
  `docker build --build-arg inputAppFolderName=test -t microservic:v4 .`  
- Image inspect  
  `docker image inspect microservic:v4`    
- next step , Run Container   
  `docker container run -d --name microservicv4 --rm -p 9999:9999  microservic:v4`   
- see Springboot log
`docker logs microservicv4`  
- Check jar file 
`docker exec -it microservicv4 /bin/sh`
- Finally, Stop container       
`docker container stop microservicv4`  
I had a runable, secure, , small size , and Parameterization Springboot Microservice Docker Image.
#End 
I hope this all was very useful and interesting to you. 
I will meet you in the next episode of docker. 