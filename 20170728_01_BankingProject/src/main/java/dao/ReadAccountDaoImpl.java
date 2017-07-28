package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Account;

public class ReadAccountDaoImpl implements ReadAccountDao {
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// ============================== 4. 계좌 하나 조회 ==============================
	@Override
	public Account readAccount(int accNum) {
		// 여기 두 번째 인자로 적은 accNum과, xml에 적은 #{accNum}의 이름이 일치해야 한다?
		// 아니면 그냥 Model.Account라고 해줬으니 알아서 하는 것인지.
		// 아무튼 변수명 동일하게 해 주어야 할듯
		
		// 못 찾으면 null을 리턴
		return sqlSession.selectOne("getAccount", accNum);
	}

	// ============================== 5. 전체 계좌 조회 ==============================
	@Override
	public List<Account> readAccountList() {
		// 데이터가 하나도 없으면, 빈 리스트를 리턴하는지 null을 리턴하는지 확인해 보아야함
		return sqlSession.selectList("getAccountList");
	}
}
