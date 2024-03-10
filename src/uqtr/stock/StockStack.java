package uqtr.stock;

import uqtr.models.ProductUnit;

import java.util.Stack;

public class StockStack extends StockRow {
    private final Stack<ProductUnit> stack;

    public StockStack() {
        this.stack = new Stack<>();
    }

    @Override
    public ProductUnit pop() {
        return stack.pop();
    }

    @Override
    public void push(ProductUnit unit) {
        stack.push(unit);
    }

    @Override
    public int getCount() {
        return stack.size();
    }

    @Override
    public void removeQuantity(int quantity) {
        for (int i = 0; i < quantity; i++) {
            stack.pop();
        }
    }
}
