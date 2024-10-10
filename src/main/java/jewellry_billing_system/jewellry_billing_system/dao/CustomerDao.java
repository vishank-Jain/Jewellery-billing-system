package jewellry_billing_system.jewellry_billing_system.dao;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jewellry_billing_system.jewellry_billing_system.dto.Customer;

public class CustomerDao {
      
	Scanner sc=new Scanner(System.in);
	
	EntityManager em=Persistence.createEntityManagerFactory("hibernate").createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	
	public Customer saveCustomerDetails(Customer c) {
		
		try {
			et.begin();
			em.persist(c);
			et.commit();
			return c;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
}
