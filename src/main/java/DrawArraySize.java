import javax.swing.*;
import java.awt.*;

/**
 * The DrawArraySize class simulates the visualization of 1D arrays to track how the size of the visualization window is affected.
 * Because the orientation and openings of the visualization are parameterized, the application has the flexibility
 * to be used for a variety of other data-structures.
 * @author huskydj1
 */
public class DrawArraySize<D> extends JComponent{
    //extends JComponent for paintComponent

    public static final int HORIZONTAL = 0, VERTICAL = 1;
    public static final int NONE = 2, FRONT = 3, BACK = 4, BOTH = 5;

    public int x = 25, y = 25;

    private D[] arr;
    private int orientation;
    private int opening;
    private String name;

    public DrawArraySize(D[] array, String name, int orientation, int opening){
        this.arr = array;
        this.name = name;
        this.orientation = orientation;
        this.opening = opening;
    }

    public void setXY (int x, int y){
        this.x = x;
        this.y = y;
    }

    public Dimension insertArray(Dimension d){
        if(orientation==DrawArray.HORIZONTAL){
            d = insertHorizontalArray(d);
        }
        else if(orientation==DrawArray.VERTICAL){
            d = insertVerticalArray(d);
        }
        return d;
    }

    private Dimension insertHorizontalArray(Dimension d){
        //getFontMetrics
        Font font = new Font("sanserif", Font.BOLD, 14);
        Canvas c = new Canvas();
        FontMetrics fm = c.getFontMetrics(font);

        //Display Name
        String arrayName = this.name.trim();
        d.width = Math.max(d.width, x + fm.stringWidth(arrayName + ":"));
        d.height = Math.max(d.height, y+20);

        //Stop if Array Is Empty
        if(arr.length==0){
            d.width = Math.max(d.width, x + fm.stringWidth("EMPTY OBJECT PASSED"));
            d.height = Math.max(d.height, y+50);
            y+=70;
            return d;
        }

        int x1 = x, y1 = y+25;

        //Iterate through and visualize each cell
        for(int i = 0; i<arr.length; i++){
            String content = arr[i].toString();
            int width = Math.max(fm.stringWidth(content) + 30, 50);

            //Draw Cell
            d.width = Math.max(d.width, x1+width);
            d.height = Math.max(d.height, y1+50);

            //Display Index
            d.height = Math.max(d.height, y1+65);

            //Update (x, y) pointer
            x1+=width;
        }
        y = y1 + 65 + 20;
        return d;
    }

    private Dimension insertVerticalArray(Dimension d) {
        //getFontMetrics
        Font font = new Font("sanserif", Font.BOLD, 14);
        Canvas c = new Canvas();
        FontMetrics fm = c.getFontMetrics(font);

        //Display Name
        String arrayName = this.name.trim();
        d.width = Math.max(d.width, x + fm.stringWidth(arrayName + ":"));
        d.height = Math.max(d.height, y+20);

        //Stop if Array is Empty
        if (arr.length == 0) {
            d.width = Math.max(d.width, x + fm.stringWidth("EMPTY OBJECT PASSED"));
            d.height = Math.max(d.height, y+50);
            y+=70;
            return d;
        }

        //Iterate through and Final Final Width
        int maxWidth = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            String content = arr[i].toString();
            int width = Math.max(fm.stringWidth(content) + 30, 50);
            maxWidth = Math.max(maxWidth, width);
        }
        d.width = Math.max(d.width, x + maxWidth);

        //Iterate through and Visualize Each Cell - Uniform Cell Height
        int y1 = y + 25;

        y+= 50*arr.length;

        //Draw Arrow of Direction
        y = y1 + 20 + 20;

        d.height = Math.max(d.height, y);
        return d;
    }
}
