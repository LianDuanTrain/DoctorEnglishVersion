# Docker Multi-stage Build
- What is Docker Multi-stage build?  
- How to implement Multi-stage build in Springboot Microservice Docker Image? 

# What is Docker Multi-stage build?  
- Optimize Dockerfiles
- Keep the image size down

# How to implement Multi-stage build in Springboot Microservice Docker Image? 

- Dockerfile Commands  
   - FROM XXXX AS stage name
   - COPY --from=stage name
- Dockerfiles
- /v5/Dockerfile
- Build  
  `docker build -t microservic:v5 .`  
- Image inspect  
  `docker image inspect microservic:v5`
- Run Container   
  `docker container run -d --name microservicv5 --rm -p 9999:9999  microservic:v5`   
- Check Springboot log  
`docker logs microservicv5`  
- Check jar file   
`docker exec -it microservicv5 /bin/sh`
- Test APIs
    - Add User  
     `curl -H "Accept: application/json" -H "Content-type: application/json" -d '{"lastName":"Duan","firstName":"Lian"}' -X POST 172.17.0.3:9999/users`  
    - Find users  
     `curl 172.17.0.3:9999/users`  
- Stop container       
`docker container stop microservicv5`

    