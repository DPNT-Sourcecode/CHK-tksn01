package befaster.solutions.CHK;

import befaster.solutions.CHK.domain.Item;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {

    public Integer checkout(String skus) {
        if (skus == null || skus.isEmpty() || skus.trim().isEmpty()) {
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

        int totalSum = 0;
        for (final Item item : skusWithOccurencesMap.keySet()) {
            final Integer numberOfOccurrences = skusWithOccurencesMap.get(item);
            int numberOfTimesToApplyPromotion;
            switch (item) {
                case A:
                    numberOfTimesToApplyPromotion = numberOfOccurrences / 3;
                    totalSum += numberOfOccurrences * item.getPrice() - numberOfTimesToApplyPromotion * 20;
                    break;
                case B:
                    numberOfTimesToApplyPromotion = numberOfOccurrences / 2;
                    totalSum += numberOfOccurrences * item.getPrice() - numberOfTimesToApplyPromotion * 15;
                    break;
                default:
                    totalSum += numberOfOccurrences * item.getPrice();
            }
        }

        return totalSum;
    }
}
