package org.academiadecodigo.thunderstructs.tools;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Spray implements Tool{

    private int stroke;
    private int[] xCoordinates;
    private int[] yCoordinates;
    private Rectangle cursor;

    public Spray(int stroke){
        this.stroke = stroke;
        cursor = new Rectangle(0, 0, stroke, stroke);
        init();
    }



    private void init(){

        fillCoordinates();
        cursor = new Rectangle(0 , 0, stroke,  stroke);

    }

    public void setColor(Color color){
        cursor.setColor(color);
        cursor.draw();

    }

    public void move(double x, double y){

        double posX = x - cursor.getX() - stroke - 10;
        double posY = y - cursor.getY() - stroke - 30;

        cursor.translate(posX, posY);

    }


    private void fillCoordinates(){

        int points = (int) (stroke * stroke * 0.3);

        xCoordinates = new int[points];
        yCoordinates = new int[points];

        for(int i = 0; i < points; i++){

            xCoordinates[i] = (int)(Math.random() * stroke);
            yCoordinates[i] = (int)(Math.random() * stroke);
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
