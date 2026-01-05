package com.example.dao;
import com.example.entity.*;
import com.example.util.*;
import com.hibernate.Session;
import com.hibernate.Transaction;zw
public class StudentDao {
	public int insertStudent(Student student)
	{
		Transaction tx=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			
		}
	}
}
