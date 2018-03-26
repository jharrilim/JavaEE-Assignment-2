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
import com.aaj.fruitstore.repository.CartRepository;
import com.aaj.fruitstore.repository.StoreRepository;
import com.aaj.fruitstore.service.SessionService;

@WebServlet("/store")
public final class StoreController extends HttpServlet {

	/**
	 * 
	 */
	private static final long		serialVersionUID	= -7256321264972958525L;
	private final StoreRepository	sr					= FruitData.STORE_DATA;

	public StoreController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/store.jsp");
		request.setAttribute("fruitList", sr.all());
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute("fruitList", sr.all());
		String sku = request.getParameter("sku");
		int amount = Integer.valueOf(request.getParameter("amount").trim());
		CartRepository cart = SessionService.createSessionCart(session);
		cart.add(sr.removeByAmount(sku, amount));
		session.setAttribute("cart", cart);
		response.sendRedirect(request.getContextPath() + "/cart");

	}
}
