import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The mainWindow class visualizes the history of changes for all of the observed, stored instances of ArrayListVisual.
 * @author huskydj1
 */
public class mainWindow{

    //TODO: What type?
    private static ArrayList<ArrayListVisual> tabList;

    public mainWindow(){
        tabList = new ArrayList<ArrayListVisual>();
    }

    public void addTab(ArrayListVisual list){
        tabList.add(list);
    }

    public void viewList(){
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("There are currently " + tabList.size() + " lists.");
        for(int i = 0; i<tabList.size(); ++i){
            System.out.println(tabList.get(i).getName());
        }
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<");
    }

    public void visual(){
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run(){
                //add scrollpane to jframe
                JFrame frame = new JFrame("JScrollPane test");
                JTabbedPane tab = new JTabbedPane();

                for(ArrayListVisual tmp : tabList){
                    //create a scrollpane
                    JScrollPane scrollPane = new JScrollPane(tmp);
                    //frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
                    tab.addTab(tmp.getName(), scrollPane);
                }

                frame.getContentPane().add(tab);

                //Make it easy to close the application
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //Set the size
                frame.setSize(new Dimension(640, 480));

                //Center the frame
                frame.setLocationRelativeTo(null);

                //make it visible
                frame.setVisible(true);
            }
        });
    }
}
