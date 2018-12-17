package com.xsis.boot182.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.boot182.dao.OrangDao;
import com.xsis.boot182.model.Orang;

@Repository
public class OrangDaoImpl implements OrangDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Orang get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Orang.class, id);
	}

	@Override
	public void insert(Orang orang) {
		Session session = sessionFactory.getCurrentSession();
		session.save(orang);
	}

	@Override
	public void delete(Orang orang) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(orang);
	}

	@Override
	public void update(Orang orang) {
		Session session = sessionFactory.getCurrentSession();
		session.update(orang);
	}

	@Override
	public List<Orang> getList() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select o from Orang o";
		Query query = session.createQuery(hql);
		
		return query.list();
	}

}
