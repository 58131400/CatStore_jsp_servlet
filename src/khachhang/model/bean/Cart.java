package khachhang.model.bean;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private HashMap<String, Item> cartItems;

	public Cart() {
		cartItems = new HashMap<>();
	}

	public Cart(HashMap<String, Item> cartItems) {
		this.cartItems = cartItems;
	}

	public HashMap<String, Item> getCartItems() {
		return cartItems;
	}

	public void setCartItems(HashMap<String, Item> cartItems) {
		this.cartItems = cartItems;
	}

	public void insertToCart(String key, Item Item) {
		boolean bln = cartItems.containsKey(key);
		if (bln) {
			int quantity_old = Item.getQuantity();
			Item.setQuantity(quantity_old + 1);
			cartItems.put(Item.getProduct().getId(), Item);
		} else {
			cartItems.put(Item.getProduct().getId(), Item);
		}
	}

	public void removeToCart(String Item) {
		boolean bln = cartItems.containsKey(Item);
		if (bln) {
			cartItems.remove(Item);
		}
	}

	public int countItem() {
		int count = 0;
		count = cartItems.size();
		return count;
	}

	public double total() {
		double count = 0;
		for (Map.Entry<String, Item> list : cartItems.entrySet()) {
			count += list.getValue().getProduct().getPrice() * list.getValue().getQuantity();
		}
		return count;
	}

	
}
