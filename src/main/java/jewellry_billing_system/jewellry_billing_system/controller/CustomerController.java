package jewellry_billing_system.jewellry_billing_system.controller;

import java.util.Scanner;

import jewellry_billing_system.jewellry_billing_system.dao.CustomerDao;
import jewellry_billing_system.jewellry_billing_system.dao.OrdersDao;
import jewellry_billing_system.jewellry_billing_system.dto.Customer;
import jewellry_billing_system.jewellry_billing_system.service.OrderService;

public class CustomerController {

	ItemsController i = new ItemsController();
	OrdersDao ordersDao = new OrdersDao();

	public void customerCrud() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your details:");
		System.out.println("Please enter your ID:");
		int id = sc.nextInt();
		System.out.println("Please enter your name:");
		String name = sc.next();
		System.out.println("Please enter your mobile number:");
		Long mobileNo = sc.nextLong();

		Customer c = new Customer(id, name, mobileNo);
		CustomerDao customerDao = new CustomerDao();
		customerDao.saveCustomerDetails(c);

		while (true) {
			System.out.println("1. Menu\n2. Order your item\n3. Total Bill\n4. Back");
			int option = sc.nextInt();

			switch (option) {
			
			case 1:
				i.displayAllItems();
				break;
			case 2:
				OrderService orderService=new OrderService();
				orderService.orderItems(id);
				break;
			case 3:
				OrderService orderService1=new OrderService();
				orderService1.displayTotalBill(id);
				break;
			case 4:
				MainController.main(null);
				break;
			default:
				System.out.println("Invalid Choice");
				throw new IllegalArgumentException("Unexpected value: " + option);
			}
		}

	}
}
