package com.xsis.boot182.service;

import java.util.List;

import com.xsis.boot182.model.Orang;

public interface OrangService {
	public List<Orang> getList();
	
	public Orang getData(int id);
}
