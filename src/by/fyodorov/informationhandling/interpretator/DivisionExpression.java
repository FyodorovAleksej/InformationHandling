package by.fyodorov.informationhandling.interpretator;

/**
 * class of division node of expression (/)
 */
public class DivisionExpression implements Expression {
    private Expression left;
    private Expression right;

    public DivisionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * execute operation(/) between left and right subtrees
     * @return result of operation(/)
     */
    @Override
    public int interpret() {
        return left.interpret() / right.interpret();
    }
}
