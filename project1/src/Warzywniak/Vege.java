package Warzywniak;

import java.sql.Date;


    public class Vege {

	private Integer Id_Vege; 
	private String Name;
	private Double Price;
        private Date Date;
        //private Boolean Instock;
        
        
	public Vege(Integer Id_Vege, String Name, Double Price, Date Date) {
            
            this.Id_Vege = Id_Vege;
            this.Name = Name;
            this.Price = Price;
            this.Date = Date;
	}
	
	public Vege(String Name, Double Price, Date Date) {
		
            this.Name = Name;
            this.Price = Price;
            this.Date = Date;
	}
        
        /*
        public Vege(Integer Id_Vege, String Name, Double Price, Date Date, int Instock) {
            
            this.Id_Vege = Id_Vege;
            this.Name = Name;
            this.Price = Price;
            this.Date = Date;
            setInstock(Instock);
        }
        
        public Vege(String Name, Double Price, Date Date, int Instock) {
            
            this.Name = Name;
            this.Price = Price;
            this.Date = Date;
            setInstock(Instock);
        }*/
        
	public Vege() {}

    //Set
	public void setId_Vege(int Id_Kraj) {
            this.Id_Vege = Id_Kraj;
	}
	public void setName(String Kraj) {
            this.Name = Kraj;
	}
	public void setPrice(Double Price) {
            this.Price = Price;
	}
        public void setDate(Date Date) {
            this.Date = Date;
	}/*
        public void setInstock(int Instock) {
            //if(Instock==1){this.Instock = true;}
            //if(Instock==0){this.Instock = false;}
            //this.Instock = true;
            
            this.Instock = (Instock == 1);
	}*/

    //Get
        public Integer getId_Vege() {
            return Id_Vege;
	}
	public String getName() {
            return Name;
	}
	public Double getPrice() {
            return Price;
	}
	public Date getDate() {
            return Date;
	}/*
	public Boolean getInstock() {
            return Instock;
	}*/
    }