package befaster.solutions.CHK;

import befaster.solutions.CHK.domain.Item;
import befaster.solutions.CHK.domain.Promotion;
import befaster.solutions.CHK.exception.NoPromotionAvailableException;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {

    public Integer checkout(String skus) {
        if (skus == null) {
            return -1;
        }

        final Map<Item, Integer> skusWithOccurrencesMap = new HashMap<>();
        for (final Item item : Item.values()) {
            skusWithOccurrencesMap.put(item, 0);
        }

        for (int index = 0; index < skus.length(); index++) {
            try {
                final Item item = Item.valueOf(String.valueOf(skus.charAt(index)));
                final Integer currentNumberOfOccurrences = skusWithOccurrencesMap.get(item);
                skusWithOccurrencesMap.put(item, currentNumberOfOccurrences + 1);
            } catch (final Exception e) {
                return -1;
            }
        }

        int totalSum = 0;
        for (final Item item : skusWithOccurrencesMap.keySet()) {
            final Integer numberOfOccurrences = skusWithOccurrencesMap.get(item);
            try {
                final Promotion promotion = Promotion.getByItem(item);
                final int numberOfTimesToApplyPromotion = numberOfOccurrences / promotion.getQuantity();
                totalSum += numberOfOccurrences * item.getPrice() - numberOfTimesToApplyPromotion * promotion.getSaving();
            } catch (final NoPromotionAvailableException ignored) {
                totalSum += numberOfOccurrences * item.getPrice();
            }
        }

        return totalSum;
    }
}
