package com.payment.paytm;

public class Vehicle {

	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", vType=" + vType + ", quantity=" + quantity + ", price=" + price + "]";
	}
	String name;
	String vType;
	int quantity;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	int price;
	Vehicle(int qty,String name, int price, String b){
		quantity = qty;
		this.name= name;
		this.price= price;
		vType = b;
	}
	
	Vehicle(int qty,String name){
		quantity = qty;
		this.name= name;
	}
	
	Vehicle(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getvType() {
		return vType;
	}
	public void setvType(String vType) {
		this.vType = vType;
	}
	
	
}
