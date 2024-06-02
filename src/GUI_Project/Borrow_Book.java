package GUI_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Borrow_Book extends Order implements ActionListener {
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JPanel panel5;
    JLabel name;
    JLabel Quantity;
    JLabel Author;
    JTextField jt1;
    JTextField jt2;
    JTextField jt3;
    JFrame jf = new JFrame();
    JButton button;

    public Borrow_Book() {

        jf.setSize(500, 500);
        jf.setDefaultCloseOperation(3);
        jf.setVisible(true);
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel1.setLayout(new GridLayout(4, 1));
        button = new JButton("Submit");
        name = new JLabel("Name");
        Quantity = new JLabel("Quantity");
        Author = new JLabel("Author");
        jt1 = new JTextField();
        jt2 = new JTextField();
        jt3 = new JTextField();
        panel1.add(name);
        panel1.add(jt1);
        panel1.add(Author);
        panel1.add(jt2);
        panel1.add(Quantity);
        panel1.add(jt3);
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
        jt3.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            if (jt1.getText().isEmpty() || jt2.getText().isEmpty() || jt3.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Input cannot be empty", null, JOptionPane.WARNING_MESSAGE, null);
            }
            else {
                int isavailable=0;
                for (int i = 0; i < Library_Gui.Book_List.size(); i++) {
                    if (jt1.getText().equals(Library_Gui.Book_List.get(i).Name) && jt2.getText().equals(Library_Gui.Book_List.get(i).ISBN) && ((Integer.parseInt(jt3.getText()))<= (Library_Gui.Book_List.get(i).Quantity))) {
                        isavailable=1;
                        JOptionPane.showMessageDialog(null, "The Book must be returned within 10 days", null, JOptionPane.PLAIN_MESSAGE, null);
                        String BorrowDate = LocalDate.now().toString();
                        String ReturnDate = LocalDate.now().plusDays(10).toString();
                        int new_quantity = Library_Gui.Book_List.get(i).Quantity;
                        Library_Gui.Book_List.get(i).Quantity = new_quantity - Integer.parseInt(jt3.getText());
                        Library_Gui.Update_Book_Data();
                        System.out.println( Library_Gui.Book_List.get(i));
                        Library_Gui.AddOrders(new Order(NewUser.NormalUSer_name, jt1.getText(), Integer.parseInt(jt3.getText()), BorrowDate, ReturnDate));
                        break;
                    }
                }
                if(isavailable==0){
                    JOptionPane.showMessageDialog(null, "The Book is not found", null, JOptionPane.PLAIN_MESSAGE, null);
                    jf.dispose();
                    NormalUser nu = new NormalUser();
                }
                jf.dispose();
                NormalUser nu = new NormalUser();
            }
        }
    }
}