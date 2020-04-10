package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCategoryDao {
	
	private static String READ_ALL = "select * from category_book";
	private static String CREATE = "insert into category_book('category_name') values (?)";
	private static String READ_BY_ID = "select * from category_book where id=?";
	private static String UPDATE_BY_ID = "update category_book set category_name=? where id=?";
	private static String DELETE_BY_ID = "lelete from category_book where id=?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public BookCategoryDao(Connection connection) {
		this.connection = connection;
	}
	
	public List<BookCategory> readAll() throws SQLException{
		
		List<BookCategory> listOfBookCategory = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			listOfBookCategory.add(BookCategoryMapper.map(resultSet));
		}
		
		return listOfBookCategory;
	}
	
	public void insert(BookCategory bookCategory) throws SQLException{
		
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, bookCategory.getCategoryName());
		preparedStatement.executeUpdate();
	}
	
	public BookCategory read(int id) throws SQLException {
		
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		return BookCategoryMapper.map(resultSet);
	}
	
	public void update(BookCategory bookCategory) throws SQLException{
		
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, bookCategory.getCategoryName());
		preparedStatement.setInt(2, bookCategory.getId());
		preparedStatement.execute();
	}
	
	public void delete(int id) throws SQLException {
		
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
	}

}
