package by.fyodorov.informationhandling.composite;

import by.fyodorov.informationhandling.comporator.LexemeCharComparator;
import by.fyodorov.informationhandling.comporator.ParagraphComparator;
import by.fyodorov.informationhandling.comporator.WordLengthComparator;

import java.util.LinkedList;

/**
 * class of any node in Composite pattern
 */
public class TextCompositeComponent implements Compositely {
    private CompositeType type;
    private LinkedList<Compositely> childes;

    public TextCompositeComponent(CompositeType type) {
        this.type = type;
        childes = new LinkedList<>();
    }

    /**
     * adding child for this node
     * @param child child node
     */
    @Override
    public void addChild(Compositely child) {
        childes.add(child);
    }

    /**
     * get list of childes for current node. *Modified
     * @return list of childes
     */
    @Override
    public LinkedList<Compositely> getChildes() {
        return childes;
    }

    /**
     * getting type of current node
     * @return TEXT - root for full text
     *    PARAGRAPH - root of any paragraph in text
     *     SENTENCE - root of any sentence in paragraph
     *       LEXEME - root of any word in sentence
     */
    @Override
    public CompositeType getType() {
        return type;
    }

    /**
     * sorting paragraphs in text by count of sentences
     */
    @Override
    public void sortParagraphs() {
        if (CompositeType.TEXT.ordinal() == getType().ordinal()) {
            childes.sort(new ParagraphComparator());
        }
    }

    /**
     * sorting lexemes in sentences by it size
     */
    @Override
    public void sortWords() {
        if (CompositeType.SENTENCE.ordinal() > getType().ordinal()) {
            for (Compositely i : childes) {
                i.sortWords();
            }
        }
        else {
            if (CompositeType.SENTENCE.equals(getType())) {
                childes.sort(new WordLengthComparator());
            }
        }
    }

    /**
     * sorting lexemes in sentences by count of contain symbol
     * @param symbol - char for calculating counts in any lexeme
     */
    @Override
    public void sortLexemes(char symbol) {
        if (CompositeType.SENTENCE.ordinal() > getType().ordinal()) {
            for (Compositely i : childes) {
                i.sortLexemes(symbol);
            }
        }
        else {
            if (CompositeType.SENTENCE.equals(getType())) {
                childes.sort(new LexemeCharComparator(symbol));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Compositely i : childes) {
            builder.append(i.toString());
        }
        return builder.toString();
    }
}
