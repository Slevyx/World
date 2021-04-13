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
import it.objectmethod.models.Country;

@WebServlet("/Continent")
public class ContinentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String continentName = request.getParameter("continentName");
		List<Country> countryList = new ArrayList<>();
		IWorldDao worldDao = new WorldDaoImpl();
		if(continentName == null) {
			request.setAttribute("error", "Continent Name is Null.");
		}
		else {
			try {
				continentName = continentName.toUpperCase();
				countryList = worldDao.getCountriesByContinent(continentName);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(countryList.isEmpty()) {
				request.setAttribute("error", "Nothing was found.");
			}
		}
		request.setAttribute("isCountriesList", true);
		request.setAttribute("isCitiesList", false);
		request.setAttribute("countryList", countryList);
		request.getRequestDispatcher("pages/Continents.jsp").forward(request, response);
	}

}
