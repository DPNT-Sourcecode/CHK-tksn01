package befaster.solutions.CHK;

import befaster.solutions.CHK.domain.Item;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {

    public Integer checkout(String skus) {
        if (skus == null || skus.isEmpty()) {
            return -1;
        }

        final Map<Item, Integer> skusWithOccurencesMap = new HashMap<>();
        for (final Item item : Item.values()) {
            skusWithOccurencesMap.put(item, 0);
        }
        for (int index = 0; index < skus.length(); index++) {
            try {
                final Item item = Item.valueOf(String.valueOf(skus.charAt(index)));
                final Integer currentNumberOfOccurences = skusWithOccurencesMap.get(item);
                skusWithOccurencesMap.put(item, currentNumberOfOccurences + 1);
            } catch (final Exception e) {
                return -1;
            }
        }
        return 0;
    }
}

