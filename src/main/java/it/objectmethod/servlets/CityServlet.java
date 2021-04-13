package it.objectmethod.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.dao.IWorldDao;
import it.objectmethod.dao.impl.WorldDaoImpl;
import it.objectmethod.models.City;

@WebServlet("/City")
public class CityServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputCity = request.getParameter("city");
		City city = null;
		IWorldDao worldDao = new WorldDaoImpl();
		if(inputCity == null || inputCity.isBlank()) {
			request.setAttribute("error", "City field cannot be empty.");
		}
		else {
			try {
				inputCity = inputCity.toUpperCase();
				city = worldDao.getCity(inputCity);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(city == null) {
				request.setAttribute("error", "Nothing was found.");
			}
		}
		request.setAttribute("city", city);
		request.getRequestDispatcher("pages/City.jsp").forward(request, response);
	}
}
