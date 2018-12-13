package com.xsis.boot182.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Orang {
	private int id;
	private String nama;
	private String alamat;
	private String jk;
	private Date tglLahir;
	private String tmpLahir;
	
	public Orang() {
		System.out.println("Orang : Constructor is called");
	}
	
	public int getId() {
		return id;
	}	
	public void setId(int id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getJk() {
		return jk;
	}
	public void setJk(String jk) {
		this.jk = jk;
	}
	public Date getTglLahir() {
		return tglLahir;
	}
	public void setTglLahir(String tglLahir) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date tgl = null;
		try {
			tgl = format.parse(tglLahir);
		} catch (Exception e) {
			tgl = null;
		}
		this.tglLahir = tgl;
	}
	public String getTmpLahir() {
		return tmpLahir;
	}
	public void setTmpLahir(String tmpLahir) {
		this.tmpLahir = tmpLahir;
	}
}
