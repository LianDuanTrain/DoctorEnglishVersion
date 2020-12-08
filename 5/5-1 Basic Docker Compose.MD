# Basic Docker Compose
- What is Docker Compose?
- Why use Docker Compose in project?
- How to create a simple Docker Compose?
- How to run Docker Compose?
- How to scale services ?

## What is Docker Compose?
- Running multi-container applications on Docker
- YAML file
- Single command - create,start,stop all the services 

## Why need Docker Compose?
- Multiple isolated environments on a single host
- Preserve volume data when containers are created
- Only recreate containers that have changed
- Variables and moving a composition between environments

## How to create a Docker Compose file?
- docker container run -d --name microsservic --rm -p 9999:9999  microsservic:v5
- docker-compose.yml  
``` 
version: "3.8"     
services:          
    microsservic:        
        ports:        
            - 9999:9999        
        image: 192.168.31.231:5000/microservic:v5  
```      
- Compose File Version : https://docs.docker.com/compose/compose-file/compose-versioning/

## How to run Docker Compose?  
- docker-compose --help  
- `docker-compose config`
- `docker tag microservic:v5 192.168.31.231:5000/microservic:v5`   
- `docker push 192.168.31.231:5000/microservic:v5`
- `docker-compose up -d`
  - Test API - Find users  
  - `curl 172.19.0.2:9999/users`
- `docker-compose ps` 
- `docker-compose down`  
- `docker-compose -p myTest up -d` 
- `docker-compose  -p myTest ps`
- `docker-compose  -p myTest down`  
 
## How to scale services?
- docker-compose.yml
``` 
version: "3.8"     
services:          
    microsservic:        
        ports:        
            - 9000-9999:9999        
        image: 192.168.31.231:5000/microservic:v5  
        
```     
- `docker-compose -p myTest up -d` 
- `docker-compose  -p myTest scale microsservic=2`

- `docker-compose  -p myTest ps`


