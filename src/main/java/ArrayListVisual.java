import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

/*
Class for drawing ArrayLists of any type with their name
Extends JComponent
 */
public class ArrayListVisual<D> extends JComponent{

    private int PREF_W = 640;
    private int PREF_H = 480;

    @Override
    public Dimension getPreferredSize() {
        Dimension d = new Dimension(0, 0);
        int x1 = 25, y1 = 80;
        for(int i = 0; i<changes.size(); ++i){
            DrawArraySize<D> cur = new DrawArraySize<D>((D[]) changes.get(i).toArray(), Integer.toString(i+1) + ": " + changeNames.get(i), DrawArraySize.HORIZONTAL, DrawArraySize.NONE);
            cur.setXY(x1, y1);
            d = cur.insertArray(d);
            x1 = cur.x; y1 = cur.y;
        }
        d.width+=20; d.height+=20;
        return d;
    }

    private ArrayList<D> list;
    private String name;

    public String getName(){
        return this.name;
    }

    private ArrayList<ArrayList<D>> changes;
    private ArrayList<String> changeNames;

    public ArrayListVisual(String name){
        this.list = new ArrayList<D>();
        this.name = name;
        changes = new ArrayList<ArrayList<D>>();
        changeNames = new ArrayList<String>();

        changes.add((ArrayList<D>) list.clone());
        changeNames.add("Initial Instantiation");

        this.setLayout(new GridLayout(1, 1));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        //Default Styles
        g.setFont(new Font("sanserif", Font.BOLD, 14));
        g.setColor(Color.DARK_GRAY);

        g.setColor(Color.RED);
        g.setFont(new Font("sanserif", Font.BOLD, 30));
        g.drawString(this.name, 25, 40);
        g.setFont(new Font("sanserif", Font.BOLD, 14));
        g.setColor(Color.DARK_GRAY);

        int x1 = 25, y1 = 80;
        for(int i = 0; i<changes.size(); ++i){
            DrawArray<D> cur = new DrawArray<D>((D[]) changes.get(i).toArray(), Integer.toString(i+1) + ": " + changeNames.get(i), DrawArray.HORIZONTAL, DrawArray.NONE);
            cur.setXY(x1, y1);
            g = cur.insertArray(g);
            x1 = cur.x; y1 = cur.y;
        }

        return;
    }

    //ArrayList API: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
    public void add(D e){
        list.add(e);
        changes.add((ArrayList<D>) list.clone());
        changeNames.add(e.toString() + " was added to ArrayList");
    }

    public void add(int index, D element){
        list.add(index, element);
        changes.add((ArrayList<D>) list.clone());
        changeNames.add(element.toString() + " was added to ArrayList at index " + index);
    }

    public void addAll(Collection<? extends D> c){
        list.addAll(c);
        changes.add((ArrayList<D>) list.clone());
        changeNames.add("New Collection Size " + c.size() + " was added to ArrayList");
    }

    public void addAll(int index, Collection<? extends D> c){
        list.addAll(c);
        changes.add((ArrayList<D>) list.clone());
        changeNames.add("New Collection Size " + c.size() + " was added to ArrayList at " + index);
    }

    public void addAll(){
        list.clear();
        changes.add((ArrayList<D>) list.clone());
        changeNames.add("ArrayList was cleared");
    }

    public Object clone(){
        return list.clone();
    }

    public boolean contains(Object o){
        return list.contains(o);
    }

    //ensureCapacity
    //forEach

    public D get(int index){
        return list.get(index);
    }

    public int indexOf(Object o){
        return list.indexOf(o);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    //iterator

    public int lastIndexOf(Object o){
        return list.lastIndexOf(o);
    }

    //listIterator()
    //listIterator(int index)

    public D removeIndex(int index){
        D tmp = list.remove(index);

        changes.add((ArrayList<D>) list.clone());
        changeNames.add("Element at index " + index + " was removed");

        return tmp;
    }

    //removeAll
    //removeIf
    //removeRange
    //replaceAll
    //retainAll

    public D set(int index, D element){
        D tmp = list.set(index, element);
        changes.add((ArrayList<D>) list.clone());
        changeNames.add("Element at index " + index + " was replaced with " + element.toString());
        return tmp;
    }

    public int getListSize(){
        return list.size();
    }

    public void sort(Comparator<? super D> c){
        list.sort(c);
        changes.add((ArrayList<D>) list.clone());
        changeNames.add("ArrayList was sorted");
    }

    //spliterator
    //subList
    //toArray
    //toArray(T[] a)
    //trimToSize()
}