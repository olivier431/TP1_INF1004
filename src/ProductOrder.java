public class ProductOrder {
    private int quantityOrdered;
    private Product productOrdered;


    public ProductOrder(int quantityOrdered, Product productOrdered) {
        if (quantityOrdered > productOrdered.getQuantity()){
            System.out.println("Error: Cannot order more quantity than available in stock.");
        }else{
            this.quantityOrdered = quantityOrdered;
            this.productOrdered = productOrdered;
            setNewQuantity(productOrdered, quantityOrdered);
        }

    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public Product getProductOrdered() {
        return productOrdered;
    }

    public void setProductOrdered(Product productOrdered) {
        this.productOrdered = productOrdered;
    }

    public void setNewQuantity(Product product, int quantityOrdered){
        int newQuantity = product.getQuantity() - quantityOrdered;
        product.setQuantity(newQuantity);
    }
}
