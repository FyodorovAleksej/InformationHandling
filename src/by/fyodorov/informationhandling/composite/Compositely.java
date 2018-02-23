package by.fyodorov.informationhandling.composite;

import java.util.LinkedList;

/**
 * interface for any element in Composite pattern
 */
public interface Compositely {

    /**
     * adding child node for current node
     * @param child - node for adding
     */
    void addChild(Compositely child);

    /**
     * get list of childes for current node. *Modified
     * @return list of childes
     */
    LinkedList<Compositely> getChildes();

    /**
     * getting type of current node
     * @return Enum: TEXT - root for full text
     *          PARAGRAPH - root of any paragraph in text
     *           SENTENCE - root of any sentence in paragraph
     *             LEXEME - root of any word in sentence
     *               LEAF - end element. Contains character in word
     */
    CompositeType getType();

    /**
     * sorting paragraphs in text by count of sentences
     */
    void sortParagraphs();

    /**
     * sorting lexemes in sentences by it size
     */
    void sortWords();

    /**
     * sorting lexemes in sentences by count of contain symbol
     * @param symbol - char for calculating counts in any lexeme
     */
    void sortLexemes(char symbol);
}
