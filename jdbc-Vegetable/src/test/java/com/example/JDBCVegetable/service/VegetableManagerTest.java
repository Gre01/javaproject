package com.example.JDBCVegetable.service;
import com.example.JDBCVegetable.domain.Vegetable;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class VegetableManagerTest {


    VegetableManagerJDBC VegetableManager = new VegetableManagerJDBC();

    private final static String[] VG_Name = {"Ziemniak", "Pomidor", "Cebula", "Ogorek", "Marchewka"};
    private final static String[] VG_Desc = {"test descr 1", "test descr 2", "test descr 3", "test descr 4", "test descr 5"};
    private final static double[] VG_Price = {0.99, 2.20, 0.75, 3.45, 5.20};
    private final static String[] VG_Color = {"Brudny", "Czerwony", "Bialy", "Zielony", "Pomaranczowy"};

    @Test
    public void checkConnection() {
        assertNotNull(VegetableManager.getConnection());
    }

    @Test
    public void checkAdding() {
        if (VG_Name.length == VG_Desc.length && VG_Desc.length == VG_Price.length && VG_Desc.length == VG_Color.length) {
            int i = 0;
            Vegetable[] VG_Tab = new Vegetable[VG_Name.length];
            VegetableManager.clearVegetables();

            for (i = 0; i < VG_Name.length - 3; i++) {
                VG_Tab[i] = new Vegetable(VG_Name[i], VG_Desc[i], VG_Price[i], VG_Color[i]);
                assertEquals(1, VegetableManager.addVegetable(VG_Tab[i]));
            }

            List<Vegetable> VG_List = VegetableManager.getAllVegetables();
            Vegetable[] Veget = new Vegetable[VG_Name.length];

            for (i = 0; i < VG_Name.length - 3; i++) {
                Veget[i] = VG_List.get(i);

                assertEquals(VG_Name[i], Veget[i].getName());
                assertEquals(VG_Desc[i], Veget[i].getDescr());
                assertEquals((int) VG_Price[i], (int) Veget[i].getPrice());
                assertEquals(VG_Color[i], Veget[i].getColor());
            }
        }
    }

    @Test
    public void checkAddingList() {
        VegetableManager.clearVegetables();
        List<Vegetable> listToAdd = new ArrayList<>();

        Vegetable VG_1 = new Vegetable(VG_Name[1], VG_Desc[2], VG_Price[2], VG_Color[2]);
        Vegetable VG_2 = new Vegetable(VG_Name[3], VG_Desc[3], VG_Price[3], VG_Color[3]);
        Vegetable VG_3 = new Vegetable(VG_Name[4], VG_Desc[4], VG_Price[4], VG_Color[4]);

        listToAdd.add(VG_1);
        listToAdd.add(VG_2);
        listToAdd.add(VG_3);

        VegetableManager.addAllVegetables(listToAdd);
        List<Vegetable> VG_List = VegetableManager.getAllVegetables();

        assertEquals(3, VG_List.size());
        VegetableManager.clearVegetables();
        listToAdd.clear();

        VG_1.setName(VG_Name[2]);
        listToAdd.add(VG_1);
        listToAdd.add(VG_2);
        listToAdd.add(VG_3);

        VegetableManager.addAllVegetables(listToAdd);
        VG_List = VegetableManager.getAllVegetables();

        assertEquals(3, VG_List.size());

    }

    @Test
    public void checkDeleting() {
        VegetableManager.clearVegetables();
        Vegetable VG = new Vegetable("test", "test", 29, "test");
        VegetableManager.addVegetable(VG);
        VegetableManager.removeVegetable("test");
        List<Vegetable> VG_List = VegetableManager.getAllVegetables();
        assertEquals(0, VG_List.size());
    }

    @Test
    public void checkDeletingSelected() {
    	Vegetable VG_1 = new Vegetable(VG_Name[2], VG_Desc[2], VG_Price[2], VG_Color[2]);
    	Vegetable VG_2 = new Vegetable(VG_Name[3], VG_Desc[3], VG_Price[3], VG_Color[3]);
    	Vegetable VG_3 = new Vegetable(VG_Name[4], VG_Desc[4], VG_Price[4], VG_Color[4]);
        
    	VegetableManager.clearVegetables();
        List<Vegetable> VG_List = new ArrayList<>();
        VG_List.add(VG_1);
        VG_List.add(VG_2);
        VG_List.add(VG_3);
        VegetableManager.addAllVegetables(VG_List);
        VG_List.remove(VG_1);
        VG_List.remove(VG_3);
        VegetableManager.removeSelectedVegetable(VG_List);
        List<Vegetable> VG_List_2 = VegetableManager.getAllVegetables();

        assertEquals(2, VG_List_2.size());
        VegetableManager.removeSelectedVegetable(VG_List);
        VG_List_2 = VegetableManager.getAllVegetables();

        assertEquals(2, VG_List_2.size());
    }
}
