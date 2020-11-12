# Summary
Welcome to our class. Today our topics is Data Container 
# Data Container

- Create a data container   
        `docker run -d -it --name myData  --mount type=bind,source="$(pwd)"/html,target=/usr/share/nginx/html/ alpine:latest` 
- Verify data  
        `docker exec -it myData /bin/sh`    
        `cd /usr/share/nginx/html/`  
- Run nginx and use myData  
-- volumes-from        
        `docker run -d -it --name myNginx -p 7777:80 --rm --volumes-from myData nginx:latest`  
- Container inspect   
`docker container inspect myNginx`  
`docker container inspect myData`  

- Stop Container  
`docker container stop  myData`  
` docker container stop  myNginx`  
       
       

        
    
        
