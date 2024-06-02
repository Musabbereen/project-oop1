package GUI_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Calculate_fine extends Library_Gui implements ActionListener {
    String Due_Date;
    int order_no;
    String Return_date;
    JFrame jf;
    String Borrower_name;


    JPanel panel1;JPanel panel2;JPanel panel3;JPanel panel4;JPanel panel5;
    JLabel day;JLabel month;JLabel year; JTextField jt1; JTextField jt2;JTextField jt3;JLabel heading;
    JButton submit;

    public Calculate_fine(String due_Date, int order_no) {
        this.Due_Date = due_Date;
        this.order_no = order_no;
        jf = new JFrame();
        jf.setSize(500,500);
        jf.setDefaultCloseOperation(3);
        jf.setVisible(true);
        panel1 = new JPanel();panel2 = new JPanel();panel3 = new JPanel();panel4 = new JPanel();panel5 = new JPanel();
        panel1.setLayout(new GridLayout(4,2));
        day = new JLabel("Day");month = new JLabel("Month");year = new JLabel("Year");jt1 = new JTextField();jt2 = new JTextField();jt3 = new JTextField();submit = new JButton("Submit");
        heading = new JLabel("CALCULATE FINE");
        panel1.add(day);panel1.add(jt1);panel1.add(month);panel1.add(jt2);panel1.add(year);panel1.add(jt3);panel1.add(new JLabel(""));panel1.add(submit);
        panel2.add(heading);
        panel1.setPreferredSize(new Dimension(100,100));panel2.setPreferredSize(new Dimension(100,100));panel3.setPreferredSize(new Dimension(100,100));panel4.setPreferredSize(new Dimension(100,100));panel5.setPreferredSize(new Dimension(100,100));
        jf.add(panel1,BorderLayout.CENTER);jf.add(panel2,BorderLayout.NORTH);jf.add(panel3,BorderLayout.SOUTH);jf.add(panel4,BorderLayout.EAST);jf.add(panel5,BorderLayout.WEST);
        submit.addActionListener(this);jt1.addActionListener(this);jt2.addActionListener(this);jt3.addActionListener(this);
    }

    public Calculate_fine( String borrower_name,String due_Date, String return_date) {
        this.Due_Date = due_Date;
        this.Return_date = return_date;
        this.Borrower_name = borrower_name;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            if(jt1.getText().isEmpty() ||jt2.getText().isEmpty() || jt3.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Input cannot be Empty",null,JOptionPane.WARNING_MESSAGE,null);
            }
            else{
                String dateString = this.Due_Date;
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate due_date = LocalDate.parse(dateString,dtf);
                System.out.println(due_date.toString());
                LocalDate return_date = LocalDate.of(Integer.parseInt(jt3.getText()),Integer.parseInt(jt2.getText()),Integer.parseInt(jt1.getText()));
                System.out.println(return_date.toString());
                if(return_date.isAfter(due_date)){
                    JOptionPane.showMessageDialog(null,"The Borrower will be fined",null,JOptionPane.WARNING_MESSAGE,null);
                    Library_Gui.AddFine(new Calculate_fine(Library_Gui.orders.get(order_no).User_name,Due_Date,return_date.toString()));
                    jf.dispose();

                }
                else{
                    JOptionPane.showMessageDialog(null,"No fine is issued",null,JOptionPane.WARNING_MESSAGE,null);
                }
            }
        }

    }
}
