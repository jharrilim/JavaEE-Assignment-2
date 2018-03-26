package com.aaj.fruitstore.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

import com.aaj.fruitstore.exception.AmountDeductionException;
import com.aaj.fruitstore.model.Fruit;

public class StoreRepository implements Repository<Fruit> {
	
	private final HashMap<String, Fruit> items;
	
	public StoreRepository() {
		items = new HashMap<String, Fruit>();
	}
	
	public StoreRepository(Fruit[] fruitArr) {
		this.items = new HashMap<String, Fruit>();
		for(Fruit fruit : fruitArr) {
			this.items.put(fruit.getSku(), fruit);
		}
	}
	
	public List<Fruit> all() {
		return new ArrayList<Fruit>(items.values());
	}
	
	public Fruit key(String sku) {
		return this.items.get(sku);
	}
	
	public void addByAmount(Fruit f, int amount) {
		if(this.items.containsKey(f.getSku()) == false) {
			this.items.put(f.getSku(), f);
		}
		else {
			this.items.get(f.getSku()).addAmount(amount);
		}
	}
	
	public Fruit removeByAmount(String sku, int amount) {
		Fruit f = this.items.get(sku);
		try {
			if(f.getAmount() == amount) {
				return this.items.remove(sku);
			}
			if(f.getAmount() > amount) {
				f.deductAmount(amount);
				return new Fruit(f.getName(), f.getSku(),f.getDescription(), amount, f.getPrice(), f.getCalories(), f.getCountryOfOrigin());
			}
		}
		catch (AmountDeductionException e) {
		}
		return f;
	}
	
	@Override
	public List<Fruit> query(Predicate<Fruit> query) {
		ArrayList<Fruit> fruits = new ArrayList<Fruit>();
		for(Fruit fruit: this.items.values()) {
			if (query.test(fruit)) {
				fruits.add(fruit);
			}
		}
		return fruits;
	}

	@Override
	public void add(Fruit item) {
		items.put(item.getSku(), item);
	}

	@Override
	public void add(Iterable<Fruit> fruits) {
		for(Fruit fruit : fruits) {
			this.items.put(fruit.getSku(), fruit);
		}
	}

	@Override
	public boolean update(Fruit item) {
		if (this.items.get(item.getSku()) != null) {
			this.items.put(item.getSku(), item);
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(Predicate<Fruit> query) {
		boolean hasRemoved = false;
		for(Fruit fruit: this.items.values()) {
			if (query.test(fruit)) {
				this.items.remove(fruit.getSku());
				hasRemoved = true;
			}
		}
		return hasRemoved;
	}
}
