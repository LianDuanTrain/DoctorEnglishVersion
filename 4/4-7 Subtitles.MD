# Summary 
Hello and welcome to this session, we're gonna learn about Docker Multi-stage build. There are the topics I cover in the session

- What is Docker Multi-stage builds?  
- How to implement Multi-stage build in Springboot Microservice Docker Image?  

# What is Docker Multi-stage builds?   
Springboot Microservice Docker Image is in Befroe session. first, I use maven docker image compel java srouce code and create runable jar file. second, copy the jar file to JRE image and make a ENTRYPOINT in JRE image.
Maintain two steps are not easy tasks, even go bhell script.

Also,  It was  very common to have one Dockerfile to use for development (which contained everything needed to build your application), and a slimmed-down one to use for production, which only contained  application and exactly what was needed to run it.
This called “builder pattern”. Maintaining two Dockerfiles is not ideal.

Multi-stage builds can fix above issues, multi-stage builds has multiple FROM statements in  Dockerfile. 
Each FROM instruction can use a different base, and each of them begins a new stage of the build. 
I can selectively copy artifacts from one stage to another, leaving behind everything you don’t want in the final image. 

- Optimize Dockerfiles
- Keep the image size down

# How to implement Multi-stage build in Springboot Microservice Docker Image? 
I'll show the demo.
- There are two new Dockerfile Commands  
   - FROM XXXX AS stage name, AS stage name  is magic key word, it likes hook for each layer. 
   - COPY --from=stage name/file or folder  --from=stage name is able to copy file or files from provisos stage
- Dockerfiles/v5/Dockerfile



- next build image  
  `docker build -t microservic:v5 .`  
- Get Image detail  
  `docker image inspect microservic:v5`
- and then , Run a Container   
  `docker container run -d --name microservicv5 --rm -p 9999:9999  microservic:v5`   
- verify Springboot log  
`docker logs microservicv5`  

- Test APIs
    - Add User  
     `curl -H "Accept: application/json" -H "Content-type: application/json" -d '{"lastName":"Duan","firstName":"Lian"}' -X POST 172.17.0.3:9999/users`  
    - Find users  
     `curl 172.17.0.3:9999/users`  
- Stop container       
`docker container stop microservicv5`