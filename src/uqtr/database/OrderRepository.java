package uqtr.database;

import uqtr.models.order.Order;

import java.util.LinkedList;
import java.util.Queue;

public class OrderRepository {
    private final Queue<Order> orders;

    public OrderRepository() {
        this.orders = new LinkedList<>();
    }

    public void push(Order order) {
        orders.offer(order);
    }

    public Order pop() {
        return orders.poll();
    }

    public Order peek() {
        return orders.peek();
    }
}
