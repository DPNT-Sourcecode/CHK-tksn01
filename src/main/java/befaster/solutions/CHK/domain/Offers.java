package befaster.solutions.CHK.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Offers {
    // this class will simulate a database
    // ideally, all offers would reside in a database, in order to allow easier addition / removal of offers
    // without any additional deployments

    private static final MultiBuyOffer OFFER_1 = new MultiBuyOffer(Item.A, 3, 20);
    private static final MultiBuyOffer OFFER_2 = new MultiBuyOffer(Item.A, 5, 50);
    private static final MultiBuyOffer OFFER_3 = new MultiBuyOffer(Item.F, 3, 10);
    private static final MultiBuyOffer OFFER_4 = new MultiBuyOffer(Item.H, 5, 5);
    private static final MultiBuyOffer OFFER_5 = new MultiBuyOffer(Item.H, 10, 20);
    private static final MultiBuyOffer OFFER_6 = new MultiBuyOffer(Item.K, 2, 20);
    private static final MultiBuyOffer OFFER_7 = new MultiBuyOffer(Item.P, 5, 50);
    private static final MultiBuyOffer OFFER_8 = new MultiBuyOffer(Item.Q, 3, 10);
    private static final MultiBuyOffer OFFER_9 = new MultiBuyOffer(Item.U, 4, 40);
    private static final MultiBuyOffer OFFER_10 = new MultiBuyOffer(Item.V, 2, 10);
    private static final MultiBuyOffer OFFER_11 = new MultiBuyOffer(Item.V, 3, 20);
    private static final MultiBuyOffer OFFER_12 = new MultiBuyOffer(Item.B, 2, 15);

    private static final SpecialOffer SPECIAL_OFFER_1 = new SpecialOffer(Item.E, 2, Item.B, 1);
    private static final SpecialOffer SPECIAL_OFFER_2 = new SpecialOffer(Item.N, 3, Item.M, 1);
    private static final SpecialOffer SPECIAL_OFFER_3 = new SpecialOffer(Item.R, 3, Item.Q, 1);

    private static final MixMatchOffer MIX_MATCH_OFFER = new MixMatchOffer(Arrays.asList(Item.S, Item.T, Item.X, Item.Y, Item.Z),
            3, 45);

    public static List<Offer> getOrderedOffers() {
        final List<MultiBuyOffer> multiBuyOffers = Arrays.stream(Item.values()).map(item -> new MultiBuyOffer(item, 1, 0)).collect(Collectors.toList());
        multiBuyOffers.add(OFFER_1);
        multiBuyOffers.add(OFFER_2);
        multiBuyOffers.add(OFFER_3);
        multiBuyOffers.add(OFFER_4);
        multiBuyOffers.add(OFFER_5);
        multiBuyOffers.add(OFFER_6);
        multiBuyOffers.add(OFFER_7);
        multiBuyOffers.add(OFFER_8);
        multiBuyOffers.add(OFFER_9);
        multiBuyOffers.add(OFFER_10);
        multiBuyOffers.add(OFFER_11);
        multiBuyOffers.add(OFFER_12);

        multiBuyOffers.sort((o1, o2) -> Integer.compare(o2.getDiscount(), o1.getDiscount()));

        final ArrayList<Offer> orderedOffers = new ArrayList<>();
        orderedOffers.add(SPECIAL_OFFER_1);
        orderedOffers.add(SPECIAL_OFFER_2);
        orderedOffers.add(SPECIAL_OFFER_3);
        orderedOffers.add(MIX_MATCH_OFFER);
        orderedOffers.addAll(multiBuyOffers);

        return orderedOffers;
    }
}

