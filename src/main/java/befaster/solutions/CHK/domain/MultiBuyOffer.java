package befaster.solutions.CHK.domain;

public class MultiBuyOffer implements Offer {

    private final Item requiredItem;
    private final int requiredQuantity;
    private final int discount;

    public MultiBuyOffer(final Item requiredItem, final int requiredQuantity, final int discount) {
        this.requiredItem = requiredItem;
        this.requiredQuantity = requiredQuantity;
        this.discount = discount;
    }

    @Override
    public boolean supports(final Basket basket) {
        return basket.getItems().containsKey(requiredItem) && basket.getItems().get(requiredItem) >= requiredQuantity;
    }

    @Override
    public int applyTo(final Basket basket) {
        final int basketQuantity = basket.getItems().get(requiredItem);
        final int numberOfBulks = basketQuantity / requiredQuantity;
        final int discountedPrice = requiredItem.getPrice() * basketQuantity - numberOfBulks * discount;
        basket.remove(requiredItem, requiredQuantity * numberOfBulks);
        return discountedPrice;
    }
}
