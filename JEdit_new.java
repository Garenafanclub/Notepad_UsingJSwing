package MyGUI;

public class JEdit_new
{
    CreateGUI gui;
    JEdit_new(CreateGUI gui)
    {
        this.gui = gui;
    }
    public void undo()
    {
        try{
            gui.un.undo();     //  if(gui.txt == null) {}
        }catch (Exception ee) {}
    }
    public void redo()
    {
        try {
            gui.un.redo();
        }catch (Exception ee)  {}
    }
}
