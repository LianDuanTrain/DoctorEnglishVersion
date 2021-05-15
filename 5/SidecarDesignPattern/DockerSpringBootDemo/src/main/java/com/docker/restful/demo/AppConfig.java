package com.docker.restful.demo;


import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.docker.restful.demo.rest.UserResource;

@Configuration
@Component
public class AppConfig {
    @Named
    static class JerseyConfig extends ResourceConfig {
        public JerseyConfig() {
            this.packages("com.docker.restful.demo.*");
            register(UserResource.class);
        }
    }

}