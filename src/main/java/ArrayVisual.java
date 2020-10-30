import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/*
Class for drawing arrays of any type with their name
Extends JComponent
 */
public class ArrayVisual<D> extends JComponent{

    private D[] arr;
    private String name;

    public ArrayVisual(D[] array, String name){
        this.arr = array;
        this.name = name;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        //Default Styles
        g.setFont(new Font("sanserif", Font.BOLD, 14));
        g.setColor(Color.DARK_GRAY);

        //Generate Rectangle
        int x = 25, y = 25;

        /*
        //When I stored an ArrayList of arrays
        for(int i = 0; i<list.size(); ++i){
            g = insertArray(names.get(i), list.get(i), x, y, g);
            y+=100;
        }
        System.out.println(list.size());
         */

        g = insertArray(this.name, this.arr, x, y, g);
    }

    private Graphics insertArray(String arrayName, D[] arr, int x, int y, Graphics g){
        //Display Name
        arrayName = arrayName.trim();
        g.drawString(arrayName + ":", x, y+20);

        //Iterate through and visualize each cell
        int x1 = x, y1 = y+25;
        for(int i = 0; i<arr.length; i++){
            String content = arr[i].toString();
            int width = Math.max(g.getFontMetrics(g.getFont()).stringWidth(content) + 30, 50);
            //Draw Cell
            g.drawRect(x1, y1, width, 50);
            //Display Contents
            g.drawString(content, x1 + 15, y1+30);
            //Display Index
            int widthIndex = g.getFontMetrics(g.getFont()).stringWidth(Integer.toString(i));
            g.drawString(Integer.toString(i), x1 + width/2 - widthIndex/2, y1 + 65);

            //Update (x, y) pointer
            x1+=width;
        }
        return g;
    }
}