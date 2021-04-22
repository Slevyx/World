package it.objectmethod.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String redirect = null;
		if(username == null || username.isBlank()) {
			request.setAttribute("error", "Username cannot be empty.");
			redirect = "pages/Login.jsp";
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("loggedUser", username);
			redirect = "pages/City.jsp";
		}
		request.getRequestDispatcher(redirect).forward(request, response);
	}
}
