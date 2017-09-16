package com.esteban.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.esteban.entity.Student;

public class UpdateStudent {
public static void main(String[] args) {
		
		//1.crear la fabrica de sessions (session factory)
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//2. crear la session.
		Session session = factory.getCurrentSession();
		
		try{
			//3.usa el object session to UPDATE the Java Object 
				//3.2 start una transaccion
				session.beginTransaction();
				//3.3 UPDATE THE JAVA OBJECT
					//A)ALTERNATIVA 1 DE UPDATE
						//3.3.1 Hago un retrieve del objeto a partir de la PK.
						int pk_alumno = 1;
						Student alumno = session.get(Student.class, pk_alumno);
						//3.3.2 Actualizo (UPDATE) el valor del campo nombre.
						alumno.setNombre("Ignacio");
					
						System.out.println(alumno);
						
					//B)ALTERNATIVA 2 DE UPDATE (no necesita retrieve para hacer el update, el update lo hace on the fly)
						session.createQuery("update Student set email='foo@gmail.com' ").executeUpdate();
						
				//3.4 commit la transaccion
				session.getTransaction().commit();
				
		}finally{
			//4.cerramos la fabrica de sessions. (la factory)
			factory.close(); 
		}

	}
}
