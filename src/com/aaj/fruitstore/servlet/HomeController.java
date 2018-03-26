package com.aaj.fruitstore.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aaj.fruitstore.model.Fruit;
import com.aaj.fruitstore.repository.CartRepository;
import com.aaj.fruitstore.service.SessionService;
import com.aaj.fruitstore.data.FruitData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/home")
public final class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 7182192776772556744L;
	ArrayList<Fruit>			fruits				= FruitData.getFruits();

	public HomeController() {
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
		session.setAttribute("cartCount", cart.count());
		session.setAttribute("cart", cart);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
