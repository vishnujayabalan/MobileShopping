package com.niit.backend.model;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import org.springframework.stereotype.Component;
@Entity
@Table(name="CATEGORY")
@Component
public class Category {
	@Column(name="NAME")
	private String name;
	
	@Id
	@Column(name="ID")
	private String id;
	
	@Column(name="DESCRIPTION")
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
