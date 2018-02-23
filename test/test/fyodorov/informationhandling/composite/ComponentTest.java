package test.fyodorov.informationhandling.composite;

import by.fyodorov.informationhandling.composite.CompositeLeaf;
import by.fyodorov.informationhandling.composite.CompositeType;
import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.composite.TextCompositeComponent;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ComponentTest {

    @Test
    public void testExecute() {
        TextCompositeComponent component = new TextCompositeComponent(CompositeType.TEXT);
        TextCompositeComponent component1 = new TextCompositeComponent(CompositeType.TEXT);
        TextCompositeComponent component2 = new TextCompositeComponent(CompositeType.TEXT);
        TextCompositeComponent component3 = new TextCompositeComponent(CompositeType.TEXT);
        TextCompositeComponent component4 = new TextCompositeComponent(CompositeType.TEXT);
        TextCompositeComponent component5 = new TextCompositeComponent(CompositeType.TEXT);
        TextCompositeComponent component6 = new TextCompositeComponent(CompositeType.TEXT);

        Compositely leaf = new CompositeLeaf('A');
        Compositely leaf1 = new CompositeLeaf('l');
        Compositely leaf2 = new CompositeLeaf('e');
        Compositely leaf3 = new CompositeLeaf('x');
        Compositely leaf4 = new CompositeLeaf('e');
        Compositely leaf5 = new CompositeLeaf('y');

        component.addChild(component1);
        component.addChild(component2);
        component.addChild(component3);
        component1.addChild(component4);
        component1.addChild(component5);
        component2.addChild(component6);

        component4.addChild(leaf);
        component4.addChild(leaf1);
        component4.addChild(leaf2);
        component5.addChild(leaf3);
        component6.addChild(leaf4);
        component6.addChild(leaf5);

        assertEquals(component.toString(), "Alexey");
    }
}