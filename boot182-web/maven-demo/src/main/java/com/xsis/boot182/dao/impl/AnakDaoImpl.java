package com.xsis.boot182.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.boot182.dao.AnakDao;
import com.xsis.boot182.model.Anak;

@Repository
public class AnakDaoImpl implements AnakDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Anak get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Anak.class, id);
	}

	@Override
	public void insert(Anak anak) {
		Session session = sessionFactory.getCurrentSession();
		session.save(anak);
	}

	@Override
	public void update(Anak anak) {
		Session session = sessionFactory.getCurrentSession();
		session.update(anak);
	}

	@Override
	public void delete(Anak anak) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(anak);
	}

	@Override
	public List<Anak> listAnakByOrangTua(Integer idOrangTua) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select a from Anak a where a.idOrangTua = :idnyaorangtua";
		Query query = session.createQuery(hql);
		query.setParameter("idnyaorangtua", idOrangTua);

		return query.getResultList();
	}

}
