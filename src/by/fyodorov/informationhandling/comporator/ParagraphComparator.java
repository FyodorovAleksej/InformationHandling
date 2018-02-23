package by.fyodorov.informationhandling.comporator;

import by.fyodorov.informationhandling.composite.Compositely;
import java.util.Comparator;

import static by.fyodorov.informationhandling.composite.CompositeType.PARAGRAPH;

/**
 * class for comparing paragraphs by count of sentences
 */
public class ParagraphComparator implements Comparator<Compositely>{

    /**
     * comparing 2 paragraphs by count of sentences
     * @param o1 - first paragraph
     * @param o2 - second paragraph
     * @return   1 - 1-st paragraph contain more sentences
     *          -1 - 2-nd paragraph contain more sentences
     *           0 - 1-st and 2-nd paragraph contain equal count of sentences
     */
    @Override
    public int compare(Compositely o1, Compositely o2) {
        if (PARAGRAPH.equals(o1.getType()) && PARAGRAPH.equals(o2.getType())) {
            return Integer.compare(o1.getChildes().size(), o2.getChildes().size());
        }
        return -1;
    }
}
