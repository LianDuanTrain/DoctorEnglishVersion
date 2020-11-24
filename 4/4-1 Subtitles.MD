# Summary 
Hello and welcome to this session on docker Image. we're go learn about docker Image.
## What is Docker Image?
## How to find high quality Docker image?
## How to download Docker Image?
## How to get Docker Image detail?
## How to delete Docker Image?

What is Docker Image?
A Docker image is a read-only template witch used to create and run  docker containers on the Docker platform.
The template provides a convenient way to package up applications and preconfigured server environments.

How to find high quality Docker image?
- Download Quantity
- Last update time
- Start
- Official image

Let me login to hub docker, search - jetty, if you do not have a account yet, pleae create one brcause docker push need login dicker hub first.

View Available Tags has docker pull CMD and all Available jetty image version
There are  

There is Dockerfile link, the Dockerfile is a good resource to studay how to write a Dockerfile for green hand.


docker image -- help will give you the details on docker image command,
you can see all these options  and I will just show you later


Command:
How to download Docker Image?
I can use docker pull and image name and tag to download docker imge from docker hub to local

- docker pull jetty:9.4.34-jre8
If you want to check local image, you can run  docker image ls or docker images 

- docker image ls (docker images)
docker image tag command is able to add a tag into exisiting image. For example:   
- docker image tag jetty:9.4.34-jre8 myjetty:v1  
- 
 How to get  docker image detail, run docker image inspect.
- docker image inspect myjetty:v1
  
- docker image inspect jetty:9.4.34-jre8
  I see there are  Entrypoint and Cmd,
  Entrypoint is static part of container start
  Cmd provide user input parameter
  docker run -d jetty --module=jmx jetty.threadPool.maxThreads=500
- docker image history jetty:9.4.34-jre8


  If you want to delete all unuse image , you can say docker image prune
- docker image prune

docker image rm and image name can delete Specify image
- docker image rm
  

- docker search
- docker image build
- docker push


