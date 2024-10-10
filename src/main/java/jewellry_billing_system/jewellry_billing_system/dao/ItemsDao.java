package jewellry_billing_system.jewellry_billing_system.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jewellry_billing_system.jewellry_billing_system.dto.Items;
import jewellry_billing_system.jewellry_billing_system.dto.Jeweller;

public class ItemsDao {

	EntityManager em=Persistence.createEntityManagerFactory("hibernate").createEntityManager();
	EntityTransaction et=em.getTransaction();
	

	 private List<Items> itemsList = new ArrayList<>();
	
     /*
      * Add Items Details
      */
	public Items saveItems(Items i) {
		try {
			et.begin();
			em.persist(i);
			et.commit();
			return i;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
     /*
      * Remove Item	
      */
	}
	public void removeItems(int i_id) {
		try {
			et.begin();
			Items i=em.find(Items.class, i_id);
			em.remove(i);
			et.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	/*
	 * Update Item detail
	 */
	public boolean updateItems(int i_id,String i_name,double price) {
		try {
			Items i=em.find(Items.class, i_id);
			et.begin();
			i.setI_name(i_name);
			i.setPrice(price);
			em.merge(i);
			et.commit();
			
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	/*
	 * Display all Item Details
	 */
	public List<Items> displayItems(){
		return em.createQuery("from Items").getResultList();
		
	}
	
	
	 public Items getItemById(int itemId) {
		 itemsList= em.createQuery("from Items").getResultList();
	        for (Items item : itemsList) {
	            if (item.getI_id() == itemId) {
	                return item;
	            }
	        }
	        return null; 
	    }
	
}
