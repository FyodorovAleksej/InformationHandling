package by.fyodorov.informationhandling.interpretator;

/**
 * class with arguments for all text (i and j initializing). Singleton
 */
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

    /**
     * setup start value for i and j values
     * @param i - setup value for i
     * @param j - setup value for j
     */
    public void initialize(int i, int j) {
        this.i = i;
        this.j = j;
    }

    /**
     * getting i value
     * @return i
     */
    public int getI() {
        return i;
    }

    /**
     * incrementing value of I
     */
    public void incrementI() {
        i++;
    }

    /**
     * decrementing value of I
     */
    public void decrementI() {
        i--;
    }

    /**
     * getting j value
     * @return j
     */
    public int getJ() {
        return j;
    }

    /**
     * incrementing value of J
     */
    public void incrementJ() {
        j++;
    }

    /**
     * decrementing value of J
     */
    public void decrementJ() {
        j--;
    }
}
