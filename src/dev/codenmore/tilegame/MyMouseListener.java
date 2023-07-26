package dev.codenmore.tilegame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static dev.codenmore.tilegame.GameState.clickedQuadrant;


import static dev.codenmore.tilegame.game.isXTurn;
import static dev.codenmore.tilegame.game.moves;

public class MyMouseListener extends MouseAdapter {
    @Override
    public void mouseReleased(MouseEvent e) {
         int x = e.getX();
        int y = e.getY();
        System.out.println("Mouse clicked at (" + x + ", " + y + ")");
        if (x >0  && x < 100 && y > 0 && y < 100) {
            System.out.println("quadrant 1 selected");
            GameState.setClickedQuadrant("1");
        }
        if (x >101  && x < 238 && y > 0 && y < 100) {
            System.out.println("quadrant 2 selected");
            GameState.setClickedQuadrant("2");
        }
        if (x >239  && x < 348 && y > 0 && y < 100) {
            System.out.println("quadrant 3 selected");
            GameState.setClickedQuadrant("3");
        }
        if (x >0  && x < 100 && y > 101 && y < 234) {
            System.out.println("quadrant 4 selected");
            GameState.setClickedQuadrant("4");
        }
        if (x >101  && x < 238 && y > 101 && y < 234) {
            System.out.println("quadrant 5 selected");
            GameState.setClickedQuadrant("5");
        }
        if (x >239  && x < 348 && y > 101 && y < 234) {
            System.out.println("quadrant 6 selected");
            GameState.setClickedQuadrant("6");
        }
        if (x >0  && x < 100 && y > 235 && y < 349) {
            System.out.println("quadrant 7 selected");
            GameState.setClickedQuadrant("7");
        }
        if (x >101  && x < 238 && y > 235 && y < 349) {
            System.out.println("quadrant 8 selected");
            GameState.setClickedQuadrant("8");
        }
        if (x >239  && x < 348 && y > 235 && y < 349) {
            System.out.println("quadrant 9 selected");
            GameState.setClickedQuadrant("9");
        }



        boolean alreadyClicked = false;
        for (Move move : moves) {
            if (move.getQuadrant().equals(clickedQuadrant)) {
                alreadyClicked = true;
                break;
            }
        }
        if (!alreadyClicked) {
            moves.add(new Move(clickedQuadrant, isXTurn));
            isXTurn = !isXTurn;
        }

    }

}
