package lab2;

public class SportFactory implements AbstractFactory {
    @Override
    public Footwear createFootwear() {
        return new Sneakers();
    }

    @Override
    public Suit createSuit() {
        return new SportSuit();
    }
}
