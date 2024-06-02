package GUI_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends User implements ActionListener {
    JFrame jf = new JFrame();
    JTable jt;
    JPanel panel1;JPanel panel2;JPanel panel3;JPanel panel4;JPanel panel5;
    JButton exit;JButton viewbook;JButton addbook; JButton removebook; JButton vieworders;JButton viewfines;

    public Admin(String name, String mobile_no, String ID) {
        super(name, mobile_no, ID);
    }
    public Admin(){

        jf.setSize(500,500);
        jf.setDefaultCloseOperation(3);
        jf.setVisible(true);
        panel1 = new JPanel();panel2 = new JPanel();panel3 = new JPanel();panel4 = new JPanel();panel5 = new JPanel();
        panel1.setLayout(new GridLayout(6,1));
        viewbook = new JButton("View Books");
        addbook = new JButton("Add Books");
        removebook  = new JButton("Remove Books");
        vieworders = new JButton("View Orders");
        viewfines = new JButton("View Fines");
        exit = new JButton("Exit");
        panel1.add(viewbook);panel1.add(addbook);panel1.add(removebook);panel1.add(vieworders);panel1.add(viewfines);panel1.add(exit);
        panel1.setPreferredSize(new Dimension(100,100));panel2.setPreferredSize(new Dimension(100,100));panel3.setPreferredSize(new Dimension(100,100));panel4.setPreferredSize(new Dimension(100,100));panel5.setPreferredSize(new Dimension(100,100));
        jf.add(panel1,BorderLayout.CENTER);jf.add(panel2,BorderLayout.NORTH);jf.add(panel3,BorderLayout.SOUTH);jf.add(panel4,BorderLayout.EAST);jf.add(panel5,BorderLayout.WEST);
        viewbook.addActionListener(this); addbook.addActionListener(this); removebook.addActionListener(this); vieworders.addActionListener(this); viewfines.addActionListener(this); exit.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewbook){
            jf.dispose();
            ViewBook vb = new ViewBook();
            Admin an = new Admin();
        }
        else if(e.getSource()==addbook){
                    jf.dispose();
                    AddBook ab = new AddBook();
        }
        else if(e.getSource()==removebook){
            RemoveBook rb = new RemoveBook();

        }
        else if(e.getSource()==vieworders){
            ViewOrder vo = new ViewOrder();

        }
        else if(e.getSource()==viewfines){
            View_Fine vf = new View_Fine();

        }
        else if(e.getSource()==exit){
            jf.dispose();
            new First_Gui();

        }

    }
}
