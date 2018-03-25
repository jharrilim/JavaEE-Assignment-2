package com.aaj.fruitstore.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aaj.fruitstore.data.FruitData;
import com.aaj.fruitstore.model.Fruit;

@WebServlet("/store")
public final class StoreController extends HttpServlet {

	private final ArrayList<Fruit> fruits = FruitData.getFruits();
	
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
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/store.jsp");
		request.setAttribute("fruitList", fruits);
		dispatcher.forward(request, response);
		ServletContext sc = getServletContext();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute("fruitList", fruits);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/store.jsp");
		dispatcher.forward(request, response);
		ServletContext sc = getServletContext();
		
	}
}
