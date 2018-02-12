package by.fyodorov.informationhandling.interpretator;

public class AriphmeticExpression implements Expression {
    private String ariphmeticExpression;

    public AriphmeticExpression(String ariphmeticExpression) {
        this.ariphmeticExpression = ariphmeticExpression;
    }

    @Override
    public int interpret() {
        StaticArguments arguments = StaticArguments.getInstance();
        switch (ariphmeticExpression) {
            case "i": { return arguments.getI();}
            case "j": { return arguments.getJ();}
            default: { return 0;}
        }
    }
}
