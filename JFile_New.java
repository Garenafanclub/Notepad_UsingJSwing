package MyGUI;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class JFile_New extends Component {
    CreateGUI gui;
    String fileName;
    String fileAddress;
    public JFile_New(CreateGUI gui)
    {
        this.gui = gui;
    }
    public void New_File()
    {
        gui.txt.setText("");
        gui.fWindow.setTitle("New");
        fileName = null;
        fileAddress = null;
    }
    public void open_file() throws FileNotFoundException {
       FileDialog dialog = new FileDialog(gui.fWindow , "Open" , FileDialog.LOAD);
       dialog.setVisible(true);
       if(dialog.getFile()!= null)
       {
           fileName = dialog.getFile();
           fileAddress = dialog.getDirectory();
           gui.fWindow.setTitle(fileName);
       }
       String str = null;
       try
       {
           BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
           gui.txt.setText("");
           while((str = br.readLine())!= null)
           {
              gui.txt.append(str + "\n");
           }
           br.close();
       }catch (Exception ee)
       {
           System.out.println("File not Found");
       }
    }
    public void save_file() throws IOException {
       if(fileName == null)
       {
           saveAs_file();
       }
       else {
           try {
               FileWriter fw = new FileWriter(fileAddress + fileName);
               fw.write(gui.txt.getText());
               gui.fWindow.setTitle(fileName);
               fw.close();
           }catch (Exception ee)
           {
               System.out.println("Something went Wrong");
           }
       }
    }

    public void saveAs_file()
    {
        FileDialog fd = new FileDialog(gui.fWindow , "Save" , FileDialog.SAVE);
        fd.setVisible(true);
        if(fd.getFile()!= null)
        {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.fWindow.setTitle(fileName);
        }
        try
        {FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(gui.txt.getText());
            fw.close();
        }catch (Exception ee)
        {
            System.out.println("Something went Wrong");
        }
    }
    public void exit_file()
    {
        System.exit(0);
    }
}
