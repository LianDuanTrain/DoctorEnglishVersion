# Docker Registry 
- What is a Docker Registry?
- Why we need a private Docker  Registry?
- How to create the simplest private Docker Registry in local?  

## How to create the simplest private Docker Registry in local? 
- Get Docker Image  
    `docker pull registry:2.7.1`
- Configuration  
        vi /etc/docker/daemon.json  
        add "insecure-registries":["yout box IP:5000"]  
            `{
                "insecure-registries": ["192.168.31.231:5000"]
            }`
- Reload and Restart Docker  
      - `systemctl daemon-reload`    
      - `systemctl restart docker`    
      - `systemctl status docker`    
- Run  
    `docker volume create LocalDockerRegistry`  
    `docker container run -d --name localDockerRegistry --restart=always -p 5000:5000 -e REGISTRY_STORAGE_DELETE_ENABLED=true  --mount source=LocalDockerRegistry,target=/var/lib/registry registry:2.7.1`

- Test    
    `curl -XGET http://192.168.31.231:5000/v2/_catalog`  

  
