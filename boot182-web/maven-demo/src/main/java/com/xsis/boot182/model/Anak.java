package com.xsis.boot182.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="T_ANAK")
public class Anak {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ANKID", nullable=false)
	private Integer id;
	
	@Column(name="ORGID", nullable=false)
	private Integer idOrangTua;

	@Column(name="ANKNM", nullable=false)
	private String nama;
	
	@Column(name="ANKADDR", nullable=false)
	private String alamat;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="ANKDOB")
	private Date tanggalLahir;
	
	@Column(name="ANKPOB")
	private String tempatLahir;
	
	@ManyToOne
	@JoinColumn(name="ORGID", insertable=false, updatable=false)
	private Orang orangTua;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdOrangTua() {
		return idOrangTua;
	}

	public void setIdOrangTua(Integer idOrangTua) {
		this.idOrangTua = idOrangTua;
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

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

	public Orang getOrangTua() {
		return orangTua;
	}

	public void setOrangTua(Orang orangTua) {
		this.orangTua = orangTua;
	}
}
