package by.fyodorov.informationhandling.interpretator;

/**
 * interface any element in Expression tree
 */
public interface Expression {

    /**
     * execute operation by yourself or between left and right subtrees
     * @return result of operation
     */
    int interpret();
}
