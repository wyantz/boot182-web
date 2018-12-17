package com.xsis.boot182.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_ORANG")
public class Orang {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="ORGNM", length=50)
	private String nama;
	
	@Column(name="ORGADDR", length=100)
	private String alamat;
	
	@Column(name="ORGJK", length=1)
	private String jk;
	
	@Temporal(TemporalType.DATE)
	@Column(name="ORGDOB")
	private Date tglLahir;
	
	@Column(name="ORGPOB", length=50)
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
