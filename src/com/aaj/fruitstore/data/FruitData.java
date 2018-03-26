package com.aaj.fruitstore.data;

import java.util.ArrayList;

import com.aaj.fruitstore.model.Fruit;
import com.aaj.fruitstore.repository.StoreRepository;

// Test Data
public final class FruitData {

	private FruitData() {	}

	private final static Fruit[] DEFAULT_FRUITS_ARRAY = new Fruit[] {
		new Fruit("Mango", "AB10010","Sweet and juicy", 10, 4.99, 200, "India"),
		new Fruit("Apple", "AB10011", "Sweet and crunchy", 20, 0.99, 100, "Canada"),
		new Fruit("Strawberry", "AB10012", "Red and seedy", 20, 0.99, 20, "USA"),
		new Fruit("Banana", "AB10013", "Yellow and soft", 10, 1.25, 200, "Mexico"),
		new Fruit("Kiwi", "AB10014", "Fuzzy and seedy", 10, 0.99, 100, "Australia"),
		new Fruit("Orange", "AB10015", "Sweet and tangy", 10, 0.99, 100, "USA"),
	};
	
	private final static ArrayList<Fruit> DEFAULT_FRUITS;
	
	public final static ArrayList<Fruit> getFruits() {
		return DEFAULT_FRUITS;
	}

	public final static StoreRepository STORE_DATA = new StoreRepository(DEFAULT_FRUITS_ARRAY);
	
	static {
		DEFAULT_FRUITS = new ArrayList<>();
		for(Fruit f : DEFAULT_FRUITS_ARRAY) {
			DEFAULT_FRUITS.add(f);
		}
	}


}
