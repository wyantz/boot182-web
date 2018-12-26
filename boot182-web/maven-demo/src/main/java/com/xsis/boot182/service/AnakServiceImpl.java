package com.xsis.boot182.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xsis.boot182.dao.AnakDao;
import com.xsis.boot182.model.Anak;

@Service
@Transactional
public class AnakServiceImpl implements AnakService {
	@Autowired private AnakDao anakDao;
	
	@Override
	public Anak get(Integer id) {
		return this.anakDao.get(id);
	}

	@Override
	public void insert(Anak anak) {
		this.anakDao.insert(anak);
	}

	@Override
	public void update(Anak anak) {
		this.anakDao.update(anak);
	}

	@Override
	public void delete(Anak anak) {
		this.anakDao.delete(anak);
	}

	@Override
	public List<Anak> listAnakByOrangTua(Integer idOrangTua) {
		return this.anakDao.listAnakByOrangTua(idOrangTua);
	}

}
