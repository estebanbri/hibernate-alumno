package com.esteban.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.esteban.entity.Student;

public class SaveStudent {
	
	
	public static void main(String[] args) {
		
		//1.crear la fabrica de sessions (session factory)
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//2. crear la session.
		Session session = factory.getCurrentSession();
		
		try{
			//3.usa el object session to SAVE el Java object.
				//3.1 crea un student
				Student alumno1  = new Student("Esteban","Briceño","esteban_89_1@hotmail.com");
				//3.2 start una transaccion
				session.beginTransaction();
				//3.3 SAVE THE STUDENT OBJECT
				session.save(alumno1);
				//3.4 commit la transaccion
				session.getTransaction().commit();
				
		}finally{
			//4.cerramos la fabrica de sessions. (la factory)
			factory.close(); 
		}

	}

}
