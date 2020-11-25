# Summary 
Hello and welcome to this session on Dockerfile. we're go learn about build docker image via Dockerfile.
- What is Dockerfile? 
- How to create a Dockerfile?
- How to build a Image via Dockerfile?

- What is Dockerfile?   
Dockerfiles are text documents that allow you to build images for Docker.So the Dockerfile is build instructions to build the image. 
- How to create a Dockerfile?
Any text edie can create/ecit a Dockerfile.
- What is Dockerfile CMD? 
Dockerfile contains all the commands  to assemble an image.
There are list of command

FROM 
RUN 
MAINTAINER  
LABEL 
ENV
COPY
USER 
MAINTAINER
LABEL 
ARG
EXPOSE 
ENTRYPOINT 
CMD
Doday, we use FROM and RUN, remaining commands will use the future sessions. 
- FROM - must be the first non-comment instruction in the Dockerfile.
- RUN  (shell form, the command is run in a shell, which by default is /bin/sh on Linux or cmd  on Windows)

- How to build a Image via Dockerfile?
docker build command to create a image use Dockerfile
docker build --help
--no-cache  -t

let's start a demo   

First,  Create a Dockerfile  
`mkdir mynginx`   
`cd mynginx`  
`touch Dockerfile`  
Dockerfile    
`FROM nginx:1.19.2  
  RUN echo '<h1>Hello, First Docker Image!</h1>' > /usr/share/nginx/html/index.html`
And than,  Build a Docker Image     	
`docker build -t dl0218/mynginx:v1 .` 
Also , docker support Build a Docker Image form standard input.

`docker build -t dl0218/mynginx:v1 -<<"EOF"
FROM nginx:1.19.2
RUN echo '<h1>Hello, First Docker Image!</h1>' > /usr/share/nginx/html/index.html
EOF`

Next, run a container which is based on my created  Image
`docker container run -d --rm -p 8080:80 --name=mynginx dl0218/mynginx:v1`
`curl localhost:8080`


I hope  now you understand a docker image by yourself 
I will meet you in the next session of docker， 
