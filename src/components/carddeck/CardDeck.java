package components.carddeck;


public interface CardDeck extends CardDeckKernel {

    /**
     * Randomly shuffle cards in this.
     *
     * @updates this
     * @ensures this is a random reordering of #this
     */
    void shuffle();

    /**
     * Remove and return the top card from the deck.
     *
     * @requires |this| > 0
     * @updates this
     * @ensures
     *   drawOne = #this[0]  and
     *   this = #this[1, |#this|]
     * @return top card
     */
    String drawOne();

    /**
     * Remove and return a random card from the deck.
     *
     * @requires |this| > 0
     * @updates this
     * @ensures
     *   drawRand is in #this and
     *   this = #this remove {drawRand}
     * @return a random card
     */
    String drawRand();

    /**
     * Remove and return the first {@code i} cards in this deck.
     *
     * @param i
     *            number of cards to draw
     * @requires 0 <= i <= |this|
     * @updates this
     * @ensures
     *   drawCards = #this[0, i] and
     *   this = #this[i, |#this|]
     * @return card deck containing the removed cards
     */
    CardDeck drawCards(int i);

    /**
     * Return the top {@code i} cards without removing them.
     *
     * @param i
     *            number of cards to view
     * @requires 0 <= i <= |this|
     * @ensures viewCards = this[0, i] and this = #this
     * @return card deck with the top i cards in it
     */
    CardDeck viewCards(int i);

    /**
     * Return the index of the given {@code card}.
     *
     * @param card
     *            card to locate
     * @requires this.contains(card)
     * @ensures this = #this and int 0 <= locationOf <= |this - 1|
     * @return index of {@code card}
     */
    int locationOf(String card);

    /**
     * Shows whether the deck contains {@code card}.
     *
     * @param card
     *            card to search for
     * @ensures contains = (card is in this)
     * @return true if card is in this
     */
    boolean contains(String card);

    /**
     * Swap the cards at positions {@code i} and {@code j}.
     *
     * @param i
     *            first index
     * @param j
     *            second index
     * @requires 0 <= (i, j) < |this|
     * @updates this
     * @ensures
     *   this[i] = #this[j]  and
     *   this[j] = #this[i]
     */
    void swap(int i, int j);
}
