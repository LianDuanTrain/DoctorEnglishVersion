# Summary 
Hello and welcome to this session. we're go learn about private Docker Registry.
- What is a Docker Registry?  
  A Docker Registry is where you can store 1 or more versions of a specific Docker image.   
  
  There are two types Docker Registry, public, such as docker hub,  and private Docker Registry is on you company or in your local box. 

- Why we need a private Docker Registry?  
  Sometimes you can’t share your Registry with the world because it contains company code or confidential information, so you need a private Docker Registry.

- How to create the simplest private Docker Registry in local?  

## How to create the simplest private Docker Registry in local? 
- How to Get Docker registry Image? 
  First download registry    
    `docker pull registry:2.7.1`

- and than add Configuration  in  daemon file. My demo is in the simplest way, so I do not  like to set up SSL,  insecure-registries item has to add daemon.json.
  
        vi /etc/docker/daemon.json  
        add "insecure-registries":["yout box IP:5000"]  
            `{
                "insecure-registries": ["192.168.31.231:5000"]
            }`

- After change daemon, Docker service need to Reload and Restart.
      - `systemctl daemon-reload`    
      - `systemctl restart docker`    
      - `systemctl status docker`    
- next, create a  volume LocalDockerRegistry to persistency Registry data.  
    `docker volume create LocalDockerRegistry` 
- and then start  Local Docker Registry  container，If we want to release disk space after delete image,  env parameter - REGISTRY_STORAGE_DELETE_ENABLED=true need to add.   
    `docker container run -d --name localDockerRegistry --restart=always -p 5000:5000 -e REGISTRY_STORAGE_DELETE_ENABLED=true  --mount source=LocalDockerRegistry,target=/var/lib/registry registry:2.7.1`

- Finally, Test   Local Docker Registry,  
 cURL is a command-line tool for getting or sending data using URL syntax  
    `curl -XGET http://192.168.31.231:5000/v2/_catalog`  
    I see the empty result because I did not push any image to the local Docker Registry  
# End  

  I hope  now you understand the concept of docker private Registry and you can create  Registry in your local.
 I will meet you in the next episode of docker， 
