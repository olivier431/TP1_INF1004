package uqtr.models;

import uqtr.stock.StockQueue;
import uqtr.stock.StockRow;
import uqtr.stock.StockStack;

public class Product {
    private String name;
    private double price;
    private final StockRow stock;

    public Product(String name, double price, boolean isPerishable) {
        this.name = name;
        this.price = price;
        this.stock = isPerishable ? new StockQueue() : new StockStack();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public StockRow getStock() {
        return stock;
    }
}
