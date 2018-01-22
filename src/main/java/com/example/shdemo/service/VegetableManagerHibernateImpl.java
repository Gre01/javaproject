package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Serial;
import com.example.shdemo.domain.Type;
import com.example.shdemo.domain.Vegetable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class VegetableManagerHibernateImpl implements VegetableManager{

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
  
    @Override
    public void addType(Type t) {
        sessionFactory.getCurrentSession().persist(t);
    }

    @Override
    public void deleteType(Type t) {
        sessionFactory.getCurrentSession().delete(t);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Type> getAllTypes() {
        return sessionFactory.getCurrentSession().getNamedQuery("type.all").list();
    }

    @Override
    public void addVegetables(Vegetable VG) {
        sessionFactory.getCurrentSession().persist(VG);
    }

    @Override
    public void deleteVegetable(Vegetable VG) {
        sessionFactory.getCurrentSession().delete(VG);
    }
  
    @Override
    @SuppressWarnings("unchecked")
    public List<Vegetable> getAllVegetables() {
        return sessionFactory.getCurrentSession().getNamedQuery("vegetable.all").list();
    }
  
    @Override
    public void updateVegetable(Vegetable old_VG, Vegetable new_VG) {
        old_VG = (Vegetable) sessionFactory.getCurrentSession().get(Vegetable.class, old_VG.getId());

        old_VG.setSongname(new_VG.getSongname());
        old_VG.setBandname(new_VG.getBandname());
        old_VG.setCost(new_VG.getCost());
        old_VG.setYor(new_VG.getYor());

        sessionFactory.getCurrentSession().update(old_VG);
    }

    @Override
    public void addSerial(Serial s) {
        sessionFactory.getCurrentSession().persist(s);
    }

    @Override
    public void deleteSerial(Serial s) {
        sessionFactory.getCurrentSession().delete(s);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Serial> getAllSerials() {
        return sessionFactory.getCurrentSession().getNamedQuery("serial.all").list();
    }
}