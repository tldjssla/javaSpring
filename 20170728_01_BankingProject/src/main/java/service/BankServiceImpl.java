package service;

import java.util.List;

import catalog.AccountCatalog;
import catalog.BankingCatalog;
import model.Account;

public class BankServiceImpl implements BankService {
	private AccountCatalog accountCatalog;
	private BankingCatalog bankingCatalog;

	public void setAccountCatalog(AccountCatalog accountCatalog) {
		this.accountCatalog = accountCatalog;
	}

	public void setBankingCatalog(BankingCatalog bankingCatalog) {
		this.bankingCatalog = bankingCatalog;
	}

	@Override
	public void makeAccount(Account account) {
		accountCatalog.makeAccount(account);
	}

	@Override
	public boolean deposit(Account account, int money) {
		return bankingCatalog.deposit(account, money);
	}

	@Override
	public boolean withdraw(Account account, int money) {
		return bankingCatalog.withdraw(account, money);
	}

	@Override
	public Account findAccountByAccNum(int accNum) {
		return accountCatalog.findAccountByAccNum(accNum);
	}

	@Override
	public List<Account> findAccountList() {
		return accountCatalog.findAccountList();
	}

}
