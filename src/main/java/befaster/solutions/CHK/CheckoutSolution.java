package befaster.solutions.CHK;

import befaster.solutions.CHK.domain.*;

import java.util.Arrays;
import java.util.List;

public class CheckoutSolution {

    private final List<Offer> orderedOffers;

    public CheckoutSolution() {
        final Offer offer1 = new MultiBuyOffer(Item.A, 3, 20);
        final Offer offer2 = new MultiBuyOffer(Item.B, 2, 15);
        final Offer offer3 = new MultiBuyOffer(Item.A, 1, 0);
        final Offer offer4 = new MultiBuyOffer(Item.B, 1, 0);
        final Offer offer5 = new MultiBuyOffer(Item.C, 1, 0);
        final Offer offer6 = new MultiBuyOffer(Item.D, 1, 0);
        final Offer offer7 = new MultiBuyOffer(Item.A, 5, 50);
        final Offer offer8 = new MultiBuyOffer(Item.E, 1, 0);
        final Offer specialOffer = new SpecialOffer(Item.E, 2, Item.B, 1);
        orderedOffers = Arrays.asList(specialOffer, offer7, offer1, offer2, offer3, offer4, offer5, offer6, offer8);
    }

    public Integer checkout(String skus) {
        if (skus == null) {
            return -1;
        }

        final Basket basket = new Basket();

        for (int index = 0; index < skus.length(); index++) {
            try {
                final Item item = Item.valueOf(String.valueOf(skus.charAt(index)));
                basket.addItem(item);
            } catch (final Exception e) {
                return -1;
            }
        }

        int totalSum = 0;
        while (!basket.isEmpty()) {
            for (final Offer offer : orderedOffers) {
                if (offer.supports(basket)) {
                    totalSum += offer.applyTo(basket);
                    break;
                }
            }
        }

        return totalSum;
    }
}



