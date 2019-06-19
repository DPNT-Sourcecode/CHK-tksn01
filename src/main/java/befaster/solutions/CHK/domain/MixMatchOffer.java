package befaster.solutions.CHK.domain;

import java.util.List;

public class MixMatchOffer implements Offer {

    private final List<Item> qualifyingItems;
    private final int requiredQuantity;
    private final int offerValue;

    public MixMatchOffer(final List<Item> qualifyingItems, final int requiredQuantity, final int offerValue) {
        this.qualifyingItems = qualifyingItems;
        // important to sort the items in decreasing order of their price, will be used by the greedy approach in the
        // applyTo method
        this.qualifyingItems.sort((o1, o2) -> Integer.compare(o2.getPrice(), o1.getPrice()));
        this.requiredQuantity = requiredQuantity;
        this.offerValue = offerValue;
    }

    @Override
    public boolean supports(final Basket basket) {
        final int totalQuantity = 0;
        for (Item item : qualifyingItems) {
            totalQuantity += basket.contains(item) ? basket.getItems().get(item) : 0;
        }
        return false;
    }

    @Override
    public int applyTo(final Basket basket) {
        return offerValue;
    }
}


