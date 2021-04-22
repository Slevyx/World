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

import it.objectmethod.dao.ICityDao;
import it.objectmethod.dao.impl.CityDaoImpl;
import it.objectmethod.models.City;

@WebServlet("/cities")
public class CitiesByCountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String countryCode = request.getParameter("countryCode");
		List<City> cities = new ArrayList<>();
		ICityDao cityDao = new CityDaoImpl();
		if(countryCode == null) {
			request.setAttribute("error", "Country not found.");
		}
		else {
			try {
				cities = cityDao.getCitiesByCountry(countryCode);
				if(cities.isEmpty()) {
					request.setAttribute("error", "Nothing was found.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("cities", cities);
		request.getRequestDispatcher("pages/Cities.jsp").forward(request, response);
	}
}
