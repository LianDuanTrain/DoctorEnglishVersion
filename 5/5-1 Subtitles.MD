# Summary 
Hello and welcome to this session on Docker Compose. we're go learn about Docker Compose concept and run a demo step by step.

- What is Docker Compose?
- Why use Docker Compose in project?
- How to create a simple Docker Compose?
- How to run Docker Compose?
- How to scale services?



- What is Docker Compose?
  Compose is a tool for defining and running multi- Docker container
  In Compose, i use a YAML file to configure my application’s services. The YAML file default name is docker-compose.yml.
  Docker Compose support a single command to create and start all the services from my configuration


- Why use Docker Compose in project?
 Multiple isolated environments on a single host, Compose uses a project name to isolate environments from each other.

 Preserve volume data when containers are created
 Compose preserves all volumes used by your services. 
 When docker-compose up runs, if it finds any containers from previous runs, it copies the volumes from the old container to the new container.

 Only recreate containers that have changed
 Compose caches the configuration used to create a container. When you restart a service that has not changed, Compose re-uses the existing containers. 


 Variables and moving a composition between environments
 Compose supports variables in the Compose file. variables read from file.


- How to create a simple Docker Compose?
 I can convert a docker container run command to a docker-compose.yml as start point.

 docker container run -d --name microsservic --rm -p 9999:9999  microsservic:v5

--name equle to docker-compose services name.
-p convert to ports, default particle is TCP
microsservic:v5 is equle to image
 docker-compose.yml  
``` 
version: '3.3'     
 services:          
    microsservic:        
        ports:        
            - '9999:9999'        
        image: 'microsservic:v5'  
``` 

- How to run Docker Compose?
docker-compose --help give all detail and options of docker-compose command.

- `docker-compose config` can check docker-compose file, for example check above docker-compose.yml, 
   docker-compose config
before run docker-compose, I have to upload microservic:v5 to  my Private Docker Repository
First, add  tag for Private Docker Repository, tag has two four parts, Private Docker Repository IP and port and image  and version
- `docker tag microservic:v5 192.168.31.231:5000/microservic:v5` 
  Second, pus the image to   Private Docker Repository
- `docker push 192.168.31.231:5000/microservic:v5`
  Next, run docker-compose up -d
- `docker-compose up -d`
  And then, test API.
  - Test API - Find users  
  - `curl 172.19.0.2:9999/users`
  How to verify running docker container? use
- `docker-compose ps` 
  let me check docker container status
- `docker-compose down`  
  container name has three part, mytest_microsservic_1 
    foldername plus server name ans number. 
    How to change container name?  Ues -p, while if I use -p, follow docker-compose command need -p. 
- `docker-compose -p myTest up -d` 
  if i forget -p, i can not find running container  
- `docker-compose  -p myTest ps`
- `docker-compose  -p myTest down`  







- How to scale services?
  Each service defined in Docker compose configuration can be scaled using scale command.
  Although services can be scaled, but you will run into port conflict error.
  Because all services run in one box. One port can not use in two same service. 
  This can be fix by assigning port range on the ports section of compose yaml file.

version: "3.8"     
services:          
    microsservic:        
        ports:        
            - 9000-9999:9999        
        image: 192.168.31.231:5000/microservic:v5 

- `docker-compose -p myTest up -d` 
- `docker-compose  -p myTest scale microsservic=2`


I hope  now you can creat  docker Compose  and Run. 
I will meet you in the next episode of docker，

