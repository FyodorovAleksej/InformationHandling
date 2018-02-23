package by.fyodorov.informationhandling.composite;

import java.util.LinkedList;

/**
 * end element of Composite pattern
 */
public class CompositeLeaf implements Compositely {
    private char part;

    public CompositeLeaf(char part) {
        this.part = part;
    }

    /**
     * adding child for this node. For leaf - nothing to do
     * @param child child node
     */
    @Override
    public void addChild(Compositely child) {
    }

    /**
     * get list of childes for current node. *Modified.
     * @return list of childes. For Leaf - return null
     */
    @Override
    public LinkedList<Compositely> getChildes() {
        return null;
    }

    /**
     * getting type of current node
     * @return LEAF - end element. Contains character in word
     */
    @Override
    public CompositeType getType() {
        return CompositeType.LEAF;
    }

    /**
     * sorting paragraphs in text by count of sentences. For Leaf - doing nothing
     */
    @Override
    public void sortParagraphs() {
    }

    /**
     * sorting lexemes in sentences by it size. For Leaf - doing nothing
     */
    @Override
    public void sortWords() {
    }

    /**
     * sorting lexemes in sentences by count of contain symbol. For Leaf - doing nothing
     * @param symbol - char for calculating counts in any lexeme
     */
    @Override
    public void sortLexemes(char symbol) {
    }

    @Override
    public String toString() {
        return Character.toString(part);
    }
}
