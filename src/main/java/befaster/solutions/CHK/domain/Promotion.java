package befaster.solutions.CHK.domain;

import befaster.solutions.CHK.exception.NoPromotionAvailableException;

public enum Promotion {

    // Instead of storing the total price for that bundle, we store the savings induced by the promotion
    PROMOTION_1(Item.A, 3, 20),
    PROMOTION_2(Item.B, 2, 15);

    private final Item item;
    private final int quantity;
    private final int saving;

    Promotion(final Item item, final int quantity, final int saving) {
        this.item = item;
        this.quantity = quantity;
        this.saving = saving;
    }

    // The following will assume that we can only have 1 promotion / item, for now
    public static Promotion getByItem(final Item item) throws NoPromotionAvailableException {
        for (final Promotion promotion : values()) {
            if (promotion.item == item) {
                return promotion;
            }
        }

        throw new NoPromotionAvailableException();
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSaving() {
        return saving;
    }
}

