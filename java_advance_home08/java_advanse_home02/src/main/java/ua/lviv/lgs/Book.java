package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.List;

public class Book {

	private int id;
	private String bookName;
	private String bookDescription;
	private double price;
	private String isbn;

	public Book(int id, String bookName, String bookDescription, double price, String isbn) {

		this.id = id;
		this.bookName = bookName;
		this.bookDescription = bookDescription;
		this.price = price;
		this.isbn = isbn;
	}

	public Book(String bookName, String bookDescription, double price, String isbn) {

		this.bookName = bookName;
		this.bookDescription = bookDescription;
		this.price = price;
		this.isbn = isbn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", bookDescription=" + bookDescription + ", price=" + price
				+ ", isbn=" + isbn + "]";
	}
	

}
