package jewellry_billing_system.jewellry_billing_system.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jewellry_billing_system.jewellry_billing_system.dto.Orders;

public class OrdersDao {

	EntityManager em = Persistence.createEntityManagerFactory("hibernate").createEntityManager();
    EntityTransaction et = em.getTransaction();

    public void saveOrder(Orders order) {
        try {
            et.begin();
            em.persist(order);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
    }

    public double calculateTotalBill(int customerId) {
        double totalBill = 0;
        List<Orders> ordersList = em.createQuery("SELECT o FROM Orders o WHERE o.customer.c_id = :customerId", Orders.class)
                                    .setParameter("customerId", customerId)
                                    .getResultList();
        for (Orders order : ordersList) {
            totalBill += order.getTotalPrice();
        }
        return totalBill;
    }
}
