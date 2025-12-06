package components.carddeck;

import components.sequence.Sequence1L;

/**
 * CardDeck1: Concrete implementation of CardDeck using a Sequence1L.
 *
 * @convention $this.rep != null. For all entries e in $this.rep, e is a string
 * @correspondence this = $this.rep
 */
public class CardDeck1 extends CardDeckSecondary {

    /**
     * Representation of {@code this}.
     */
    private Sequence1L<String> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = new Sequence1L<String>();
    }

    /**
     * Default constructor.
     */
    public CardDeck1() {
        this.createNewRep();
    }

    @Override
    public void add(String card) {
        this.rep.add(this.rep.length(), card);
    }

    @Override
    public void add(String card, int index) {
        this.rep.add(index, card);
    }

    @Override
    public String remove(int index) {
        return this.rep.remove(index);
    }

    @Override
    public int size() {
        return this.rep.length();
    }

    @Override
    public boolean isEmpty() {
        return this.rep.length() == 0;
    }

    @Override
    public String look(int index) {
        return this.rep.entry(index);
    }

    @Override
    public CardDeck newInstance() {
        return new CardDeck1();
    }

    @Override
    public void clear() {
        this.rep.clear();
    }

    @Override
    public void transferFrom(CardDeck c) {
        CardDeck1 local = (CardDeck1) c;
        this.rep = local.rep;
        local.createNewRep();
    }

}
