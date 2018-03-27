package com.example.bunion8_api;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "series_info")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class SeriesInfo {

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "seriesInfo")
	private Set<Comment> comments = new HashSet<>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "seriesInfo")
	private Set<Rating> ratings = new HashSet<>();

	public Set<Comment> getComments() {
		return comments;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

}
