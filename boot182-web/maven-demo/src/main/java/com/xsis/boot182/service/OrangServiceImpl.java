package com.xsis.boot182.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.boot182.dao.OrangDao;
import com.xsis.boot182.model.Orang;

@Service
@Transactional
public class OrangServiceImpl implements OrangService {
	@Autowired
	private OrangDao orangDao;

	@Override
	public List<Orang> getList() {
		return this.orangDao.getList();
	}

	@Override
	public Orang getData(int id) {
		return this.orangDao.get(id);
	}

}
