package TerminalRPG;

import java.util.ArrayList;

public class Pokemon {
    private String name;
    private int level;
    public int hp;
    public ArrayList<Move> moves;

    public Pokemon(String name, int level, int hp, ArrayList<Move> moves) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.moves = moves;
    }

    public String name() {
        return this.name;
    }

    public int level() {
        return this.level;
    }

    public int hp() {
        return this.hp;
    }

    public ArrayList<Move> moves() {
        return this.moves;
    }
    
} 
