package com.esteban.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.esteban.entity.Student;

public class RetrieveStudent {
public static void main(String[] args) {
		
		//1.crear la fabrica de sessions (session factory)
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//2. crear la session.
		Session session = factory.getCurrentSession();
		
		try{
			//3.usa el object session to RETRIEVE el Java object usando la PK.
				//3.2 start una transaccion
				session.beginTransaction();
				//3.3 RETRIEVE THE STUDENT OBJECT BASANDONOS EN LA PK.
				int pk_alumno = 1;
				Student alumno = session.get(Student.class, pk_alumno);
				System.out.print("Alumno que le correspone el valor de PK = "+ pk_alumno + " -> ");
				System.out.println(alumno);
				//3.4 commit la transaccion
				session.getTransaction().commit();
				
		}finally{
			//4.cerramos la fabrica de sessions. (la factory)
			factory.close(); 
		}

	}
}
