package GUI_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

public class Login_Gui extends JFrame implements ActionListener {
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JPanel panel5;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JLabel Name;
    JLabel Mobile_no ;
    JLabel ID;

    //   panel2.add(label);
    JButton submit;
    public Login_Gui(){

        setSize(500,500);
        setDefaultCloseOperation(3);
        setVisible(true);
         panel1 = new JPanel();
         panel2 = new JPanel();
         panel3 = new JPanel();
         panel4 = new JPanel();
         panel5 = new JPanel();
        t1 = new JTextField();
         t2 = new JTextField();
        t3 = new JTextField();
        Name = new JLabel("Enter Name: ");
        Mobile_no = new JLabel("Mobile_no");
        ID = new JLabel("ID");
        panel1.setLayout(new GridLayout(4,2));
     //   panel2.add(label);
        submit = new JButton("Submit");

        panel1.add(Name);
        panel1.add(t1);
        panel1.add(Mobile_no);
        panel1.add(t2);
        panel1.add(ID);
        panel1.add(t3);
        panel1.add(new JLabel(" "));
        panel1.add(submit);
        panel1.setPreferredSize(new Dimension(100,100));
        panel2.setPreferredSize(new Dimension(100,100));
        panel3.setPreferredSize(new Dimension(100,100));
        panel4.setPreferredSize(new Dimension(100,100));
        panel5.setPreferredSize(new Dimension(100,100));
        add(panel1,BorderLayout.CENTER);
        add(panel2,BorderLayout.NORTH);
        add(panel3,BorderLayout.SOUTH);
        add(panel4,BorderLayout.EAST);
        add(panel5,BorderLayout.WEST);
        submit.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
                if(e.getSource()==submit){
                    if(t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Input cannot be Empty",null,JOptionPane.WARNING_MESSAGE,null);
                    }
                    else{
                        int n= Library_Gui.SearchUser(t1.getText(),t2.getText());
                        if(n==0){
                            JOptionPane.showMessageDialog(null,"User does not Exist",null,JOptionPane.WARNING_MESSAGE,null);
                            dispose();
                            First_Gui fg = new First_Gui();
                        }
                        else{
                            dispose();
                            new NormalUser();

                        }
                    }
                }
    }
}
