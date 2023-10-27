package OOP3;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {

    JPanel boardPanel = new JPanel();
    JButton[][] buttons = new JButton[4][4];



    public Board() {
        setSize(400,400);
        this.add(boardPanel);
        boardPanel.setLayout(new GridLayout(4,4));

        setupBoard();


        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void setupBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j] = new JButton();
                boardPanel.add(buttons[i][j]);
            }
        }
    }

    public static void main(String[] args) {

        Board b = new Board();
    }
}
