package by.fyodorov.informationhandling.interpretator;

public class DevisionExpression implements Expression {
    private Expression left;
    private Expression right;

    public DevisionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() / right.interpret();
    }
}
