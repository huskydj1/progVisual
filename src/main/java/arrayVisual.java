import javax.swing.JFrame;
import java.awt.Rectangle;

public class arrayVisual {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(640, 480); //TODO: Parameterize theses
        window.setTitle("Array Visualization");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        int[] arr = {10, 100, 200, 300, 901}; //TODO: Parameterize Visualization
        draw1DArray DC = new draw1DArray("Array Example", arr, 5, 10);
        window.add(DC);
    }
}
