package befaster.solutions.CHK.domain;

public class SpecialOffer implements Offer {

    private final Item requiredItem;
    private final int requiredQuantity;
    private final Item freeItem;
    private final int freeItemQuantity;

    public SpecialOffer(final Item requiredItem, final int requiredQuantity, final Item freeItem, final int freeItemQuantity) {
        this.requiredItem = requiredItem;
        this.requiredQuantity = requiredQuantity;
        this.freeItem = freeItem;
        this.freeItemQuantity = freeItemQuantity;
    }

    @Override
    public boolean supports(final Basket basket) {
        return basket.contains(requiredItem, requiredQuantity) && basket.contains(freeItem, freeItemQuantity);
    }

    @Override
    public int applyTo(final Basket basket) {
        final int basketQuantity = basket.getItems().get(requiredItem);
        final int numberOfBulks = basketQuantity / requiredQuantity;
        basket.remove(freeItem, freeItemQuantity * numberOfBulks);
        basket.remove(requiredItem, requiredQuantity * numberOfBulks);
        return requiredItem.getPrice() * basketQuantity;
    }
}
