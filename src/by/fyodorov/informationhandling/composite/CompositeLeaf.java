package by.fyodorov.informationhandling.composite;

import java.util.LinkedList;

public class CompositeLeaf implements Compositely {
    private char part;

    public CompositeLeaf(char part) {
        this.part = part;
    }

    @Override
    public void addChild(Compositely child) {
    }

    @Override
    public LinkedList<Compositely> getChildrens() {
        return null;
    }

    @Override
    public void addChildList(LinkedList<Compositely> childrens) {
    }

    @Override
    public String toString() {
        return Character.toString(part);
    }
}
