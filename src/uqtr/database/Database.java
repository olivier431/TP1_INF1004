package uqtr.database;

public class Database {

    private ProductRepository products;
    private static Database instance;

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public ProductRepository getProductRepository() {
        return products;
    }

    private Database() {
        products = new ProductRepository();
    } //Private for singleton
}
