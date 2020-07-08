package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {
    @Before
    public void setUp() throws Exception {
    }

    private Hero setupNewHero() {
        return new Hero("Batman", 45, "Money", "Loneliness");
    }

    private Hero setupHero2() {
        return new Hero("Iron Man", 30, "Money", "Ego");
    }

    private Squad setupNewSquad(Hero hero) {
        return new Squad("Justice League", "Just Exist", hero);
    }

    private Squad setupNewSquad2(Hero hero) {
        return new Squad("Avengers", "Just Exist again", hero);
    }
    @Test
    public void squadInstantiatedCorrectly() {
        Squad squad = setupNewSquad(setupNewHero());
        assertTrue(squad instanceof Squad);
    }
    @Test
    public void getSquadName() {
        Squad squad = setupNewSquad(setupNewHero());
        assertTrue(squad.getSquadName() instanceof String);
    }

    @Test
    public void getSquadCause() {
        Squad squad = setupNewSquad(setupNewHero());
        assertTrue(squad.getCause() instanceof String);
    }
    @Test
    public void addingHeroToExistingSquad() {
        Squad squad = setupNewSquad(setupNewHero());
        squad.addMembers(setupHero2());
        assertEquals(2, squad.getMembers().size());
    }
}