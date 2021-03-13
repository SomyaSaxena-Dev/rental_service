package com.payment.paytm;

import java.util.*;

public class Branch {

	@Override
	public String toString() {
		return "Branch [branchName=" + branchName + ", vehicleInventory=" + vehicleInventory + "]";
	}
	String branchName;
	Inventory vehicleInventory = new Inventory();
	Set<Vehicle> vList = new HashSet<>();
	
	public Set<Vehicle> getvList() {
		return vList;
	}
	public void setvList(Set<Vehicle> vList) {
		this.vList = vList;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public Inventory getVehicleInventory() {
		return vehicleInventory;
	}
	public void setVehicleInventory(Inventory vehicleInventory) {
		this.vehicleInventory = vehicleInventory;
	}
	
	
	
	Branch(String name){
		branchName = name;
	}
	Branch(String name, List<Vehicle> vList){
		this.branchName = name;
		for(Vehicle v: vList) {
			vehicleInventory.add(v.getName());
			this.vList.add(v);
		}
		
	}
	
	Vehicle getVehicle(String name) {
		for(Vehicle v : vList) {
			if(v.getName().equals(name)) {
				return v;
			}
		}
		return null;
	}
	
	
}
