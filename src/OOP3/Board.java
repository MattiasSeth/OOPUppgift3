package OOP3;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {

    JPanel boardPanel = new JPanel();
    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();
    JButton b4 = new JButton();
    JButton b5 = new JButton();
    JButton b6 = new JButton();
    JButton b7 = new JButton();
    JButton b8 = new JButton();
    JButton b9 = new JButton();
    JButton b10 = new JButton();
    JButton b11 = new JButton();
    JButton b12 = new JButton();
    JButton b13 = new JButton();
    JButton b14 = new JButton();
    JButton b15 = new JButton();
    JButton b16 = new JButton();


    public Board() {
        setSize(400,400);
        this.add(boardPanel);
        boardPanel.setLayout(new GridLayout(4,4));
        boardPanel.add(b1);
        boardPanel.add(b2);
        boardPanel.add(b3);
        boardPanel.add(b4);
        boardPanel.add(b5);
        boardPanel.add(b6);
        boardPanel.add(b7);
        boardPanel.add(b8);
        boardPanel.add(b9);
        boardPanel.add(b10);
        boardPanel.add(b11);
        boardPanel.add(b12);
        boardPanel.add(b13);
        boardPanel.add(b14);
        boardPanel.add(b15);
        boardPanel.add(b16);


        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        Board b = new Board();
    }
}
