package org.academiadecodigo.thunderstructs.tools;

import org.academiadecodigo.simplegraphics.graphics.Color;

public interface Tool {

    int[] getXCoordinates();

    int[] getYCoordinates();

    void setColor(Color color);

    void move(double x, double y);

}
