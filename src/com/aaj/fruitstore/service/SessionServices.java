package com.aaj.fruitstore.service;

import javax.servlet.http.HttpSession;

import com.aaj.fruitstore.repository.CartRepository;

public class SessionServices {

	/**
	 * Adds a cart to the session if one does not already exist.
	 * @param session
	 */
	public static void createSessionCart(HttpSession session) {
		if (session.getAttribute("cart") == null) {
			session.setAttribute("cart", new CartRepository());
		}
	}
}
