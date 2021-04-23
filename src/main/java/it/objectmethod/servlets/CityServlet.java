package it.objectmethod.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.dao.ICityDao;
import it.objectmethod.dao.impl.CityDaoImpl;
import it.objectmethod.models.City;

@WebServlet("/city")
public class CityServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cityName = request.getParameter("cityName");
		City city = null;
		ICityDao cityDao = new CityDaoImpl();
		if(cityName == null || cityName.isBlank()) {
			request.setAttribute("error", "City field cannot be empty.");
		}
		else {
			cityName = cityName.toUpperCase();
			city = cityDao.getCityByName(cityName);
			if(city == null) {
				request.setAttribute("error", "Nothing was found.");
			}
		}
		request.setAttribute("city", city);
		request.getRequestDispatcher("pages/City.jsp").forward(request, response);
	}
}
