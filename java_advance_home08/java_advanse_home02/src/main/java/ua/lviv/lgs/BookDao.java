package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	
	private static String READ_ALL = "select * from book ";
	private static String CREATE = "insert into book('title','descript','price','isbn')";
	private static String READ_BY_ID = "selekt * from book where id=?";
	private static String UPDATE_BY_ID = "update book set title=?, descript=?, price=?,isbn=? where id=?";
	private static String DELETE_BY_ID = "delete from book where id=?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public BookDao(Connection connection) {
		this.connection = connection;
	}
	
	public List<Book> readAll() throws SQLException{
		
		List<Book> listOfBook = new ArrayList<Book>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			listOfBook.add(BookMapper.map(resultSet));
		}
		return null;		
	}
	
	public void insert(Book book) throws SQLException {
		
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, book.getBookName());
		preparedStatement.setString(2, book.getBookDescription());
		preparedStatement.setDouble(3, book.getPrice());
		preparedStatement.setString(4, book.getIsbn());
		preparedStatement.executeUpdate();		
	}
	
	public Book read(int id) throws SQLException {
		
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		return BookMapper.map(resultSet);		
	}
	
	public void update(Book book) throws SQLException {
		
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, book.getBookName());
		preparedStatement.setString(2, book.getBookDescription());
		preparedStatement.setDouble(3, book.getPrice());
		preparedStatement.setString(4, book.getIsbn());
		preparedStatement.setInt(5, book.getId());
		preparedStatement.executeUpdate();
	}
	
	public void  delete(int id) throws SQLException {
		
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();		
	}
	
}
