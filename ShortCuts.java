package MyGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;


public class ShortCuts implements KeyListener , MouseListener
{
    CreateGUI gui;
    ShortCuts(CreateGUI gui)
    {
        this.gui = gui;
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S)
        {
            try {
                gui.fNew.save_file();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.isShiftDown() && e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
            gui.fNew.saveAs_file();
        }
        if(e.isAltDown() && e.getKeyCode() == KeyEvent.VK_F)
        {
           gui.file.doClick();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}


    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e)
    {
        gui.fNew.setBackground(Color.DARK_GRAY);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        gui.fNew.setBackground(Color.yellow);
    }

}
