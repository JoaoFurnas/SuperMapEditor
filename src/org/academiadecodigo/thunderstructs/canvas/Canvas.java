package org.academiadecodigo.thunderstructs.canvas;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.thunderstructs.Cursor;
import org.academiadecodigo.thunderstructs.MapEditor;

public class Canvas {

    public static Pixel[][] canvas;
    private int cols;
    private int rows;
    private Cursor cursor;

    public Canvas(int cols, int rows){

        this.cols = cols;
        this.rows = rows;
    }

    public void setCursor(Cursor cursor){
        this.cursor = cursor;
    }

    public void fillCanvas(){

        Rectangle back = new Rectangle(MapEditor.PADDING, MapEditor.PADDING, cols, rows);
        back.setColor(Color.GRAY);
        back.draw();

        canvas = new Pixel[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                canvas[i][j] = new Pixel(j + MapEditor.PADDING, i+ MapEditor.PADDING);

            }

        }

    }
}
