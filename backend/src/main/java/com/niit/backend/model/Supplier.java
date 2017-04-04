package com.niit.backend.model;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import org.springframework.stereotype.Component;
@Entity
@Component
@Table(name="SUPPlIER")
public class Supplier {
	@Column(name="NAME")
	private String name;
	@Id
	@Column(name="ID")
	private String id;
	@Column(name="ADDRESS")
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
