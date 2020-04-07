package kim.spe.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import junit.framework.TestCase;
import kim.spe.entity.User;
import kim.spe.utils.HibernateUtils;

public class HibernateDemo extends TestCase {
	
	@Test
	public void textTx() {
		//load cfg
//		Configuration cfg = new Configuration();
//		cfg.configure();
		//session factory
//		SessionFactory sessionFactory = cfg.buildSessionFactory();
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		
		//create session
		Session session = sessionFactory.openSession();
		//begin
		Transaction tx = session.beginTransaction();
		//entity
		User user = new User();
		user.setUsername("lover");
		user.setPassword("1314520");
		user.setAddress("Fujian");
		session.save(user);
		
//		User user = session.get(User.class, "4028098171537449017153744a980000");
//		
////		System.out.println(user);
//		
//		//update
//		user.setUsername("darling");
//		//by id
//		session.update(user);
		//delete
//		session.delete(user);
		
		//commit
		tx.commit();
		//close
		session.close();
		sessionFactory.close();
		
	}
	
	@Test
    public void testHello(){     

		Session session = null;
		Transaction tx = null;
		try {

			session = HibernateUtils.getSessionObject();
			
			//start work
			tx = session.beginTransaction();
			
			//add
			User user = new User();
			user.setUsername("onlyLover");
			user.setPassword("520");
			user.setAddress("Fujian");
			session.save(user);
			//commit
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
			
		} finally {
			//close
			session.close();
//			sessionFactory.close();
		}
    }
}
