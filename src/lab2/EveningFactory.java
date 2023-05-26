package lab2;

public class EveningFactory implements AbstractFactory {
    @Override
    public Footwear createFootwear() {
        return new Shoes();
    }

    @Override
    public Suit createSuit() {
        return new Tuxedo();
    }
}
