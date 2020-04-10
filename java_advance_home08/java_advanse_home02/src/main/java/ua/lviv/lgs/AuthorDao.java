package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {
	
	private static String READ_ALL = "select * from author";
	private static String CREATE = "insert into author('author_first_name','author_last_name','mail','addres') values (?,?,?,?)";
	private static String READ_BY_ID = "select * from author where id=?";
	private static String UPDATE_BY_ID = "update author set author_first_name=?, author_last_name=?, mail=?, addres=?";
	private static String DELETE_BY_ID = "delete form author where id=?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public AuthorDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Author author) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, author.getAuthor_first_name());
		preparedStatement.setString(2, author.getAutor_last_name());
		preparedStatement.setString(3, author.getMail());
		preparedStatement.setString(4, author.getAddres());
		preparedStatement.execute();
	}
	
	public Author read(int id) throws SQLException {
		
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		return AuthorMapper.map(resultSet);
				
	}
	
	public void  update (Author author) throws SQLException {
		
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, author.getAuthor_first_name());
		preparedStatement.setString(2, author.getAutor_last_name());
		preparedStatement.setString(3, author.getMail());
		preparedStatement.setString(4, author.getAddres());
		preparedStatement.setInt(5, author.getAuthor_id());
		preparedStatement.execute();
		
	}
	
	
	public void delete(int id) throws SQLException {
		
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
				
	}
	
	
	public List<Author> readAll() throws SQLException{
		
		List<Author> listOfAuthor = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			listOfAuthor.add(AuthorMapper.map(resultSet));
		}
		
		return listOfAuthor;
		
	}	

}
