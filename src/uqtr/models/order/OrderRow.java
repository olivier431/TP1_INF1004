package uqtr.models.order;

import uqtr.models.product.Product;

public class OrderRow {
    private final int quantityOrdered;
    private final Product orderedProduct;
    private final double price; //Not to be confused with unit price


    public OrderRow(int quantityOrdered, Product productOrdered) {
        this.quantityOrdered = quantityOrdered;
        this.orderedProduct = productOrdered;
        this.price = quantityOrdered * orderedProduct.getUnitPrice();
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public Product getOrderedProduct() {
        return orderedProduct;
    }

    public double getPrice() {
        return price;
    }
}
