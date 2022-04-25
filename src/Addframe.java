import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Addframe extends JFrame {
    private static JDialog addDialog;
    private JButton check;

    public Addframe(){
        JFrame f = new JFrame();
        addDialog = new JDialog(f,"Add a new staff ",true);
        addDialog.setLayout(new FlowLayout());
        check = new JButton("check");
        check.addActionListener(new checkListener());
        addDialog.add(new JLabel("Press check to check"));
        addDialog.add(check);
        addDialog.setLocation(600, 200);
        addDialog.setSize(300,300);
        addDialog.setVisible(true);
    }


    public class checkListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            System.out.println("Test pressed!!");
            addDialog.setVisible(false);
        }
    }
    
}
