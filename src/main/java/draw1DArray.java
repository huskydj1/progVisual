import javax.swing.JComponent;
import java.awt.*;
import java.util.ArrayList;

public class draw1DArray extends JComponent{

    private ArrayList<int[]> list;
    private ArrayList<String> names;

    public draw1DArray(){
        list = new ArrayList<int[]>();
        names = new ArrayList<String>();
    }

    public void addCompleteList(ArrayList<int[]> list, ArrayList<String> names){
        this.list = list;
        this.names = names;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        //Default Styles
        g.setFont(new Font("sanserif", Font.BOLD, 14));
        g.setColor(Color.DARK_GRAY);

        //Generate Rectangle
        int x = 25, y = 25;

        for(int i = 0; i<list.size(); ++i){
            g = insertArray(names.get(i), list.get(i), x, y, g);
            y+=100;
        }
        System.out.println(list.size());

    }

    private static Graphics insertArray(String arrayName, int[] arr, int x, int y, Graphics g){
        //Display Name
        arrayName = arrayName.trim();
        g.drawString(arrayName + ":", x, y+20);

        //Iterate through and visualize each cell
        int x1 = x, y1 = y+25;
        for(int i = 0; i<arr.length; i++){
            String content = Integer.toString(arr[i]);
            int width = Math.max(content.length()*9 + 10, 45);
            //Draw Cell
            g.drawRect(x1, y1, width, 50);
            //Display Contents
            g.drawString(content, x1 + 10, y1+30);
            //Display Index
            g.drawString(Integer.toString(i), x1 + width/2 - (int)((double)0.5*content.length()), y1 + 65);

            //Update (x, y) pointer
            x1+=width;
        }
        return g;
    }
}
