package MyGUI;

import java.awt.*;

public class JFormat_view extends Component
{
   CreateGUI gui;
   Font arial , comicSansMS , timesNewRoman;
   String selectedFont;
   public JFormat_view(CreateGUI gui)
   {
       this.gui = gui;
   }
   public void wordWrap()
   {
       if(gui.WordWrapOn == false)
       {
           gui.WordWrapOn = true;
           gui.txt.setLineWrap(true);  // do word wrap after completion of a word..
           gui.txt.setWrapStyleWord(true);
           gui.iWrap.setText("Word Wrap: ON");
       }
       else if(gui.WordWrapOn)
       {
           gui.WordWrapOn = false;
           gui.txt.setLineWrap(true);  // do word wrap after completion of a word..
           gui.txt.setWrapStyleWord(true);
           gui.iWrap.setText("Word Wrap : Off");
       }
   }
   public void createFont(int fontSize)
   {
       arial = new Font("Arial", Font.PLAIN, fontSize);
       comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
       timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
       setFont(selectedFont);
   }
   public void setFont(String font)
   {
       selectedFont = font;
       switch (selectedFont)
       {
           case "Arial":
               gui.txt.setFont(arial);
               break;
           case "Comic Sans MS":
               gui.txt.setFont(comicSansMS);
               break;
           case "Times New Roman":
               gui.txt.setFont(timesNewRoman);
               break;
       }
   }

}
