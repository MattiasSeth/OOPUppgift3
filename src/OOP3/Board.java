package OOP3;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {

    JPanel boardPanel = new JPanel();
    JButton[][] buttons = new JButton[4][4];



    public Board() {

        Game newGame = new Game();
        int[][]matrix = new int[4][4];
        newGame.generateGame(matrix);

        setSize(400,400);
        this.add(boardPanel);
        boardPanel.setLayout(new GridLayout(4,4));

        setupBoard();
        setBoardNumbers(matrix);

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void setupBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JButton tempButton = new JButton();
                tempButton.addMouseListener(new Game(tempButton));
                buttons[i][j] = tempButton;
                boardPanel.add(buttons[i][j]);
            }
        }
    }
    public void setBoardNumbers (int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                buttons[i][j].setText(String.valueOf(matrix[i][j]));
            }
        }
    }

    public static void main(String[] args) {

        Board b = new Board();
    }
}
