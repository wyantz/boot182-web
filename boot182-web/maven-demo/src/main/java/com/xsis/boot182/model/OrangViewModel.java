package com.xsis.boot182.model;

import java.util.List;

public class OrangViewModel {
	private Orang orangTua;
	private List<Anak> anak;
	
	public Orang getOrangTua() {
		return orangTua;
	}
	public void setOrangTua(Orang orangTua) {
		this.orangTua = orangTua;
	}
	public List<Anak> getAnak() {
		return anak;
	}
	public void setAnak(List<Anak> anak) {
		this.anak = anak;
	}
}
