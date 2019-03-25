package com.library.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mark Angrish
 */
@NodeEntity
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private int released;
	private String tagline;

	@JsonIgnoreProperties("book")
	@Relationship(type = "WROTE", direction = Relationship.INCOMING)
	private List<Role> roles;

	public Book() {
	}

	public Book(String title, int released, String tagline) {
		this.title = title;
		this.released = released;
		this.tagline = tagline;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getReleased() {
		return released;
	}

	public String getTagline() {
		return tagline;
	}

	public List<Role> getRoles() {
		return roles;
	}

}