package catalog;

import java.util.List;

import model.Account;

public interface AccountCatalog {
	// 1. 계좌 개설
	void makeAccount(Account account);
	
	// 4. 계좌 하나 조회
	Account findAccountByAccNum(int accNum);

	// 5. 전체 계좌 조회
	List<Account> findAccountList();
}
