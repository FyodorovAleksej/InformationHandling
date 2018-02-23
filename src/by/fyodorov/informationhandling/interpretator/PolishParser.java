package by.fyodorov.informationhandling.interpretator;

import java.util.ArrayDeque;

/**
 * class for transform int expression from string to polish notation
 */
public class PolishParser {
    private final static String POSTFIX_EXPRESSION = "[ij][+\\-]{2}";
    private final static String PREFIX_EXPRESSION = "[\\-+]{2}[ij]";
    private final static String ARITHMETIC_EXPRESSION = "(" + POSTFIX_EXPRESSION + ")|(" + PREFIX_EXPRESSION + ")";

    private final static int ARITHMETIC_LENGTH = 3;

    /**
     * transform string to polish notation
     * @param raw input string for transforming
     * @return polish notation
     */
    public String toPolish(String raw) {
        StringBuilder result = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < raw.length(); i++) {
            if (raw.charAt(i) == ')') {
                while (!"(".equals(stack.getFirst())) {
                    result.append(stack.pop()).append(" ");
                }
                stack.pop();
            }
            int pos = i;
            while (pos < raw.length() && Character.isDigit(raw.charAt(pos))) {
                pos++;
            }
            if (pos != i) {
                result.append(raw.substring(i, pos)).append(" ");
                i = pos - 1;
            }
            if (raw.charAt(i) == '(') {
                stack.push("(");
            }
            if (raw.charAt(i) == '+' || raw.charAt(i) == '-' || raw.charAt(i) == '*' || raw.charAt(i) == '/' || raw.charAt(i) == ' ') {
                if (raw.charAt(i) == ' ') {
                    String expression = raw.substring(i + 1, i + ARITHMETIC_LENGTH + 1);
                    if (expression.matches(ARITHMETIC_EXPRESSION)) {
                        result.append(expression).append(" ");
                        i += ARITHMETIC_LENGTH + 1;
                    }
                } else {
                    addOperation(stack, result, String.valueOf(raw.charAt(i)));
                }
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }
        return result.toString();
    }

    private void addOperation(ArrayDeque<String> stack, StringBuilder result, String operation) {
        if (stack.isEmpty()) {
            stack.push(operation);
        } else {
            if (prior(stack.getFirst()) < prior(operation)) {
                stack.push(operation);
            } else {
                while (!stack.isEmpty() && (prior(stack.getFirst()) >= prior(operation))) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(operation);
            }
        }
    }

    /**
     * getting priority of operation
     * @param operation operator
     * @return priority of input operator
     */
    private int prior(String operation) {
        switch (operation) {
            case "*": { return 4;}
            case "/": { return 4;}
            case "+": { return 3;}
            case "-": { return 3;}
            case "(": { return 1;}
            default:  {
                if (operation.matches(PREFIX_EXPRESSION)) {
                    return 5;
                }
                if (operation.matches(POSTFIX_EXPRESSION)) {
                    return 2;
                }
                return 0;
            }
        }
    }
}
