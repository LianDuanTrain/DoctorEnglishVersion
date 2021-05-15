# Dockerfile CMDs
# V1 : FROM, LABEL, Add, EXPOSE, ENTRYPOINT
# Parent Image
FROM openjdk:8-jdk
# Add metadata to an image
LABEL version="V 1.0" description="Springboot Microservice - CRUD User" author="Lian"
# Add jar file from local to image
ADD target/demo-0.0.1-SNAPSHOT.jar /myMicroservice/demo.jar
# Instruction Docker container listens on the specified network ports at runtime
EXPOSE 9999
# Container run as an executable.
ENTRYPOINT java -jar /myMicroservice/demo.jar