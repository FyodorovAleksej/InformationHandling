package by.fyodorov.informationhandling.comporator;

import by.fyodorov.informationhandling.composite.Compositely;
import java.util.Comparator;

import static by.fyodorov.informationhandling.composite.CompositeType.LEXEME;

/**
 * class for comparing words by size
 */
public class WordLengthComparator implements Comparator<Compositely> {

    /**
     * comparing 2 lexemes by size
     * @param o1 - first paragraph
     * @param o2 - second paragraph
     * @return   1 - 1-st lexeme's length is bigger than 2-nd lexeme's length
     *          -1 - 2-nd lexeme's length is bigger than 1-st lexeme's length
     *           0 - 1-st and 2-nd lexeme's length was equals
     */
    @Override
    public int compare(Compositely o1, Compositely o2) {
        if (LEXEME.equals(o1.getType()) && LEXEME.equals(o2.getType())) {
            return Integer.compare(o1.toString().length(), o2.toString().length());
        }
        return -1;
    }
}
