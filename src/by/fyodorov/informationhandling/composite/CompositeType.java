package by.fyodorov.informationhandling.composite;

/**
 * enum of types of nodes in Composite pattern:
 *         TEXT - root for full text
 *    PARAGRAPH - root of any paragraph in text
 *     SENTENCE - root of any sentence in paragraph
 *       LEXEME - root of any word in sentence
 *         LEAF - end element. Contains character in word
 */
public enum CompositeType {
    TEXT, PARAGRAPH, SENTENCE, LEXEME, LEAF
}
