import java.util.*;

class CardCollection {
    private Map<String, List<String>> cardMap;

    public CardCollection() {
        cardMap = new HashMap<>();
    }

    public void addCard(String symbol, String rank) {
        cardMap.putIfAbsent(symbol, new ArrayList<>());
        cardMap.get(symbol).add(rank);
    }

    public List<String> getCardsBySymbol(String symbol) {
        return cardMap.getOrDefault(symbol, Collections.emptyList());
    }

    public void displayCards() {
        for (var entry : cardMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        CardCollection collection = new CardCollection();

        collection.addCard("Hearts", "A");
        collection.addCard("Hearts", "10");
        collection.addCard("Spades", "K");
        collection.addCard("Diamonds", "Q");
        collection.addCard("Clubs", "J");

        System.out.println("Cards of Hearts: " + collection.getCardsBySymbol("Hearts"));
        System.out.println("All Cards:");
        collection.displayCards();
    }
}
