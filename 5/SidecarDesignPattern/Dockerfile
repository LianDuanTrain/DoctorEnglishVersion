    #
    # Microservice Build  as War
    #
    FROM maven:3.6-jdk-8-openj9 AS build
    LABEL version="1.0" description="Microservice build by Maven" by="Lian"  
    ENV APP_Build_Home=/home/build
    COPY src ${APP_Build_Home}/src
    COPY pom.xml ${APP_Build_Home}
    RUN groupadd -r build && useradd -r -g build build ; \
	chown -R build:build "${APP_Build_Home}"; 
    USER build
    WORKDIR ${APP_Build_Home}
    RUN mvn -U -DskipTests=true -f pom.xml clean package
    #
    # War file Container
    #
    FROM gliderlabs/alpine:3.9
    LABEL version="1.0" description="War file Container" by="Lian"
    #Default value
    ENV APP_Home=/var/lib/jetty/webapps
    ENV APP_Build_Home=/home/build
    ARG jarName=demo.jar 
    ENV APP_Name=${jarName}  
    RUN apk add --no-cache bash
    RUN mkdir -p /var/lib/jetty/webapps
    COPY --from=build ${APP_Build_Home}/target/demo.war ${APP_Home}/${APP_Name}
    VOLUME  ${APP_Home}
    ENTRYPOINT /usr/bin/tail -f /dev/null