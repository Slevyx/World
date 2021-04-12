package it.objectmethod.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.dao.IWorldDao;
import it.objectmethod.dao.impl.WorldDaoImpl;
import it.objectmethod.models.City;

@WebServlet("/Cities")
public class CitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String countryCode = request.getParameter("countryCode");
		List<City> citiesList = new ArrayList<>();
		IWorldDao worldDao = new WorldDaoImpl();
		
		try {
			citiesList = worldDao.getCitiesByCountryCode(countryCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(citiesList.isEmpty()) {
			request.setAttribute("error", "Nothing was found.");
		}
		request.setAttribute("isCountriesList", false);
		request.setAttribute("isCitiesList", true);
		request.setAttribute("citiesList", citiesList);
		request.getRequestDispatcher("pages/Continents.jsp").forward(request, response);
	}
}
