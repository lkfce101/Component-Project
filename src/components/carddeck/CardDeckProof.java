package components.carddeck;

import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Proof-of-concept for the component.
 *
 * @author Cayden Laukhuf
 */
public class CardDeckProof {

    /**
     * "Under the hood" data structure.
     */
    private final Sequence<String> deck;

    /**
     * Default constructor--empty deck.
     */
    public CardDeckProof() {
        this.deck = new Sequence1L<>();
    }

    //Some kernel methods

    /**
     * Adds card to end of this.
     *
     * @param card
     *            card to add
     */
    public void add(String card) {
        this.deck.add(this.deck.length(), card);
    }

    /**
     * Adds card to given index.
     *
     * @param card
     *            card to add
     * @param index
     *            position to add it at
     */
    public void add(String card, int index) {
        this.deck.add(index, card);
    }

    /**
     * Removes and returns the card at given index.
     *
     * @param index
     *            index of card to remove
     * @return removed card
     */
    public String remove(int index) {
        return this.deck.remove(index);
    }

    /**
     * Returns size of this.
     *
     * @return number of cards
     */
    public int size() {
        return this.deck.length();
    }

    //Some secondary methods

    /**
     * Randomizes order of cards in this.
     */
    public void shuffle() {
        int n = this.size();
        for (int i = 0; i < n; i++) {
            int removedIndex = (int) (Math.random() * this.size());
            String card = this.remove(removedIndex);
            int insertIndex = (int) (Math.random() * (this.size() + 1));
            this.add(card, insertIndex);
        }
    }

    /**
     * Removes and returns top card.
     *
     * @return top card
     */
    public String drawOne() {
        return this.remove(0);
    }

    /**
     * Remove and return the first i cards as a new CardDeckProof.
     *
     * @param i
     *            number of cards to draw
     * @return new CardDeckProof w/ drawn cards
     */
    public CardDeckProof drawMany(int i) {
        CardDeckProof newDeck = new CardDeckProof();
        for (int k = 0; k < i; k++) {
            newDeck.add(this.remove(0));
        }
        return newDeck;
    }

    /**
     * String representation of this deck.
     */
    @Override
    public String toString() {
        return this.deck.toString();
    }

    //main method testing
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        CardDeckProof test = new CardDeckProof();
        // create 15 card deck
        for (int i = 1; i < 16; i++) {
            test.add("Card " + i);
        }
        out.println("Initial deck:");
        out.println(test);

        out.println("Shuffle 1:");
        test.shuffle();
        out.println(test);

        out.println("Shuffle 2:");
        test.shuffle();
        out.println(test);

        out.println("One card drawn: " + test.drawOne());
        out.println("Rest of deck:");
        out.println(test);

        out.println("Draw 3 cards (with drawMany):");
        CardDeckProof drawn = test.drawMany(3);
        out.println("cards drawn:");
        out.println(drawn);

        out.println("Rest of deck:");
        out.println(test);

        out.close();
    }
}
