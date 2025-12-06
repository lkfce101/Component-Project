import components.carddeck.CardDeck;
import components.carddeck.CardDeck1;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class CardDeckDemo {

    public static void main(String[] args) {

        SimpleWriter out = new SimpleWriter1L();

        CardDeck deck = new CardDeck1();
        String[] cards = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
        for (String card : cards) {
            deck.add(card);
        }

        out.println("Initial deck:");
        out.println(deck.toString());

        // shuffle the deck
        deck.shuffle();

        out.println("Shuffled deck:");
        out.println(deck.toString());
        // draw one card
        String drawnCard = deck.drawOne();
        out.println("Drew card: " + drawnCard);
        out.println("Deck after drawing one card:");
        out.println(deck.toString());

        // draw random card
        String randomCard = deck.drawRand();
        out.println("Drew random card: " + randomCard);
        out.println("Deck after drawing random card:");
        out.println(deck.toString());

        // draw multiple cards
        int numToDraw = 2;
        CardDeck drawnCards = deck.drawCards(numToDraw);
        out.println("Drew " + numToDraw + " cards:");
        out.println(drawnCards.toString());
        out.println("Deck after drawing multiple cards:");
        out.println(deck.toString());

        // view multiple cards
        final int numToView = 3;
        CardDeck viewedCards = deck.viewCards(numToView);
        out.println("Viewed top " + numToView + " cards (without removing):");
        out.println(viewedCards.toString());
        out.println("Deck after viewing cards (should be unchanged):");
        out.println(deck.toString());

        deck.swap(0, deck.size() - 1);
        out.println("Deck after swapping first and last cards:");
        out.println(deck.toString());

        int location = deck.locationOf("E");
        out.println("Location of card 'E': (-1 if not in deck) " + location);

        out.close();

    }
}
