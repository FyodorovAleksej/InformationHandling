package by.fyodorov.informationhandling.interpretator;

import by.fyodorov.informationhandling.exception.TextException;

import java.util.Stack;

public class Context {

    public Expression evaluate(String s) throws TextException {
        String[] expressions = s.split(" ");
        Stack<Expression> stack = new Stack<Expression>();

        for (int i = 0; i < expressions.length; i++) {
            if (isAripmetic(expressions[i])) {
                executeAripmetic(expressions[i]);
            }
            if (isVariable(expressions[i])) {
                if (i + 1 < expressions.length && isAripmetic(expressions[i + 1])) {
                    executeAripmetic(expressions[i + 1]);
                    stack.push(new NumericExpression(getVariable(expressions[i])));
                    i++;
                    continue;
                } else {
                    stack.push(new NumericExpression(getVariable(expressions[i])));
                }
            }
            if (isNumber(expressions[i])) {
                stack.push(new NumericExpression(Integer.valueOf(expressions[i])));
            }

            if (isPlus(expressions[i])) {
                Expression right = stack.pop();
                Expression left = stack.pop();
                stack.push(new PlusExpression(left, right));
            }

            if (isMinus(expressions[i])) {
                Expression right = stack.pop();
                Expression left = stack.pop();
                stack.push(new MinusExpression(left, right));
            }

            if (isMultiply(expressions[i])) {
                Expression right = stack.pop();
                Expression left = stack.pop();
                stack.push(new MultiplyExpression(left, right));
            }

            if (isDivide(expressions[i])) {
                Expression right = stack.pop();
                Expression left = stack.pop();
                stack.push(new DevisionExpression(left, right));
            }
        }
        if (stack.size() > 1) {
            throw new TextException("Invalid Polish expression");
        }
        return stack.pop();
    }

    private boolean isNumber(String s) {
        final String NUMBER_EXPRESSION = "\\s?[0-9]+\\s?";
        return s.matches(NUMBER_EXPRESSION);
    }

    private boolean isMinus(String s) {
        final String MINUS_EXPRESSION = "\\s?\\-\\s?";
        return s.matches(MINUS_EXPRESSION);
    }

    private boolean isPlus(String s) {
        final String PLUS_EXPRESSION = "\\s?\\+\\s?";
        return s.matches(PLUS_EXPRESSION);
    }

    private boolean isMultiply(String s) {
        final String MULTIPLY_EXPRESSION = "\\s?\\*\\s?";
        return s.matches(MULTIPLY_EXPRESSION);
    }

    private boolean isDivide(String s) {
        final String DIVIDE_EXPRESSION = "\\s?\\/\\s?";
        return s.matches(DIVIDE_EXPRESSION);
    }

    private boolean isAripmetic(String s) {
        final String POSTFIKS_EXPRESSION = "[ij][+\\-]{2}";
        final String PREFIKS_EXPRESSION = "[\\-+]{2}[ij]";
        final String ARIPMETIC_EXPRESSION = "(" + POSTFIKS_EXPRESSION + ")|(" + PREFIKS_EXPRESSION + ")";
        return s.matches(ARIPMETIC_EXPRESSION);
    }

    private boolean isVariable(String s) {
        final String VARIABLE_EXPRESSION = "[ij]";
        return s.matches(VARIABLE_EXPRESSION);
    }

    private void executeAripmetic(String s) {
        if (s.indexOf('i') != -1) {
            if (s.indexOf('-') != -1) {
                StaticArguments.getInstance().decrementI();
            }
            if (s.indexOf('+') != -1) {
                StaticArguments.getInstance().incrementI();
            }
        }

        if (s.indexOf('j') != -1) {
            if (s.indexOf('-') != -1) {
                StaticArguments.getInstance().decrementJ();
            }
            if (s.indexOf('+') != -1) {
                StaticArguments.getInstance().incrementJ();
            }
        }
    }

    private int getVariable(String s) {
        if (s.indexOf('i') != -1) {
            return StaticArguments.getInstance().getI();
        }
        if (s.indexOf('j') != -1) {
            return StaticArguments.getInstance().getJ();
        }
        return 0;
    }
}
