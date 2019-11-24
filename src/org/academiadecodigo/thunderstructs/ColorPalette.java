package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class ColorPalette {

    private final int WIDTH = 50;
    private final int HEIGHT = 20;
    private Rectangle[] palette;
    private Cursor cursor;

    public ColorPalette(int posX){
        palette = new Rectangle[10];

        for(int i = 0; i < palette.length; i++){
            palette[i] = new Rectangle(MapEditor.PADDING + posX, i * HEIGHT + (i*5) + MapEditor.PADDING, WIDTH, HEIGHT);
        }
        addColors();

    }

    private void addColors(){
        palette[0].setColor(Color.BLACK);
        palette[1].setColor(Color.GRAY);
        palette[2].setColor(Color.MAGENTA);
        palette[3].setColor(Color.PINK);
        palette[4].setColor(Color.CYAN);
        palette[5].setColor(Color.ORANGE);
        palette[6].setColor(Color.YELLOW);
        palette[7].setColor(Color.GREEN);
        palette[8].setColor(Color.BLUE);
        palette[9].setColor(Color.RED);

    }

    public void showPalette(){
        for(int i = 0; i < palette.length; i++){
            palette[i].fill();
        }
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

    public Rectangle[] getPalette(){
        return palette;
    }

    public int getHeight(){
        return HEIGHT;
    }

    public int getWidth(){
        return WIDTH;
    }

}
