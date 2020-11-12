# Summary 
Welcome to our class. Today our topics are
- How to manage data in Docker?
- Three ways to mount data on Docker

# How to manage  data in Docker?
- Persist 
- Temp
# Three ways to mount data on Docker
## Mount Type:
- bind mounts
- volumes
- tmpfs 
  ![avatar](https://docs.docker.com/storage/images/types-of-mounts.png) 
   
### Bind mounts
--mount  
`--mount type=bind,source="$(pwd)"/html,target=/usr/share/nginx/html/`   
- Creat Html file in html folder

- Mount file to a nginx Container  
`docker container run -d --name myNginx -p 7777:80 --rm --mount type=bind,source="$(pwd)"/html,target=/usr/share/nginx/html/ nginx:latest` 
- Find mount detail  
`docker inspect myNginx`  
- Verify  
`docker exec -it myNginx /bin/bash`  
`curl 172.17.0.2:80/index.html` 
- Stop the nginx Container  
`docker container stop myNginx`
- Add mount file permission  
`docker container run -d   --name myNginx -p 7777:80 --rm --mount type=bind,source="$(pwd)"/html,target=/usr/share/nginx/html/ nginx:latest`
- Stop the nginx Container  
`docker container stop myNginx`
- Mount folder must be exist  
`docker container run -d   --name myNginx -p 7777:80 --rm --mount type=bind,source="$(pwd)"/html2,target=/usr/share/nginx/html/,readonly nginx:latest`

### Volume
- Manage Volume   
`docker volume create htmlContent`  
`docker volume ls`  
`docker volume inspect htmlContent`
- Copy Html file to htmlContent  
- Run a nginx container with volume <br>                   
`docker container run -d -it --name myNginx -p 7777:80 --mount source=htmlContent,target=/usr/share/nginx/html/ nginx:latest` 
- Inspect the nginx container  
`docker inspect myNginx`  
- Verify
`docker exec -it myNginx /bin/bash`  
`curl 172.17.0.2:80/index.html` 
- Stop the nginx Container  
`docker container stop myNginx`  
- Docker auto create Volume   
`docker container run -d -it --name myNginx -p 7777:80 --mount source=htmlContent2,target=/usr/share/nginx/html/nginx:latest` 
- Verify   
`docker volume ls`  
`docker volume inspect htmlContent2`  
`docker container stop myNginx`  
`docker volume rm htmlContent`  
### tmpfs 
- temp mount  
`docker container run -d -it --name myNginx -p 7777:80 --rm --mount type=tmpfs,target=/app nginx:latest` 
- Verify        
`docker inspect myNginx`  
`docker container stop myNginx`    

