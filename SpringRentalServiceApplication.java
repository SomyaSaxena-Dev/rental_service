package com.payment.paytm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRentalServiceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringRentalServiceApplication.class, args);
		BranchFactory b = BranchFactory.getInstance();
		
		Vehicle v = new Vehicle(1,"suv",12,VehicleType.CAR);
		Vehicle v1 = new Vehicle(3,"sedan",10,VehicleType.CAR);
		Vehicle v2 = new Vehicle(3,"bike",20,VehicleType.BIKE);
		List<Vehicle> vList = new ArrayList<>();
		vList.add(v2);
		vList.add(v);
		vList.add(v1);
		b.add_branch("gachibowli",vList);
		
		
		Vehicle v4 = new Vehicle(3,"sedan",11,VehicleType.CAR);
		Vehicle v5 = new Vehicle(3,"bike",30,VehicleType.BIKE);
		Vehicle v6 = new Vehicle(4,"hatch_back",20,VehicleType.BIKE);
		vList.clear();
		vList.add(v4);
		vList.add(v6);
		vList.add(v5);
		b.add_branch("kukatpally",vList);
		
		
				
		
		//add_branch("miyapur", [“1 suv for Rs.11 per hour”, “10 bikes for Rs.3 per hour”, “3 sedan for Rs.10 per hour”]);

		
		Vehicle v3 = new Vehicle(1,"sedan");
		b.add_vehicle("gachibowli", v3);
		System.out.println("Before renting");
		b.print_system_view();
		
		b.rent_vehicle("sedan", null, null);
		
		System.out.println("After renting");
		b.print_system_view();
	}

}
