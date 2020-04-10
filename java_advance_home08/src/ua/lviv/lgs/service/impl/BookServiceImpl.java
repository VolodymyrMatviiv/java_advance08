package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.BookDao;
import ua.lviv.lgs.dao.impl.BookDaoImpl;
import ua.lviv.lgs.dao.impl.BucketOrderDaoImpl;
import ua.lviv.lgs.domain.Book;
import ua.lviv.lgs.service.BookService;

public class BookServiceImpl implements BookService {

	private static Logger LOGGER = Logger.getLogger(BucketOrderDaoImpl.class);
	private static BookService productServiceImpl;

	private BookDao bookDao;

	public BookServiceImpl() {

		try {

			bookDao = new BookDaoImpl();

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}

	public static BookService getBookService() {
		if (productServiceImpl == null) {
			productServiceImpl = new BookServiceImpl();
		}

		return productServiceImpl;

	}

	@Override
	public Book create(Book t) {

		return bookDao.create(t);
	}

	@Override
	public Book read(Integer id) {

		return bookDao.read(id);
	}

	@Override
	public Book update(Book t) {

		return bookDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		bookDao.delete(id);

	}

	@Override
	public List<Book> raedAll() {

		return bookDao.raedAll();
	}

}
