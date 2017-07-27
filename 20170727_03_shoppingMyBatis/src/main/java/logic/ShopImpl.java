package logic;

import java.util.List;

public class ShopImpl implements Shop {
	private ItemCatalog itemCatalog;
	private UserCatalog userCatalog;

	public void setItemCatalog(ItemCatalog itemCatalog) {
		this.itemCatalog = itemCatalog;
	}

	public void setUserCatalog(UserCatalog userCatalog) {
		this.userCatalog = userCatalog;
	}

	@Override
	public List<Item> getItemList() {
		return this.itemCatalog.getItemList();
	}

	@Override
	public Item getItemByItemId(Integer itemId) {
		return itemCatalog.getItemByItemId(itemId);
	}

	@Override
	public User getUserByUserIdAndPassword(String userId, String password) {
		return userCatalog.getUserByUserIdAndPassword(userId, password);
	}

}
