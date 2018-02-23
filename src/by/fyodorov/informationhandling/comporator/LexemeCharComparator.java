package by.fyodorov.informationhandling.comporator;

import by.fyodorov.informationhandling.composite.Compositely;
import java.util.Comparator;

import static by.fyodorov.informationhandling.composite.CompositeType.LEXEME;

/**
 * class for comparing lexemes by count of char in lexemes or by Alphabetic order
 */
public class LexemeCharComparator implements Comparator<Compositely> {
    private char symbol;

    public LexemeCharComparator(char symbol) {
        this.symbol = symbol;
    }

    /**
     * comparing 2 lexemes by count of symbol and then by Alphabetic
     * @param o1 - first lexeme
     * @param o2 - second lexeme
     * @return   1 - 2-nd lexeme contain symbol more count then 1-st. Or if counts was equals - 2-nd lexeme more by Alphabetic order
     *          -1 - 1-st lexeme contain symbol more count then 2-nd. Or if counts was equals - 1-st lexeme more by Alphabetic order
     *           0 - 1-st and 2-nd lexemes was equals
     */
    @Override
    public int compare(Compositely o1, Compositely o2) {
        if (LEXEME.equals(o1.getType()) && LEXEME.equals(o2.getType())) {
            String str2 = o2.toString();
            String str1 = o1.toString();
            int byCount = Integer.compare(charCount(str2), charCount(str1));
            if (byCount == 0) {
                if (str2.equals(str1)) {
                    return 0;
                }
                return str2.compareTo(str1);
            }
            return byCount;
        }
        return -1;
    }

    /**
     * find count of symbol in string
     * @param str - string fore finding
     * @return count of contain symbol in this string
     */
    private int charCount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == symbol) {
                count++;
            }
        }
        return count;
    }
}
