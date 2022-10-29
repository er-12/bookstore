package s22.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	private String title;
	private String author;
	private int published;
	private String isbn;
	private double price;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "catid")
    private Category category;
	
	public Book() {
		super();
	}

	public Book(String title, String author, int published, String isbn, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.published = published;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublished() {
		return published;
	}

	public void setPublished(int published) {
		this.published = published;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", published=" + published + ", isbn="
				+ isbn + ", price=" + price + ", category=" + category + "]";
	}

//	@Override
//	public String toString() {
//		return "Book [title=" + title + ", author=" + author + ", published=" + published + ", isbn=" + isbn + ", price=" + price
//				+ "]";
//	}
//	
	
	

}
