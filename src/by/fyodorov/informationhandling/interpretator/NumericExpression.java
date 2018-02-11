package by.fyodorov.informationhandling.interpretator;

public class NumericExpression implements Expression {
    private int number;

    public NumericExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}
