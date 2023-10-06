/**
* Rachel Schulz - rsgoodrich
* CIS175 - Fall 2023
* Oct 3, 2023
*/
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import javax.persistence.Query;

import model.Book;
import model.Category;

/**
 * @author Rachel Schulz - rsgoodrich
 * CIS175 - Fall 2023
 * Oct 3, 2023
 */
public class CategoryHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Bookshelf");
	
	public void insertCategory(Category c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> showAllCategories() {
		EntityManager em = emfactory.createEntityManager();
		em.clear();
		Query q = em.createQuery("SELECT i FROM category i");
		List<Category> allItems = q.getResultList();
		em.close();
		return allItems;
	}
	
	public Category searchCategoryByName(String categoryName) {//oldName passed in from UpdateCategory.java
		EntityManager manager = emfactory.createEntityManager();
		TypedQuery<Category> query = manager.createQuery("SELECT i FROM category AS i WHERE i.categoryName = :categoryName", Category.class);
		query.setParameter("categoryName", categoryName);
		Category dbEntity = query.getSingleResult();
		manager.close();
		return dbEntity;
		
	
	}
	
	public void delete(Category toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Category.class, toDelete.getCategoryName()));
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void update(Category c) {
		EntityManager em = emfactory.createEntityManager();
		Category dbEntity = em.find(Category.class, c.getCategoryId());
		em.getTransaction().begin();
		dbEntity.setCategoryName(c.getCategoryName());
		dbEntity.setAbbreviation(c.getAbbreviation());
		em.getTransaction().commit();
		em.close();
	}
	
}
