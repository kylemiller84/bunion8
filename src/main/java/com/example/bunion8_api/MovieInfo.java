package com.example.bunion8_api;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "movie_info")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class MovieInfo {

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "movieInfo")
	private Set<Comment> comments = new HashSet<>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	
	private String poster_path;
	
	private String backdrop_path;
	
	@Column(columnDefinition="TEXT")
	private String overview;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "movieInfo")
	private Set<Rating> ratings = new HashSet<>();

	public Set<Comment> getComments() {
		return comments;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}

	public String getBackdrop_path() {
		return backdrop_path;
	}

	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

}
