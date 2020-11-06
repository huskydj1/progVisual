import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

/*
Class for drawing ArrayLists of any type with their name
Extends JComponent
 */
public class ArrayListVisual<D> {

    private ArrayList<D> list;
    private String name;

    private ArrayList<ArrayList<D>> changes;
    private ArrayList<String> changeNames;

    public ArrayListVisual(ArrayList<D> list, String name){
        this.list = list;
        this.name = name;
        changes = new ArrayList<ArrayList<D>>();
        changeNames = new ArrayList<String>();

        changes.add(list);
        changeNames.add("Initial Instantiation");
    }

    //public DrawArray<D> getDrawType(); TODO: Create this method

    //ArrayList API: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
    public void add(D e){
        list.add(e);
        changes.add(list);
        changeNames.add(e.toString() + " was added to ArrayList");
    }

    public void add(int index, D element){
        list.add(index, element);
        changes.add(list);
        changeNames.add(element.toString() + " was added to ArrayList at index " + index);
    }

    public void addAll(Collection<? extends D> c){
        list.addAll(c);
        changes.add(list);
        changeNames.add("New Collection Size " + c.size() + " was added to ArrayList");
    }

    public void addAll(int index, Collection<? extends D> c){
        list.addAll(c);
        changes.add(list);
        changeNames.add("New Collection Size " + c.size() + " was added to ArrayList at " + index);
    }

    public void addAll(){
        list.clear();
        changes.add(list);
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

    public D remove(int index){
        D tmp = list.remove(index);
        changes.add(list);
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
        changes.add(list);
        changeNames.add("Element at index " + index + " was replaced with " + element.toString());
        return tmp;
    }

    public int size(){
        return list.size();
    }

    public void sort(Comparator<? super D> c){
        list.sort(c);
        changes.add(list);
        changeNames.add("ArrayList was sorted");
    }

    //spliterator
    //subList
    //toArray
    //toArray(T[] a)
    //trimToSize()
}