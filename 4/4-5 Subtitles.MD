# Summary 
Hello and welcome to this session, using Docker Maven Image build java Springboot project. 

Why we need Maven Docker image build JAVA project?
How to use Maven Docker image build  JAVA project?
How to run Meavn image as non-root ?

Before build Springboot project, let go over the it. The project has four APIs ,  getUsers , createUser , updateUser  and deleteUser. The API data store in memory.

  - First, try Add User infomataion  
    `curl -H "Accept: application/json" -H "Content-type: application/json" -d "{\"lastName\":\"AA3\",\"firstName\":\"BB3\"}" -X POST localhost:9999/users`
  - And then get User List: 
    `curl localhost:9999/users`
- You can download Project from :  
- https://github.com/LianDuanTrain/DockerSpringBootDemo/tree/buildJarFile   
- Upload the download source code to mvn folder in my linux box.  

What is Maven?   
Apache Maven is a cornerstone of Java development, and the most used build management tool for Java.  
## Why we need Maven Docker image build JAVA project?
- Java language need to build and then Run
- Befroe I create my java project Docker image, best practice is verify Java code, Mave build script, Docker maven image env parameter  in my local box via Maven Docker image.
- Maven Docker image  can work as build note in CI/CD tool
  
## How to use Maven Docker image build a JAVA project?
- First Get Docker maven Image  
    `docker pull maven:3.6-jdk-8-openj9`  
- And then Start container to build
   `docker container run -it --name mvn001 -v /home/lian/mvn:/usr/src/mymaven -w /usr/src/mymaven maven:3.6-jdk-8-openj9 mvn clean package  -U -DskipTests`
- Check build result
   `cd target`    
   `docker logs -f mvn001`

- Next, if My code change, I have to run maven bnuild again.   
   `docker container start mvn001`   
Did you find the different between first time container run and second time container?
second time container run quick then first time container because container do not need download dependency jar files again.

Sinc the container run as root use, the target folder and its children files belong to root user. Could I Running Meavn image as non-root user?
Before my demo,  delete .m2 and target folders because the folder owner is root user.

Start the demo,
- First step, get user UID  
root run 'cat /etc/passwd'
- Second step, I have to clean up existing .m2 folder because .m2 owner is root. current user lian can not change any file in the folder.
- Third step , Run container
`docker container run -v ~/.m2:/var/maven/.m2 -v /home/lian/mvn:/usr/src/mymaven -w /usr/src/mymaven -ti --rm -u 1000 -e MAVEN_CONFIG=/var/maven/.m2  maven:3.6-jdk-8-openj9 mvn -Duser.home=/var/maven clean package  -U -DskipTests`  

I hope  now you can use Maven Docker Image as build tool in your projects  
I will meet you in the next episode of docker，
      



