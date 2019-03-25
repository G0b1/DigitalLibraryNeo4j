package com.library.service.domain;

import org.neo4j.ogm.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RelationshipEntity(type = "WROTE")
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    private List<String> roles = new ArrayList<>();

    @StartNode
    private Person person;

    @EndNode
    private Book book;

    public Role() {
    }

    public Role(Book book, Person author) {
        this.book = book;
        this.person = author;
    }

    public Long getId() {
        return id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public Person getPerson() {
        return person;
    }

    public Book getBook() {
        return book;
    }
}
