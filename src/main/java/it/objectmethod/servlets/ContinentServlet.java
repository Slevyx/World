package it.objectmethod.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.dao.ICountryDao;
import it.objectmethod.dao.impl.CountryDaoImpl;

@WebServlet("/continent")
public class ContinentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> continentsList = new ArrayList<>();
		ICountryDao countryDao = new CountryDaoImpl();
		continentsList = countryDao.getContinents();
		if(continentsList.isEmpty()) {
			request.setAttribute("error", "Nothing was found.");
		}
		request.setAttribute("continentsList", continentsList);
		request.getRequestDispatcher("pages/Continents.jsp").forward(request, response);
	}
}
