package catalog;

import dao.UpdateAccountDao;
import model.Account;

public class BankingCatalogImpl implements BankingCatalog {
	private UpdateAccountDao updateAccountDao;

	public void setUpdateAccountDao(UpdateAccountDao updateAccountDao) {
		this.updateAccountDao = updateAccountDao;
	}

	@Override
	public boolean deposit(Account account, int money) {
		return updateAccountDao.deposit(account, money);
	}

	@Override
	public boolean withdraw(Account account, int money) {
		return updateAccountDao.withdraw(account, money);
	}

}
