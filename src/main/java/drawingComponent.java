import javax.swing.JComponent;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class drawingComponent extends JComponent{

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.blue);

        Font fontf = new Font("sanserif", Font.BOLD, 14);
        g2.setFont(fontf);

        g2.drawString("Hey guys I'm a String", 40, 50);
        /*
        Color tmp = Color.DARK_GRAY;
        g2.setColor(new Color(0, 0, 0));

        Rectangle rect1 = new Rectangle(5, 5, 100, 200);
        g2.fill(rect1);

        Ellipse2D.Double ellipse1 = new Ellipse2D.Double(100, 100, 50, 20);
        g2.fill(ellipse1);

        Line2D.Double line1 = new Line2D.Double(150, 150, 100, 50);
        g2.draw(line1);

        Point2D.Double p1 = new Point2D.Double(200, 200);
        Point2D.Double p2 = new Point2D.Double(500, 200);

        Line2D.Double l2 = new Line2D.Double(p1, p2);
        g2.draw(l2);
         */
    }
}
