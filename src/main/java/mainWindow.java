import javax.swing.*;
import java.awt.*;

public class mainWindow{

    public static void main(String[] args) {
        JFrame frame = new JFrame("TabbedPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(640, 480));

        //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        JTabbedPane tabbedPane = new JTabbedPane();
        //<

        /*
        Use CardLayout to Navigate Between Variables
        Use Buttons to Check Out Difference Time Points (Create on the side as to not disturb our work)
         */

        ArrayListVisual<Integer> tmp = new ArrayListVisual<Integer>("Test Array");
        tmp.add(10);
        tmp.add(20);
        tmp.add(30);
        tmp.add(1);
        tmp.add(10000);
        //TODO: Figure out how to scroll through pane
        tabbedPane.addTab(tmp.getName(), tmp);

        //>
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        frame.add(tabbedPane);
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        frame.pack();
        frame.setVisible(true);
    }
}
