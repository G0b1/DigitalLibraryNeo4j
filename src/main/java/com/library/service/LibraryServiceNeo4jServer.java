package com.library.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@EnableAutoConfiguration
@EnableNeo4jRepositories("com.library.service.repositories")
public class LibraryServiceNeo4jServer {
    public static void main(String[] args) {
        SpringApplication.run(LibraryServiceNeo4jServer.class, args);
    }
}
