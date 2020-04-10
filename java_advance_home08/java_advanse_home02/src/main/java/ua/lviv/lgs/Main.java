package ua.lviv.lgs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		
		AuthorDao authorDao = new AuthorDao(ConnectionUtile.openConnection());
		BookCategoryDao bookCategoryDao = new BookCategoryDao(ConnectionUtile.openConnection());
		BookDao bookDao = new BookDao(ConnectionUtile.openConnection());
		
		
		List<Author> listOfAuthors = new ArrayList<Author>();
		listOfAuthors.add(new Author("Джеф", "Кінні", "d.kinns@mail.com", "Форт Вашингтон, Меріленд, США"));
		listOfAuthors.add(new Author("Маріша", "Пессл", "m.pessl@mail.com", "Кларкстон, Мічіган, США"));
		listOfAuthors.add(new Author("Суі", "Ісіда", "s.isida@mail.com", "Фукуока, Япония"));
		listOfAuthors.add(new Author("Умберто", "Еко", "u.eko@mail.com", "Алессандрiя, Iталiя"));
		listOfAuthors.add(new Author("Олексій", "Васильєв", "o.vasilev@mail.com", "Санкт-Петербург, Россия"));
		
		List<BookCategory> listOfBookCategory = new ArrayList<BookCategory>();
		listOfBookCategory.add(new BookCategory("Фентезі"));
		 listOfBookCategory.add(new BookCategory("Детектив"));
		 listOfBookCategory.add(new BookCategory("Комікси"));
		 listOfBookCategory.add(new BookCategory("Художня література"));
		 listOfBookCategory.add(new BookCategory("Пригоди"));
		 
		List<Book> listOfBook = new ArrayList<Book>();
		listOfBook.add(new Book("Книга 1", "Мова: українська", 125.00, "978-966-948-239-6"));
		listOfBook.add(new Book("Книга 2", "Мова: українська", 130.00, "978-966-948-170-2"));
		listOfBook.add(new Book("Книга 3", "Мова: українська", 125.00, "978-617-7535-73-6"));
		listOfBook.add(new Book("Книга 4", "Мова: українська", 208.00, "978-966-917-290-7"));
		listOfBook.add(new Book("Книга 5", "Мова: російська", 248.00, "978-5-389-15107-9"));
		
		
//		CRUD operation with Author
		
		listOfAuthors.stream().forEach(author->{
			try {
				authorDao.insert(author);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		});
		
		
		authorDao.readAll().forEach(System.out::println);
		System.out.println("+++++++++++++++++++++++++++++++++++++++\n");
		
		System.out.println(authorDao.read(3));
		System.out.println("+++++++++++++++++++++++++++++++++++++++\n");
		
		authorDao.update(new Author(2,"Петро", "Івасів","ivaskiv@gmail.com", "Фукуока, Япония"));
		System.out.println(authorDao.read(2));
		System.out.println("+++++++++++++++++++++++++++++++++++++++\n");
		
		authorDao.delete(3);
		authorDao.readAll().forEach(System.out::println);
		System.out.println("+++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		
//		CRUD operation with BookCategory
		
		listOfBookCategory.stream().forEach(bookCategory ->{
			try {
				bookCategoryDao.insert(bookCategory);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		
		
		bookCategoryDao.readAll().forEach(System.out::println);
		System.out.println("+++++++++++++++++++++++++++++++++++++++\n");
		
		System.out.println(bookCategoryDao.read(2));
		System.out.println("+++++++++++++++++++++++++++++++++++++++\n");
		
		bookCategoryDao.update(new BookCategory(2, "Триллер"));
		System.out.println(bookCategoryDao.read(2));
		System.out.println("+++++++++++++++++++++++++++++++++++++++\n");
		
		bookCategoryDao.delete(2);
		bookCategoryDao.readAll().forEach(System.out::println);
		System.out.println("+++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		
//		CRUD operation with Book
		
		listOfBook.stream().forEach(book ->{
			try {
				bookDao.insert(book);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		
		bookDao.readAll().forEach(System.out::println);
		System.out.println("+++++++++++++++++++++++++++++++++++++++\n");
		
		System.out.println(bookDao.read(2));
		System.out.println("+++++++++++++++++++++++++++++++++++++++\n");
		
		bookDao.update(new Book(2, "Книга 6", "Мова: українська", 66.00, "976-617-7635-76-6"));
		System.out.println(bookDao.read(2));
		System.out.println("+++++++++++++++++++++++++++++++++++++++\n");
		
		bookDao.delete(2);
		bookDao.readAll().forEach(System.out::println);
				
	}
	

}
