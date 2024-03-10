package uqtr.stock;

import uqtr.models.ProductUnit;

public abstract class StockRow {
    public abstract ProductUnit pop();
    public abstract void push(ProductUnit unit);
    public abstract int getCount();

    public abstract void removeQuantity(int quantity);

}
