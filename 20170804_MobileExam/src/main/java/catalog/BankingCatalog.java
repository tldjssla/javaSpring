package catalog;

import model.Account;

public interface BankingCatalog {
	// 2. 입금
	boolean deposit(Account account, int money);

	// 3. 출금
	boolean withdraw(Account account, int money);
}
