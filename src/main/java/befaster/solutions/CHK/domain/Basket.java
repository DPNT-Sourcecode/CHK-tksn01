package befaster.solutions.CHK.domain;

import java.util.Collections;
import java.util.Map;

public final class Basket {

    private Map<Item, Integer> items;

    public Basket() {
        items = Collections.emptyMap();
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

    public Map<Item, Integer> getItems() {
        return items;
    }
}
