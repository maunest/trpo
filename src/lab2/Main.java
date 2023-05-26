package lab2;

public class Main {
    public static void main(String[] args) {
        AbstractFactory eveningFactory = new EveningFactory();
        Footwear eveningFootwear = eveningFactory.createFootwear();
        Suit eveningSuit = eveningFactory.createSuit();

        eveningFootwear.putOn(); // Надеваем туфли
        eveningSuit.dressUp(); // Надеваем смокинг

        AbstractFactory sportFactory = new SportFactory();
        Footwear sportFootwear = sportFactory.createFootwear();
        Suit sportSuit = sportFactory.createSuit();

        sportFootwear.putOn(); // Надеваем кроссовки
        sportSuit.dressUp(); // Надеваем спортивный костюм
    }
}
