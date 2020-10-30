import javax.swing.*;

public class draw1DArray<T> {

    private T[] arr;
    private String name;

    public draw1DArray(T[] arr, String name){
        this.arr = arr;
        this.name = name;
    }

    public draw1DArray(T[] arr){
        this.arr = arr;
        this.name = "Unnamed Array";
    }

    public JTabbedPane convert(int tabNum){
        JTabbedPane tabbedPane = new JTabbedPane();

        ArrayVisual<Integer> arr1 = new ArrayVisual(this.arr, this.name);

        tabbedPane.addTab(("Tab " + Integer.toString(tabNum)), arr1);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        return tabbedPane;
    }
}
