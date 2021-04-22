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

import it.objectmethod.dao.ICountryDao;
import it.objectmethod.dao.impl.CountryDaoImpl;
import it.objectmethod.models.Country;

@WebServlet("/countriesByContinent")
public class CountriesByContinentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String continentName = request.getParameter("continentName");
		List<Country> countries = new ArrayList<>();
		ICountryDao countryDao = new CountryDaoImpl();
		if(continentName == null) {
			request.setAttribute("error", "Continent not found.");
		}
		else {
			try {
				countries = countryDao.getCountriesbyContinentName(continentName);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("countries", countries);
		request.getRequestDispatcher("pages/Countries.jsp").forward(request, response);
	}
}
