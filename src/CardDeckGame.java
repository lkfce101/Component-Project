import components.carddeck.CardDeck;
import components.carddeck.CardDeck1;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class CardDeckGame {

    public static void main(String[] args) {

        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        // create card deck
        CardDeck deck = new CardDeck1();
        String[] cards = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14" };
        for (String card : cards) {
            deck.add(card);
        }

        // shuffle the deck
        deck.shuffle();

        int score = 0;

        while (deck.size() > 0) {

            out.print(
                    "Do you think the card drawn will be even or odd? (e/o): ");
            String guess = "";
            while (true) {
                guess = in.nextLine().trim().toLowerCase();
                if (guess.equals("e") || guess.equals("o")) {
                    break;
                } else {
                    out.print(
                            "Invalid input. Please enter 'e' for even or 'o' for odd: ");
                }
            }

            String topCard = deck.drawOne();
            int cardValue = Integer.parseInt(topCard);

            if (guess.equals("e")) {
                if (cardValue % 2 == 0) {
                    out.println("You guessed right! The card " + cardValue
                            + " is even.");
                    score++;
                } else {
                    out.println("Sorry, the card " + cardValue + " is odd.");
                }
            } else {
                if (cardValue % 2 != 0) {
                    out.println("You guessed right! The card " + cardValue
                            + " is odd.");
                    score++;
                } else {
                    out.println("Sorry, the card " + cardValue + " is even.");
                }
            }
        }

        out.println("Game over! Your final score: " + score);

        in.close();
        out.close();
    }
}
