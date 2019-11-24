package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.thunderstructs.canvas.Canvas;
import org.academiadecodigo.thunderstructs.tools.*;


public class MapEditor implements MouseHandler {

    public static final int PADDING = 20;

    private Cursor cursor;
    private Canvas canvas;
    private ColorPalette palette;
    private ToolArea toolArea;
    private ToolSize toolSize;
    private int width;
    private int height;

    public MapEditor(int cols, int rows){
        this.width = cols;
        this.height = rows;
        cursor = new Cursor();
        canvas = new Canvas(cols, rows);
        palette = new ColorPalette(cols + PADDING);
        toolArea = new ToolArea(cols + PADDING + palette.getWidth() + PADDING);
        toolSize = new ToolSize(cols + PADDING + palette.getWidth() + PADDING + toolArea.getWidth() + PADDING);
        init();
    }

    public void init(){
        canvas.fillCanvas();
        palette.showPalette();
        toolArea.show();
        toolSize.show();
        canvas.setCursor(cursor);
        palette.setCursor(cursor);
        toolArea.setCursor(cursor);
        toolSize.setCursor(cursor);
        new KeyboardController(cursor);
        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        int col = (int) (mouseEvent.getX() - 10);
        int row = (int) (mouseEvent.getY() - PADDING - 10);

        if(col >= palette.getPalette()[0].getX() && col <= palette.getPalette()[0].getX() + palette.getPalette()[0].getWidth()){

            cursor.setColor(getClickedColor(row));
        }

        if(col >= toolArea.getTool()[0].getX() && col <= toolArea.getTool()[0].getX() + toolArea.getTool()[0].getWidth()){

            setTool(getClickedTool(row), getClickedTool(row).getSize1());
        }

        if(col >= toolSize.getTool()[0].getX() && col <= toolSize.getTool()[0].getX() + toolSize.getTool()[0].getWidth()) {

            setTool(cursor.getToolInUse(), getClickedToolSize(row));
        }

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

        int col = (int) (mouseEvent.getX() - (PADDING * 2));
        int row = (int) (mouseEvent.getY() - (PADDING * 3));

        if(col >= 0 && col <= width && row >= 0 && row <= height){
            cursor.move(mouseEvent.getX(), mouseEvent.getY());
            if(cursor.isPainting()){
                cursor.paint(col, row);
            }
        }
    }

    private Color getClickedColor(int clickY){

        for(int i = 0; i < palette.getPalette().length; i++){

            int startY = palette.getPalette()[i].getY();
            int endY = palette.getPalette()[i].getY() + palette.getPalette()[i].getHeight();

            if (clickY >= startY && clickY <= endY){
                return palette.getPalette()[i].getColor();
            }

        }

        return cursor.getColor();
    }

    private ToolsList getClickedTool(int clickY){

        ToolsList selTool = ToolsList.PENCIL;
        for(int i = 0; i < toolArea.getTool().length; i++){

            int startY = toolArea.getTool()[i].getY();
            int endY = toolArea.getTool()[i].getY() + toolArea.getTool()[i].getHeight();

            if (clickY >= startY && clickY <= endY){
                toolArea.getTool()[i].setColor(Color.LIGHT_GRAY);
                toolArea.getTool()[i].fill();
                selTool = ToolsList.values()[i];
            } else {
                toolArea.getTool()[i].setColor(Color.GRAY);
                toolArea.getTool()[i].draw();
            }

        }
        return selTool;
    }

    private int getClickedToolSize(int clickY){

        int size = 0;
        for(int i = 0; i < 5; i++){

            int startY = toolSize.getTool()[i].getY();
            int endY = toolSize.getTool()[i].getY() + toolSize.getTool()[i].getHeight();

            if (clickY >= startY && clickY <= endY){
                toolSize.getTool()[i].setColor(Color.LIGHT_GRAY);
                toolSize.getTool()[i].fill();
                size = i;

            } else {
                toolSize.getTool()[i].setColor(Color.GRAY);
                toolSize.getTool()[i].draw();
            }

        }

        switch (size){
            case 0:
                return cursor.getToolInUse().getSize1();
            case 1:
                return cursor.getToolInUse().getSize2();
            case 2:
                return cursor.getToolInUse().getSize3();
            case 3:
                return cursor.getToolInUse().getSize4();
            case 4:
                return cursor.getToolInUse().getSize5();
            default:
                return 1;
        }

    }

    private void setTool(ToolsList tool, int stroke){
        switch (tool){
            case PENCIL:
                cursor.setDrawingTool(new Pencil(stroke));
                cursor.setToolInUse(tool);
                break;
            case SPRAY:
                cursor.setDrawingTool(new Spray(stroke));
                cursor.setToolInUse(tool);
                break;
            case ERASER:
                cursor.setDrawingTool(new Eraser(stroke));
                cursor.setToolInUse(tool);
                break;
            default:
                break;
        }

    }
}
