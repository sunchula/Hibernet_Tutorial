package com.pravin.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pravin.hibernate.entity.Student;

public class CreateStudentDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			System.out.println("Creating new Student Object!!");
			Student tempStudent = new Student("pravin","sunchula","pravin@gmail.com");
			Student tempStudent1 = new Student("archana","kumari","archana@gmail.com");
			Student tempStudent2 = new Student("sarmita","dey","sarmita@gmail.com");
			Student tempStudent3 = new Student("priyaka","sahu","priyanka@gmail.com");
			session.beginTransaction();
			System.out.println("Saving the student!!");
			session.save(tempStudent);
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally{
			
		}
	}

}
