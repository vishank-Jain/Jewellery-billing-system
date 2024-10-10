package jewellry_billing_system.jewellry_billing_system.service;

import java.util.Scanner;

import jewellry_billing_system.jewellry_billing_system.controller.ItemsController;
import jewellry_billing_system.jewellry_billing_system.dao.OrdersDao;
import jewellry_billing_system.jewellry_billing_system.dto.Items;
import jewellry_billing_system.jewellry_billing_system.dto.Orders;

public class OrderService {
	 ItemsController i = new ItemsController();
	    OrdersDao ordersDao = new OrdersDao();

	    public void orderItems(int customerId) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the Item ID:");
	        int itemId = sc.nextInt();
	        System.out.println("Enter the quantity:");
	        int quantity = sc.nextInt();

	        Items item = i.getItemById(itemId);
	        if (item != null) {
	            double totalPrice = item.getPrice() * quantity;
	            Orders order = new Orders(0, quantity, totalPrice, item);
	            ordersDao.saveOrder(order);
	            System.out.println("Order placed successfully! Total Price: " + totalPrice);
	        } else {
	            System.out.println("Item not found!");
	        }
	    }

	    public void displayTotalBill(int customerId) {
	        double totalBill = ordersDao.calculateTotalBill(customerId);
	        System.out.println("Your total bill is: " + totalBill);
	    }

}
