package com.hand.entity;

public class Language {
	private int language_id;
	private String name;
	
	public Language() {
		super();

	}
	public Language(int language_id, String name) {
		super();
		this.language_id = language_id;
		this.name = name;
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
