package com.aaj.fruitstore.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aaj.fruitstore.data.FruitData;
import com.aaj.fruitstore.model.Fruit;
import com.aaj.fruitstore.repository.CartRepository;
import com.aaj.fruitstore.repository.StoreRepository;
import com.aaj.fruitstore.service.SessionService;

@WebServlet("/cart")
public final class CartController extends HttpServlet {

	/**
	 * 
	 */
	private static final long		serialVersionUID	= 496969882032083216L;
	private final StoreRepository	sr					= FruitData.STORE_DATA;

	public CartController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		CartRepository cart = SessionService.createSessionCart(session);
		session.setAttribute("cart", cart);
		request.setAttribute("cartList", cart.all());
		RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sku = request.getParameter("sku");
		CartRepository cart = SessionService.createSessionCart(session);
		int amount = Integer.valueOf(request.getParameter("amount").trim());
		if (amount <= cart.key(sku).getAmount()) {
			Fruit f = (Fruit) cart.removeByAmount(sku, amount);
			sr.addByAmount(f, f.getAmount());
			sr.key(f.getSku()).addAmount(f.getAmount());
		}
		session.setAttribute("cart", cart);
		doGet(request, response);
	}
}
