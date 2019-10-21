package Interfaces;

public interface Raft {

    int getposition();
    int getLevel();
    void upgrade();
}
