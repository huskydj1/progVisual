import javax.swing.*;
import java.awt.*;

public class mainWindow{
    public void batchVisualize(){
        JFrame frame = new JFrame("TabbedPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(540, 480);
        frame.setMinimumSize(new Dimension(640, 480));

        //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        JTabbedPane tabbedPane = new JTabbedPane();
        //<
        //TODO: Make main a method (without this inbetween tester code). Use wrapper classes to store watched objects

        /*
        Use CardLayout to Navigate Between Variables
        Use Buttons to Check Out Difference Time Points (Create on the side as to not disturb our work)
         */

        //>
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        frame.add(tabbedPane);
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TabbedPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(540, 480);
        frame.setMinimumSize(new Dimension(640, 480));

        JTabbedPane tabbedPane = new JTabbedPane();

        Integer[] arrI = {1, 2, 3, 4, 1000, 200000};
        DrawArray<Integer> tabI = new DrawArray<Integer>(arrI, "Integer Array", DrawArray.VERTICAL, DrawArray.BOTH);
        tabbedPane.addTab("Tab 2", tabI);

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        frame.add(tabbedPane);

        frame.pack();
        frame.setVisible(true);
    }
}
