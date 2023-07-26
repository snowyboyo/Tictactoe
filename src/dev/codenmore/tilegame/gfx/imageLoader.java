package dev.codenmore.tilegame.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class imageLoader {


    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(imageLoader.class.getResource(path));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
