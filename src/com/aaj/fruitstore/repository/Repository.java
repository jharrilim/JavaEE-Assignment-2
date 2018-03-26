package com.aaj.fruitstore.repository;

import java.util.List;
import java.util.function.Predicate;

public interface Repository<T> {

	List<T> query(Predicate<T> query);

	void add(T item);

	void add(Iterable<T> items);

	boolean update(T item);

	boolean remove(Predicate<T> query);
}
