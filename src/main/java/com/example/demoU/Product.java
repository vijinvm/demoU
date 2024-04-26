package com.example.demoU;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int year;
	@ManyToOne
	@JoinColumn(name="person_id")
private Person person;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public Person getPerson() {
	return person;
}
public void setPerson(Person person) {
	this.person = person;
}
}
