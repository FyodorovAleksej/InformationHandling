package test.fyodorov.informationhandling.composite;

import by.fyodorov.informationhandling.composite.TextCompositeComponent;
import by.fyodorov.informationhandling.composite.CompositeLeaf;
import by.fyodorov.informationhandling.composite.Compositely;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ComponentTest {

    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }


    @Test
    public void testExecute() throws Exception {
        TextCompositeComponent component = new TextCompositeComponent();
        TextCompositeComponent component1 = new TextCompositeComponent();
        TextCompositeComponent component2 = new TextCompositeComponent();
        TextCompositeComponent component3 = new TextCompositeComponent();
        TextCompositeComponent component4 = new TextCompositeComponent();
        TextCompositeComponent component5 = new TextCompositeComponent();
        TextCompositeComponent component6 = new TextCompositeComponent();

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