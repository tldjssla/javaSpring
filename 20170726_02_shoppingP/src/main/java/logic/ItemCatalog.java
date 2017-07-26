package logic;

import java.util.List;

import logic.Item;

// 아이템들의 목록. (Catalog 자체가, 보통 "책자"라는 의미로 쓰임)
public interface ItemCatalog {
	List<Item> getItemList();
	Item getItemByItemId(Integer itemId);
}
