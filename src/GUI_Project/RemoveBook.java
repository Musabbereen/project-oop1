package GUI_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveBook implements ActionListener {
    JPanel panel1;JPanel panel2;JPanel panel3;JPanel panel4;JPanel panel5;
    JLabel name;JLabel ISBN;JLabel Author;JLabel Quantity;JLabel Price;
    JTextField jt1;JTextField jt2;JTextField jt3;JTextField jt4;JTextField jt5;
    JFrame jf = new JFrame();
    JButton button;
    public RemoveBook(){

        jf.setSize(500,500);
        jf.setDefaultCloseOperation(3);
        jf.setVisible(true);
        panel1 = new JPanel();panel2 = new JPanel();panel3 = new JPanel();panel4 = new JPanel();panel5 = new JPanel();
        panel1.setLayout(new GridLayout(6,1));
        button  = new JButton("Submit");
        name = new JLabel("Name");ISBN = new JLabel("ISBN");Author = new JLabel("Author");Quantity = new JLabel("Quantity");Price = new JLabel("Price");
        jt1 = new JTextField();jt2 = new JTextField();jt3 = new JTextField();jt4 = new JTextField();jt5 = new JTextField();
        panel1.add(name);panel1.add(jt1); panel1.add(ISBN);panel1.add(jt2);panel1.add(Author);panel1.add(jt3);panel1.add(Quantity);panel1.add(jt4);panel1.add(Price);panel1.add(jt5);panel1.add(new JLabel(" "));panel1.add(button);
        panel1.setPreferredSize(new Dimension(100,100));panel2.setPreferredSize(new Dimension(100,100));panel3.setPreferredSize(new Dimension(100,100));panel4.setPreferredSize(new Dimension(100,100));panel5.setPreferredSize(new Dimension(100,100));
        jf.add(panel1,BorderLayout.CENTER);jf.add(panel2,BorderLayout.NORTH);jf.add(panel3,BorderLayout.SOUTH);jf.add(panel4,BorderLayout.EAST);jf.add(panel5,BorderLayout.WEST);
        button.addActionListener(this);jt1.addActionListener(this);jt2.addActionListener(this);jt3.addActionListener(this);jt4.addActionListener(this);jt5.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            if(jt1.getText().isEmpty() || jt2.getText().isEmpty() || jt3.getText().isEmpty() || jt4.getText().isEmpty() || jt5.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Input cannot be Empty",null,JOptionPane.WARNING_MESSAGE,null);
            }
            else{
                for(int i=0;i<Library_Gui.Book_List.size();i++){
                        if(jt1.getText().equals(Library_Gui.Book_List.get(i).Name) && jt2.getText().equals(Library_Gui.Book_List.get(i).Author) && jt3.getText().equals(Library_Gui.Book_List.get(i).Author)){
                            Library_Gui.Book_List.remove(i);
                            JOptionPane.showMessageDialog(null,"Book successfully removed",null,JOptionPane.WARNING_MESSAGE,null);
                            jf.dispose();
                            Admin admin = new Admin();
                        }
                }
                JOptionPane.showMessageDialog(null,"Book not found",null,JOptionPane.WARNING_MESSAGE,null);
                Admin admin = new Admin();


            }
        }
    }
}
