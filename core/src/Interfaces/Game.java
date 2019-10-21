package Interfaces;

import java.util.List;

public interface Game {


    String GetName();
    List<Player> GetPlayers();
    Stage getStage();

    void Start();

}
