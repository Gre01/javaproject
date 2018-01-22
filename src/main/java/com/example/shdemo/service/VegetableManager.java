package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Serial;
import com.example.shdemo.domain.Type;
import com.example.shdemo.domain.Vegetable;


public interface VegetableManager {
	
	void addVegetables(Vegetable VG);
	void deleteVegetable(Vegetable VG);
	List<Vegetable> getAllVegetables();
	void updateVegetable(Vegetable old_VG, Vegetable new_VG);
	
	void addSerial(Serial s);
	void deleteSerial(Serial s);
	List<Serial> getAllSerials();
	
	void addType(Type t);
	void deleteType(Type t);
	List<Type> getAllTypes();

}
