package com.pro.wings.dao;

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
}
