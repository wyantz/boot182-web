package com.xsis.boot182.dao;

import java.util.List;

import com.xsis.boot182.model.Orang;

public interface OrangDao {
	public Orang get(Integer id);
	public void insert(Orang orang);
	public void delete(Orang orang);
	public void update(Orang orang);
	public List<Orang> getList();
}
