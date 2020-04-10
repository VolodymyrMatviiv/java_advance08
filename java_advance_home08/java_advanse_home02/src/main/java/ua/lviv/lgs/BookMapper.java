package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper {
	
	public static Book map(ResultSet resultSet) throws SQLException {
		
		int id = resultSet.getInt("id");
		String bookName = resultSet.getString("title");
		String bookDescription = resultSet.getString("descript");
		double price = resultSet.getDouble("price");
		String isbn = resultSet.getString("isbn");
		
		return new Book(id,bookName,bookDescription,price,isbn);
	}
}
