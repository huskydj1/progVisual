import javax.swing.JFrame;
import java.awt.Rectangle;
import java.util.ArrayList;

public class arrayListVisual {

    private arrayVisual store;

    public void clear(){
        store.clear();
    }

    public arrayListVisual(){
        store = new arrayVisual();
    }

    public void add(String name, ArrayList<Integer> arr){
        //Simply Convert to primitive Array Type
        int[] tmp = new int[arr.size()];
        for(int i = 0; i<arr.size(); ++i){
            tmp[i] = arr.get(i);
        }

        store.add(name, tmp);
    }

    public boolean remove(String name){
        return store.remove(name);
    }

    public void visualize(){
        store.visualize();
    }

}
