package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IGamePlayerManagerImpl implements IGamePlayerManager {
    public String playerId;
    public String playerName;
    public int score;
    private HashMap<String, String> players;
    private HashMap<String, Integer> playersScore;


    public IGamePlayerManagerImpl() {
        players = new HashMap<>();
        playersScore = new HashMap<>();
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public void registerPlayer(String playerId, String playerName) {
        players.put(playerId, playerName);
    }

    @Override
    public String getPlayerDetails(String playerId) {
        if(players.get(playerId) != null)
        return players.get(playerId);
        return null;
    }

    @Override
    public void updatePlayerScore(String playerId, int scoreToAdd) {
        playersScore.put(playerId, scoreToAdd);
    }

    @Override
    public boolean checkLevelUp(String playerId) {
        if(playersScore.get(playerId) >= 100){
            return true;
        }
        else if(playersScore.get(playerId) < 100){
            return false;
        }
        return false;
    }

    @Override
    public boolean deletePlayer(String playerId) {
        if(players.containsKey(playerId)){
            players.remove(playerId);
            return true;
        }
        return false;
    }


}
