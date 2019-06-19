package befaster.solutions.CHK;

import befaster.solutions.CHK.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CheckoutSolution {

    private final List<Offer> orderedOffers;

    public CheckoutSolution() {
        final MultiBuyOffer offer1 = new MultiBuyOffer(Item.A, 3, 20);
        final MultiBuyOffer offer2 = new MultiBuyOffer(Item.B, 2, 15);
        final MultiBuyOffer offer3 = new MultiBuyOffer(Item.A, 1, 0);
        final MultiBuyOffer offer4 = new MultiBuyOffer(Item.B, 1, 0);
        final MultiBuyOffer offer5 = new MultiBuyOffer(Item.C, 1, 0);
        final MultiBuyOffer offer6 = new MultiBuyOffer(Item.D, 1, 0);
        final MultiBuyOffer offer7 = new MultiBuyOffer(Item.A, 5, 50);
        final MultiBuyOffer offer8 = new MultiBuyOffer(Item.E, 1, 0);
        final MultiBuyOffer offer9 = new MultiBuyOffer(Item.F, 1, 0);
        final MultiBuyOffer offer10 = new MultiBuyOffer(Item.F, 3, 10);
        final List<MultiBuyOffer> multiBuyOffers = Arrays.asList(offer1, offer2, offer3, offer4, offer5, offer6, offer7, offer8, offer9, offer10);
        multiBuyOffers.sort((o1, o2) -> Integer.compare(o2.getDiscount(), o1.getDiscount()));
        final SpecialOffer specialOffer = new SpecialOffer(Item.E, 2, Item.B, 1);
        orderedOffers = new ArrayList<>();
        orderedOffers.add(specialOffer);
        orderedOffers.addAll(multiBuyOffers);
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



