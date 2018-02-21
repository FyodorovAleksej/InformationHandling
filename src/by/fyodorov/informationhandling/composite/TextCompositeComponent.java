package by.fyodorov.informationhandling.composite;

import java.util.LinkedList;

public class TextCompositeComponent implements Compositely {
    private LinkedList<Compositely> childes;

    public TextCompositeComponent() {
        childes = new LinkedList<Compositely>();
    }

    @Override
    public void addChild(Compositely child) {
        childes.add(child);
    }

    @Override
    public LinkedList<Compositely> getChildrens() {
        return childes;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Compositely i : childes) {
            builder.append(i.toString());
        }
        return builder.toString();
    }

    @Override
    public void addChildList(LinkedList<Compositely> childrens) {
        childes.addAll(childrens);
    }
}
