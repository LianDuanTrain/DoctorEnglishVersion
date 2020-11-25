4-4 Docker Image as Build Tool
Src:https://github.com/LianDuanTrain/DockerSpringBootDemo
Get Docker Image
    docker pull maven:3.6-jdk-8-openj9
Run
   docker container run -it --name mvn001 --dns 8.8.8.8 -v /home/lian/mvn:/usr/src/mymaven -w /usr/src/mymaven maven:3.6-jdk-8-openj9 mvn clean package  -U -DskipTests 
   
   docker container run -it --name mvn002 -u 1000 -v /home/lian/mvn:/usr/src/mymaven -w /usr/src/mymaven maven:3.6-jdk-8-openj9 mvn clean package -U -DskipTests=true   
Test        
    docker start mvn001
    docker logs -f mvn001
        docker container rm mvn001 


