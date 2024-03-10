package uqtr.database;

import uqtr.models.order.Order;

import java.util.ArrayList;

public class SaleRepository {
    private final ArrayList<Order> sales; //A sale is simply an order that was processed

    public void add(Order order) {
        sales.add(order);
    }

    public ArrayList<Order> findAll() {
        return sales;
    }

    SaleRepository() {
        this.sales = new ArrayList<>();
    }
}
