package components.carddeck;

import components.standard.Standard;

public interface CardDeckKernel extends Standard<CardDeck> {

    /**
     * Adds {@code card} to the end of this deck.
     *
     * @param card
     *            the card to add
     * @updates this
     * @ensures this = #this, <card>
     */
    void add(String card);

    /**
     * Add {@code card} at a given position {@code index}.
     *
     * @param card
     *            the card to add
     * @param index
     *            position at which to add the card
     * @requires 0 <= index <= |this|
     * @updates this
     * @ensures this = #this[0, index], <card>,  #this[index, |#this|]
     */
    void add(String card, int index);

    /**
     * Remove and return the card at position {@code index}.
     *
     * @param index
     *            index of card to remove
     * @requires 0 <= index < |this|
     * @updates this
     * @ensures
     *  remove = #this[index]  and
     *  this = #this[0, index],  #this[index + 1, |#this|]
     * @return the removed card
     */
    String remove(int index);

    /**
     * Reports the number of cards in this.
     *
     * @return size of this
     * @ensures size = |this|
     */
    int size();

    /**
     * Reports whether this is empty.
     *
     * @return true iff this has no cards
     * @ensures isEmpty = (|this| = 0)
     */
    boolean isEmpty();

    /**
     * Returns (but does not remove) the card at position {@code index}.
     *
     * @param index
     *            index of card to view
     * @requires 0 <= index < |this|
     * @ensures look = this[index]
     * @return the card at {@code index}
     */
    String look(int index);
}
