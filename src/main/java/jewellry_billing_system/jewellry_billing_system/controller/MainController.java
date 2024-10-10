package jewellry_billing_system.jewellry_billing_system.controller;

import java.util.Scanner;

public class MainController {
  public static void main(String[] args) {
	System.out.println("Welcome to Jewellery Shop");
	System.out.println("Are you a Jeweller or Customer?");
	
	while(true) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Press 1 for Jeweller");
		System.out.println("Press 2 for Customer");
		System.out.println("Press 3 for Exit");
		int option=sc.nextInt();
		switch (option) {
		case 1: {
			JewellerController j=new JewellerController();
			j.jewellerCrud();
			;
		}
		case 2:{
			CustomerController c=new 	CustomerController();
			c.customerCrud();
			break;
		}
		case 3:{
			System.out.println("Your Application is Terminated");
			System.exit(1);
		}
		default:
			System.out.println("Invalid Choice");
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
	}
}
}
