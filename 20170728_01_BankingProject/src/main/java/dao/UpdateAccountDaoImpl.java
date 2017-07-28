package dao;

import org.apache.ibatis.session.SqlSession;

import model.Account;

public class UpdateAccountDaoImpl implements UpdateAccountDao {
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	// ============================== 2. 입금 ==============================
	@Override
	public boolean deposit(Account account, int money) {
		// 입금 결과를 account 객체에 저장
		int balance = account.getBalance();
		account.setBalance(balance+money);
		System.out.println("UpdateAccountDaoImpl.deposit() : " + account);
		// sqlSession.update() 의 리턴 값 -> 쿼리로 인해 영향을 받은 row의 수
		// 하나만 업데이트 하니까 리턴값이 1인지 검사하여서 1일 경우 return true, 아니면 return false
		int res = sqlSession.update("updateAccount", account);
		
		if(res==1)
			return true;
		else
			return false;
	}
	
	// ============================== 3. 출금 ==============================
	@Override
	public boolean withdraw(Account account, int money) {
		if(account.getBalance() < money) {
			// 잔액이 출금액보다 작으면 출금할 수 없기 때문에 return false
			return false;
		}
		// 출금 결과를 account 객체에 저장
		int balance = account.getBalance();
		account.setBalance(balance-money);
		System.out.println("UpdateAccountDaoImpl.deposit() : " + account);
		int res = sqlSession.update("updateAccount", account);
		
		// 한 개의 행이 업데이트 된 것이며 제대로 된 거니까 return true, 아니면 return false
		if(res==1)
			return true;
		else
			return false;
	}
}
