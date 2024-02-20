import java.util.ArrayList;

public class ProductRepository{
    private ArrayList<Product> productList = new ArrayList<Product>();

    public void addToList(Product product){
        productList.add(product);
    }

    public Product findProduct(String name){
        for (Product product : productList){
            if (product.getName().equals(name)){
                return  product;
            }
        }
        System.out.println("Product not found !");
        return null;
    }

    public void showAllProduct(){
        for (Product product : productList){
            System.out.println(product.getName() + " " + product.getPrice() + "$" + "\n");
        }
    }

    public void removeProduct(String name){
        Product productToRemove = findProduct(name);
        if (productToRemove != null){
            productList.remove(productToRemove);
            System.out.println("Product removed !");
        }else{
            System.out.println("Product not found. No deletion has been made");
        }
    }

}