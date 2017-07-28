package dao;

import model.Account;

public interface CreateAccountDao extends AccountDao {
	// 1. 계좌 개설
	void createAccount(Account account);
}
