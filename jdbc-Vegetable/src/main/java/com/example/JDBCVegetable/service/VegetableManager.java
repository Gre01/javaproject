package com.example.JDBCVegetable.service;

import java.util.List;

import com.example.JDBCVegetable.domain.Vegetable;

public interface VegetableManager {

    public int addVegetable(Vegetable VG);

    public List<Vegetable> getAllVegetables();

    public void addAllVegetables(List<Vegetable> list);

    public void removeVegetable(String VG);

    public void removeSelectedVegetable(List<Vegetable> list);

}
