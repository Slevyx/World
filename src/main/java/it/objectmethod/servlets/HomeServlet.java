package it.objectmethod.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("login");
		String redirect = null;
		if(username == null || username.isBlank()) {
			request.setAttribute("error", "Username cannot be empty.");
			redirect = "pages/Home.jsp";
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			redirect = "pages/City.jsp";
		}
		request.getRequestDispatcher(redirect).forward(request, response);
	}
}
