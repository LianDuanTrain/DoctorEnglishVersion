# Summary 
Hello and welcome to this session of Docker compose. we're go learn about Advanced Features of  Docker compose.
- How to use env parameter in Docker Compose file? 
- How to use multiple Docker Compose files? 


Why i need env parameter in Docker Compose? Becasue env parameter avoide hardcode vaule in docker compose yaml file.  easy maintenance compose yaml file.

## How to use env parameter in Docker Compose? 
Format is $ brackets parameter name and colon - default value
First add parameter into docker-compose-env.yaml
-  ${parameter name:-default value}
    - ${IMAGETAG:-jetty:9.4.31-jdk8-slim}

add key vaule pare in .evn file. # Comment key word
-  .env file content:
    - IMAGETAG=jetty:9.4.35-jre8
  - 
Next,  create a .env file in the folder which has docker compose file
Don't use quotes in the .env file, they will be part of the value
- Create .env file
    IMAGETAG=jetty:9.4-jre8-slim  

And than, start docker-compose, -f parametrer is  Specify yaml file
- Start up  
    `docker-compose -f  docker-compose-env.yaml up  -d`

- Check status         
    `docker-compose ps`

- Next check image detail, the image should be jetty:9.4.35-jre8, is not jetty:9.4.31-jdk8-slim. Because env  image vaule overwirte image vaule in docker compose file.   
-     
- Shutdown    
    `docker-compose -f docker-compose-env.yaml down -v`    

## How to use multiple Docker compose files? 
Use multiple Docker Compose files when I want to change app for different environments (e.g., dev, QA, and production) or when I want to run admin tasks against a Compose application. 

- Merge rules are 
   -  For single-value options like image, command or mem_limit, the new value replaces the old value.   
   - For the multi-value options ports, expose, external_links, dns, dns_search, and tmpfs, Compose concatenates both sets of values.

- use  sub command config to Print the merged configuration file. go thouth docker-compose-qa.yaml
   - `docker-compose -f file1.yaml -f file2.yaml config`
   - `docker-compose -f docker-compose-env.yaml -f docker-compose-qa.yaml config`
     
- Start  docker-compose  
 `docker-compose -f  docker-compose-env.yaml -f  docker-compose-qa.yaml  up  -d`   
- Check Port mapping  
`docker-compose ps`    
-  Test API 
   - Add User
    `curl -H "Accept: application/json" -H "Content-type: application/json" -d '{"lastName":"AA3","firstName":"BB3"}' -X POST 192.168.31.231:8080/demo/users`   
   - Get user list with two ports:


    `curl 192.168.31.231:8080/demo/users`    
    `curl 192.168.31.231:8888/demo/users`


I hope  now you can use env in  docker Compose file   and add  multiple Docker compose files for different env. 


