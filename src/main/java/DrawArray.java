import javax.swing.*;
import java.awt.*;

public class DrawArray<D> extends JComponent{

    public static final int HORIZONTAL = 0, VERTICAL = 1;
    public static final int NONE = 2, FRONT = 3, BACK = 4, BOTH = 5;

    private D[] arr;
    private int orientation;
    private int opening;
    private String name;

    public DrawArray(D[] array, String name, int orientation, int opening){
        this.arr = array;
        this.name = name;
        this.orientation = orientation;
        this.opening = opening;
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
        if(orientation==DrawArray.HORIZONTAL){
            g = insertHorizontalArray(this.name, this.arr, x, y, g);
        }
        else if(orientation==DrawArray.VERTICAL){
            g = insertVerticalArray(this.name, this.arr, x, y, g);
        }

        return;
    }

    private Graphics insertHorizontalArray(String arrayName, D[] arr, int x, int y, Graphics g){
        //Display Name
        arrayName = arrayName.trim();
        g.drawString(arrayName + ":", x, y+20);
        if(arr.length==0){
            g.setColor(Color.red);
            g.drawString("EMPTY OBJECT PASSED", x, y+50);
            g.setColor(Color.darkGray);
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
        return g;
    }

    private Graphics insertVerticalArray(String arrayName, D[] arr, int x, int y, Graphics g) {
        //Display Name
        arrayName = arrayName.trim();
        g.drawString(arrayName + ":", x, y + 20);
        if (arr.length == 0) {
            g.setColor(Color.red);
            g.drawString("EMPTY OBJECT PASSED", x, y + 50);
            g.setColor(Color.darkGray);
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

        return g;
    }
}