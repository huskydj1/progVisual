import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

public class TESTER
{
    public static void main(String[] args)    {
        mainWindow window = new mainWindow();

        ArrayListVisual<Integer> iList = new ArrayListVisual<Integer>("Integer list");
        iList.add(120);
        iList.add(2);
        iList.add(154523);
        iList.add(214);
        iList.removeIndex(2);
        window.addTab(iList);

        ArrayListVisual<String> sList = new ArrayListVisual<String>("String list");
        sList.add("Hello ");
        sList.add("My name ");
        sList.add(" is ");
        sList.removeIndex(2);
        window.addTab(sList);

        window.visual();
    }
}