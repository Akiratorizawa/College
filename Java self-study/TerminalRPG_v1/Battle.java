package TerminalRPG_v1;

import java.util.concurrent.ThreadLocalRandom;

public class Battle {
    private int turns;
    private Pokemon player;
    private Pokemon opponent;

    public Battle(Pokemon player, Pokemon opponent) {
        this.turns = 0;
        this.player = player;
        this.opponent = opponent;
    }

    public int turns() {
        return this.turns;
    }

    
    public Pokemon player() {
        return this.player;
    }

    
    public Pokemon opponent() {
        return this.opponent;
    }

    public static int damageCalculation(Move move, Pokemon target) {
        int variance = ThreadLocalRandom.current().nextInt(-10, 11);
        int damage = (move.power() / 2) + variance;
        return damage;
    }     
}
