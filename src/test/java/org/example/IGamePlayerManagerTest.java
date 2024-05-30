package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IGamePlayerManagerTest {
    IGamePlayerManager IGPM;

    @BeforeAll
    public static void setUp(){

    }

    @Test
    void registerPlayerTest() {
        //Setup
        // ---
        //Execute
        IGPM.registerPlayer("1", "Tom");
        IGPM.registerPlayer("2", "Steve");
        IGPM.registerPlayer("3", "Ben");
        //Assert
        assertEquals("Tom", IGPM.getPlayerDetails("1"));
        assertTrue(IGPM.getPlayerDetails("3").contains("Ben"));
    }

    @Test
    void getPlayerDetailsTest() {
        //Setup
        // ---
        //Execute
        IGPM.registerPlayer("1", "Tom");
        IGPM.registerPlayer("2", "Steve");
        IGPM.registerPlayer("3", "Ben");
        //Assert
        assertEquals("Tom", IGPM.getPlayerDetails("1"));
        assertFalse(IGPM.getPlayerDetails("4").contains("Nameless"));
    }

    @Test
    void updatePlayerScoreTest() {
        //Setup
        // ---
        //Execute
        IGPM.registerPlayer("1", "Tom");
        IGPM.registerPlayer("2", "Steve");
        IGPM.registerPlayer("3", "Ben");
        IGPM.updatePlayerScore("1", 7);
        IGPM.updatePlayerScore("2", 34);
        IGPM.updatePlayerScore("3", 0);
        //Assert
        assertEquals(7, IGPM.checkLevelUp("1"));
        assertEquals(34,IGPM.checkLevelUp("2"));
    }

    @Test
    void checkLevelUpTest() {
        //Setup
        // String player1 = "1, Tom, 94"
        // String player2 = "2, Steve, 66"
        // String player3 = "3, Ben, 74"
        //Execute
        IGPM.registerPlayer("1", "Tom");
        IGPM.registerPlayer("2", "Steve");
        IGPM.registerPlayer("3", "Ben");
        IGPM.updatePlayerScore("1", 7);
        IGPM.updatePlayerScore("2", 34);
        IGPM.updatePlayerScore("3", 0);
        //Assert
        assertTrue(IGPM.checkLevelUp("2"));
    }

    @Test
    void deletePlayerTest() {
        //Setup

        //Execute
        IGPM.registerPlayer("1", "Tom");
        IGPM.registerPlayer("2", "Steve");
        IGPM.deletePlayer("2");
        //Assert
        assertFalse(IGPM.getPlayerDetails("2").contains("Steve"));
    }
}