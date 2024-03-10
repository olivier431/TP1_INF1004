package uqtr;

import uqtr.database.Database;
import uqtr.models.order.Order;

import java.util.*;

public class ReportGenerator {
    public void printSalesReport() {
        var sales = Database.getInstance().getSaleRepository().findAll();
        if (sales.size() == 0 ) {
            System.out.println("Aucune vente disponible.");
        }
        for (var sale : sales) {
            printSale(sale);
        }
    }

    public void printBestSellingReport() {
        var sales = Database.getInstance().getSaleRepository().findAll();
        if (sales.size() == 0) {
            System.out.println("Aucune vente disponible.");
            return;
        }
        var productsSold = calculateBestSellers(sales);
        var productsOrderedByNumberSoldDesc = productsSold.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        int i = 0;
        System.out.println("Produits les plus vendus : ");
        for (var bestSeller : productsOrderedByNumberSoldDesc.toList()) {
            if (bestSeller.getValue() == 0) return;
            System.out.printf("%d: %s (Vendu %d fois)\n", ++i, bestSeller.getKey(), bestSeller.getValue());
        }
    }

    private HashMap<String, Integer> calculateBestSellers(ArrayList<Order> sales) {
        var productsSold = new HashMap<String, Integer>();
        for (var sale : sales) {
            for (var row : sale.getAllRows()) {
                var productName = row.getOrderedProduct().getName();
                int currentAmountSold = 0;
                if (productsSold.containsKey(productName)) {
                    currentAmountSold = productsSold.get(productName);
                }
                productsSold.put(productName, currentAmountSold + row.getQuantityOrdered());
            }
        }
        return productsSold;
    }

    public void printOutOfStockReport() {
        var products = Database.getInstance().getProductRepository().findAll();
        System.out.println("Produits hors stock : ");
        var hasAtLeastOneOutOfStock = false;
        for (var product: products) {
            if (product.getStock().getCount() != 0) continue;
            System.out.printf("%s (Quantité restante : 0)", product.getName());
            hasAtLeastOneOutOfStock = true;
        }
        System.out.println();
        if (!hasAtLeastOneOutOfStock) {
            System.out.println("Aucun produit hors stock !");
        }
    }

    private void printSale(Order sale) {
        System.out.printf("Vente (Total: %.2f$) : \n", sale.getTotal());
        for (var soldProduct : sale.getAllRows()) {
            System.out.printf("%s (%.2f$) x %d = %.2f$\n",
                    soldProduct.getOrderedProduct().getName(),
                    soldProduct.getOrderedProduct().getUnitPrice(),
                    soldProduct.getQuantityOrdered(),
                    soldProduct.getPrice());
        }
        System.out.println();
    }
}
