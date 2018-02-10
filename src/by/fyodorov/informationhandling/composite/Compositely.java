package by.fyodorov.informationhandling.composite;

import java.util.LinkedList;

public interface Compositely {
    void addChild(Compositely child);
    LinkedList<Compositely> getChildrens();
    void addChildList(LinkedList<Compositely> childrens);
}
