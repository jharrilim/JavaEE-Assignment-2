package com.aaj.fruitstore.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

import com.aaj.fruitstore.exception.AmountDeductionException;
import com.aaj.fruitstore.model.CartItem;
import com.aaj.fruitstore.model.Fruit;

public final class CartRepository implements Repository<CartItem> {

	private final HashMap<String, CartItem> items;

	public CartRepository() {
		items = new HashMap<String, CartItem>();
	}

	public List<CartItem> all() {
		return new ArrayList<CartItem>(items.values());
	}

	public int count() {
		return items.size();
	}

	public int itemTotal() {
		int total = 0;
		for (CartItem item : this.items.values()) {
			total = total + item.getAmount();
		}
		return total;
	}

	public CartItem key(String sku) {
		return this.items.get(sku);
	}

	public CartItem removeByAmount(String sku, int amount) {
		Fruit cartItem = (Fruit) this.items.get(sku);
		try {
			if (cartItem.getAmount() == amount) {
				return this.items.remove(sku);
			}
			if (cartItem.getAmount() > amount) {
				cartItem.deductAmount(amount);
				return new Fruit(cartItem.getName(), cartItem.getSku(), cartItem.getDescription(), amount,
						cartItem.getPrice(), cartItem.getCalories(), cartItem.getCountryOfOrigin());
			}
		}
		catch (AmountDeductionException e) {
		}
		return cartItem;
	}

	@Override
	public List<CartItem> query(Predicate<CartItem> query) {
		List<CartItem> results = new ArrayList<>();
		for (CartItem item : items.values()) {
			if (query.test(item)) {
				results.add(item);
			}
		}
		return results;
	}

	@Override
	public void add(CartItem item) {
		items.put(item.getSku(), item);
	}

	@Override
	public void add(Iterable<CartItem> items) {
		items.forEach(i -> this.items.put(i.getSku(), i));
	}

	@Override
	public boolean update(CartItem item) {
		CartItem ci = this.items.get(item.getSku());
		if (ci != null) {
			ci = item;
			return true;
		}
		return false;
	}

	public boolean update(CartItem item, Predicate<CartItem> query) {
		boolean updated = false;
		for (CartItem i : this.items.values()) {
			if (query.test(i)) {
				i = item;
				updated = true;
			}
		}
		return updated;
	}

	public boolean remove(String sku) {
		if (this.items.containsKey(sku)) {
			this.items.remove(sku);
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(Predicate<CartItem> query) {
		boolean hasRemoved = false;
		for (CartItem i : this.items.values()) {
			if (query.test(i)) {
				this.items.remove(i.getSku());
				hasRemoved = true;
			}
		}
		return hasRemoved;
	}

}
