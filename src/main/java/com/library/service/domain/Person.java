package com.library.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.*;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int born;

    @Relationship(type = "WROTE")
    private List<Book> books = new ArrayList<>();

    public Person() {

    }

    public Person(String name, int born) {
        this.name = name;
        this.born = born;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBorn() {
        return born;
    }

    public List<Book> getBooks() {
        return books;
    }
}

