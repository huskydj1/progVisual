import javax.swing.*;
import java.awt.*;

public class mainWindow{
    //clear
    //add
    //remove
    //batch visualize
    public static void main(String[] args) {
        JFrame frame = new JFrame("TabbedPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(540, 480);
        frame.setMinimumSize(new Dimension(640, 480));

        //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        JTabbedPane tabbedPane = new JTabbedPane();
        //<
        //TODO: Make main a method (without this inbetween tester code). Use wrapper classes to store watched objects

        String[] arrS = {"Hello", "My", "Name", "JEFF"};
        ArrayVisual<String> tabS = new ArrayVisual<String>(arrS, "String Array");
        tabbedPane.addTab("Tab 1", tabS);

        Integer[] arrI = {1, 2, 3, 4, 1000, 200000};
        ArrayVisual<Integer> tabI = new ArrayVisual<Integer>(arrI, "Integer Array");
        tabbedPane.addTab("Tab 2", tabI);

        Double[] arrD = {1.2, 2.0, 3.5, 4.9, 1000.020, 200000.14};
        ArrayVisual<Double> tabD = new ArrayVisual<Double>(arrD, "Double Array");
        tabbedPane.addTab("Tab 3", tabD);

        Character[] arrC = {'a', 'b', 'c', 'd', 'e', '.', 'z'};
        ArrayVisual<Character> tabC = new ArrayVisual<Character>(arrC, "Character Array");
        tabbedPane.addTab("Tab 4", tabC);

        //>
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        frame.add(tabbedPane);
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        frame.pack();
        frame.setVisible(true);
    }
}
