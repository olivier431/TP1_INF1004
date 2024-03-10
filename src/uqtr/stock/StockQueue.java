package uqtr.stock;

import uqtr.models.ProductUnit;

import java.util.LinkedList;
import java.util.Queue;

public class StockQueue extends StockRow {
    private final Queue<ProductUnit> queue;

    public StockQueue() {
        queue = new LinkedList<>();
    }

    @Override
    public ProductUnit pop() {
        return queue.remove();
    }

    @Override
    public void push(ProductUnit unit) {
        queue.add(unit);
    }

    @Override
    public int getCount() {
        return queue.size();
    }

    @Override
    public void removeQuantity(int quantity) {
        for (int i = 0; i < quantity; i++) {
            queue.remove();
        }
    }
}
