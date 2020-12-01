# Dockerfile CMDs
# V1 : FROM, LABEL, ADD, EXPOSE, ENTRYPOINT
# V2 : RUN, COPY, USER, WORKDIR, CMD 
# Parent Image
FROM openjdk:8-jdk
# Add metadata to an image
LABEL version="V 2.0" description="Springboot Microservice - CRUD User" author="Lian"
# Copy jar file from local to image
COPY target/demo-0.0.1-SNAPSHOT.jar /myMicroservice/demo.jar
# Run /bin/bash
# apt Update
RUN apt-get update;
RUN apt-get install --assume-yes apt-utils;
# Add user and user group
RUN groupadd -r microservice;
RUN useradd -r -g microservice microservice; 
RUN chown -R microservice:microservice /myMicroservice;
# Switch User
USER microservice
# WORKDIR is working directory for any RUN, CMD, ENTRYPOINT, COPY
WORKDIR /myMicroservice 
# Instruction Docker container listens on the specified network ports at runtime
EXPOSE 9999
# CMD  is to provide defaults for an executing containe
# If CMD is used to provide default arguments for the ENTRYPOINT instruction, both the CMD and ENTRYPOINT instructions should be specified with the JSON array format.
CMD java -jar /myMicroservice/demo.jar