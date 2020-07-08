package models;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void heroInstantiatesCorrectly() {
        Hero newHero = setupNewHero();
        assertTrue(newHero instanceof Hero);
    }
}