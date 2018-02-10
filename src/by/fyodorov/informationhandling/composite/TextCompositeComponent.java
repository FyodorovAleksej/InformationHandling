package by.fyodorov.informationhandling.composite;

import java.util.LinkedList;

public class TextCompositeComponent implements Compositely {
    private LinkedList<Compositely> childs;

    public TextCompositeComponent() {
        childs = new LinkedList<Compositely>();
    }

    @Override
    public void addChild(Compositely child) {
        childs.add(child);
    }

    @Override
    public LinkedList<Compositely> getChildrens() {
        return childs;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Compositely i : childs) {
            builder.append(i.toString());
        }
        return builder.toString();
    }

    @Override
    public void addChildList(LinkedList<Compositely> childrens) {
        childs.addAll(childrens);
    }
}
