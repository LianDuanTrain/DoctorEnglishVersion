# Summary 
Welcome to our class. Today our topics are
- How to manage data in Docker?
- Three ways to mount data on Docker

# How to manage data in Docker?
By default all files created inside a container are stored on a writable container layer. This means that:
- The data doesn’t persist when that container remove
- A container’s writable layer is tight to the docker host box 
- Writing into a container’s writable layer requires a storage driver.  The storage driver  reduces performance as compared to using data volumes, which write directly to the host filesystem. 

There are two types of data. One data need to Persist, the other one data is temporary data.
- Persist  
  Persist data have two ways, one, mount data from docker host box to container, Such as when you want to test a new version of your application without building a new image. Another one,  store APP log from container to docker host box.
- Temp  
  Temporary data usually for app local cache.
# Three ways to mount data on Docker
## Mount Type:clear

- bind mounts is Persist data
- volumes is Persist data
- tmpfs is Temporary data
  ![avatar](https://docs.docker.com/storage/images/types-of-mounts.png) 
   
### Bind mounts
Bind mounts have been around since the early days of Docker. 
Bind mounts have limited functionality compared to volumes. 
When you use a bind mount, a file or directory on the host machine is mounted into a container.
In general, --mount is more explicit and verbose. The biggest difference is that the -v syntax combines all the options together in one field, while the --mount syntax separates them. Here is a comparison of the syntax for each flag.

--mount tag  
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
Volumes have several advantages over bind mounts  
- Volumes are easier to back up or migrate than bind mounts.  
- You can manage volumes using Docker CLI commands.  
- Volumes work on both Linux and Windows containers.  
- Volumes can be more safely shared among multiple containers.  
- Volume drivers let you store volumes on remote hosts or cloud providers.  
- New volumes can have their content pre-populated by a container.  
- Volumes on Docker Desktop have much higher performance than bind mounts from Mac and Windows hosts. 
- In addition, volumes are often a better choice than persisting data in a container’s writable layer, because a volume does not increase the size of the containers, and the volume’s contents exist outside the container lifecycle. 
- Do example

- Manage Volume   
`docker volume create htmlContent`  
`docker volume ls`  
`docker volume inspect htmlContent`
- Copy Html file to htmlContent  
- Run a nginx container with volume <br>                   
`docker run -d -it --name myNginx -p 7777:80 --mount source=htmlContent,target=/usr/share/nginx/html/ nginx:latest` 
- Inspect the nginx container  
`docker inspect myNginx`  
- Verify html page access
`docker exec -it myNginx /bin/bash`  
`curl 172.17.0.2:80/index.html` 
- Stop the nginx Container  
`docker container stop myNginx`  
- try Docker auto create Volume   
`docker run -d -it --name myNginx -p 7777:80 --mount source=htmlContent2,target=/usr/share/nginx/html/nginx:latest` 
- Verify volume htmlContent2
`docker volume ls`  
`docker volume inspect htmlContent2`  
`docker container stop myNginx`  
`docker volume rm htmlContent`  
### tmpfs 
- temp mount  
 If your container generates non-persistent data, consider using a tmpfs mount to avoid storing the data in container’s writable layer,  avoiding writing into the container’s writable layer will increase the container’s performance.  
`docker run -d -it --name myNginx -p 7777:80 --rm --mount type=tmpfs,target=/app nginx:latest` 
- Verify tmpfs        
`docker inspect myNginx`  
`docker container stop myNginx`    

