import javax.swing.JFrame;
import java.awt.Rectangle;
import java.util.ArrayList;

public class arrayVisual {

    private ArrayList<int[]> tList;
    private ArrayList<String> tNames;

    public void init(){
        tList = new ArrayList<int[]>();
        tNames = new ArrayList<String>();
    }

    public void newArray(String name, int[] arr){
        tNames.add(name);
        tList.add(arr);
    }

    public void visualize(){
        JFrame window = new JFrame();
        window.setSize(640, 480); //TODO: Parameterize theses
        window.setTitle("Array Visualization");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        draw1DArray DC = new draw1DArray();
        DC.addListArray(tList, tNames);

        window.add(DC);
    }

}
