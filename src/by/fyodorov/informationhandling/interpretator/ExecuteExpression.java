package by.fyodorov.informationhandling.interpretator;

/**
 * class of executable element of expression ((i|j)(++|--) | (++|--)(i|j))
 */
public class ExecuteExpression implements Expression {
    private final static String POSTFIX_EXPRESSION = "[ij][+\\-]{2}";
    private final static String PREFIX_EXPRESSION = "[\\-+]{2}[ij]";
    private String expression;

    public ExecuteExpression(String expression) {
        this.expression = expression;
    }

    /**
     * execute operation of increment or decrement and return result.
     * executing can be activate before getting value or after getting value;
     * @return result of operation
     */
    @Override
    public int interpret() {
        if (expression.matches(POSTFIX_EXPRESSION)) {
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
        if (expression.matches(PREFIX_EXPRESSION)) {
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
