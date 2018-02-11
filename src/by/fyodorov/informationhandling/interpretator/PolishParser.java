package by.fyodorov.informationhandling.interpretator;

import java.util.Stack;

public class PolishParser {
    final static String POSTFIKS_EXPRESSION = "\\s[ij][+\\-]{2}\\s";
    final static String PREFIKS_EXPRESSION = " \\s[\\-+]{2}[ij]\\s";
    final static String ARIPMETIC_EXPRESSION = "(" + POSTFIKS_EXPRESSION + ")|(" + PREFIKS_EXPRESSION + ")";

    final static int ARIPMETIC_LENGTH = 5;

    public String toPolish(String s) {
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<String>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                while (!stack.lastElement().equals("(")) {
                    result.append(stack.pop()).append(" ");
                }
                stack.pop();
            }
            int pos = i;
            while (pos < s.length() && Character.isDigit(s.charAt(pos))) {
                pos++;
            }
            if (pos != i) {
                result.append(s.substring(i, pos)).append(" ");
                i = pos - 1;
            }
            if (s.charAt(i) == '(') {
                stack.push("(");
            }
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == ' ') {
                if (s.charAt(i) == ' ') {
                    String expression = s.substring(i, i + ARIPMETIC_LENGTH);
                    if (expression.matches(ARIPMETIC_EXPRESSION)) {
                        //Pattern pattern = Pattern.compile("[ij]");
                        //Matcher matcher = pattern.matcher(expression);
                        //if (matcher.find()) {
                        //    result.append(matcher.)
                        //}
                        result.append("i").append(" ");
                        addOperation(stack, result, expression);
                        i += ARIPMETIC_LENGTH - 1;
                    }
                } else {
                    addOperation(stack, result, String.valueOf(s.charAt(i)));
                }
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }
        return result.toString();
    }

    private void addOperation(Stack<String> stack, StringBuilder result, String operation) {
        if (stack.isEmpty()) {
            stack.push(operation);
        } else {
            if (prior(stack.lastElement()) < prior(operation)) {
                stack.push(operation);
            } else {
                while (!stack.isEmpty() && (prior(stack.lastElement()) >= prior(operation))) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(operation);
            }
        }
    }

    private int prior(String operation) {
        switch (operation) {
            case "*": { return 4;}
            case "/": { return 4;}
            case "+": { return 3;}
            case "-": { return 3;}
            case "(": { return 1;}
            default:  {
                System.out.println("");
                if (operation.matches(PREFIKS_EXPRESSION)) {
                    return 5;
                }
                if (operation.matches(POSTFIKS_EXPRESSION)) {
                    return 2;
                }
                return 0;
            }
        }
    }
}
