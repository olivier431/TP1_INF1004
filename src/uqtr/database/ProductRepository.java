package uqtr.database;

import uqtr.models.Product;

import java.util.ArrayList;

public class ProductRepository {
    private final ArrayList<Product> productList;

    public void add(Product product){
        productList.add(product);
    }

    public Product find(String name){
        for (Product product : productList){
            if (product.getName().equalsIgnoreCase(name)){
                return  product;
            }
        }
        System.out.println("Produit non trouvé !");
        return null;
    }

    //TODO : Bouger dans terminal
    public void showAll(){
        for (Product product : productList){
            System.out.println(product.getName() + " " + product.getPrice() + "$" + "\n");
        }
    }

    public void remove(String name){
        Product productToRemove = find(name);
        if (productToRemove != null){
            productList.remove(productToRemove);
            System.out.println("Produit retiré !");
        }else{
            System.out.println("Erreur : Produit non trouvé");
        }
    }

    //Package constructor, only Database should instantiate this class
    ProductRepository() {
        productList = new ArrayList<>();
    }

}