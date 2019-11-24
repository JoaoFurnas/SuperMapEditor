package org.academiadecodigo.thunderstructs.tools;

public enum ToolsList {
    PENCIL("Pencil", 2, 4, 6, 8, 10),
    SPRAY("Spray", 4,8, 12, 16, 20),
    ERASER("Eraser", 2, 4, 6, 8, 10);

    String name;
    int size1;
    int size2;
    int size3;
    int size4;
    int size5;

    ToolsList(String name, int size1, int size2, int size3, int size4, int size5){
        this.name = name;
        this.size1 = size1;
        this.size2 = size2;
        this.size3 = size3;
        this.size4 = size4;
        this.size5 = size5;
    }

    public String getName(){
        return name;
    }

    public int getSize1() {
        return size1;
    }

    public int getSize2() {
        return size2;
    }

    public int getSize3() {
        return size3;
    }

    public int getSize4() {
        return size4;
    }

    public int getSize5() {
        return size5;
    }

}
