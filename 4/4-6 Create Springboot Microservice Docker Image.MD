# Create Springboot Microservice Docker Image
- How to create a runable Springboot Microservice Docker Image?  
- How to enhance Docker image security?  
- How to reduce Docker image file size?  
- How to use environment variable in Dockerfile?  

## How to create a runable Springboot Microservice Docker Image? 
- Two major parts are in Docker Image   
   - Copy jarFile from local to image
   - Run jarFile
- Dockerfiles/v1/Dockerfile
- Build  
  `docker build -t microservic:v1 .`  
- Image inspect  
  `docker image inspect microservic:v1`
- Run Container   
  `docker container run -d --name microservicv1 --rm -p 9999:9999  microservic:v1`   
- Check Springboot log  
`docker logs microservicv1`  
- Check jar file   
`docker exec -it microservicv1 /bin/sh`
- Test APIs
    - Add User  
     `curl -H "Accept: application/json" -H "Content-type: application/json" -d '{"lastName":"Duan","firstName":"Lian"}' -X POST 172.17.0.3:9999/users`  
    - Find users  
     `curl 172.17.0.3:9999/users`  
- Stop container       
`docker container stop microservicv1`

## How to enhance Docker image security?
- Enhance Items 
   - Update OS packages
   - Do not run as root user
   - Replace COPY with ADD
- Dockerfiles/v2/Dockerfile
- Build  
  `docker build -t microservic:v2 .` 
- Image inspect  
  `docker image inspect microservic:v2`    
- Run Container   
  `docker container run -d --name microservicv2 --rm -p 9999:9999  microservic:v2`   
- Check Springboot log  
`docker logs microservicv2`  
- Check jar file   
`docker exec -it microservicv2 /bin/sh`
- Test APIs
    - Add User  
     `curl -H "Accept: application/json" -H "Content-type: application/json" -d '{"lastName":"Duan","firstName":"Lian"}' -X POST 172.17.0.3:9999/users`  
    - Find users  
     `curl 172.17.0.3:9999/users`  
- Stop container       
`docker container stop microservicv2`
- Haskell Dockerfile Linter  
  `docker container run --rm -i --name hadolint  hadolint/hadolint:latest-alpine< Dockerfile`

## How to reduce Docker image file size?
- Todo list:
   - Use small parent image  
   - Reduce docker image layers   
- Dockerfiles/v3/Dockerfile
- Build  
  `docker build -t microservic:v3 .` 
- Compare images size  
  `docker images`  
- Image inspect  
  `docker image inspect microservic:v3`    
- Run Container   
  `docker container run -d --name microservicv3 --rm -p 9999:9999  microservic:v3`   
- Check Springboot log  
`docker logs microservicv3`  
- Check jar file   
`docker exec -it microservicv2 /bin/sh`
- Stop container       
`docker container stop microservicv3`

## How to use environment variable in Dockerfile? 
Read build arguments and pass arguments to environment variable  
- Dockerfiles/v4/Dockerfile
- Build  
  `docker build -t microservic:v4 .`     
  `docker build --build-arg inputAppFolderName=test -t microservic:v4 .`
- Find images size  
  `docker images`  
- Image inspect  
  `docker image inspect microservic:v4`    
- Run Container   
  `docker container run -d --name microservicv4 --rm -p 9999:9999  microservic:v4`   
- Check Springboot log  
`docker logs microservicv4`  
- Check jar file   
`docker exec -it microservicv4 /bin/sh`
- Test APIs
    - Add User  
     `curl -H "Accept: application/json" -H "Content-type: application/json" -d '{"lastName":"Duan","firstName":"Lian"}' -X POST 172.17.0.3:9999/users`  
    - Find users  
     `curl 172.17.0.3:9999/users`  
- Stop container       
`docker container stop microservicv4`