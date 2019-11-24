package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {
    public static void main(String[] args) {

        Rectangle back = new Rectangle(10,10,1000,500);
        back.setColor(Color.BLACK);
        back.draw();

        MapEditor editor = new MapEditor(700, 400);
        editor.init();

    }
}
