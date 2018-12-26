package com.xsis.boot182.service;

import java.util.List;

import com.xsis.boot182.model.Orang;
import com.xsis.boot182.model.OrangViewModel;

public interface OrangService {
	public List<Orang> getList();
	
	public Orang getData(int id);
	public void insert(Orang orang);
	public void delete(Orang orang);
	public void update(Orang orang);
	
	public void insert(OrangViewModel orangViewModel);
}
