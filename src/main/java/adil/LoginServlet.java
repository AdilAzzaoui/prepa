package adil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import viewmodels.UserVM;

import java.io.IOException;

import Models.UserModel;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserVM user = new UserVM();
		user.setLogin(request.getParameter("login"));
		user.setPassword(request.getParameter("password"));
		UserModel userModel = new UserModel(user);
		boolean b = userModel.Login(user);
		System.out.println(b);

		if(b) {
			response.sendRedirect(request.getContextPath() + "/AddProduct.jsp");
		}
		else {
			System.out.println("eroor");
		}
		
		doGet(request, response);

	}

}
