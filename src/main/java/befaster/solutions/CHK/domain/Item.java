package befaster.solutions.CHK.domain;

public enum Item {
    A(50),
    B(30),
    C(20),
    D(15),
    E(40),
    F(10),
    G(20),
    H(10),
    I(35),
    J(60),
    K(70),
    L(90),
    M(15),
    N(40),
    O(10),
    P(50),
    Q(30),
    R(50),
    S(20),
    T(20),
    U(40),
    V(50),
    W(20),
    X(17),
    Y(20),
    Z(21);


    private final int price;

    Item(final int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
