package com.example.shdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import com.example.shdemo.domain.Vegetable;
import com.example.shdemo.domain.Serial;
import com.example.shdemo.domain.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class VegetableManagerTest {

    @Autowired
    VegetableManager VegetableManager;
    
    private final String VG_1_Name = "Pomidor";
    private final String VG_1_Descr = "test descr 1";
    private final double VG_1_Price = 5.99;
    private final int VG_1_Instock = 1;
    
    private final String VG_2_Name = "Ziemniak";
    private final String VG_2_Descr = "test descr 2";
    private final double VG_2_Price = 2.99;
    private final int VG_2_Instock = 2;
    
    private final String VG_3_Name = "Cebula fioletowa";
    private final String VG_3_Descr = "test descr 3";
    private final double VG_3_Price = 3.99;
    private final int VG_3_Instock = 3;
    
    Serial serial1 = new Serial("123456789");
    Serial serial2 = new Serial("147258369");
    Serial serial3 = new Serial("987654321");
    
    Type type_1 = new Type("Southern");
    Type type_2 = new Type("Middle");
    Type type_3 = new Type("Northern");
    
    @Test
    public void addgetVegetableCheck() {
        Vegetable VG = new Vegetable();

        VG.setSongname(VG_1_Name);
        VG.setBandname(VG_1_Descr);
        VG.setCost(VG_1_Price);
        VG.setYor(VG_1_Instock);

        VG.setSerial(serial1);
        VG.setGenre(type_1);

        List<Vegetable> before = VegetableManager.getAllVegetables();
        VegetableManager.addVegetables(VG);
        List<Vegetable> after = VegetableManager.getAllVegetables();
        assertEquals(before.size() + 1, after.size());
    }

    @Test
    public void deleteVegetableCheck(){
    	Vegetable VG = new Vegetable();

        VG.setSongname(VG_2_Name);
        VG.setBandname(VG_2_Descr);
        VG.setCost(VG_2_Price);
        VG.setYor(VG_2_Instock);

        VG.setSerial(serial2);
        VG.setGenre(type_2);

        VegetableManager.addVegetables(VG);
        List<Vegetable> before = VegetableManager.getAllVegetables();
        VegetableManager.deleteVegetable(VG);
        List<Vegetable> after = VegetableManager.getAllVegetables();
        assertEquals(before.size(), after.size()+1);
    }

    @Test
    public void addSerialCheck() {
        Serial test_serial = new Serial("139742685");

        List<Serial> before = VegetableManager.getAllSerials();
        VegetableManager.addSerial(test_serial);
        List<Serial> after = VegetableManager.getAllSerials();
        assertEquals(before.size() + 1, after.size());
    }

    @Test
    public void deleteSerialCheck() {
    	Serial test_serial = new Serial("268413975");

    	VegetableManager.addSerial(test_serial);
        List<Serial> before = VegetableManager.getAllSerials();
        VegetableManager.deleteSerial(test_serial);
        List<Serial> after = VegetableManager.getAllSerials();
        assertEquals(before.size(), after.size() + 1);
    }
    @Test
    public void addTypeCheck() {
        Type test_type = new Type("Oriental");

        List<Type> before = VegetableManager.getAllTypes();
        VegetableManager.addType(test_type);
        List<Type> after = VegetableManager.getAllTypes();
        assertEquals(before.size() + 1, after.size());
    }


    @Test
    public void deleteTypeCheck() {
    	Type test_type = new Type("Tropical");

    	VegetableManager.addType(test_type);
    	List<Type> before = VegetableManager.getAllTypes();
        VegetableManager.deleteType(test_type);
        List<Type> after = VegetableManager.getAllTypes();
        assertEquals(before.size(), after.size() + 1);
    }



    
}
