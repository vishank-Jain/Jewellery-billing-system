package jewellry_billing_system.jewellry_billing_system.controller;

import java.util.Scanner;


import jewellry_billing_system.jewellry_billing_system.dto.Jeweller;

public class JewellerController {
 
	public void jewellerCrud() {
		Scanner sc=new Scanner(System.in);
	    Jeweller j=new Jeweller();
		while(true) {
			System.out.println("Enter your name");
			String name=sc.next();
			System.out.println("Enter your password");
			String password=sc.next();
			if(j.getJ_uname().equals(name) && j.getJ_password().equals(password)) {
				while(true) {
					// items controller
					System.out.println("1.Add item\n2.Remove\n3.Update\n4.Display All items\n5.Back");
					int option=sc.nextInt();
					
					ItemsController ic=new ItemsController();
					
					switch (option) {
					case 1: {
						ic.addItems();
						break;
					}
					case 2:{
						ic.removeItems();
						break;
					}
					case 3:{
						ic.updateItems();
						break;
						
					}
					case 4:{
						ic.displayAllItems();
						break;
					}
					case 5:{
						MainController.main(null);
					}
					default:
						System.out.println("Invalid Option");
						throw new IllegalArgumentException("Unexpected value: " + option);
					}
					
				}
			}else {
				System.out.println("Credentils is wrong");
			}
			}
		}
	}