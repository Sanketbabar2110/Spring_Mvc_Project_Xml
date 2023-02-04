package com.pro.wings.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.wings.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory factory;

	@Override
	public boolean createEmployee(Employee emp) {

		Session session = null;

		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();

			session.save(emp);

			tx.commit();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Failed to insert/create Employee!!!");
			e.printStackTrace();
			return false;
			
		} finally {
			session.close();
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			return session.createQuery("From Employee").list();
					
		} catch (Exception e) {
			
			System.out.println("Failed to insert/create Employee!!!");
			e.printStackTrace();
			return null;
			
		} finally {
			tx.commit();
			session.close();
		}
	}
}
