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


@WebServlet("/Countries")
public class CountriesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String countryName = request.getParameter("country").toUpperCase();
		String countryContinent = request.getParameter("continent").toUpperCase();
		List<Country> countryList = new ArrayList<>();
		IWorldDao worldDao = new WorldDaoImpl();
		try {
			countryList = worldDao.getCountries(countryName, countryContinent);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(countryList.isEmpty()) {
			request.setAttribute("error", "Nothing was found.");
		}
		request.setAttribute("countryList", countryList);
		request.getRequestDispatcher("pages/Countries.jsp").forward(request, response);
	}
}
