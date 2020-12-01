# Dockerfile CMDs
# V1 : FROM, LABEL, ADD, EXPOSE, ENTRYPOINT
# V2 : RUN, COPY, USER, WORKDIR, CMD 
# Parent Image
FROM openjdk:8-jre-slim
# Add metadata to an image
LABEL version="V 3.0" description="Springboot Microservice - CRUD User" by="Lian"
# Copy jar file from local to image
COPY target/demo-0.0.1-SNAPSHOT.jar /myMicroservice/demo.jar
# Run /bin/bash
# Add user and user group
RUN  apt-get update && apt-get install --assume-yes apt-utils; \
     groupadd -r microservice && useradd -r -g microservice microservice;  \
     chown -R microservice:microservice /myMicroservice;
# Switch User
USER microservice
# WORKDIR is working directory for any RUN, CMD, ENTRYPOINT, COPY
WORKDIR /myMicroservice 
# Instruction Docker container listens on the specified network ports at runtime
EXPOSE 9999
# CMD  is to provide defaults for an executing containe
# If CMD is used to provide default arguments for the ENTRYPOINT instruction, both the CMD and ENTRYPOINT instructions should be specified with the JSON array format.
CMD java -jar /myMicroservice/demo.jar