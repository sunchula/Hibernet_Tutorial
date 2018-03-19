package com.pravin.hibernate.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pravin.hibernate.entity.Student;

public class QueryStudentDemo {

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
			
			//start Transaction
			session.beginTransaction();

			//query students
			List<Student> theStudents  = session.createQuery("from Student").list();
			displayStudentMethd(theStudents);
			
			//query student : last name = kumari
			System.out.println("\n-------------------------------");
			theStudents = session.createQuery("from Student s where s.lastname = 'kumari'").list();			
			System.out.println("\n\nst	udent with last name = kumari  ");
			displayStudentMethd(theStudents);			
			
			//query student : first name = pravin
			System.out.println("\n-------------------------------");
			theStudents = session.createQuery("from Student s where s.firstname = 'pravin'").list();			
			System.out.println("\n\nstudent with first name = pravin  ");
			displayStudentMethd(theStudents);
			
			//query student : lastName = kumari or firstName = pravin
			System.out.println("\n-------------------------------");
			theStudents = session.createQuery("from Student s where" + " s.lastname = 'dey' or s.firstname = 'pravin'").list();			
			System.out.println("\n\nstudent with lastName = kumari or firstName = pravin");
			displayStudentMethd(theStudents);
			
			//query student : email ends with gmail.com
			System.out.println("\n-------------------------------");
			theStudents = session.createQuery("from Student s where" + " s.email LIKE '%gmail.com'").list();			
			System.out.println("\n\nstudent with email ends with gmail.com");
			displayStudentMethd(theStudents);
			
			session.getTransaction().commit();	
			
			System.out.println("\nDone");
		}
		finally{
			factory.close();
		}
	}

	private static void displayStudentMethd(List<Student> theStudents) {
		for(Student theStudent : theStudents){
		
			System.out.println(theStudent.getId());
			System.out.println(theStudent.getFirstname());
			System.out.println(theStudent.getLastname());
			System.out.println(theStudent.getEmail());
			/*readStudentArrayList.add(theStudent.getId());
			readStudentArrayList.add(theStudent.getFirstname());
			readStudentArrayList.add(theStudent.getLastname());
			readStudentArrayList.add(theStudent.getEmail());*/
		}
	}

}
