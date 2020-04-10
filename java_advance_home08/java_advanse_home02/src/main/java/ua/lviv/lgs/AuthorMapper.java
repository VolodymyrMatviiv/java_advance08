package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper {
	
	public static Author map(ResultSet resultSet) throws SQLException {
		
		int id = resultSet.getInt("author_id");
		String authorFirstName = resultSet.getString("author_first_name");
		String authorLastName = resultSet.getString("author_last_name");
		String mail = resultSet.getString("mail");
		String addres = resultSet.getString("addres");
				
		return new Author(id, authorFirstName, authorLastName, mail, addres);
	}	
}
