package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class Test {
	
	public static void main(String[] args) {
		//add(); 
		//getAll();
		//delete();
		update();
	}
	
	//add student 
	static void add() {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session  session = sf.openSession();
		session.beginTransaction();
		
		Student s = new Student();
		
		s.setFname("Prem");
		s.setLname("Raule");
		s.setAge(30);
		s.setCollege("SNSC");
		s.setCity("Dang");
		
		session.save(s);//insert sql write
		
		session.getTransaction().commit();//execute sql
		session.close();
		
	}
	
	//get students

	static void getAll() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session  session = sf.openSession();
		
		Criteria  crt = session.createCriteria(Student.class);
		// crt.add(Restrictions.ge("age", 20));
		// crt.add(Restrictions.eq("college","NCC"));
		// crt.add(Restrictions.eq("city", "Dhangadhi"));
		// crt.add(Restrictions.eq("city", "Ktm"));
		
		crt.add(Restrictions.in("city", List.of("Pokhara","Ktm")));
		 
		List<Student> slist =crt.list();//select sql
		System.out.println(slist);
	}
	
	//delete student
	static void delete() {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session  session = sf.openSession();
		session.beginTransaction();
		
		Student s = (Student) session.get(Student.class, 3);
		session.delete(s); //delete sql
		session.getTransaction().commit();
		session.close();
	}
	
	//update student
	static void update() {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session  session = sf.openSession();
		session.beginTransaction();
		
		Student s = (Student) session.get(Student.class, 4);
		s.setCity("Delhi");
		s.setAge(28);
		
		session.update(s);//update sql
		
		session.getTransaction().commit();
		session.close();
	}

}
