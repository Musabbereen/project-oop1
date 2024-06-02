package GUI_Project;

import Final_Try.BorrowBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NormalUser extends User implements ActionListener {
    public NormalUser(String name, String mobile_no, String ID) {
        super(name, mobile_no, ID);
    }
    JFrame jf = new JFrame();

    JPanel panel1;JPanel panel2;JPanel panel3;JPanel panel4;JPanel panel5;
    JButton exit;JButton viewbook;JButton SearchBook; JButton ReturnBook; JButton BorrowBook;

    public NormalUser(){
        jf.setSize(500,500);
        jf.setDefaultCloseOperation(3);
        jf.setVisible(true);
        panel1 = new JPanel();panel2 = new JPanel();panel3 = new JPanel();panel4 = new JPanel();panel5 = new JPanel();
        panel1.setLayout(new GridLayout(5,1));
        exit =new JButton("Exit");
        viewbook = new JButton("ViewBook");
        SearchBook = new JButton("SearchBook");
        ReturnBook = new JButton("ReturnBook");
        BorrowBook = new JButton("BorrowBook");
        panel1.add(viewbook);panel1.add(SearchBook);panel1.add(BorrowBook);panel1.add(ReturnBook);panel1.add(exit);
        panel1.setPreferredSize(new Dimension(100,100));panel2.setPreferredSize(new Dimension(100,100));panel3.setPreferredSize(new Dimension(100,100));panel4.setPreferredSize(new Dimension(100,100));panel5.setPreferredSize(new Dimension(100,100));
        jf.add(panel1,BorderLayout.CENTER);jf.add(panel2,BorderLayout.NORTH);jf.add(panel3,BorderLayout.SOUTH);jf.add(panel4,BorderLayout.EAST);jf.add(panel5,BorderLayout.WEST);
        viewbook.addActionListener(this);SearchBook.addActionListener(this);BorrowBook.addActionListener(this);ReturnBook.addActionListener(this);exit.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewbook){

            ViewBook vb = new ViewBook();

        }
        else if(e.getSource()==SearchBook){
            SearchBook sb = new SearchBook();
            jf.dispose();
        }
        else if(e.getSource()==BorrowBook){
            Borrow_Book bb = new Borrow_Book();

        }
        else if(e.getSource()==ReturnBook){
            Return_Book rb = new Return_Book();
        }
        else if(e.getSource()==exit){
            jf.dispose();
            new First_Gui();
        }

    }
}
