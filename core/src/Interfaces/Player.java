package Interfaces;

import Enums.ProjectileType;

import java.util.List;

public interface Player {
    Raft getRaft();
    List<Pawn> getPawns();
    int getGrapeCount();
    int getMissleCount();
    int getGrenadeCount();
    Pawn getCurrentPawn();
    Projectile getProjectile();
    Shop getShop();

    void fireProjectile(ProjectileType projectileType);
}
