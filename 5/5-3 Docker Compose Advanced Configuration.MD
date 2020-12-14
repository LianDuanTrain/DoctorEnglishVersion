# Docker Compose Advanced Configuration
- How to use env parameter in Docker Compose file? 
- How to use multiple Docker Compose files?   

## How to use env parameter in Docker Compose file?
-  ${parameter name:-default value}
    - ${IMAGETAG:-jetty:9.4.31-jdk8-slim}
-  .env file content:
    - IMAGETAG=jetty:9.4.35-jre8

- Create .env file
    IMAGETAG=jetty:9.4-jre8-slim  
- Start up  
    `docker-compose -f  docker-compose-env.yaml up  -d`
- Check status         
    `docker-compose ps`
- Shutdown    
    `docker-compose -f docker-compose-env.yaml down -v`    


## How to use multiple compose files?
- Merge Rule
   - For single-value options like image, command or mem_limit, the new value replaces the old value.
   - For the multi-value options ports, expose, external_links, dns, dns_search, and tmpfs, Compose concatenates both sets of values.  
- Print the merged configuration file
   - `docker-compose -f file1.yaml -f file2.yaml config`
   - `docker-compose -f docker-compose-env.yaml -f docker-compose-qa.yaml config`   
- Start   
 `docker-compose -f  docker-compose-env.yaml -f  docker-compose-qa.yaml  up  -d`   
- Check Port   
`docker-compose ps`    
-  Test API:
   - Add User  
    `curl -H "Accept: application/json" -H "Content-type: application/json" -d '{"lastName":"AA3","firstName":"BB3"}' -X POST 192.168.31.231:8080/demo/users`   
   - Get user list  
    `curl 192.168.31.231:8080/demo/users`    
    `curl 192.168.31.231:8888/demo/users`


