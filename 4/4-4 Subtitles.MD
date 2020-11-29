# Summary 
Hello and welcome to this session on Docker image push/delete.In previous session, I showed how to create a docker image. today, we're go learn.
- How to push image in Docker hub?
- How to delete image in Docker hub?
- How to push image to Private Docker Registry?
- How to delete image to Private Docker Registry?
- How to release disk space in Private Docker Registry? 
  
## How to push image to Docker hub? 
let me start and go to my terminal 
before  push image to docker hub, I have to login Docker hub.
`docker login`  
If you want to publish an image to docekr hub, run docker push 
`docker push --help` 
this gives us the usage of the docker push command, you can see the command with all these options . The command syntax is   
`docker push <hub-user>/<repo-name>:<tag>`    
`docker push dl0218/mynginx:v1` 
Push down , let's go to UI to check result.

Next, delete the image in Docker Hub.


## How to push image to Private Docker Registry?
In previous class, I created a Private Docker Registry. The Private Docker Registry is used to following steps.

First change the tag, the tag format for Private Docker Registry is  IP or name and port and image name and version.

`docker tag dl0218/mynginx:v1 192.168.31.231:5000/mynginx:v1`
Docker push
`docker push 192.168.31.231:5000/mynginx:v1`    
and than, check _catalog to verify push image result

The Docker Registry HTTP API is the protocol to  images  distribute to the docker engine. 

`curl -XGET http://localhost:5000/v2/_catalog`   

If you want to get all tags in Repository, cmd is

`curl -XGET http://localhost:5000/v2/mynginx/tags/list` 

the API give  you image detail
`curl -XGET http://localhost:5000/v2/mynginx/manifests/v1`   
 
## How to delete image to Private Docker Repository?
Get Digest use this CMD
After Repository 2.3 the header needs, whitout the header, the request will return incurrect Digest.
https://docs.docker.com/registry/spec/api/#/deleting-an-image
`curl -v --silent -H "Accept: application/vnd.docker.distribution.manifest.v2+json" -X GET  http://192.168.31.231:5000/v2/mynginx/manifests/v1 2>&1 | grep Docker-Content-Digest | awk '{print ($3)}'`  

Next, Use -X DELETE to delete image
`curl -v --silent -H "Accept: application/vnd.docker.distribution.manifest.v2+json" -X DELETE http://192.168.31.231:5000/v2/mynginx/manifests/sha256:86c85cc3166e24782c877fe772accf9813d04b70527402d79ea9dfe6c4b4e4b1`

## How to release disk space in Private Docker Repository? 
`docker exec -it localDockerRegistry  /bin/registry garbage-collect  /etc/docker/registry/config.yml
# End
I hope  now you understand the concept of docker push、delete and you can now use it in your projects  
I will meet you in the next episode of docker，

   

