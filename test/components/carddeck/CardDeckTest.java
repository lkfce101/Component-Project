package components.carddeck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CardDeckTest {

    private CardDeck constructorTest() {
        return new CardDeck1();
    }

    private CardDeck createFromArgs(String... args) {
        CardDeck d = this.constructorTest();
        for (String x : args) {
            d.add(x);
        }
        return d;
    }

    @Test
    public void testConstructorEmpty() {
        CardDeck d = this.constructorTest();
        assertEquals(0, d.size());
        assertTrue(d.isEmpty());
    }

    @Test
    public void testConstructorNoAlias() {
        CardDeck d1 = this.constructorTest();
        CardDeck d2 = d1.newInstance();

        assertNotSame(d1, d2);
        assertEquals(0, d2.size());
    }

    @Test
    public void testAddSingle() {
        CardDeck d = this.constructorTest();
        d.add("A");
        assertEquals(1, d.size());
        assertEquals("A", d.look(0));
    }

    @Test
    public void testAddMultiple() {
        CardDeck d = this.constructorTest();
        d.add("A");
        d.add("B");
        d.add("C");

        assertEquals(3, d.size());
        assertEquals("A", d.look(0));
        assertEquals("B", d.look(1));
        assertEquals("C", d.look(2));
    }

    @Test
    public void testAddFront() {
        CardDeck d = this.createFromArgs("B", "C");
        d.add("A", 0);

        assertEquals("A", d.look(0));
        assertEquals("B", d.look(1));
    }

    @Test
    public void testAddMiddle() {
        CardDeck d = this.createFromArgs("A", "C");
        d.add("B", 1);

        assertEquals("B", d.look(1));
        assertEquals(3, d.size());
    }

    @Test
    public void testAddEnd() {
        CardDeck d = this.createFromArgs("A", "B");
        d.add("C", 2);

        assertEquals("C", d.look(2));
    }

    @Test
    public void testRemoveToEmpty() {
        CardDeck d = this.createFromArgs("A");
        String removed = d.remove(0);

        assertEquals("A", removed);
        assertTrue(d.isEmpty());
    }

    @Test
    public void testRemoveFront() {
        CardDeck d = this.createFromArgs("A", "B", "C");
        String removed = d.remove(0);

        assertEquals("A", removed);
        assertEquals("B", d.look(0));
    }

    @Test
    public void testRemoveMiddle() {
        CardDeck d = this.createFromArgs("A", "B", "C");
        String removed = d.remove(1);

        assertEquals("B", removed);
        assertEquals("C", d.look(1));
    }

    @Test
    public void testRemoveEnd() {
        CardDeck d = this.createFromArgs("A", "B", "C");
        String removed = d.remove(2);

        assertEquals("C", removed);
        assertEquals(2, d.size());
    }

    @Test
    public void testLookSingle() {
        CardDeck d = this.createFromArgs("A");
        CardDeck copy = this.createFromArgs("A");

        assertEquals("A", d.look(0));
        assertTrue(d.equals(copy));
    }

    @Test
    public void testLookMiddle() {
        CardDeck d = this.createFromArgs("A", "B", "C");
        CardDeck copy = this.createFromArgs("A", "B", "C");

        assertEquals("B", d.look(1));
        assertTrue(d.equals(copy));
    }

    @Test
    public void testClear() {
        CardDeck d = this.createFromArgs("A", "B");
        d.clear();

        assertEquals(0, d.size());
        assertTrue(d.isEmpty());
    }

    @Test
    public void testTransferFromWorks() {
        CardDeck source = this.createFromArgs("A", "B", "C");
        CardDeck target = this.constructorTest();

        target.transferFrom(source);

        assertEquals(3, target.size());
        assertEquals("A", target.look(0));
        assertEquals(0, source.size());
    }

    @Test
    public void testTransferFromClears() {
        CardDeck source = this.createFromArgs("A", "B");
        CardDeck target = this.constructorTest();

        target.transferFrom(source);

        assertTrue(source.isEmpty());
        assertEquals(2, target.size());
    }

    @Test
    public void testEqualsSameSequence() {
        CardDeck d1 = this.createFromArgs("A", "B", "C");
        CardDeck d2 = this.createFromArgs("A", "B", "C");

        assertTrue(d1.equals(d2));
    }

    @Test
    public void testEqualsFalseDifferentSize() {
        CardDeck d1 = this.createFromArgs("A");
        CardDeck d2 = this.createFromArgs("A", "B");

        assertFalse(d1.equals(d2));
    }

    @Test
    public void testEqualsFalseDifferentElements() {
        CardDeck d1 = this.createFromArgs("A", "B");
        CardDeck d2 = this.createFromArgs("A", "C");

        assertFalse(d1.equals(d2));
    }

    @Test
    public void testEqualsEmpty() {
        CardDeck d1 = this.constructorTest();
        CardDeck d2 = this.constructorTest();

        assertTrue(d1.equals(d2));
    }

}
