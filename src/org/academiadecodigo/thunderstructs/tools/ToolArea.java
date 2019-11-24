package org.academiadecodigo.thunderstructs.tools;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.thunderstructs.Cursor;
import org.academiadecodigo.thunderstructs.MapEditor;

public class ToolArea {

    private final int WIDTH = 60;
    private final int HEIGHT = 30;
    private Rectangle[] tool;
    private Text[] labels;
    private Cursor cursor;

    public ToolArea(int posX){
        tool = new Rectangle[ToolsList.values().length];
        labels = new Text[ToolsList.values().length];

        for(int i = 0; i < tool.length; i++){
            tool[i] = new Rectangle(MapEditor.PADDING + posX, i * HEIGHT + (i*5) + MapEditor.PADDING, WIDTH, HEIGHT);
            tool[i].setColor(Color.GRAY);
            labels[i] = new Text(MapEditor.PADDING + posX + 10, i * HEIGHT + (i*5) + MapEditor.PADDING + 10, ToolsList.values()[i].getName());
            labels[i].setColor(Color.GRAY);
        }

    }

    public void show(){
        for(int i = 0; i < tool.length; i++){
            tool[i].draw();
            labels[i].draw();
        }
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

    public Rectangle[] getTool(){
        return tool;
    }

    public int getHeight(){
        return HEIGHT;
    }

    public int getWidth(){
        return WIDTH;
    }

}
