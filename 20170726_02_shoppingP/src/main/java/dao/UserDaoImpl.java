package dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import logic.User;

public class UserDaoImpl implements UserDao {
	private SimpleJdbcTemplate template;
	
	private static final String SELECT_BY_USERID_PASSWORD = 
			"SELECT user_id, user_name, password from user_account_tb where user_id=?";
	
	public void setDataSource(DataSource ds) {
		template = new SimpleJdbcTemplate(ds);
	}
	
	@Override
	public User findByUserIdAndPassword(String userId, String password) {
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>();
		
		return template.queryForObject(SELECT_BY_USERID_PASSWORD, mapper, userId, password);
	}

}
