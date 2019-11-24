package org.academiadecodigo.thunderstructs.tools;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Pencil implements Tool{

    private Rectangle cursor;
    private int stroke;
    private int[] xCoordinates;
    private int[] yCoordinates;

    public Pencil(int stroke){
        this.stroke = stroke;
        init();
    }

    private void init(){

        fillCoordinates();
        cursor = new Rectangle(0 , 0, stroke,  stroke);

    }

    public void setColor(Color color){
        cursor.setColor(color);
        cursor.fill();

    }

    public void move(double x, double y){

        double posX = x - cursor.getX() - stroke - 10;
        double posY = y - cursor.getY() - stroke - 30;

        cursor.translate(posX, posY);

    }

    private void fillCoordinates(){

        xCoordinates = new int[stroke*stroke];
        yCoordinates = new int[stroke*stroke];

        int countX = 0;

        for(int i = 0; i < stroke; i++){
            for (int j = 0; j < stroke; j++){

                xCoordinates[countX] = i;
                yCoordinates[countX] = j;
                countX++;
            }
        }

    }

    @Override
    public int[] getXCoordinates() {
        return xCoordinates;
    }

    @Override
    public int[] getYCoordinates() {
        return yCoordinates;
    }

}
