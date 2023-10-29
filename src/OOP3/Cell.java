package OOP3;

import java.util.ArrayList;

public class Cell {

    private int x;
    private int y;

    public Cell (int x, int y) {
        setX(x);
        setY(y);
    }
    public Cell () {

    }

    public void setX (int x) {
        this.x = x;
    }
    public void setY (int y) {
        this.y = y;
    }

    public int getX () {
        return this.x;
    }

    public int getY () {
        return this.y;
    }



}
