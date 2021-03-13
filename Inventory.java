package com.payment.paytm;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
public class Inventory {
    private Map<String, Integer> inventory = new TreeMap<String, Integer>();
    
    public int getQuantity(String item){
        Integer value = inventory.get(item);
        return value == null? 0 : value ;
    }
   
    public void add(String item){
        int count = this.hasItem(item) ? inventory.get(item) : 0 ;
        inventory.put(item, count+1);
    }
   
    public void deduct(String item) {
        if (hasItem(item)) {
            int count = inventory.get(item);
            inventory.put(item, count - 1);
        }
    }
   
    public boolean hasItem(String item){
        return getQuantity(item) > 0;
    }

   
    @Override
	public String toString() {
		return "Inventory [inventory=" + inventory + "]";
	}
	public void clear(){
        inventory.clear();
    }

    public void put(String item, int quantity) {
        inventory.put(item, quantity);
    }
    
    
    public Map<String,Integer> getAllItems() {
    	Map<String, Integer> inventory = new HashMap<String, Integer>();
    	for(Map.Entry<String,Integer> entry : inventory.entrySet()) {
    		inventory.put(entry.getKey(),entry.getValue());
    	}
    	return inventory;
    }
    public Integer getItem(String name){
    	return inventory.get(name);
    }
   
}

