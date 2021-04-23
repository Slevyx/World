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
import it.objectmethod.models.Country;


@WebServlet("/countries")
public class CountriesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String countryName = request.getParameter("countryName");
		String continentName = request.getParameter("continentName");
		List<Country> countriesList = new ArrayList<>();
		ICountryDao countryDao = new CountryDaoImpl();
		if(countryName == null || continentName == null) {
			request.setAttribute("error", "Null fields.");
		}
		else {
			countryName = countryName.toUpperCase();
			continentName = continentName.toUpperCase();
			countriesList = countryDao.getCountriesByCountryNameContinentName(countryName, continentName);
			if(countriesList.isEmpty()) {
				request.setAttribute("error", "Nothing was found.");
			}
		}
		request.setAttribute("countriesList", countriesList);
		request.getRequestDispatcher("pages/CountriesList.jsp").forward(request, response);
	}
}
