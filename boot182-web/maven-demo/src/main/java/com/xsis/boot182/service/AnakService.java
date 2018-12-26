package com.xsis.boot182.service;

import java.util.List;

import com.xsis.boot182.model.Anak;

public interface AnakService {
	public Anak get(Integer id);
	public void insert(Anak anak);
	public void update(Anak anak);
	public void delete(Anak anak);
	public List<Anak> listAnakByOrangTua(Integer idOrangTua);
}
