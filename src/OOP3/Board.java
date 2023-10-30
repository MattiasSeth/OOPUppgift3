package OOP3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Board extends JFrame {

    JPanel boardPanel = new JPanel();
    JButton[][] buttons = new JButton[4][4];



    public Board() {

        int[][] matrix2 = {  { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 0, 15 } };

        Game newGame = new Game();
        int[][]matrix = new int[4][4];
        newGame.generateGame(matrix);

        setSize(400,400);
        this.add(boardPanel);
        boardPanel.setLayout(new GridLayout(4,4));

        setupBoard();
        setBoardNumbers(matrix2);
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                int buttonValue = Integer.parseInt(clickedButton.getText());
                newGame.runGame(buttonValue, matrix2, buttons);

                if(newGame.winCheck(matrix2)){    /// Glöm ej att fixa
                    System.out.println("Du vann!");
                    System.exit(0);
                }
            }
        };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j].addMouseListener(mouseAdapter);
            }
        }

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public void setupBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JButton tempButton = new JButton();
                //tempButton.addMouseListener(new MouseClick(tempButton));
                buttons[i][j] = tempButton;
                boardPanel.add(buttons[i][j]);
            }
        }
    }
    public void setBoardNumbers (int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0)
                    buttons[i][j].setText(String.valueOf(matrix[i][j]));
            }
        }
    }
    public void winBoardTest(int[][] matrix){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

            }
        }
    }
    public static void main(String[] args) {

        Board b = new Board();
    }
}
