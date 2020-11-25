# Create First Dockerfile Step by Step
- What is Dockerfile?
- How to create a Dockerfile?  
- What is Dockerfile CMD？
    - FROM  
    - RUN  
    - MAINTAINER  
    - LABEL 
    - ENV
    - COPY
    - USER 
    - MAINTAINER
    - LABEL 
    - ARG
    - EXPOSE 
    - ENTRYPOINT 
CMD
- How to build a Image via Dockerfile?

## Create a Dockerfile  
`mkdir mynginx`   
`cd mynginx`  
`touch Dockerfile`  
Dockerfile    
`FROM nginx:1.19.2  
  RUN echo '<h1>Hello, First Docker Image!</h1>' > /usr/share/nginx/html/index.html`
## Build a Docker Image     	
`docker build -t dl0218/mynginx:v1 .`  
## Build a Docker Image form standard input  
`docker build -t dl0218/mynginx:v1 -<<"EOF"
FROM nginx:1.19.2
RUN echo '<h1>Hello, First Docker Image!</h1>' > /usr/share/nginx/html/index.html
EOF`
## Test Image
`docker container run -d --rm -p 8080:80 --name=mynginx dl0218/mynginx:v1`

  

