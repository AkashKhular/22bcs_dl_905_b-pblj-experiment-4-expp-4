import java.util.*;

// Card class represents a playing card with rank and symbol
class Card {
    private String rank;
    private String symbol;

    public Card(String rank, String symbol) {
        this.rank = rank;
        this.symbol = symbol;
    }

    public String getRank() {
        return rank;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return rank + " of " + symbol;
    }
}

// Deck class implements the Collection interface to store cards
class Deck implements Collection<Card> {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
    }

    // Add a card to the deck
    @Override
    public boolean add(Card card) {
        return cards.add(card);
    }

    // Add all cards from another collection to the deck
    @Override
    public boolean addAll(Collection<? extends Card> c) {
        return cards.addAll(c);
    }

    // Check if a card is in the deck
    @Override
    public boolean contains(Object o) {
        return cards.contains(o);
    }

    // Check if the deck contains all the cards in the given collection
    @Override
    public boolean containsAll(Collection<?> c) {
        return cards.containsAll(c);
    }

    // Clear all cards from the deck
    @Override
    public void clear() {
        cards.clear();
    }

    // Return the number of cards in the deck
    @Override
    public int size() {
        return cards.size();
    }

    // Check if the deck is empty
    @Override
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    // Return an iterator for the deck
    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }

    // Remove a single card from the deck
    @Override
    public boolean remove(Object o) {
        return cards.remove(o);
    }

    // Remove all cards in the given collection from the deck
    @Override
    public boolean removeAll(Collection<?> c) {
        return cards.removeAll(c);
    }

    // Retain only the cards in the deck that are also in the given collection
    @Override
    public boolean retainAll(Collection<?> c) {
        return cards.retainAll(c);
    }

    // Convert the deck to an array
    @Override
    public Object[] toArray() {
        return cards.toArray();
    }

    // Convert the deck to a typed array
    @Override
    public <T> T[] toArray(T[] a) {
        return cards.toArray(a);
    }

    // Custom method to get all cards of a specific symbol
    public Collection<Card> getCardsBySymbol(String symbol) {
        List<Card> symbolCards = new ArrayList<>();
        for (Card card : cards) {
            if (card.getSymbol().equals(symbol)) {
                symbolCards.add(card);
            }
        }
        return symbolCards;
    }
}

// CardCollector class to manage the deck and find cards based on symbol
public class CardCollector {

    public static void main(String[] args) {
        // Create a deck of cards
        Deck deck = new Deck();

        // Add some cards to the deck
        deck.add(new Card("Ace", "Hearts"));
        deck.add(new Card("King", "Hearts"));
        deck.add(new Card("Queen", "Spades"));
        deck.add(new Card("Jack", "Spades"));
        deck.add(new Card("10", "Diamonds"));
        deck.add(new Card("Ace", "Spades"));

        // Print the deck
        System.out.println("Deck of Cards: ");
        printDeck(deck);

        // Collect cards of a specific symbol (e.g., "Spades")
        System.out.println("\nCards of Spades: ");
        Collection<Card> spades = deck.getCardsBySymbol("Spades");
        printCards(spades);
    }

    // Helper method to print all cards in a collection
    private static void printCards(Collection<Card> cards) {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    // Helper method to print the entire deck
    private static void printDeck(Deck deck) {
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}
