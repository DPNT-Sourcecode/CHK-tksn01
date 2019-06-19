package befaster.solutions.CHK.domain;

import java.util.HashMap;
import java.util.Map;

public final class Basket {

    private Map<Item, Integer> items;

    public Basket() {
        items = new HashMap<>();
    }

    public void addItem(final Item item) {
        final int currentQuantity = items.getOrDefault(item, 0);
        items.put(item, currentQuantity + 1);
    }

    public void remove(final Item item, final int quantityToRemove) {
        final int currentQuantity = items.getOrDefault(item, 0);
        final int newQuantity = currentQuantity - quantityToRemove;
        if (newQuantity <= 0) {
            items.remove(item);
        } else {
            items.put(item, newQuantity);
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public boolean contains(final Item item) {
        return contains(item, 1);
    }

    public boolean contains(final Item item, final int quantity) {
        return items.containsKey(item) && items.get(item) >= quantity;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }
}

