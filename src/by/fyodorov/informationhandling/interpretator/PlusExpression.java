package by.fyodorov.informationhandling.interpretator;

/**
 * class of plus node of expression (+)
 */
public class PlusExpression implements Expression {
    private Expression left;
    private Expression right;

    public PlusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * execute operation(+) between left and right subtrees
     * @return result of operation(+)
     */
    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}
