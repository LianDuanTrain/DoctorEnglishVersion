# Container Management
##  Add Container Name
        docker container run --name web jetty:9.4.31-jre8 
        docker container ls 
        docker container stop web
        docker container restart web
        docker container rm web
##	Restart Container			
##  Run As Detached 
        docker container run -d --name web jetty:9.4.31-jre8
        docker container ls  -f "name=web"
        docker container ls -f "name=we*"
##  Kill VS Stop 
- Docker stop attempts to stop the container gracefully allowing the main process to cleanup before shutting down. Docker inspect would shows that the Exit Code under container Status is 0 when the container was stopped using docker stop.
- docker kill shows an Exit Code of 137 (non 0 exit) in the container status.
        docker events
        docker top {containerName}
        docker stats
        docker container kill web (-signal=9) (exitCode=137)
        docker container rm web
        docker container run -d --name web jetty:9.4.31-jre8
        docker container stop web (-signal=15) (exitCode=143)           
##  Exec
        docker container run -d --name web jetty:9.4.31-jre8
        docker exec -it web /bin/bash
        docker container run -it --name web jetty:9.4.31-jre8 /bin/bash
        docker container stop web
        docker container rm web
##  Stop and Remove
        docker container run -d --rm --name web jetty:9.4.31-jre8
        docker container stop web
        docker container ls -a
##  Inspect
        docker container run -d --rm --name web jetty:9.4.31-jre8      
        docker container inspect web   --format='{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}'
        docker container inspect web | grep IP
##  Log
        docker container logs web
##  Export/Inport    
        docker container export web -o jettybackup.tar
        docker container stop web
        docker container rm web
        docker container ls      
        cat jettybackup.tar | docker import - test/myjetty:v1.0
        docker image ls 
        docker image rm test/myjetty:v1.0
        
