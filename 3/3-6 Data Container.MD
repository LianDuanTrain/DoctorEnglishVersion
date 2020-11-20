# Summary
Welcome to our class. Today our topics is Data Container 
# Data Container
- Create a HTMl page in html folder
- Create a data container   
        `docker run -d -it --name myData  --mount type=bind,source="$(pwd)"/html,target=/usr/share/nginx/html/ alpine:latest` 
- Verify data  
        `docker exec -it myData /bin/sh`    
        `cd /usr/share/nginx/html/`  
- Run nginx and use myData  
-- volumes-from        
        `docker run -d -it --name myNginx -p 7777:80 --rm --volumes-from myData nginx:latest`  
- Verify data            
`docker exec -it myNginx /bin/sh`        
`curl 172.17.0.2:80/index.html`         
- Container inspect   
`docker container inspect myNginx`  
`docker container inspect myData`  
- Stop Container  
`docker container stop  myData`  
- Verify data            
`docker exec -it myNginx /bin/sh`        
`curl 172.17.0.2:80/index.html`  
- Stop Container
`docker container stop  myNginx`  

       
       

        
    
        
