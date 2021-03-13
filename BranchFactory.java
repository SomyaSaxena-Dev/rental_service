package com.payment.paytm;

import java.util.*;

public class BranchFactory {

	static BranchFactory bFactInst = new BranchFactory();
	public Map<String,Branch> branches = new HashMap<>();
	//PriorityQueue<Map.Entry<String,Branch>> b = new PriorityQueue<>();
	public static BranchFactory getInstance() {
		return bFactInst;
	}
	
	//Functionality 1
	public void add_branch(String name, List<Vehicle> vehicles) {
		
		Branch b = new Branch(name);
		Set<Vehicle> vehicleSet = new HashSet<>();
		for(Vehicle v: vehicles) {
				b.getVehicleInventory().put(v.getName(),v.getQuantity());
				vehicleSet.add(v);
		}
		b.setvList(vehicleSet);
		branches.put(name,b);
		
	}
	
	//functionality 2
	public void add_vehicle(String name, Vehicle v) {
		if(branches.containsKey(name)) {
			Branch b = branches.get(name);
			if(b.getVehicle(v.getName())!=null) {
				Inventory inv = b.getVehicleInventory();
				inv.add(v.getName());
			}
			branches.put(name, b);
		}
		else {
			List<Vehicle> vList  = new ArrayList<>();
			vList.add(v);
			add_branch(name,vList);
		}
		
	}
	
	public class Entry implements Comparable<Entry>{
		private int key;
		private String value;
		Entry(int key, String value){
			this.setKey(key);
			this.setValue(value);
		}
		
		@Override
		public int compareTo(Entry r) {
			return this.getKey()- r.getKey();
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}
	}
	
	//functionality 3
	public void rent_vehicle(String vName,Date from, Date to) {
		PriorityQueue<Entry> catalog = new PriorityQueue<>();
		for(Map.Entry<String, Branch> b : branches.entrySet()) {
			
			Branch branch = b.getValue();
			if(branch.getVehicle(vName)!=null)
					catalog.add(new Entry(branch.getVehicle(vName).getPrice(),branch.getBranchName()));
			
		}
		
		if(!catalog.isEmpty()) {
			Entry p = catalog.poll();
			String bName =p.getValue();
			for(Map.Entry<String, Branch> b : branches.entrySet()) {
				
				Branch branch = b.getValue();
				if(branch.getBranchName().equals(bName)) {
					branch.getVehicleInventory().deduct(vName);
				}
			}
		}
		
	}
	
	//functionality 4
	//see time range also
	//sorted price missing
	public void getAvailableVehicle(String branchName){
		if(branches.containsKey(branchName)) {
			Branch b = branches.get(branchName);
			//return vehicle list
			for(Map.Entry<String,Integer> vehicle :b.getVehicleInventory().getAllItems().entrySet()) {
				System.out.println("Vehilce name : " + vehicle.getKey() + "Quantity :" +  vehicle.getValue());
			}
		}
		else {
			System.out.println("No branch Found");
			
		}
	}
	
	//functionality 5
	public void print_system_view() {
		for(Map.Entry<String,Branch> branch :branches.entrySet()) {
			System.out.println(branch.getKey());
			System.out.println(branch.getValue());
			for(Vehicle vehicle :branch.getValue().getvList()) {
				System.out.println(vehicle);
			}
		}
	}
	
}

