package TerminalRPG;

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
}
