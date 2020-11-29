# Summary 
Hello and welcome to this session on Dockerfile. we're go learn about build docker image via Dockerfile.
- What is Dockerfile? 
- How to create a Dockerfile?
- How to build a Image via Dockerfile?
After the session, you will get all answers.

- What is Dockerfile?   
Dockerfiles are text documents that allow you to build images for Docker.So the Dockerfile is build instructions to build an image. 
- How to create a Dockerfile?
Any text edie can create a Dockerfile.
- What is Dockerfile CMD? 
Dockerfile contains all the commands  to assemble an image.
There are list of command

FROM 
RUN 
LABEL 
ENV
COPY
USER  
ARG
EXPOSE 
ENTRYPOINT 
CMD
Doday, we use FROM and RUN, remaining commands will use the future sessions. 
- FROM - must be the first non-comment instruction in the Dockerfile. FROM mansion A parent image is that your image is based on.
   
- RUN  (shell form, the command is run in a shell, which by default is /bin/sh on Linux or cmd  on Windows)

- How to build a Image via Dockerfile?
docker build command  create a image use Dockerfile
docker build --help  will give you the details on docker build command,
you can see all these options.

--no-cache means always download parent image, does not use local image cash
-t tage of image

let's start a demo   

First,  Create a Dockerfile  
`mkdir mynginx`   
`cd mynginx`  
`touch Dockerfile` touch is uded to create, change and modify timestamps of a file  

Dockerfile    
`FROM nginx:1.19.2  
  RUN echo '<h1>Hello, First Docker Image!</h1>' > /usr/share/nginx/html/index.html`

And than,  Build  Docker Image  , the tag has three parts: docker hub user name, and image name, version      	
`docker build -t dl0218/mynginx:v1 .`   
Also , docker support Build a Docker Image form linux standard input. The build commands are between first EOF ans second EOF.

`docker build -t dl0218/mynginx:v1 -<<"EOF"
FROM nginx:1.19.2
RUN echo '<h1>Hello, First Docker Image!</h1>' > /usr/share/nginx/html/index.html
EOF`

Next, run a container which is based on my created  Image
`docker container run -d --rm -p 8080:80 --name=mynginx dl0218/mynginx:v1`
`curl localhost:8080`


I hope  now you understand a dockerfile by yourself, and is able to use dockerfile to create container.



I will meet you in the next session of docker， 
