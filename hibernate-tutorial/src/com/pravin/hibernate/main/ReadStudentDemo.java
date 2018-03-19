package com.pravin.hibernate.main;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pravin.hibernate.entity.Student;

public class ReadStudentDemo {

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
		
		ArrayList tempStudentArrayList = new ArrayList(); 
		ArrayList readStudentArrayList = new ArrayList(); 
		
		try{
			//create student object
			System.out.println("Creating new Student Object!!");
			Student tempStudent = new Student("archana2","kumari2","archana2@gmail.com");
			
			//start Transaction
			session.beginTransaction();
			
			//save the student
			System.out.println("Saving the student!!");
			//System.out.println(tempStudent);
			tempStudentArrayList.add(tempStudent.getId());
			tempStudentArrayList.add(tempStudent.getFirstname());
			tempStudentArrayList.add(tempStudent.getLastname());
			tempStudentArrayList.add(tempStudent.getEmail());
			System.out.println(tempStudentArrayList);
			
			session.save(tempStudent);
			
			//commit Transaction
			session.getTransaction().commit();
			
			
			//find out Student ID : Primary Key
			System.out.println("saved student generated ID:- " + tempStudent.getId());
			
			//now get a new session and start Transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the ID: primary key
			System.out.println("\n Getting Student with ID: " +tempStudent.getId());
			Student readStudent = session.get(Student.class, +tempStudent.getId());
			//System.out.println("Get Complete: " + readStudent);
			readStudentArrayList.add(tempStudent.getId());
			readStudentArrayList.add(tempStudent.getFirstname());
			readStudentArrayList.add(tempStudent.getLastname());
			readStudentArrayList.add(tempStudent.getEmail());
			
			System.out.println(readStudentArrayList);
			
			//commit transaction
			session.getTransaction().commit();			
			
			System.out.println("Done");
		}
		finally{
			factory.close();
		}
	}

}
