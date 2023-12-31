package OOP3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Board extends JFrame {

    JPanel borderPanel = new JPanel();
    JPanel newGamePanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JButton[][] buttons = new JButton[4][4];

    JButton newGameButton = new JButton("New Game");

    public int[][] matrix;

    public Board() {
        // empty matrix
        matrix = new int[4][4];

        // Game
        newGameButton.addActionListener(e -> {
            clearBoard();
            Game newGame = new Game();

            //newGame.getWinMatrix(matrix);      // win Matrix
            newGame.generateGame(matrix);
            setupBoard();
            setBoardNumbers(matrix);

            MouseAdapter mouseAdapter = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        JButton clickedButton = (JButton) e.getSource();
                        int buttonValue = Integer.parseInt(clickedButton.getText());
                        newGame.runGame(buttonValue, matrix, buttons);

                        if(newGame.winCheck(matrix)){
                            System.out.println("Du vann!");
                            System.exit(0);
                        }
                    }catch (NumberFormatException ignored){

                    }
                }
            };

            // add mouseAdapter
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    buttons[i][j].addMouseListener(mouseAdapter);
                }
            }
        });

        // panels
        setSize(400,400);
        this.add(borderPanel);
        borderPanel.setLayout(new BorderLayout());
        borderPanel.add(newGamePanel, BorderLayout.NORTH);
        borderPanel.add(boardPanel, BorderLayout.CENTER);
        newGamePanel.add(newGameButton);
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
                //tempButton.addMouseListener(new MouseClick(tempButton));
                buttons[i][j] = tempButton;
                boardPanel.add(buttons[i][j]);
            }
        }
    }
    public void clearBoard (){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                boardPanel.remove(buttons[i][j]);
            }
        }
    }
    public void setBoardNumbers (int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0)
                    buttons[i][j].setText(String.valueOf(matrix[i][j]));
                    Font customFont = new Font(buttons[i][j].getFont().getFontName(), Font.BOLD, 26);
                    buttons[i][j].setFont(customFont);
                    buttons[i][j].setBackground(Color.DARK_GRAY);
                    buttons[i][j].setForeground(Color.WHITE);
            }
        }
    }

    public static void main(String[] args) {

        Board b = new Board();
    }
}
