package com.xsis.boot182.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.boot182.model.Orang;

@Service
@Transactional
public class OrangServiceImpl implements OrangService {

	@Override
	public List<Orang> getList() {
		List<Orang> listOrang = new ArrayList<>();

		Orang org1 = new Orang();
		org1.setId(1);
		org1.setNama("Ahmad Roni");
		org1.setAlamat("Jakarta");
		org1.setJk("Pria Perkasa");
		org1.setTmpLahir("Tulang Bawang");
		org1.setTglLahir("22-12-1990");
		listOrang.add(org1);
		
		Orang org2 = new Orang();
		org2.setId(2);
		org2.setNama("Dita");
		org2.setAlamat("Jakarta");
		org2.setJk("Wanita");
		org2.setTmpLahir("Bandar Lampung");
		org2.setTglLahir("22-11-1996");
		listOrang.add(org2);
		
		Orang org3 = new Orang();
		org3.setId(3);
		org3.setNama("Siti Zubaidah");
		org3.setAlamat("Jakarta");
		org3.setJk("Wanita");
		org3.setTmpLahir("Jakarta");
		org3.setTglLahir("22-10-1996");
		listOrang.add(org3);
		
		Orang org4 = new Orang();
		org4.setId(5);
		org4.setNama("Rere");
		org4.setAlamat("Jakarta");
		org4.setJk("Wanita");
		org4.setTmpLahir("Jakarta");
		org4.setTglLahir("05-12-1996");
		listOrang.add(org4);
		
		Orang org5 = new Orang();
		org5.setId(5);
		org5.setNama("Welly");
		org5.setAlamat("Jakarta");
		org5.setJk("Pria Kurus");
		org5.setTmpLahir("Sukabumi");
		org5.setTglLahir("22-12-1999");
		listOrang.add(org5);
		
		return listOrang;
	}

	@Override
	public Orang getData(int id) {
		return null;
	}

}
