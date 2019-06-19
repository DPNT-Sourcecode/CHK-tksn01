package befaster.solutions.CHK.service;

import befaster.solutions.CHK.domain.Basket;
import befaster.solutions.CHK.domain.Offer;
import befaster.solutions.CHK.domain.Offers;

import java.util.List;

public final class CheckoutService {

    private static final List<Offer> ORDERED_OFFERS = Offers.getOrderedOffers();

    public Integer calculateTotal(final Basket basket) {
        int totalSum = 0;
        while (!basket.isEmpty()) {
            for (final Offer offer : ORDERED_OFFERS) {
                if (offer.supports(basket)) {
                    totalSum += offer.applyTo(basket);
                    break;
                }
            }
        }

        return totalSum;
    }
}
