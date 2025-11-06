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
    public boolean equals(CardDeck c) {
        boolean ans = false;
        if (this.size() == c.size()) {
            ans = true;
            int i = 0;
            while (i < this.size() && ans) {
                if (!this.look(i).equals(c.look(i))) {
                    ans = false;
                }
                i++;
            }
        }
        return ans;
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
