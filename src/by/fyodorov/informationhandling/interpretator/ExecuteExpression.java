package by.fyodorov.informationhandling.interpretator;

public class ExecuteExpression implements Expression {
    final static String POSTFIKS_EXPRESSION = "[ij][+\\-]{2}";
    final static String PREFIKS_EXPRESSION = "[\\-+]{2}[ij]";
    private String expression;

    public ExecuteExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public int interpret() {
        if (expression.matches(POSTFIKS_EXPRESSION)) {
            if (expression.indexOf('-') != -1) {
                if (expression.indexOf('i') != -1) {
                    int i = StaticArguments.getInstance().getI();
                    StaticArguments.getInstance().decrementI();
                    return i;
                }
                if (expression.indexOf('j') != -1) {
                    int j = StaticArguments.getInstance().getJ();
                    StaticArguments.getInstance().decrementJ();
                    return j;
                }
            }

            if (expression.indexOf('+') != -1) {
                if (expression.indexOf('i') != -1) {
                    int i = StaticArguments.getInstance().getI();
                    StaticArguments.getInstance().incrementI();
                    return i;
                }
                if (expression.indexOf('j') != -1) {
                    int j = StaticArguments.getInstance().getJ();
                    StaticArguments.getInstance().incrementJ();
                    return j;
                }
            }
        }
        if (expression.matches(PREFIKS_EXPRESSION)) {
            if (expression.indexOf('-') != -1) {
                if (expression.indexOf('i') != -1) {
                    StaticArguments.getInstance().decrementI();
                    return StaticArguments.getInstance().getI();
                }
                if (expression.indexOf('j') != -1) {
                    StaticArguments.getInstance().decrementJ();
                    return StaticArguments.getInstance().getJ();
                }
            }

            if (expression.indexOf('+') != -1) {
                if (expression.indexOf('i') != -1) {
                    StaticArguments.getInstance().incrementI();
                    return StaticArguments.getInstance().getI();
                }
                if (expression.indexOf('j') != -1) {
                    StaticArguments.getInstance().incrementJ();
                    return StaticArguments.getInstance().getJ();
                }
            }
        }

        return 0;
    }
}
