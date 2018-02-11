package by.fyodorov.informationhandling.interpretator;

public class StaticArguments {
    private static volatile StaticArguments instance;

    private int i;
    private int j;

    private StaticArguments() {
    }

    public static StaticArguments getInstance() {
        if (instance == null) {
            synchronized (StaticArguments.class) {
                if (instance == null) {
                    instance = new StaticArguments();
                }
            }
        }
        return instance;
    }

    public void initialize(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }
    public void incrementI() {
        i++;
    }

    public int getJ() {
        return j;
    }

    public void incrmentJ() {
        j++;
    }
}
