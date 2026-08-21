package TerminalRPG_v2.src;

public class Move {
    private String move;
    private int power;
    private int pp;
    private double accuracy;

    public Move(String name, int power, int pp, double accuracy) {
        this.move = name;
        this.power = power;
        this.pp = pp;
        this.accuracy = accuracy;
    }

    public String move() {
        return this.move;
    }

    public int power() {
        return this.power;
    }

    public int pp() {
        return this.pp;
    }

    public double accuracy() {
        return this.accuracy;
    }
}
