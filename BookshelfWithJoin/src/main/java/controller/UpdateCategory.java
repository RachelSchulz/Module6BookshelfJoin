package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;

/**
 * Servlet implementation class UpdateCategory
 */
@WebServlet("/updateCategory")
public class UpdateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryHelper ch = new CategoryHelper();
		
		String oldName = request.getParameter("oldName");
		String name = request.getParameter("newName");
		String abbr = request.getParameter("abbr");
		
		Category catToUpdate = ch.searchCategoryByName(oldName);
		catToUpdate.setCategoryName(name);
		catToUpdate.setAbbreviation(abbr);
		ch.update(catToUpdate);
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
