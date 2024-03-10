package uqtr.models;

public class ProductOrder {
    private final int quantityOrdered;
    private final Product orderedProduct;
    private final double subTotal;


    public ProductOrder(int quantityOrdered, Product productOrdered) {
        this.quantityOrdered = quantityOrdered;
        this.orderedProduct = productOrdered;
        this.subTotal = quantityOrdered * orderedProduct.getPrice();
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public Product getOrderedProduct() {
        return orderedProduct;
    }

    public double getSubTotal() {
        return subTotal;
    }
}
