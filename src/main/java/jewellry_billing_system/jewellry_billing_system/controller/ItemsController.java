package jewellry_billing_system.jewellry_billing_system.controller;

import java.util.List;
import java.util.Scanner;
import jewellry_billing_system.jewellry_billing_system.dao.ItemsDao;
import jewellry_billing_system.jewellry_billing_system.dto.Items;

public class ItemsController {
	
	Scanner sc=new Scanner(System.in);
	ItemsDao dao=new ItemsDao();
	
	public void addItems() {
		System.out.println("Enter the Item id");
		int i_id=sc.nextInt();
		System.out.println("Enter the Item name");
		String i_name=sc.next();
		System.out.println("Enter the item price");
		Double price=sc.nextDouble();
		Items items=new Items(i_id, i_name, price);
		dao.saveItems(items);
		System.out.println("Item added successfulyy");
		
	}
	public void removeItems() {
		System.out.println("Enter item id");
		int i_id=sc.nextInt();
		dao.removeItems(i_id);
		System.out.println("Item remove successfulyy");
		
	}
	public void updateItems() {
		System.out.println("Enter the item id");
		int i_id=sc.nextInt();
		System.out.println("Enter the item name which do you want to change");
		String i_name=sc.next();
		System.out.println("Enter the item price which do you want to change");
		double price=sc.nextDouble();
		dao.updateItems(i_id,i_name,price);
		System.out.println("Item modify successfulyy");
		
	}
	public void displayAllItems() {
		System.out.println("All item list is ");
		List<Items> items=dao.displayItems();
		for (Items i : items) {
			System.out.println(i);
			
		}
	}
	
	 public Items getItemById(int itemId) {
	        return dao.getItemById(itemId);
	    }

}
