package dev.codenmore.tilegame;
import dev.codenmore.tilegame.display;
import dev.codenmore.tilegame.gfx.imageLoader;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import static dev.codenmore.tilegame.GameState.clickedQuadrant;

public class game implements Runnable{
    public int turn;
    private display display;
    public int width,height;
    public String title;
    private boolean running = false;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;
    private BufferedImage testImage;
    private BufferedImage X;
    private BufferedImage O;
    private BufferedImage OWIN;
    private BufferedImage XWIN;
    public static List<Move> moves = new ArrayList<>();
    public static boolean isXTurn = true;

    public game(String title, int width, int height){
        this.width=width;
        this.height=height;
        this.title=title;

    }
    private void init(){

        display = new display(title,width,height);
        display.getCanvas().addMouseListener(new MyMouseListener());
        testImage = imageLoader.loadImage("/textures/board.png");
        X = imageLoader.loadImage("/textures/realX2.png");
        O = imageLoader.loadImage("/textures/O2.png");
        OWIN = imageLoader.loadImage("/textures/OWIN2.png");
        XWIN = imageLoader.loadImage("/textures/WIN.png");
    }

       void tick(){
           try {
               Thread.sleep(500);  // Pause for 3000 milliseconds, or 3 seconds
           } catch (InterruptedException e) {
               e.printStackTrace();
           }


    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }


        String l = "";
        String m = "";
        String n = "";
        String o = "";
        String p = "";
        String q = "";
        String r = "";
        String s = "";
        String t = "";



        String a = ("XXX");
        String b = ("OOO");
        StringBuffer winner = new StringBuffer();
        winner = null;

        g = bs.getDrawGraphics();
        // Clear the entire screen
        g.clearRect(0, 0, width, height);

        // Draw the board
        g.drawImage(testImage, 0, 0, null);

        // Draw all the moves
        for (Move move : moves) {
            // Choose the correct image for the player
            BufferedImage imageToDraw = move.isXTurn() ? X : O;

            // Get the quadrant of the move
            String quadrant = move.getQuadrant();

            // Determine the x and y position for the image based on the quadrant
            int x = 0;
            int y = 0;
            switch (quadrant) {
                case "1":
                    x = 0;
                    y = 0;
                    l = String.valueOf(move.isXTurn() ? "X" : "O");

                    break;
                case "2":
                    x = 102;
                    y = 0;
                    m = String.valueOf(move.isXTurn() ? "X" : "O");
                    break;
                case "3":
                    x = 242;
                    y = 0;
                    n = String.valueOf(move.isXTurn() ? "X" : "O");
                    break;
                case "4":
                    x = 0;
                    y = 100;
                    o = String.valueOf(move.isXTurn() ? "X" : "O");
                    break;
                case "5":
                    x = 105;
                    y = 100;
                    p = String.valueOf(move.isXTurn() ? "X" : "O");
                    break;
                case "6":
                    x = 242;
                    y = 100;
                    q = String.valueOf(move.isXTurn() ? "X" : "O");
                    break;
                case "7":
                    x = 0;
                    y = 235;
                    r = String.valueOf(move.isXTurn() ? "X" : "O");
                    break;
                case "8":
                    x = 105;
                    y = 235;
                    s = String.valueOf(move.isXTurn() ? "X" : "O");
                    break;
                case "9":
                    x = 241;
                    y = 235;
                    t = String.valueOf(move.isXTurn() ? "X" : "O");
                    break;
            }
            if((l + m + n).equals(a)) {
                System.out.println("X Wins!1");
                g.drawImage(X, x, y, null);
                tick();
                g.drawImage(XWIN, 0, 0, null);
                bs.show();
                stop();
            }
            if((l + m + n).equals(b)) {
                System.out.println("O Wins!");
                g.drawImage(O, x, y, null);
                tick();
                g.drawImage(OWIN, 0, 0, null);
                bs.show();
                stop();
            }
            if((o + p + q).equals(a)) {
                System.out.println("X Wins!");
                g.drawImage(X, x, y, null);
                tick();
                g.drawImage(XWIN, 0, 0, null);
                bs.show();
                stop();
            }
            if((o + p + q).equals(b)) {
                System.out.println("O Wins!");
                g.drawImage(O, x, y, null);
                tick();
                g.drawImage(OWIN, 0, 0, null);
                bs.show();
                stop();
            }
            if((r+ s + t).equals(a)) {
                System.out.println("X Wins!");
                g.drawImage(X, x, y, null);
                tick();
                g.drawImage(XWIN, 0, 0, null);
                bs.show();
                stop();
            }
            if((r + s + t).equals(b)) {
                System.out.println("O Wins!");
                g.drawImage(O, x, y, null);
                tick();
                g.drawImage(OWIN, 0, 0, null);
                bs.show();
                stop();
            }
            if((l+ o + r).equals(a)) {
                System.out.println("X Wins!");
                g.drawImage(X, x, y, null);
                tick();
                g.drawImage(XWIN, 0, 0, null);
                bs.show();
                stop();
            }
            if((l + o + r).equals(b)) {
                System.out.println("O Wins!");
                g.drawImage(O, x, y, null);
                tick();
                g.drawImage(OWIN, 0, 0, null);
                bs.show();
                stop();
            }
            if((m+ p + s).equals(a)) {
                System.out.println("X Wins!");
                g.drawImage(X, x, y, null);
                tick();
                g.drawImage(XWIN, 0, 0, null);
                bs.show();
                stop();
            }
            if((m + p + s).equals(b)) {
                System.out.println("O Wins!");
                g.drawImage(O, x, y, null);
                tick();
                g.drawImage(OWIN, 0, 0, null);
                bs.show();
                stop();
            }
            if((n+ q + t).equals(a)) {
                System.out.println("X Wins!");
                g.drawImage(X, x, y, null);
                tick();
                g.drawImage(XWIN, 0, 0, null);
                bs.show();
                stop();
            }
            if((n + q + t).equals(b)) {
                System.out.println("O Wins!");
                g.drawImage(O, x, y, null);
                tick();
                g.drawImage(OWIN, 0, 0, null);
                bs.show();
                stop();
            }
            if((l+ p + t).equals(a)) {
                System.out.println("X Wins!");
                g.drawImage(X, x, y, null);
                tick();
                g.drawImage(XWIN, 0, 0, null);
                bs.show();
                stop();
            }
            if((l + p + t).equals(b)) {
                System.out.println("O Wins!");
                g.drawImage(O, x, y, null);
                tick();
                g.drawImage(OWIN, 0, 0, null);
                bs.show();
                stop();
            }
            if((n+ p + r).equals(a)) {
                System.out.println("X Wins!");
                g.drawImage(X, x, y, null);
                tick();
                g.drawImage(XWIN, 0, 0, null);
                bs.show();
                stop();
            }
            if((n + p + r).equals(b)) {
                System.out.println("O Wins!");
                g.drawImage(O, x, y, null);
                tick();
                g.drawImage(OWIN, 0, 0, null);
                bs.show();
                stop();
            }

            // Draw the image at the calculated position
            g.drawImage(imageToDraw, x, y, null);
        }

        // Show the new frame
        bs.show();
        g.dispose();
    }
    public void run(){
        init();
        while(running){

            render();
        }
        stop();
    }
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}


