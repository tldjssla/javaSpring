package logic;

import java.io.Serializable;

public class Item implements Serializable {
	private static final long serialVersionUID = 1631056036986026071L;

	private Integer itemId;
	private String itemName;
	private Integer price;
	private String description;
	private String pictureUrl;

	public Item() {
		super();
	}

	public Item(Integer itemId, String itemName, Integer price, String description, String pictureUrl) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.description = description;
		this.pictureUrl = pictureUrl;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", description=" + description
				+ ", pictureUrl=" + pictureUrl + "]";
	}

}
