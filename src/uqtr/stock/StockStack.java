package uqtr.stock;

import uqtr.models.product.ProductUnit;

import java.util.EmptyStackException;
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

    @Override //On pourrait seulement utiliser size(), mais voici une façon récursive pour le TP
    public int getCount() {
        var stackCopy = new Stack<ProductUnit>();
        stackCopy.addAll(stack);
        return countStackDepth(0, stackCopy);
    }

    private int countStackDepth(int count, Stack<ProductUnit> stackCopy) {
        try {
            stackCopy.pop(); //Throws error if stack is empty
            return countStackDepth(++count, stackCopy);
        } catch (EmptyStackException e) {
            return count;
        }
    }

    @Override
    public void removeQuantity(int quantity) {
        for (int i = 0; i < quantity; i++) {
            stack.pop();
        }
    }
}
