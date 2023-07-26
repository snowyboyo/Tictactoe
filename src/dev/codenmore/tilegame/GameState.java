package dev.codenmore.tilegame;


import static dev.codenmore.tilegame.game.isXTurn;

public class GameState {
    public static String clickedQuadrant = "";

    public static void setClickedQuadrant(String quadrant) {
        clickedQuadrant = quadrant;
    }

    public static String getClickedQuadrant() {
        return clickedQuadrant;

    }
}