package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.thunderstructs.canvas.Canvas;
import org.academiadecodigo.thunderstructs.tools.Pencil;
import org.academiadecodigo.thunderstructs.tools.Tool;
import org.academiadecodigo.thunderstructs.tools.ToolsList;

public class Cursor {

    private Color color;
    private Tool drawingTool;
    private ToolsList toolInUse;
    private boolean isPainting;
    private int stroke;

    public Cursor() {
        this.isPainting = false;
        this.toolInUse = ToolsList.PENCIL;
        this.stroke = toolInUse.getSize1();
        drawingTool = new Pencil(stroke);
        this.color = Color.RED;
        this.drawingTool.setColor(color);
    }

    public void move(double x, double y) {
        drawingTool.setColor(color);
        drawingTool.move(x,y);
    }

    public void paint(int posX, int posY){

            for(int i = 0; i < drawingTool.getXCoordinates().length; i++){
                int x = drawingTool.getXCoordinates()[i];
                int y = drawingTool.getYCoordinates()[i];

                if(toolInUse == ToolsList.ERASER){
                    Canvas.canvas[posY + y][posX + x].erase();
                } else {
                    Canvas.canvas[posY + y][posX + x].paint(color);
                }
            }

    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

    public boolean isPainting() {
        return isPainting;
    }

    public void setPainting(boolean painting) {
        isPainting = painting;
    }

    public void setDrawingTool(Tool tool){
        drawingTool = tool;
    }

    public void setToolInUse(ToolsList tool){
        toolInUse = tool;
    }

    public ToolsList getToolInUse() {
        return toolInUse;
    }
}

