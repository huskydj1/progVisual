import java.util.ArrayList;

public class testr {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<10; ++i){
            list.add(i);
        }

        //TODO: Find a way to create a snapshot timeline for everytime that visualize is called
        //Currently, everything is displayed at the same time after all operations are complete, no matter the order.
        arrayListVisual tmp = new arrayListVisual();
        tmp.add("Name", list);
        tmp.visualize();

        tmp.add("Harry", list);
        tmp.visualize();

        tmp.remove("Name");
    }
}
