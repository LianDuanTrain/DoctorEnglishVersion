# Push/Delete Docker Image
- How to push image to Docker hub?
- How to delete image in Docker hub?
- How to push image to Private Docker Registry?
- How to delete image in Private Docker Registry?
- How to release disk space in Private Docker Registry? 

## How to push image to Docker hub? 
- Login    
`docker login` 
- Push     
`docker push --help` 
`docker push <hub-user>/<repo-name>:<tag>`    
`docker push dl0218/mynginx:v1` 

## How to delete image in Docker hub?

## How to push image to Private Docker Registry?
- Rename tag    
Tag is  <Private Docker Repository IP/Name:Port>/<repo-name>:<tag> 
`docker tag dl0218/mynginx:v1 192.168.31.231:5000/mynginx:v1`    
`docker push 192.168.31.231:5000/mynginx:v1`     
- Check push result    
`curl -XGET http://localhost:5000/v2/_catalog`   
- Get tags  
`curl -XGET http://localhost:5000/v2/mynginx/tags/list`  
- Get image detial  
`curl -XGET http://localhost:5000/v2/mynginx/manifests/v1`   
 
## How to delete image in Private Docker Registry?
- Get Digest  
`curl -v --silent -H "Accept: application/vnd.docker.distribution.manifest.v2+json" -X GET  http://192.168.31.231:5000/v2/mynginx/manifests/v1 2>&1 | grep Docker-Content-Digest | awk '{print ($3)}'`  
- Delete image  
`curl -v --silent -H "Accept: application/vnd.docker.distribution.manifest.v2+json" -X DELETE http://192.168.31.231:5000/v2/mynginx/manifests/v1/sha256:682f792503be45000b59d22b1b4a50683f93fbb159db12e1098d007e6707afdb`

## How to release disk spacein Private Docker Repository 
- Run   
`docker exec -it localDockerRegistry  /bin/registry garbage-collect  /etc/docker/registry/config.yml`

   

