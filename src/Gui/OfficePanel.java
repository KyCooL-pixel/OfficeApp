package Gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import Logic.Logic;
import Office.*;
import Staff.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Formatter;

public class OfficePanel extends JPanel {
    static Formatter f = new Formatter();
    JPanel topPanel;
    static JCheckBox low;
    static JCheckBox mid;
    static JCheckBox high;

    JPanel centerPanel;
    static ArrayList<String> data = new ArrayList<>();
    static JList<Object> stafflist;
    JScrollPane scrollStaffList;

    public OfficePanel(){
        // set layout
        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        // top panel
        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        low = new JCheckBox("Low Office");
        mid = new JCheckBox("Mid Office");
        high = new JCheckBox("High Office");

        low.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                refresh();
            }
        });
        mid.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                refresh();
            }
        });
        high.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                refresh();
            }
        });
        topPanel.add(low);
        topPanel.add(mid);
        topPanel.add(high);

        add(topPanel,BorderLayout.NORTH);

        // center panel
        centerPanel = new JPanel();
        check();
        stafflist = new JList<Object>(data.toArray());

        // this code centers elements in JList: Copied from stackOverFlow
        DefaultListCellRenderer renderer =  (DefaultListCellRenderer)stafflist.getCellRenderer();  
        renderer.setHorizontalAlignment(JLabel.CENTER); 

        scrollStaffList = new JScrollPane(stafflist);
        scrollStaffList.setPreferredSize(new Dimension(300,300));
        centerPanel.add(scrollStaffList);

        add(centerPanel,BorderLayout.CENTER);

    }

    public static void fetchdata(int officeReference){
        Office office = Logic.fetchOffice(officeReference);
        for(int i =0;i< office.getStaffs().length;i++)
            if(office.getStaffs()[i]!= null)
                data.add(
                    office.getStaffs()[i].getName()
                   +"               "
                    +office.getStaffs()[i].getMatric()
                   +"              "
                   +office.getStaffs()[i].getOffice());

    }

    public static void cleardata(){
        data.clear();
    }
    
    public static void refresh(){
        cleardata();
        check();
        stafflist.setListData(data.toArray());
    }

    public static void check(){
        if(low.isSelected())
        fetchdata(0);
        if(mid.isSelected())
        fetchdata(1);
        if(high.isSelected())
        fetchdata(2);
    }

    public JCheckBox getLowBox(){
        return low;
    }

    public JCheckBox getMidBox(){
        return mid;
    }

    public JCheckBox getHighBox(){
        return high;
    }
}
