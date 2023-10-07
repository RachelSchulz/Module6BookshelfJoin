package controller;
import model.Book;
import model.Category;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book b = new Book();
		BookHelper bh = new BookHelper();
		b.setAuthor(request.getParameter("author"));
		b.setTitle(request.getParameter("title"));
		b.getCategory().setCategoryName(request.getParameter("catName"));
		bh.insertBook(b);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}