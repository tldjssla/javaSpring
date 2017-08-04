package dao;

import java.util.List;
import model.Account;

public interface ReadAccountDao extends AccountDao {
	// 4. 계좌 조회
	Account readAccount(int accountNum);

	// 5. 전체 계좌 조회
	List<Account> readAccountList();
}
