package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class IGamePlayerManagerTest {
    static IGamePlayerManager IGPM;

    @BeforeAll
    public static void setUp(){
        IGPM = new IGamePlayerManagerImpl();
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
        assertTrue(IGPM.getPlayerDetails("3").contains("Ben"));
        assertNull(IGPM.getPlayerDetails("4"));
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
        IGPM.updatePlayerScore("2", 100);
        IGPM.updatePlayerScore("3", 0);
        //Assert
        assertFalse(IGPM.checkLevelUp("1"));
        assertTrue(IGPM.checkLevelUp("2"));
        assertFalse(IGPM.checkLevelUp("3"));
    }

    @Test
    void checkLevelUpTest() {
        //Setup
        // ---
        //Execute
        IGPM.registerPlayer("1", "Tom");
        IGPM.registerPlayer("2", "Steve");
        IGPM.registerPlayer("3", "Ben");
        IGPM.updatePlayerScore("1", 7);
        IGPM.updatePlayerScore("2", 131);
        IGPM.updatePlayerScore("3", 99);
        //Assert
        assertFalse(IGPM.checkLevelUp("1"));
        assertTrue(IGPM.checkLevelUp("2"));
        assertFalse(IGPM.checkLevelUp("3"));
    }

    @Test
    void deletePlayerTest() {
        //Setup

        //Execute
        IGPM.registerPlayer("1", "Tom");
        IGPM.registerPlayer("2", "Steve");
        IGPM.registerPlayer("3", "Ben");
        //IGPM.deletePlayer("3");
        //Assert
        assertTrue(IGPM.deletePlayer("3"));
        assertFalse(IGPM.deletePlayer("4"));
    }
}