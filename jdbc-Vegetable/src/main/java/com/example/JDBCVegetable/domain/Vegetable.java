package com.example.JDBCVegetable.domain;

public class Vegetable {
	
	private long id;
	
	private String Name;
	private String Descr;
	private double Price;
	private String Color;
	
	public Vegetable() {
	}
	
	public Vegetable(String Name, String Descr, double Price, String Color) {
		super();
		this.Name = Name;
		this.Descr = Descr;
		this.Price = Price;
		this.Color = Color;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getDescr() {
		return Descr;
	}
	public void setDescr(String Descr) {
		this.Descr = Descr;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double Price) {
		this.Price = Price;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String Color) {
		this.Color = Color;
	}
}
