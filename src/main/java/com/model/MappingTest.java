package com.model;

import java.util.Arrays;

import org.dom4j.rule.pattern.DefaultPattern;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingTest {
	
	public static void main(String[] args) {
		//oneToone();
		//oneTomany();
		manyTomany();
	}
	
	private static void manyTomany() {
		 
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session  session = sf.openSession();
		session.beginTransaction();
		
		Address adr = new Address();
		adr.setCountry("Nepal");
		adr.setCity("KTM");
		adr.setState("Bagmati");
		
		session.save(adr);
		
		Employee  emp = new Employee();
		
		emp.setFname("Bishwas");
		emp.setLname("KC");
		emp.setSalary(200000);
		emp.setAddress(adr);
		
		Phone  p1 = new Phone();
		p1.setNumber("9803435354");
		p1.setType("NCELL");
		p1.setEmployee(emp);
		session.save(p1);
		
		Phone  p2 = new Phone();
		p2.setNumber("9851434343");
		p2.setType("NTC");
		p2.setEmployee(emp);
		session.save(p2);
		
		Department  d1 = new Department();
		d1.setName("IT");
		session.save(d1);
		
		Department  d2 = new Department();
		d2.setName("Finance");
		session.save(d2);
		
		Department  d3 = new Department();
		d3.setName("Admin");
		session.save(d3);
		
		emp.setDepts(Arrays.asList(d1,d2,d3));
		emp.setPhones(Arrays.asList(p1,p2));
		
		session.save(emp);
		session.getTransaction().commit();
		session.close();
		
	}

	//oneToone
	
	static void oneToone() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session  session = sf.openSession();
		session.beginTransaction();
		
		Address adr = new Address();
		adr.setCountry("Nepal");
		adr.setCity("KTM");
		adr.setState("Bagmati");
		
		session.save(adr);
		
		Employee  emp = new Employee();
		
		emp.setFname("Bishwas");
		emp.setLname("KC");
		emp.setSalary(200000);
		emp.setAddress(adr);
		
		session.save(emp);
		session.getTransaction().commit();
		session.close();
		
	}
	
	//oneTomany
	
	static void oneTomany() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session  session = sf.openSession();
		session.beginTransaction();
		
		Address adr = new Address();
		adr.setCountry("Nepal");
		adr.setCity("KTM");
		adr.setState("Bagmati");
		
		session.save(adr);
		
		Employee  emp = new Employee();
		
		emp.setFname("Bishwas");
		emp.setLname("KC");
		emp.setSalary(200000);
		emp.setAddress(adr);
		
		Phone  p1 = new Phone();
		p1.setNumber("9803435354");
		p1.setType("NCELL");
		p1.setEmployee(emp);
		session.save(p1);
		
		Phone  p2 = new Phone();
		p2.setNumber("9851434343");
		p2.setType("NTC");
		p2.setEmployee(emp);
		session.save(p2);
		
		emp.setPhones(Arrays.asList(p1,p2));
		
		session.save(emp);
		session.getTransaction().commit();
		session.close();
	}

}





