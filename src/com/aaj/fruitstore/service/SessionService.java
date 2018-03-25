package com.aaj.fruitstore.service;

import javax.servlet.http.HttpSession;

import com.aaj.fruitstore.repository.CartRepository;

public class SessionService {

	/**
	 * Adds a cart to the session if one does not already exist.
	 * @param session
	 */
	public static CartRepository createSessionCart(HttpSession session) {
		if (session.getAttribute("cart") == null) {
			session.setAttribute("cart", new CartRepository());
		}
		return (CartRepository) session.getAttribute("cart");
	}
}
