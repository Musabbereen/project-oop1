package GUI_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewUser extends JFrame implements ActionListener {

    JRadioButton Admin = new JRadioButton("Admin");
    JRadioButton NormalUser = new JRadioButton("NormalUser");
    JLabel Name;
    JLabel Mobile_no;
    JLabel ID;
    JTextField name;
    JTextField mobile;
    JTextField id;
    JButton submit;
    static  String NormalUSer_name;

    public NewUser(){
        setSize(500,500);
        setDefaultCloseOperation(3);
        setVisible(true);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        panel1.setLayout(new GridLayout(4,2));
         Name = new JLabel("Enter Name: ");
         Mobile_no = new JLabel("Mobile_no");
         ID = new JLabel("ID");
         name = new JTextField();
         id = new JTextField();
         mobile = new JTextField();
        panel1.add(Name);
        panel1.add(name);
        panel1.add(ID);
        panel1.add(id);
        panel1.add(Mobile_no);
        panel1.add(mobile);
        submit = new JButton("Submit");
        panel1.add(new JLabel(" "));
        panel1.add(submit);
        panel3.add(Admin);
        panel3.add(NormalUser);
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

        Admin.addActionListener(this);
        NormalUser.addActionListener(this);
        submit.addActionListener(this);
        name.addActionListener(this);
        mobile.addActionListener(this);
        id.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==submit ){
                if(name.getText().isEmpty() ||  mobile.getText().isEmpty() ||  id.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Input cannot be Empty",null,JOptionPane.WARNING_MESSAGE,null);
                }
                else{
                    if(Admin.isSelected()) {
                        Admin admin = new Admin(name.getText(), mobile.getText(), id.getText());
                        Library_Gui.User_List.add(admin);
                        dispose();
                        Admin ad = new Admin();

                    }
                    else if(NormalUser.isSelected()){
                        NormalUser nu = new NormalUser(name.getText(), mobile.getText(), id.getText());
                        NormalUSer_name = name.getText();
                        Library_Gui.User_List.add(nu);
                        NormalUser nu1 = new NormalUser();
                    }
                }
            }
    }
}
