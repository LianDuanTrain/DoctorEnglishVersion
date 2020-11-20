# Summary 
Welcome to our class. Today our topics is Data Container 
# Data Container
What is Data Container? The Data Container only contents data and share the data to other Containers. The data container is the simplest sidecar design pattern implementation.  

What is a sidecar design pattern? 
A sidecar attached to a motorcycle. In the pattern, the sidecar is attached to a parent application and provides supporting features for the application.  

In my demo, the sidecar provides application content.  
First, create a HTMl page in html folder
Second, create a data container based on alpine linux image.
- Create a data container   
        `docker run -d -it --name myData  --mount type=bind,source="$(pwd)"/html,target=/usr/share/nginx/html/ alpine:latest` 
Next, 
- Verify data  
        `docker exec -it myData /bin/sh`    
        `cd /usr/share/nginx/html/`  
Four step, Run nginx and use myData with  volumes-from  
- volumes-from        
        `docker run -d -it --name myNginx -p 7777:80 --rm --volumes-from myData nginx:latest` 
Next step,  Verify data, go inside myNginx         
- Verify data, go inside myNginx              
`docker exec -it myNginx /bin/sh`         
`curl 172.17.0.2:80/index.html`  
Six steps, inspect  Container and see behind the scene
- Container inspect 
`docker container inspect myData`   
`docker container inspect myNginx`  
And than, Stop myData to verify my assumption
- Stop Container  
`docker container stop  myData` 
Check data,
 - Verify data            
`docker exec -it myNginx /bin/sh`        
`curl 172.17.0.2:80/index.html`
- Stop Container  
` docker container stop  myNginx`  

