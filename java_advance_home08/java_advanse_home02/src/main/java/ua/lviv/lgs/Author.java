package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.List;

public class Author {

	private int authorId;
	private String authorFirstName;
	private String autorLastName;
	private String mail;
	private String addres;

	public Author(int author_id, String author_first_name, String autor_last_name, String mail, String addres) {
		
		this.authorId = author_id;
		this.authorFirstName = author_first_name;
		this.autorLastName = autor_last_name;
		this.mail = mail;
		this.addres = addres;
	}

	public Author(String author_first_name, String autor_last_name, String mail, String addres) {

		this.authorFirstName = author_first_name;
		this.autorLastName = autor_last_name;
		this.mail = mail;
		this.addres = addres;
	}

	public int getAuthor_id() {
		return authorId;
	}

	public void setAuthor_id(int author_id) {
		this.authorId = author_id;
	}

	public String getAuthor_first_name() {
		return authorFirstName;
	}

	public void setAuthor_first_name(String author_first_name) {
		this.authorFirstName = author_first_name;
	}

	public String getAutor_last_name() {
		return autorLastName;
	}

	public void setAutor_last_name(String autor_last_name) {
		this.autorLastName = autor_last_name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	@Override
	public String toString() {
		return "Author [author_id=" + authorId + ", author_first_name=" + authorFirstName + ", autor_last_name="
				+ autorLastName + ", mail=" + mail + ", addres=" + addres + "]";
	}


}
