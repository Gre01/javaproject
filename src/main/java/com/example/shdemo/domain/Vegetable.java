package com.example.shdemo.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "vegetable.all", query = "Select s from Vegetable s")
})
public class Vegetable {

    private Long id;

    private String Name;
    private String Descr;
    private double Price;
    private int Instock;

    private Serial serial;
    private Type type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongname() {
        return Name;
    }

    public void setSongname(String songname) {
        this.Name = songname;
    }

    public String getBandname() {
        return Descr;
    }

    public void setBandname(String bandname) {
        this.Descr = bandname;
    }

    public double getCost() {
        return Price;
    }

    public void setCost(double cost) {
        this.Price = cost;
    }

    public int getYor() {
        return Instock;
    }

    public void setYor(int yor) {
        this.Instock = yor;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Serial getSerial() {
        return serial;
    }

    public void setSerial(Serial serial) {
        this.serial = serial;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Type getGenre() {
        return type;
    }

    public void setGenre(Type type) {
        this.type = type;
    }

}