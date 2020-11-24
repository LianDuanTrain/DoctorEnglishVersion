# Summary 
Hello and welcome to this session on docker Image. we're go learn about private Docker Repository.
- What is a Docker Repository?  
  A Docker repository is where you can store 1 or more versions of a specific Docker image.   
  An image can have 1 or more versions (tags).
  There are two types Docker Repository, public, such as docker hub,  and private Docker Repository is on you company or in your local box. 
- Why we need a private Docker Repository?  
  Sometimes you can’t share your repository with the world because it contains proprietary code or confidential information, so you need a private Docker Repository.

- How to create the simplest private Docker Repository in local?  

## How to create the simplest private Docker Repository in local? 
- How to Get Docker registry Image? run   
    `docker pull registry:2.7.1`

- and than add Configuration  in  daemon file, since I'm in the simplest way, I do not like like to set up SSL, so insecure-registries has to add.
  
        vi /etc/docker/daemon.json  
        add "insecure-registries":["yout box IP:5000"]  
            `{
                "insecure-registries": ["192.168.31.197:5000"]
            }`

- After change daemon, Docker service need to Reload and Restart in root user.
      - `systemctl daemon-reload`    
      - `systemctl restart docker`    
      - `systemctl status docker`    
- next, create a  volume LocalDockerRegistry to persistency Registry data.  
    `docker volume create LocalDockerRegistry` 
- and then start  Local Docker Registry  container，If we want to release disk space after delete image,  REGISTRY_STORAGE_DELETE_ENABLED=true has to add.   
    `docker container run -d --name localDockerRegistry --restart=always -p 5000:5000 -e REGISTRY_STORAGE_DELETE_ENABLED=true  --mount source=LocalDockerRegistry,target=/var/lib/registry registry:2.7.1`

- Finally, Test   Local Docker Registry,  
 cURL is a command-line tool for getting or sending data using URL syntax  
    `curl -XGET http://192.168.31.197:5000/v2/_catalog`  
    I see the empty result because I did not push any image to the local Docker Registry  
# End  

  I hope  now you understand the concept of docker Registry and you can create  Registry in your local.
 I will meet you in the next episode of docker， 
