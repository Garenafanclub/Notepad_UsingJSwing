package MyGUI;

import org.w3c.dom.html.HTMLIsIndexElement;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.*;

public class CreateGUI implements ActionListener
{
    JFrame fWindow;
    JTextArea txt;
    boolean WordWrapOn = false;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu file , edit , view , color;
    JMenuItem open , save , exit , saveAs , jNew;
    JMenuItem undone , redone;
    JMenuItem iWrap , iFontArial , iFontCSMS , iFontTNR , iFontSize8 , iFontSize12 , iFontSize16 , iFontSize20 , iFontSize24;
    JMenuItem iColor1 , iColor2 , iColor3;
    JMenu menuFont , menuFontSize;
    JFile_New fNew = new JFile_New(this);
    JFormat_view fView = new JFormat_view(this);
    JColor_set ViewC  = new JColor_set(this);
    UndoManager un = new UndoManager();
    JEdit_new fEdit = new JEdit_new(this);
    ShortCuts sc = new ShortCuts(this);

    public static void main(String[] args)
    {
       new CreateGUI();
    }
    CreateGUI()
    {
       createWindow();
       createTextArea();
       createMenuBar();
       creteFileMenuItem();
       createEditMenu();
       createViewMenu();
       showColor();
       fView.selectedFont = "Arial";
       fView.createFont(16);
       fView.wordWrap();
       fWindow.setLocationRelativeTo(null);
       fWindow.setVisible(true);
       ViewC.changeColor("White");
    }
    public void createWindow()
    {
        fWindow = new JFrame("Notepad");
        fWindow.setSize(800,600);
        fWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void createTextArea()
    {
        txt = new JTextArea();
        txt.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                un.addEdit(e.getEdit());
            }
        });;
        txt.addKeyListener(sc);
        UIManager.getLookAndFeelDefaults().put( "TextField.caretForeground", Color.red );
        scrollPane  = new JScrollPane(txt);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());  // null;
        fWindow.add(scrollPane);
    }
    public void createMenuBar()
    {
        menuBar = new JMenuBar();
        fWindow.setJMenuBar(menuBar);

        file = new JMenu("File");
        menuBar.add(file);
        edit = new JMenu("Edit");
        menuBar.add(edit);
        view = new JMenu("View");
        menuBar.add(view);
        color = new JMenu("Color");
        menuBar.add(color);
    }

    public void creteFileMenuItem() {
        jNew = new JMenuItem("New");
        file.add(jNew);
        jNew.addActionListener(this);
        open = new JMenuItem("Open");
        file.add(open);
        open.addActionListener(this);
        save = new JMenuItem("Save");
        file.add(save);
        save.addActionListener(this);
        saveAs = new JMenuItem("Save as");
        file.add(saveAs);
        saveAs.addActionListener(this);
        exit = new JMenuItem("Exit");
        file.add(exit);
        exit.addActionListener(this);
    }
    public  void createViewMenu()
    {
        iWrap = new JMenuItem("Word Wrap: Off");
        iWrap.addActionListener(this);
        view.add(iWrap);
        menuFont = new JMenu("Font");
        view.add(menuFont);
        menuFontSize = new JMenu("Font Size");
        view.add(menuFontSize);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        menuFont.add(iFontTNR);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        menuFontSize.add(iFontSize8);


        iFontSize12 = new JMenuItem("12");
        menuFontSize.add(iFontSize12);
        iFontSize12.addActionListener(this);

        iFontSize16 = new JMenuItem("16");
        menuFontSize.add(iFontSize16);
        iFontSize16.addActionListener(this);

        iFontSize20 = new JMenuItem("20");
        menuFontSize.add(iFontSize20);
        iFontSize20.addActionListener(this);

        iFontSize24 = new JMenuItem("24");
        menuFontSize.add(iFontSize24);
        iFontSize24.addActionListener(this);
    }
    public void createEditMenu()
    {
        undone = new JMenuItem("Undo");
        undone.addActionListener(this);
        edit.add(undone);
        redone = new JMenuItem("Redo");
        redone.addActionListener(this);
        edit.add(redone);

    }
    public void showColor()
    {
        iColor1 = new JMenuItem("White");
        iColor1.addActionListener(this);
        color.add(iColor1);
        iColor2 = new JMenuItem("Black");
        iColor2.addActionListener(this);
        color.add(iColor2);
        iColor3 = new JMenuItem("Pink");
        iColor3.addActionListener(this);
        color.add(iColor3);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
       JMenuItem mi =  (JMenuItem)e.getSource();
       if(mi == jNew)
       {
         fNew.New_File();
       } else if(mi == open)
       {
           try {
               fNew.open_file();
           } catch (FileNotFoundException ex) {
               throw new RuntimeException(ex);
           }
       } else if(mi == saveAs)
       {
           fNew.saveAs_file();
       } else if (mi == save)
       {
           try {
               fNew.save_file();
           } catch (IOException ex) {
               throw new RuntimeException(ex);
           }
       } else if (mi == exit) {
           fNew.exit_file();
       } else if(mi == iWrap)
       {
           fView.wordWrap();
       } else if (mi == iFontSize8) {
           fView.createFont(8);
       } else if (mi == iFontSize12) {
           fView.createFont(12);
       } else if (mi == iFontSize16) {
           fView.createFont(16);
       } else if (mi == iFontSize20) {
           fView.createFont(20);
       } else if (mi == iFontSize24) {
           fView.createFont(24);
       } else if (mi == iFontArial) {
           fView.setFont("Arial");
       } else if (mi == iFontCSMS) {
           fView.setFont("Comic Sans MS");
       } else if (mi == iFontTNR) {
           fView.setFont("Times New Roman");
       } else if (mi == iColor1) {
            ViewC.changeColor("White");
       } else if (mi == iColor2) {
           ViewC.changeColor("Black");
       } else if (mi == iColor3) {
           ViewC.changeColor("Pink");
       } else if (mi == undone) {
           fEdit.undo();
       } else if (mi == redone) {
           fEdit.redo();
       }
    }
}