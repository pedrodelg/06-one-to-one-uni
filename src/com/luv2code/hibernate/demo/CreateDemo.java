package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		try {

			//create the objects
			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2c0de.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("www.luv2code.com",  "luv2code");
			
			//associate the objects 
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			
			// start a transaction
			
			session.beginTransaction();

			//save the instructor
			
			//Note: this will ALSO save the details object
			// because of CacasdeType.ALL
			
			System.out.println("saving instructor: " +tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}
