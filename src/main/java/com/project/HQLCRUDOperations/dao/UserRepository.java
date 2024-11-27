package com.project.HQLCRUDOperations.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.HQLCRUDOperations.entity.User;

@Repository
public class UserRepository {
	@Autowired
	SessionFactory sf;
	
	public String insertData(User user) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery = "Insert into User (userName, email, password) values (:userName, :email, :password)";
		Query query = ss.createQuery(hqlQuery);
		query.setParameter("userName", user.getUserName());
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		int i = query.executeUpdate();
		tr.commit();
		ss.close();
		return "User registered successfully!!";	
	}
	
	public List<User> getAllUsers() {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery = "From User";
		Query<User> query = ss.createQuery(hqlQuery, User.class);
		List<User> user = query.list();
		tr.commit();
		ss.close(); 
		return user;
	}
	
	public User getUser(Long id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery = "From User where id = :u_id";
		Query<User> query = ss.createQuery(hqlQuery, User.class);
		query.setParameter("u_id", id);
		User user = query.uniqueResult();
		tr.commit();
		ss.close();
		return user;
	}
	
	public String updateUser(User user, Long id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery = "Update User Set userName = :name, email = :email, password = :password  Where id = :u_id";
		Query query = ss.createQuery(hqlQuery);
		query.setParameter("name", user.getUserName());
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		query.setParameter("u_id", id);
		int i = query.executeUpdate();
		tr.commit();
		ss.close();
		return "User Deatils Updated!!";
	}
	
	public String deleteUser(Long id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery = "Delete User where id = :u_id";
		Query query = ss.createQuery(hqlQuery);
		query.setParameter("u_id", id);
		int i = query.executeUpdate();
		tr.commit();
		ss.close();
		return "User Data deleted";
	}
}
