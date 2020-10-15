import javax.swing.JComponent;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class draw1DArray extends JComponent{

    private String arrayName;
    private int[] arr;
    private int x, y;

    //Getter, Setters
    public String getArrayName(){
        return arrayName;
    }
    public void setArrayName(String arrayName){
        this.arrayName = arrayName;
    }
    public int[] getArray(){
        return arr;
    }
    public void setArray(int[] array){
        this.arr = array;
    }
    //Location parameters
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x =x ;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

    //Constructors
    public draw1DArray(String arrayName, int[] array){
        setArrayName(arrayName);
        setArray(array);
        setLocation(0, 0);
    }
    public draw1DArray(String arrayName, int[] array, int x, int y){
        setArrayName(arrayName);
        setArray(array);
        setLocation(x, y);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        int arraySize = arr.length;

        //Default Styles
        Font fontf = new Font("sanserif", Font.BOLD, 14);
        Color colorD = Color.DARK_GRAY;

        g2.setFont(fontf);
        g2.setColor(colorD);

        //Display Name
        g2.drawString(arrayName + ":", x, y+20);

        //Generate Rectangle
        for (int i = 0; i < arraySize; i++) {
            //Draw Cell
            Rectangle tmp = new Rectangle(x+40*i, y+25, 40, 40);
            g2.draw(tmp);
            //Display Index
            g2.drawString(Integer.toString(i), x+40*i + 15,y+ 25 + 40 + 20);
            //Display Contents
            g2.drawString(Integer.toString(arr[i]), x+40*i + 10, y+25+30);
            //TODO: Center contents within cell, http://journals.ecs.soton.ac.uk/java/tutorial/ui/drawing/drawingText.html
        }

        /*
        Rectangle rect1 = new Rectangle(5, 5, 100, 200);
        g2.fill(rect1);
        Line2D.Double line1 = new Line2D.Double(150, 150, 100, 50);
        g2.draw(line1);
         */

    }
}
