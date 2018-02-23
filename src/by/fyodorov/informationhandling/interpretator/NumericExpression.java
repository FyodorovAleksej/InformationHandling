package by.fyodorov.informationhandling.interpretator;

/**
 * class of numeric element in Expression tree
 */
public class NumericExpression implements Expression {
    private int number;

    public NumericExpression(int number) {
        this.number = number;
    }

    /**
     * getting yourself
     * @return numeric value of yourself
     */
    @Override
    public int interpret() {
        return number;
    }
}
