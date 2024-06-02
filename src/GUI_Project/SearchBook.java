package GUI_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBook extends Library_Gui implements ActionListener{


        JPanel panel1;JPanel panel2;JPanel panel3;JPanel panel4;JPanel panel5;
        JLabel name;JLabel ISBN;JLabel Author;
        JTextField jt1;JTextField jt2;JTextField jt3;
        JFrame jf = new JFrame();
        JButton button;
        public SearchBook(){

            jf.setSize(500,500);
            jf.setDefaultCloseOperation(3);
            jf.setVisible(true);
            panel1 = new JPanel();panel2 = new JPanel();panel3 = new JPanel();panel4 = new JPanel();panel5 = new JPanel();
            panel1.setLayout(new GridLayout(4,1));
            button  = new JButton("Submit");
            name = new JLabel("Name");ISBN = new JLabel("ISBN");Author = new JLabel("Author");
            jt1 = new JTextField();jt2 = new JTextField();jt3 = new JTextField();
            panel1.add(name);panel1.add(jt1); panel1.add(ISBN);panel1.add(jt2);panel1.add(Author);panel1.add(jt3);panel1.add(new JLabel(" "));panel1.add(button);
            panel1.setPreferredSize(new Dimension(100,100));panel2.setPreferredSize(new Dimension(100,100));panel3.setPreferredSize(new Dimension(100,100));panel4.setPreferredSize(new Dimension(100,100));panel5.setPreferredSize(new Dimension(100,100));
            jf.add(panel1,BorderLayout.CENTER);jf.add(panel2,BorderLayout.NORTH);jf.add(panel3,BorderLayout.SOUTH);jf.add(panel4,BorderLayout.EAST);jf.add(panel5,BorderLayout.WEST);
            button.addActionListener(this);jt1.addActionListener(this);jt2.addActionListener(this);jt3.addActionListener(this);
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==button){
                int is_available= 0;
                if(jt1.getText().isEmpty() || jt2.getText().isEmpty() || jt3.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"input cannot be empty",null,JOptionPane.WARNING_MESSAGE,null);
                }
               for(int i=0;i<Library_Gui.Book_List.size();i++){
                   if(jt1.getText().equals(Library_Gui.Book_List.get(i).Name) && jt2.getText().equals(Library_Gui.Book_List.get(i).ISBN) && jt3.getText().equals(Library_Gui.Book_List.get(i).Author));
                   JOptionPane.showMessageDialog(null,"The Book is Found",null,JOptionPane.PLAIN_MESSAGE,null);
                   is_available= 1;

                   break;
                 }
               if(is_available==1) {
                   jf.dispose();
                   NormalUser nu = new NormalUser();
               }
               else{ JOptionPane.showMessageDialog(null,"The Book is not Available",null,JOptionPane.PLAIN_MESSAGE,null); NormalUser nu = new NormalUser();jf.dispose();}
               }
        }
}


