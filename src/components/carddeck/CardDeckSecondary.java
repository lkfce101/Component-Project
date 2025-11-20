package components.carddeck;

public abstract class CardDeckSecondary implements CardDeck {

    @Override
    public abstract CardDeck newInstance();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < this.size(); i++) {
            sb.append(this.look(i));
            if (i < this.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardDeck)) {
            return false;
        }
        CardDeck other = (CardDeck) obj;
        if (this.size() != other.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (!this.look(i).equals(other.look(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void shuffle() {
        int n = this.size();
        for (int i = 0; i < n; i++) {
            int j = (int) (Math.random() * n);
            this.swap(i, j);
        }

    }

    @Override
    public String drawOne() {
        return this.remove(0);
    }

    @Override
    public String drawRand() {
        return this.remove((int) (Math.random() * this.size()));
    }

    @Override
    public CardDeck drawCards(int n) {
        CardDeck newDeck = this.newInstance();
        for (int i = 0; i < n; i++) {
            newDeck.add(this.drawOne());
        }
        return newDeck;
    }

    @Override
    public CardDeck viewCards(int n) {
        CardDeck newDeck = this.newInstance();
        for (int i = 0; i < n; i++) {
            newDeck.add(this.look(i));
        }
        return newDeck;
    }

    @Override
    public int locationOf(String card) {
        int ans = -1;
        int i = 0;
        boolean found = false;
        while (i < this.size() && !found) {
            if (this.look(i).equals(card)) {
                ans = i;
                found = true;
            }
            i++;
        }
        return ans;
    }

    @Override
    public boolean contains(String card) {
        return this.locationOf(card) != -1;
    }

    @Override
    public void swap(int i, int j) {
        String cardI = this.look(i);
        String cardJ = this.look(j);
        this.remove(i);
        this.add(cardJ, i);
        this.remove(j);
        this.add(cardI, j);
    }
}
