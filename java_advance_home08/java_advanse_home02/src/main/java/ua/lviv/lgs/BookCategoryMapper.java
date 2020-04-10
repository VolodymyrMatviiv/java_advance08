package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookCategoryMapper {
	
	public static BookCategory map(ResultSet resultSet) throws SQLException {
		
		int id = resultSet.getInt("id");
		String categoryName = resultSet.getString("category_name");
		
		return new BookCategory(id, categoryName);
		
	}

}
