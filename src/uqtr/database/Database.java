package uqtr.database;

public class Database {
    private final ProductRepository products;
    private final OrderRepository orders;
    private final SaleRepository sales;
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

    //Private for singleton
    private Database() {
        products = new ProductRepository();
        orders = new OrderRepository();
        sales = new SaleRepository();
    }

    public OrderRepository getOrderRepository() {
        return orders;
    }

    public SaleRepository getSaleRepository() {
        return sales;
    }
}
