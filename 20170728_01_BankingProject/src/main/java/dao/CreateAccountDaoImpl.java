package dao;

import org.apache.ibatis.session.SqlSession;

import model.Account;

public class CreateAccountDaoImpl implements CreateAccountDao {
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// ============================== 1. 계좌 개설 ==============================
	@Override
	public void createAccount(Account account) {
		// banking.xml 에 적은 쿼리문의 id와, 개설할 계좌의 정보를 같이 준다
		sqlSession.insert("insertAccount", account);
	}
}
