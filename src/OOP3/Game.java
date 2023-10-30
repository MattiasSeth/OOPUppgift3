package OOP3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {



    public Game (){

    }

    public void generateGame(int[][] matrix) {
        List<Integer> numberList = new ArrayList<>();

        for (int i=0; i<16; i++) {
            numberList.add(i);
        }
        Collections.shuffle(numberList);
        int counter = 0;

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                matrix[i][j] = numberList.get(counter);
                counter++;
            }
        }

    }

    public Cell getIndex(int userInput, int[][] matrix) {
        int []result = new int[2];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == userInput) {
                    return new Cell(i,j);
                }
            }
        }
        return null;
    }

    public ArrayList<Cell> getNeighbours (Cell currentCell){
        ArrayList<Cell> result = new ArrayList<>();
        int x = currentCell.getX();
        int y = currentCell.getY();

        result.add(new Cell(x+1,y));
        result.add(new Cell(x-1,y));
        result.add(new Cell(x,y+1));
        result.add(new Cell(x,y-1));

        for (int i=0; i<result.size(); i++) {
            int tempX = result.get(i).getX();
            int tempY = result.get(i).getY();

            if (tempX <0 || tempY < 0 || tempX > 3 || tempY > 3) {
                result.remove(i);
                i--;
            }
        }
        return result;
    }

    public void runGame (int clickedButton, int[][] matrix, JButton[][] buttons ) {

        Cell gameCell = getIndex(clickedButton, matrix);
        ArrayList<Cell> neighbours = getNeighbours(gameCell);

        for (int i=0; i<neighbours.size(); i++) {
            int neighbourX = neighbours.get(i).getX();
            int neighbourY = neighbours.get(i).getY();

            if (matrix[neighbourX][neighbourY] == 0) {
                int tempX = gameCell.getX();
                int tempY = gameCell.getY();

                matrix[neighbourX][neighbourY] = matrix[tempX][tempY];
                buttons[neighbourX][neighbourY].setText(String.valueOf(matrix[tempX][tempY]));
                matrix[tempX][tempY] = 0;
                buttons[tempX][tempY].setText("");
            }
        }

    }

    public boolean winCheck (int[][] matrix) {
        int counter = 1;

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == counter) {
                    counter++;
                }
            }
        }
        if (counter == 16 && matrix[3][3] == 0) {
            return true;
        }else
            return false;
    }

}