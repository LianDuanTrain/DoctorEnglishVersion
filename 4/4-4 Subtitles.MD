# Summary 
Hello and welcome to this session on Docker Image manangement. we're go learn about push/delete docker image.
- How to push image in Docker hub?
- How to delete image in Docker hub?
- How to push image to Private Docker Repository?
- How to delete image to Private Docker Repository?
- How to release disk space in Private Docker Repository? 
  
## How to push image to Docker hub? 
let me start and go to my terminal 
before  push image to docker hub, I hoave to login.
`docker login`  
If you want to publish an image to docekr hub, run docker push 
`docker push --help` 
this gives us the usage of the docker push command, you can see the command with all these options  and I will just show you later  
`docker push <hub-user>/<repo-name>:<tag>`    
`docker push dl0218/mynginx:v1` 
Push down , let's go to UI to check result.

Next, delete the image in Docker Hub.


## How to push image to Private Docker Repository?
First change the tag, the tag format is Private Docker Repository IP or name and port and Repository and tag.

 `docker tag dl0218/mynginx:v1 192.168.31.197:5000/mynginx:v1`
Docker push
`docker push 192.168.31.197:5000/mynginx:v1`    
and than, check _catalog to verify push image result
The Docker Registry HTTP API is the protocol to  images  distribute to the docker engine. 

`curl -XGET http://localhost:5000/v2/_catalog`   
If you want to get all tags in Repository, cmd is
`curl -XGET http://localhost:5000/v2/mynginx/tags/list`    
`curl -XGET http://localhost:5000/v2/mynginx/manifests/v1`   
the API give  you image detail 
## How to delete image to Private Docker Repository?
Get Digest use this CMD
After Repository 2.3 the header needs, whitout the header, the request will return incurrect Digest.
https://docs.docker.com/registry/spec/api/#/deleting-an-image
`curl -v --silent -H "Accept: application/vnd.docker. distribution.manifest.v2+json" -X GET  http://192.168.31.197:5000/v2/mynginx/manifests/v1 2>&1 | grep Docker-Content-Digest | awk '{print ($3)}'`  
Next, Use -X DELETE to delete image
`curl -v --silent -H "Accept: application/vnd.docker.distribution.manifest.v2+json" -X DELETE http://192.168.31.197:5000/v2/mynginx/manifests/v1/sha256:a65a0fe7950b4105f2fbaa3aaa1ec9db41a58b90a4a239720dae70e8536586e5`

## How to release disk space in Private Docker Repository? 
`docker exec -it localDockerRegistry  /bin/registry/garbage-collect  /etc/docker/registry/config.yml
# End
I hope  now you understand the concept of docker push and you can now use it in your projects  
I will meet you in the next episode of docker，

   

