package uqtr.models.order;

import java.util.ArrayList;

public class Order {
    private final ArrayList<OrderRow> orderRows;

    private double total;

    public Order() {
        this.orderRows = new ArrayList<>();
    }

    public void addRow(OrderRow row) {
        orderRows.add(row);
    }

    public void confirm() {
        if (total != 0) return;
        double total = 0;
        for (OrderRow row: orderRows) {
            total += row.getPrice();
        }
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public int getNumberOfRows() {
        return orderRows.size();
    }

    public ArrayList<OrderRow> getAllRows() {
        return orderRows;
    }
}
