# Image Management
## What is Docker Image?
## How to find high quality Docker image?
- Download Quantity
- Last update time
- Start
- Official image
## How to download Docker Image?
## How to get Docker Image detail?
## How to delete Docker Image?
Command:
- docker pull jetty:9.4.34-jre8
- docker image ls (docker images)
- docker image tag jetty:9.4.34-jre8 myjetty:v1
- docker image inspect myjetty:v1
- docker image inspect jetty:9.4.34-jre8  
  `docker run -d jetty --module=jmx jetty.threadPool.maxThreads=500`
- docker image history jetty:9.4.34-jre8
- docker image prune
- docker image rm
- docker search
- docker image build
- docker push


