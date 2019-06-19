package befaster.solutions.CHK.domain;

public enum Item {
    A(50),
    B(30),
    C(20),
    D(15),
    E(40),
    F(10);

    private final int price;

    Item(final int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
