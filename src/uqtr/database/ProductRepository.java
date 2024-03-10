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
                return  product;
            }
        }
        System.out.println("Produit non trouvé !");
        return null;
    }

    //TODO : Bouger dans terminal?
    public void showAll(){
        for (Product product : products){
            System.out.println(product.getName() + " " + product.getUnitPrice() + "$" + "\n");
        }
    }

    public void remove(String name){
        Product productToRemove = find(name);
        if (productToRemove != null){
            products.remove(productToRemove);
            System.out.println("Produit retiré !");
        }else{
            System.out.println("Erreur : Produit non trouvé");
        }
    }

    //Package constructor, only Database should instantiate this class
    ProductRepository() {
        products = new ArrayList<>();
    }

}