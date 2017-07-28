package service;

import java.util.List;

import model.Account;

public interface BankService {
	// 1. 계좌 개설
	void makeAccount(Account account);
	
	// 2. 입금
	boolean deposit(Account account, int money);

	// 3. 출금
	boolean withdraw(Account account, int money);
	
	// 4. 계좌 하나 조회
	Account findAccountByAccNum(int accNum);

	// 5. 전체 계좌 조회
	List<Account> findAccountList();
}
