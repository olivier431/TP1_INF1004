package uqtr.management;

import uqtr.database.Database;
import uqtr.database.ProductRepository;
import uqtr.helpers.Terminal;
import uqtr.models.Product;

public class ProductManagement {

    private final ProductRepository products;

    public ProductManagement() {
        products = Database.getInstance().getProductRepository();
    }

    public void add() {
        System.out.print("Entrer le nom du nouveau produit: ");
        String name = Terminal.readStringInput();
        System.out.print("Entrer le prix: ");
        var price = Terminal.readDoubleInput();
        if (price <= 0) {
            System.out.println("Erreur : Le prix doit être un nombre réel positif");
        }
        System.out.println("Le produit est-il périssable ? [O/N] : ");
        var perishableInput = Terminal.readStringInput();
        products.add(new Product(name, price, perishableInput.equalsIgnoreCase("O")));
        System.out.println("Produit ajouté!");
    }

    public void remove() {
        System.out.print("Entrer le nom du produit à retirer: ");
        String name = Terminal.readStringInput();
        products.remove(name);
        System.out.println("Produit retiré!");
    }

    public void update() {
        System.out.print("Entrer le nom du produit à modifier: ");
        String name = Terminal.readStringInput();
        Product productToUpdate = products.find(name);
        if (productToUpdate != null) {
            System.out.print("Entrer le nouveau nom: ");
            String newName = Terminal.readStringInput();
            System.out.print("Entrer le nouveau prix: ");
            var newPrice = Terminal.readDoubleInput();
            productToUpdate.setName(newName);
            productToUpdate.setPrice(newPrice);
            System.out.println("Produit modifié!");
        }
    }

    public void readAll() {
        //todo
    }
}
