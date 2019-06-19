package befaster.solutions.CHK;

import befaster.solutions.CHK.domain.Basket;
import befaster.solutions.CHK.domain.Offer;
import befaster.solutions.CHK.domain.Offers;
import befaster.solutions.CHK.exception.InvalidSkuException;
import befaster.solutions.CHK.factory.BasketFactory;

import java.util.List;

public class CheckoutSolution {

    private final List<Offer> orderedOffers = Offers.getOrderedOffers();
    private final BasketFactory basketFactory = new BasketFactory();

    public Integer checkout(String skus) {
        if (skus == null) {
            return -1;
        }

        final Basket basket;
        try {
            basket = basketFactory.createBasket(skus);
        } catch (final InvalidSkuException ignored) {
            return -1;
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

