package com.pravin.hibernate.main;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pravin.hibernate.entity.Student;

public class UpdateStudentDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		ArrayList readStudentArrayList = new ArrayList(); 
		
		try{
			int studentId = 1;
			//create student object
			System.out.println("Getting Student with ID..." + studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			//updating the student
			System.out.println("updating the student!!");
			myStudent.setFirstname("Reena");
			
			//commit Transaction
			session.getTransaction().commit();

			System.out.println("Done");
		}
		finally{
			factory.close();
		}
	}

}
