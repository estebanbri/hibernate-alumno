package com.esteban.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.esteban.entity.Student;

public class QueryStudent {
public static void main(String[] args) {
		
		//1.crear la fabrica de sessions (session factory)
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//2. crear la session.
		Session session = factory.getCurrentSession();
		
		try{
			//3.usa el object session to make QUERY's 
				//3.2 start una transaccion
				session.beginTransaction();
				//3.3 QUERY's
					//QUERY (Listar todos los alumnos) 
					//List<Student> listaAlumnos = session.createQuery("from Student").getResultList();
					
					//QUERY (Listar todos con nombre Esteban) 
					List<Student> listaAlumnos = session.createQuery("from Student s where s.nombre='Esteban' ").getResultList();
				
				System.out.println("Cantidad de alumnos= " + listaAlumnos.size());
				
				for(Student s:listaAlumnos){
					System.out.println(s);
				}
				
				//3.4 commit la transaccion
				session.getTransaction().commit();
				
		}finally{
			//4.cerramos la fabrica de sessions. (la factory)
			factory.close(); 
	}

}

}
