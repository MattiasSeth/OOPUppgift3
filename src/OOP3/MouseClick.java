package OOP3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClick extends MouseAdapter {


    private JButton jb;

    public MouseClick(JButton jb){
        this.jb = jb;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        jb.setBackground(Color.BLACK);
    }

}
