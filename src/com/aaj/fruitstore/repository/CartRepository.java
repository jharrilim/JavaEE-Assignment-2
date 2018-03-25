package com.aaj.fruitstore.repository;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

import com.mysql.jdbc.Driver;

import com.aaj.fruitstore.model.CartItem;
import static com.aaj.fruitstore.config.Constants.CONNECTION_STRING;

public final class CartRepository implements Repository<CartItem> {
	
	private final HashMap<String, CartItem> items;
	
	public CartRepository() {
		items = new HashMap<String, CartItem>();
	}
	
	public List<CartItem> all() {
		return new ArrayList<CartItem>(items.values());
	}
	
	@Override
	public List<CartItem> query(Predicate<CartItem> query) {
		List<CartItem> results = new ArrayList<>();		
		for(CartItem item : items.values()) {
			if(query.test(item)) {
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
		for(CartItem i : this.items.values()) {
			if (query.test(i)) {
				i = item;
				updated = true;
			}
		}
		return updated;
	}
	
	public boolean remove(String sku) {
		if(this.items.containsKey(sku)) {
			this.items.remove(sku);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean remove(Predicate<CartItem> query) {
		boolean hasRemoved = false;
		for(CartItem i : this.items.values()) {
			if (query.test(i)) {
				this.items.remove(i.getSku());
				hasRemoved = true;
			}
		}		
		return hasRemoved;
	}
	
}
