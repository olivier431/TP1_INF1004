package uqtr.management;

import uqtr.database.Database;
import uqtr.database.ProductRepository;
import uqtr.helpers.Terminal;
import uqtr.models.product.Product;

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
        System.out.print("Le produit est-il périssable ? [O/N] : ");
        var perishableInput = Terminal.readStringInput();
        products.add(new Product(name, price, perishableInput.equalsIgnoreCase("O")));
        System.out.println("Produit ajouté!");
    }

    public void remove() {
        System.out.print("Entrer le nom du produit à retirer: ");
        var name = Terminal.readStringInput();
        var product = products.find(name);
        if (product == null) {
            System.out.println("Erreur : Impossible de trouver le produit");
            return;
        }
        products.remove(product);
        System.out.println("Produit retiré!");
    }

    public void update() {
        System.out.print("Entrer le nom du produit à modifier: ");
        var name = Terminal.readStringInput();
        var productToUpdate = products.find(name);
        if (productToUpdate == null) {
            System.out.println("Erreur : Impossible de trouver le produit");
            return;
        }
        System.out.print("Entrer le nouveau nom: ");
        var newName = Terminal.readStringInput();
        System.out.print("Entrer le nouveau prix: ");
        var newPrice = Terminal.readDoubleInput();
        productToUpdate.setName(newName);
        productToUpdate.setUnitPrice(newPrice);
        System.out.println("Produit modifié!");
    }

    public void readAll() {
        if (products.findAll().size() == 0) {
            System.out.println("Aucun produit disponible");
        }
        for (var product : products.findAll()) {
            System.out.printf("%s (%.2f$)\n", product.getName(), product.getUnitPrice());
        }
    }
}
