package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Book;



public class BookHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Bookshelf");
	
	public void insertBook(Book toAdd) {
		EntityManager manager = emfactory.createEntityManager();
		CategoryHelper helper = new CategoryHelper();
		toAdd.setCategory(helper.searchCategoryByName(toAdd.getCategory().getCategoryName()));
		manager.getTransaction().begin();
		manager.persist(toAdd);
		manager.getTransaction().commit();
		manager.close();
	}
	

	public void removeBook(Book toDelete) {
		EntityManager manager = emfactory.createEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.find(Book.class, toDelete.getId()));
		manager.getTransaction().commit();
		manager.close();
		
	}
	
	public void updateBook(Book toUpdate) {
		EntityManager manager = emfactory.createEntityManager();
		Book dbEntity = manager.find(Book.class, toUpdate.getId());
		manager.getTransaction().begin();
		dbEntity.setAuthor(toUpdate.getAuthor());
		dbEntity.setTitle(toUpdate.getTitle());
		manager.getTransaction().commit();
		manager.close();
		
	}
	@SuppressWarnings("unchecked")
	public List<Book> showAllBooks() {
		EntityManager manager = emfactory.createEntityManager();
		List<Book> allBooks = manager.createQuery("SELECT i FROM books i").getResultList();
		return	allBooks;
	}
	
	public Book searchBookById(int id) {
		EntityManager manager = emfactory.createEntityManager();
		TypedQuery<Book> query = manager.createQuery("SELECT i FROM books i WHERE i.id = :id", Book.class);
		query.setParameter("id", id);
		Book dbEntity = query.getSingleResult();
		return dbEntity;
	}
}
