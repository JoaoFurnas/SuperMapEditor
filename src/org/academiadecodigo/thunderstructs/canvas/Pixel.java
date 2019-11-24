package org.academiadecodigo.thunderstructs.canvas;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Pixel {

    private Rectangle pixel;
    private Color color;
    private boolean isPainted;
    private int posX;
    private int posY;

    public Pixel(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        pixel = new Rectangle(posX, posY, 1, 1);
        isPainted = false;

    }

    public void paint(Color color){
        this.color = color;
        pixel.setColor(color);
        pixel.fill();
        isPainted = true;
    }

    public void erase(){
        pixel.setColor(Color.WHITE);
        pixel.draw();
        isPainted = false;
    }

    public boolean isPainted() {
        return isPainted;
    }

}
