# Summary 
Hello and welcome to this session, we're gonna learn about Docker Multi-stage build. There are the topics I cover in the session

- What is Docker Multi-stage build?  
- How to implement Multi-stage build in Springboot Microservice Docker Image?  

# What is Docker Multi-stage build?   
Befroe session, first, I use maven docker image compel java srouce code and create runable jar file. second, copy the jar file to Jre image and make a ENTRYPOINT in JRE image.
Maintain two steps are not easy tasks, even go bshell script.

Also,  It was actually very common to have one Dockerfile to use for development (which contained everything needed to build your application), and a slimmed-down one to use for production, which only contained your application and exactly what was needed to run it.
This has been referred to as the “builder pattern”. Maintaining two Dockerfiles is not ideal.

With multi-stage builds, I can use multiple FROM statements in  Dockerfile. 
Each FROM instruction can use a different base, and each of them begins a new stage of the build. 
I can selectively copy artifacts from one stage to another, leaving behind everything you don’t want in the final image. 



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