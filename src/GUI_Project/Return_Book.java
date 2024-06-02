package GUI_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Return_Book extends Order implements ActionListener {
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JPanel panel5;
    JLabel Borrower_name;
    JLabel Book_name;
    JTextField jt1;
    JTextField jt2;

    JFrame jf = new JFrame();
    JButton button;

    public Return_Book() {

        jf.setSize(500, 500);
        jf.setDefaultCloseOperation(3);
        jf.setVisible(true);
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1));
        button = new JButton("Submit");
        Borrower_name = new JLabel("Borrow_Name");
        Book_name = new JLabel("Book_name");
        jt1 = new JTextField();
        jt2 = new JTextField();
        panel1.add(Borrower_name);
        panel1.add(jt1);
        panel1.add(Book_name);
        panel1.add(jt2);
        panel1.add(new JLabel(" "));
        panel1.add(button);
        panel1.setPreferredSize(new Dimension(100, 100));
        panel2.setPreferredSize(new Dimension(100, 100));
        panel3.setPreferredSize(new Dimension(100, 100));
        panel4.setPreferredSize(new Dimension(100, 100));
        panel5.setPreferredSize(new Dimension(100, 100));
        jf.add(panel1, BorderLayout.CENTER);
        jf.add(panel2, BorderLayout.NORTH);
        jf.add(panel3, BorderLayout.SOUTH);
        jf.add(panel4, BorderLayout.EAST);
        jf.add(panel5, BorderLayout.WEST);
        button.addActionListener(this);
        jt1.addActionListener(this);
        jt2.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            if (jt1.getText().isEmpty() || jt2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Input cannot be empty", null, JOptionPane.WARNING_MESSAGE, null);
            }
            else {
                int isavailable=0;
                for (int i = 0; i < Library_Gui.orders.size(); i++) {
                    if (jt1.getText().equals(Library_Gui.orders.get(i).User_name) && jt2.getText().equals(Library_Gui.orders.get(i).Book_Name)) {
                        isavailable=1;
                        JOptionPane.showMessageDialog(null, "The Book is Returned Successfully", null, JOptionPane.PLAIN_MESSAGE, null);
                        int new_quantity = Library_Gui.orders.get(i).Quantity;
                        for(int j=0;j<Library_Gui.Book_List.size();j++){
                            if(Library_Gui.Book_List.get(i).Name.equals(jt2.getText())){
                                Library_Gui.Book_List.get(i).Quantity =  Library_Gui.Book_List.get(i).Quantity+new_quantity;
                                Library_Gui.Update_Book_Data();
                                System.out.println( Library_Gui.Book_List.get(i));
                                jf.dispose();
                                Calculate_fine cf= new Calculate_fine(Library_Gui.orders.get(i).Return_Date,i);


                            }
                        }
                        break;
                    }
                }
                if(isavailable==0){
                    JOptionPane.showMessageDialog(null, "The Book is not found", null, JOptionPane.PLAIN_MESSAGE, null);
                    jf.dispose();
                    NormalUser nu = new NormalUser();
                }
                else {
                    jf.dispose();
                    NormalUser nu = new NormalUser();
                }
            }
        }
    }

}