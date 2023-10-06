package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;

/**
 * Servlet implementation class UpdateBook
 */
@WebServlet("/updateBook")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookHelper bh = new BookHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		
		Book bookToUpdate = bh.searchBookById(tempId);
		bookToUpdate.setAuthor(author);
		bookToUpdate.setTitle(title);
		bh.updateBook(bookToUpdate);
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
