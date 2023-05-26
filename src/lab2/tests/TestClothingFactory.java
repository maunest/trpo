package lab2.tests;

import org.junit.Test;
import static org.junit.Assert.*;
import lab2.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestClothingFactory {

    @Test
    public void testEveningFactoryCreateFootwear() {
        AbstractFactory eveningFactory = new EveningFactory();
        Footwear eveningFootwear = eveningFactory.createFootwear();
        assertTrue(eveningFootwear instanceof Shoes);
    }

    @Test
    public void testEveningFactoryCreateSuit() {
        AbstractFactory eveningFactory = new EveningFactory();
        Suit eveningSuit = eveningFactory.createSuit();
        assertTrue(eveningSuit instanceof Tuxedo);
    }

    @Test
    public void testSportFactoryCreateFootwear() {
        AbstractFactory sportFactory = new SportFactory();
        Footwear sportFootwear = sportFactory.createFootwear();
        assertTrue(sportFootwear instanceof Sneakers);
    }

    @Test
    public void testSportFactoryCreateSuit() {
        AbstractFactory sportFactory = new SportFactory();
        Suit sportSuit = sportFactory.createSuit();
        assertTrue(sportSuit instanceof SportSuit);
    }

    @Test
    public void testEveningFootwearPutOn() {
        Footwear eveningFootwear = new Shoes();
        assertEquals("Надеваем туфли", getOutput(eveningFootwear::putOn));
    }

    @Test
    public void testEveningSuitDressUp() {
        Suit eveningSuit = new Tuxedo();
        assertEquals("Надеваем смокинг", getOutput(eveningSuit::dressUp));
    }

    private String getOutput(Runnable runnable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        runnable.run();
        return outputStream.toString().trim();
    }
}
