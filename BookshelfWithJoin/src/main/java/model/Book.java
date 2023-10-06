package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity(name="books")
@Table(name="books")
public class Book {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="AUTHOR")
	private String author;
	@Column(name="TITLE")
	private String title;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CATEGORYID", nullable=false)
	private Category category = new Category();
	

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String returnBookDetails() {
		return "ID: " + id + ", Author: " + this.author + ", Title: " + this.title;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory (Category category) {
		this.category = category;
	}
	

	
}
