package uqtr.models.product;

import uqtr.stock.StockQueue;
import uqtr.stock.StockRow;
import uqtr.stock.StockStack;

public class Product {
    private String name;
    private double unitPrice;
    private final StockRow stock;

    public Product(String name, double price, boolean isPerishable) {
        this.name = name;
        this.unitPrice = price;
        this.stock = isPerishable ? new StockQueue() : new StockStack();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public StockRow getStock() {
        return stock;
    }
}
