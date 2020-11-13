import javax.swing.*;
import java.awt.*;

/**
 * The DrawArray class visualizes 1D arrays.
 * Because the orientation and openings of the visualization are parameterized, the application has the flexibility
 * to be used for a variety of other data-structures.
 * @author huskydj1
 */
public class DrawArray<D> extends JComponent{
    //extends JComponent for paintComponent

    public static final int HORIZONTAL = 0, VERTICAL = 1;
    public static final int NONE = 2, FRONT = 3, BACK = 4, BOTH = 5;

    public int x = 25, y = 25;

    private D[] arr;
    private int orientation;
    private int opening;
    private String name;

    /**
     * Creates a new DrawArray based on the provided array, name, orientation, and number of openings.
     * All of the parameters must be offered in instantiation. They cannot be modified following.
     * @param array the generic array which the visualization represents
     * @param name the name of the visualized array
     * @param orientation the orientation (horizontal/vertical) that the visualization should be
     * @param opening specifies the openings present at the ends of the visualization
     */
    public DrawArray(D[] array, String name, int orientation, int opening){
        this.arr = array;
        this.name = name;
        this.orientation = orientation;
        this.opening = opening;
    }

    /**
     * Sets the top-left "origin" point, with respect to a coordinate plane, from which the graphic is drawn
     * @param x the x-component of the "origin" point
     * @param y the y-component of the "origin" point
     */
    public void setXY (int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Allows the visualization of a single array in its stored state
     * @param g stores the information used by Java to render the graphic
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        //Default Styles
        g.setFont(new Font("sanserif", Font.BOLD, 14));
        g.setColor(Color.DARK_GRAY);

        //Generate Rectangle
        g = insertArray(g);
        return;
    }

    /**
     * Inserts the array visualization as parameterized and stored into Graphics g
     * @param g stores the information used by Java to render the graphic
     * @return Graphics g after the information to render the array visualization is inserted
     */
    public Graphics insertArray(Graphics g){
        if(orientation==DrawArray.HORIZONTAL){
            g = insertHorizontalArray(g);
        }
        else if(orientation==DrawArray.VERTICAL){
            g = insertVerticalArray(g);
        }
        return g;
    }

    /**
     * Inserts a horizontal array visualization into Graphics g
     * @param g stores the information used by Java to render the graphic
     * @return Graphics g after the information to render the array visualization is inserted
     */
    private Graphics insertHorizontalArray(Graphics g){
        //Display Name
        String arrayName = this.name.trim();
        g.drawString(arrayName + ":", x, y+20);

        //Stop if Array is Empty
        if(arr.length==0){
            g.setColor(Color.MAGENTA);
            g.drawString("EMPTY OBJECT PASSED", x, y+50);
            g.setColor(Color.darkGray);
            y+=70;
            return g;
        }

        //Draw Arrow of Direction
        int x1 = x, y1 = y+25;
        int[] triangleX = {x1 - 10, x1 - 20, x1 - 20}, triangleY = {y1 + 25, y1 + 15, y1 + 35};
        g.drawPolygon(triangleX, triangleY, 3);

        //Iterate through and visualize each cell
        for(int i = 0; i<arr.length; i++){
            String content = arr[i].toString();
            int width = Math.max(g.getFontMetrics(g.getFont()).stringWidth(content) + 30, 50);

            //Draw Cell
            g.drawRect(x1, y1, width, 50);

            //Consider Openings
            if(i==0 && (opening==DrawArray.FRONT || opening==DrawArray.BOTH)){
                g.setColor(Color.WHITE);
                g.fillRect(x1, y1, 3, 50);
                g.setColor(Color.darkGray);
            }
            if(i==arr.length-1 && (opening==DrawArray.BACK || opening==DrawArray.BOTH)){
                g.setColor(Color.WHITE);
                g.fillRect(x1+width, y1, 3, 50);
                g.setColor(Color.darkGray);
            }

            //Display Contents
            int widthContent = g.getFontMetrics(g.getFont()).stringWidth(content);
            g.setColor(Color.BLUE);
            g.drawString(content, x1 + width/2 - widthContent/2, y1+30);
            g.setColor(Color.darkGray);

            //Display Index
            int widthIndex = g.getFontMetrics(g.getFont()).stringWidth(Integer.toString(i));
            g.drawString(Integer.toString(i), x1 + width/2 - widthIndex/2, y1 + 65);

            //Update (x, y) pointer
            x1+=width;
        }
        y = y1 + 65 + 20;
        return g;
    }

    /**
     * Inserts a vertical array visualization into Graphics g
     * @param g stores the information used by Java to render the graphic
     * @return Graphics g after the information to render the array visualization is inserted
     */
    private Graphics insertVerticalArray(Graphics g) {
        //Display Name
        String arrayName = name.trim();
        g.drawString(arrayName + ":", x, y + 20);

        //Stop if Array is Empty
        if (arr.length == 0) {
            g.setColor(Color.red);
            g.drawString("EMPTY OBJECT PASSED", x, y + 50);
            g.setColor(Color.darkGray);

            y+=70;
            return g;
        }

        //Iterate through and Final Final Width
        int maxWidth = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            String content = arr[i].toString();
            int width = Math.max(g.getFontMetrics(g.getFont()).stringWidth(content) + 30, 50);
            maxWidth = Math.max(maxWidth, width);
        }

        //Iterate through and Visualize Each Cell
        int x1 = x, y1 = y + 25;

        for (int i = arr.length - 1; i >= 0; i--) {
            String content = arr[i].toString();

            //Draw Cell
            g.drawRect(x1, y1, maxWidth, 50);

            //Consider Openings
            if(i==0 && (opening==DrawArray.FRONT || opening==DrawArray.BOTH)){
                g.setColor(Color.WHITE);
                g.fillRect(x1, y1+50, maxWidth, 3);
                g.setColor(Color.darkGray);
            }
            if(i==arr.length-1 && (opening==DrawArray.BACK || opening==DrawArray.BOTH)){
                g.setColor(Color.WHITE);
                g.fillRect(x1, y1, maxWidth, 3);
                g.setColor(Color.darkGray);
            }

            //Display Contents
            int widthContent = g.getFontMetrics(g.getFont()).stringWidth(content);
            g.setColor(Color.BLUE);
            g.drawString(content, x1 + maxWidth / 2 - widthContent / 2, y1 + 30);
            g.setColor(Color.darkGray);

            //Display Index
            g.drawString(Integer.toString(i), x1 + maxWidth + 10, y1 + 30);

            //Update (x, y) pointer
            y1 += 50;
        }

        //Draw Arrow of Direction
        int[] triangleX = {x1 + maxWidth/2, x1 + maxWidth/2 - 10, x1 + maxWidth/2 + 10}, triangleY = {y1 + 10, y1 + 20, y1 + 20};
        g.drawPolygon(triangleX, triangleY, 3);

        y = y1 + 20 + 20;
        return g;
    }
}