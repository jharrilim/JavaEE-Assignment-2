package com.aaj.fruitstore.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aaj.fruitstore.model.Fruit;
import com.aaj.fruitstore.data.FruitData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/")
public final class IndexController extends HttpServlet {

	ArrayList<Fruit> fruits = FruitData.getFruits();
	
	public IndexController() {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		request.setAttribute("fruitList", fruits);
		dispatcher.forward(request, response);
		ServletContext sc = getServletContext();
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Fruit fruit = new Fruit("Mango", "AB1010", "Sweet and juicy", 1, 4.99, 50, "India");
		session.setAttribute("mango", fruit);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ShowList.jsp");
		request.setAttribute("Title", "All-Time Best Children's Fantasy Books");
		request.setAttribute("BookList", null);
		dispatcher.forward(request, response);
		getServletContext();
	}

}
