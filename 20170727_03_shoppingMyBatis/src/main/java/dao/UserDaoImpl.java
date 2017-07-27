package dao;

import org.apache.ibatis.session.SqlSession;
import logic.User;

public class UserDaoImpl implements UserDao {
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public User findByUserIdAndPassword(String userId, String password) {
		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);
		
		// SimpleJdbcTemplate은 원하는 걸 못찾으면 EmptyResultDataAccessException 를 일으킨다.
		// 하지만 sqlSession은 SimpleJdbcTemplate과 달리, 그냥 null을 리턴한다.
		User res = sqlSession.selectOne("getUser", user);
//		System.out.println(res);
		return res;
	}

}
