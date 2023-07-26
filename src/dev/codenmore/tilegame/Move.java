package dev.codenmore.tilegame;

public class Move {
    private  String quadrant;
    private boolean isXTurn;

    public Move(String quadrant, boolean isXTurn) {
        this.quadrant = quadrant;
        this.isXTurn = isXTurn;
    }

    public String getQuadrant() {
        return quadrant;
    }

    public boolean isXTurn() {
        return isXTurn;
    }
}