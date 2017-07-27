package dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import logic.User;

public class UserDaoImpl implements UserDao {
	private SimpleJdbcTemplate template;
	
	private static final String SELECT_BY_USERID_PASSWORD = 
			"SELECT user_id, user_name, password from user_account_tb where user_id=? and password=?";
	
	public void setDataSource(DataSource ds) {
		template = new SimpleJdbcTemplate(ds);
	}
	
	@Override
	public User findByUserIdAndPassword(String userId, String password) {
		// User.class 를 줘서 CLass Schema를 알려줘야, db table의 것들과 매핑을 시켜준다.
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		
		return template.queryForObject(SELECT_BY_USERID_PASSWORD, mapper, userId, password);
	}

}
