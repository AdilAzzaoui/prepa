package adil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import viewmodels.ProductVM;

import java.io.IOException;
import java.util.ArrayList;

import Models.ProductModel;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO Auto-generated method stub
	    response.getWriter().append("Served at: ").append(request.getContextPath());
	    if (request.getParameter("action").equals("list")) {
	        System.out.println("gggggg");
	        ProductVM p = new ProductVM();
	        p.setId(0);
	        p.setLibelle("");
	        ArrayList<ProductModel> list = new ProductModel(p).List();
	        System.out.println(list);
	        
	        if (list != null && !list.isEmpty()) {
	            request.setAttribute("list", list);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
	            dispatcher.forward(request, response);
	        } else {
	            // Handle the case where the list is null or empty
	        	System.out.println("bbbbbb");
	            response.getWriter().append("Error fetching product list");
	        }
	    }
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action").equals("add")) {
			String Libelle = request.getParameter("libelle");
			ProductVM productvm = new ProductVM();
			ProductModel model = new ProductModel(productvm);
			productvm.setLibelle(Libelle);
			model.setId(productvm.getId());
			model.setLibelle(Libelle);
			model.AddProduct();
			response.sendRedirect("List.jsp");
			
		}else {
			
		}
		
		
		
	}

}
