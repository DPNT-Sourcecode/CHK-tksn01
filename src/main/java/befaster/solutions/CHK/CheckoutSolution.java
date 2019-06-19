package befaster.solutions.CHK;

import befaster.solutions.CHK.domain.Basket;
import befaster.solutions.CHK.domain.Item;
import befaster.solutions.CHK.domain.Offer;
import befaster.solutions.CHK.domain.Offers;

import java.util.List;

public class CheckoutSolution {

    private final List<Offer> orderedOffers = Offers.getOrderedOffers();

    public CheckoutSolution() {
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

