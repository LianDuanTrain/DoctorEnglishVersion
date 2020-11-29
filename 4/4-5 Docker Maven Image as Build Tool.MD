# Use Docker Maven Image as Build Tool
- Why we need Maven Docker image build Java project?
- How to use Maven Docker image build  Java project?  
- How to run Meavn image as non-root?  
## Why we need Maven Docker image build Java project?  
## How to use Maven Docker image build Java project?
- Java project over view 
  - Add User: 
    `curl -H "Accept: application/json" -H "Content-type: application/json" -d "{\"lastName\":\"AA3\",\"firstName\":\"BB3\"}" -X POST localhost:9999/users`
  - Get User List: 
    `curl localhost:9999/users`
- Download Project from:  
https://github.com/LianDuanTrain/DockerSpringBootDemo/tree/buildJarFile   
- Get Docker Image  
    `docker pull maven:3.6-jdk-8-openj9`  
- Start container to build  
   `docker container run -it --name mvn001 -v /home/lian/mvn:/usr/src/mymaven -w /usr/src/mymaven maven:3.6-jdk-8-openj9 mvn clean package -U -DskipTests`
- Check build result  
   `cd target`    
   `docker logs -f mvn001`

- Build Again   
   `docker container run -it --name mvn002 -u 1000 -v /home/lian/mvn:/usr/src/mymaven -w /usr/src/mymaven maven:3.6-jdk-8-openj9 mvn clean package -U -DskipTests=true`   
## How to run Meavn image as non-root?  
- Get user UID  
root run 'cat /etc/passwd'  
- Run container   
`docker container run -v ~/.m2:/var/maven/.m2 -v /home/lian/mvn:/usr/src/mymaven -w /usr/src/mymaven -ti --rm -u 1000 -e MAVEN_CONFIG=/var/maven/.m2  maven:3.6-jdk-8-openj9 mvn -Duser.home=/var/maven clean package  -U -DskipTests`     
- Check build result  
   `cd target`    
   `docker logs -f mvn001`      



