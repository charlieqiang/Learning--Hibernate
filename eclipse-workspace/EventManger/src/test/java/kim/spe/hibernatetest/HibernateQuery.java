package kim.spe.hibernatetest;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import kim.spe.entity.User;
import kim.spe.utils.HibernateUtils;

public class HibernateQuery {
	@Test
	public void textQuery() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			//
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			
			//start work
			tx = session.beginTransaction();
			
			//Query
			Query query = session.createQuery("from User");
			//
			List<User> list = query.list();
			//
			for(User user:list) {
				System.out.println(user);
			}
			
			//commit
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
			
		} finally {
			//close
//			session.close();
//			sessionFactory.close();
		}
	}
	
	@Test
	public void textCriteria() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			//
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			
			//start work
			tx = session.beginTransaction();
			
			//
//			Criteria criteria = session.createCriteria(User.class);
//			List<User> list = criteria.list();
//			
//			for(User user:list) {
//				System.out.println(user);
//			}
			
			SQLQuery sqlQuery= session.createSQLQuery("select * from t_user");
			sqlQuery.addEntity(User.class);
			
			List<User> list = sqlQuery.list();
			
			for(User obj:list) {
				System.out.println(obj);
			}
			
			//commit
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
			
		} finally {
			//close
//			session.close();
//			sessionFactory.close();
		}
	}
}
