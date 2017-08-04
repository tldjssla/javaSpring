package catalog;

import java.util.List;

import dao.CreateAccountDao;
import dao.ReadAccountDao;
import model.Account;

public class AccountCatalogImpl implements AccountCatalog {
	private CreateAccountDao createAccountDao;
	private ReadAccountDao readAccountDao;

	public void setCreateAccountDao(CreateAccountDao createAccountDao) {
		this.createAccountDao = createAccountDao;
	}

	public void setReadAccountDao(ReadAccountDao readAccountDao) {
		this.readAccountDao = readAccountDao;
	}

	@Override
	public void makeAccount(Account account) {
		createAccountDao.createAccount(account);
	}

	@Override
	public Account findAccountByAccNum(int accNum) {
		return readAccountDao.readAccount(accNum);
	}

	@Override
	public List<Account> findAccountList() {
		return readAccountDao.readAccountList();
	}

}
