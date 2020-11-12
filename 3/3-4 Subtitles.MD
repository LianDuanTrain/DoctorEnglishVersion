# Summary 
Welcome to our class. We hace to topics
- How to access docker container from the outside network
- Port mapping behind knowledge

First topic, How to access docker container from the outside network. Previous class, I  only access the Jetty inside the docker container.
   - Start a container  
    `docker container run -d --rm --name web jetty:9.4.31-jre8`  
   - Find Container IP    
        `docker network inspect bridge`
   - Access Jetty inside Container  
        `curl 172.17.0.3:8080`   
   - Find Docker 0  
        `ifconfig`        
   - Access inside Linuc box      
       `curl 192.168.31.197:8080`  
   docker container stop web
   ##  Port mapping 
   Second topic, Port mapping Behind Knowledge  
By default, when you create or run a container using docker create or docker run, it does not publish  ports to the outside world. To make a port available to services outside of Docker use the --publish or -p flag. This creates a firewall rule which maps a container port to a port on the Docker host to the outside world. Here are some examples.
   - Start new container  
    `docker container run -itd --rm -p 9999:8080 --name web jetty:9.4.31-jre8`
- Access inside Linuc box      
       `curl 192.168.31.197:9999` 
# Port mapping Behind Knowledge


- Check iptables  
            `iptables -t nat -nL`

   

# Thank you for watching, see you in the next class.