package edu.uncc.ssdi.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.uncc.ssdi.model.Login;
import edu.uncc.ssdi.model.User;
import edu.uncc.ssdi.util.DBConnection;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public User validateUser(Login login) {
		// validate if the User exists
		String sql = "select * from User where email= '" + login.getUserName() + "' and password = '"
				+ login.getPassword() + "'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}
	
	@Override
	public User validateEmail(String email) {
		// validate the Email
		User user = new User();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBConnection.getDBConnection();
			String query = "select * from User where email =  ? ";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println("Here");
				user.setId(Integer.valueOf(rs.getString("id")));
				user.setEmail((rs.getString("email")));
				user.setFirstName((rs.getString("first_name")));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return user;
	}
	
	class UserMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			User user = new User();
			user.setId(Integer.valueOf(rs.getString("id")));
			user.setEmail((rs.getString("email")));
			user.setFirstName((rs.getString("first_name")));
			user.setRole((rs.getString("role")));
			return user;
		}
	} // end of UserMapper class
} // end of UserDaoImpl class