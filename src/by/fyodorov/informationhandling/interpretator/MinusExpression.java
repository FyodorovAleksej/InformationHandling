package by.fyodorov.informationhandling.interpretator;

/**
 * class of minus node of expression (-)
 */
public class MinusExpression implements Expression {
    private Expression left;
    private Expression right;

    public MinusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * execute operation(-) between left and right subtrees
     * @return result of operation(-)
     */
    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}
