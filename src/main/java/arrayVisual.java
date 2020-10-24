import javax.swing.JFrame;
import java.awt.Rectangle;
import java.util.ArrayList;

public class arrayVisual {

    private ArrayList<int[]> tList;
    private ArrayList<String> tNames;

    public void clear(){
        tList = new ArrayList<int[]>();
        tNames = new ArrayList<String>();
    }

    public arrayVisual(){
        tList = new ArrayList<int[]>();
        tNames = new ArrayList<String>();
    }

    public void add(String name, int[] arr){
        tNames.add(name);
        tList.add(arr);
    }

    public boolean remove(String name){
        int index = tNames.indexOf(name);
        if(index==-1) return false;
        else{
            tNames.remove(index);
            tList.remove(index);
            return true;
        }
    }

    public void visualize(){
        JFrame window = new JFrame();
        window.setSize(640, 480);
        window.setTitle("Visualization");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        draw1DArray DC = new draw1DArray();
        DC.addCompleteList(tList, tNames);

        window.add(DC);
    }

}
