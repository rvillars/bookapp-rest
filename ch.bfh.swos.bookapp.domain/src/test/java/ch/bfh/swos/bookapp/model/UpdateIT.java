/**
 * 
 */
package ch.bfh.swos.bookapp.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author rovi
 * 
 */
public class UpdateIT {

	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.swos.bookapp.model").createEntityManager();

		Query q = em.createQuery("select a from Author a");
		@SuppressWarnings("unchecked")
		List<Author> foundAuthors = q.getResultList();
		Author firstAuthor = foundAuthors.get(0);

		// Write access needs a transaction
		em.getTransaction().begin();
		firstAuthor.setLastname("OtherName");
		em.getTransaction().commit();
		// Entity is persisted automatically after commit because it is managed
		// by jpa.

		Assert.assertTrue(firstAuthor.getLastname().equals("OtherName"));
	}

}
