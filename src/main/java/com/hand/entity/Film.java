package com.hand.entity;

public class Film {
	
	private int film_id;
	private String title;
	private String description;
	private int language_id;
	private String name;
	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Film(int film_id, String title, String description, int language_id,
			String name) {
		super();
		this.film_id = film_id;
		this.title = title;
		this.description = description;
		this.language_id = language_id;
		this.name = name;
	}
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
