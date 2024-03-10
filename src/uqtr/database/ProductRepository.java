package uqtr.database;

import uqtr.models.product.Product;

import java.util.ArrayList;

public class ProductRepository {
    private final ArrayList<Product> products;

    public void add(Product product){
        products.add(product);
    }

    public Product find(String name){
        for (Product product : products){
            if (product.getName().equalsIgnoreCase(name)){
                return product;
            }
        }
        return null;
    }

    public ArrayList<Product> findAll(){
        return products;
    }

    public void remove(Product product){
        products.remove(product);
    }

    ProductRepository() {
        products = new ArrayList<>();
    }
}