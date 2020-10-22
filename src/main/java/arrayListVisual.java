import javax.swing.JFrame;
import java.awt.Rectangle;
import java.util.ArrayList;

public class arrayListVisual {

    private ArrayList<int[]> tList;
    private ArrayList<String> tNames;

    public void init(){
        tList = new ArrayList<int[]>();
        tNames = new ArrayList<String>();
    }

    public void newArray(String name, ArrayList<Integer> arr){
        tNames.add(name);

        //Simply Convert to primitive Array Type
        int[] tmp = new int[arr.size()];
        for(int i = 0; i<arr.size(); ++i){
            tmp[i] = arr.get(i);
        }
        tList.add(tmp);
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
