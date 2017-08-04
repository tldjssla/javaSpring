package dao;

import org.springframework.dao.DataAccessException;

import model.Account;

public interface UpdateAccountDao extends AccountDao {
	// 2. 입금
	boolean deposit(Account account, int money) throws DataAccessException;

	// 3. 출금
	boolean withdraw(Account account, int money) throws DataAccessException;
}
