package by.fyodorov.informationhandling.interpretator;

public class Context {

    public Expression evaluate(String s) {
        int pos = s.length() - 1;
        while (pos > 0) {
            if (Character.isDigit(s.charAt(pos))) {
                pos--;
            }
            else {
                Expression left = evaluate(s.substring(0, pos));
                Expression right = new NumericExpression(Integer.valueOf(s.substring(pos + 1, s.length())));
                char operation = s.charAt(pos);
                switch (operation) {
                    case '+': return new PlusExpression(left, right);
                    case '-': return new MinusExpression(left, right);
                    case '*': return new MultiplyExpression(left, right);
                    case '/': return new DevisionExpression(left, right);
                }
            }
        }
        int result = Integer.valueOf(s);
        return new NumericExpression(result);
    }
}
