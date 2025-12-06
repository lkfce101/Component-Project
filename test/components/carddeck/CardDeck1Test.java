package components.carddeck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CardDeck1Test {

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
    public void testNewInstance() {
        CardDeck d = this.createFromArgs("A");
        CardDeck newDeck = d.newInstance();

        assertNotNull(newDeck);
        assertEquals(0, newDeck.size());
    }

    @Test
    public void testShuffle() {
        CardDeck d = this.createFromArgs("A", "B", "C", "D");
        CardDeck copy = d.viewCards(d.size());

        d.shuffle();

        assertEquals(copy.size(), d.size());
        assertTrue(d.contains("A") && d.contains("B") && d.contains("C")
                && d.contains("D"));
    }

    @Test
    public void testDrawOne() {
        CardDeck d = this.createFromArgs("A", "B", "C", "D");
        String top = d.drawOne();

        assertEquals("A", top);
        assertEquals(3, d.size());
    }

    @Test
    public void testDrawRand() {
        CardDeck d = this.createFromArgs("A", "B", "C", "D");
        String card = d.drawRand();

        assertFalse(d.contains(card));
        assertEquals(3, d.size());
    }

    @Test
    public void testDrawCards() {
        CardDeck d = this.createFromArgs("A", "B", "C", "D");
        CardDeck drawn = d.drawCards(2);

        assertEquals(2, drawn.size());
        assertEquals(2, d.size());
        assertEquals("A", drawn.look(0));
        assertEquals("B", drawn.look(1));
    }

    @Test
    public void testViewCards() {
        CardDeck d = this.createFromArgs("A", "B", "C", "D");
        CardDeck view = d.viewCards(2);

        assertEquals(2, view.size());
        assertEquals(4, d.size());
        assertEquals("A", view.look(0));
        assertEquals("B", view.look(1));
    }

    @Test
    public void testLocationOf() {
        CardDeck d = this.createFromArgs("A", "B", "C", "D");

        assertEquals(0, d.locationOf("A"));
        assertEquals(3, d.locationOf("D"));
    }

    @Test
    public void testContains() {
        CardDeck d = this.createFromArgs("A", "B", "C", "D");

        assertTrue(d.contains("A"));
        assertFalse(d.contains("Z"));
    }

    @Test
    public void testSwap() {
        CardDeck d = this.createFromArgs("A", "B", "C", "D");

        d.swap(0, 2);
        assertEquals("C", d.look(0));
        assertEquals("A", d.look(2));
    }

    @Test
    public void testEquals() {
        CardDeck d1 = this.createFromArgs("A", "B", "C", "D");
        CardDeck d2 = this.createFromArgs("A", "B", "C", "D");

        assertTrue(d1.equals(d2));

        d2.drawOne();
        assertFalse(d1.equals(d2));

        d1.drawOne();
        assertTrue(d1.equals(d2));
    }

    @Test
    public void testToString() {
        CardDeck d = this.createFromArgs("A", "B", "C", "D");
        assertEquals("{A, B, C, D}", d.toString());
    }

    @Test
    public void testEmptyDeck() {
        CardDeck d = this.constructorTest();

        assertEquals(0, d.size());
        assertFalse(d.contains("A"));
    }
}
