package MyGUI;

import java.awt.*;

public class JColor_set
{
    CreateGUI gui;
    String Color;
    public JColor_set(CreateGUI gui)
    {
        this.gui = gui;
    }
    public void changeColor(String color)
    {
        switch (color)
        {
            case "White":
                gui.fWindow.getContentPane().setBackground(java.awt.Color.white);
                gui.txt.setBackground(java.awt.Color.white);
                gui.txt.setForeground(java.awt.Color.BLACK);
                break;
            case "Black":
                gui.fWindow.getContentPane().setBackground(java.awt.Color.black);
                gui.txt.setBackground(java.awt.Color.BLACK);
                gui.txt.setForeground(java.awt.Color.WHITE);
                break;
            case "Pink":
                gui.fWindow.getContentPane().setBackground(new Color(112, 4, 76));
                gui.txt.setBackground(new Color(245, 240, 242));
                gui.txt.setForeground(new Color(214, 211, 21));
                break;
        }
    }
}
