package com.example.util;
import org.hibernate.*;
import prg.hibernate.cfg.Configuration;
public class HibernateUtil {
	public static final SessionFactory sessionFactory=buildSessionFactory();
	public static SessionFactory buiSessionFactory() {
		try {
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			throw new ExceptionInitilizerError();
		}
		public static SessionFactory getSessionFactory() {
			return SessionFactory;
		}
		public static void shutdown() {
			getSessionfactory().close();
		}
	}
}
