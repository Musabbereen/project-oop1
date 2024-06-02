package GUI_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class First_Gui extends JFrame {
    public First_Gui() {
        Update_Old_Data();
        Update_Old_Data_2();
        Update_Old_Data_3();
        setSize(500, 500);
        setDefaultCloseOperation(3);
        setLayout(new BorderLayout(10, 10));
        setVisible(true);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JLabel label = new JLabel("Welcome to Library Management System");
        label.setFont(new Font("MV Boli", Font.BOLD, 20));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        JButton login = new JButton("Login");
        JButton NewUser = new JButton("NewUser");
        JButton Exit = new JButton("Exit");
        panel1.setLayout(new GridLayout(3, 1));
        panel2.add(label);
        panel1.add(login);
        panel1.add(NewUser);
        panel1.add(Exit);
        panel1.setPreferredSize(new Dimension(100, 100));
        panel2.setPreferredSize(new Dimension(100, 100));
        panel3.setPreferredSize(new Dimension(100, 100));
        panel4.setPreferredSize(new Dimension(100, 100));
        panel5.setPreferredSize(new Dimension(100, 100));
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.NORTH);
        add(panel3, BorderLayout.SOUTH);
        add(panel4, BorderLayout.EAST);
        add(panel5, BorderLayout.WEST);
        pack();

        ActionListener a1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == login) {
                    dispose();
                    new Login_Gui();
                }
                else if (e.getSource() == NewUser) {
                    dispose();
                    new NewUser();

                } else if (e.getSource() == Exit) {
                    dispose();
                }
            }
        };
        login.addActionListener(a1);
        NewUser.addActionListener(a1);
        Exit.addActionListener(a1);

    }
    public static void Update_Old_Data(){
        try {
            FileReader fr = new FileReader("C://Users//zafor//Desktop//Presentation//Final_presentation//src//GUI_Project//Book.txt");
            BufferedReader br  =new BufferedReader(fr);
            while(br.ready()){
                String data = br.readLine();
                System.out.println(data);
                String str1[] = data.split(",");
                System.out.println(str1.length);
                Library_Gui.Book_List.add(new Book_Gui(str1[0],str1[1],str1[2],Integer.parseInt(str1[3]),Integer.parseInt(str1[4])));
            }
        }
        catch(Exception e){
            System.out.println("The Book file is empty");
            e.printStackTrace();
        }
    }
    public static void Update_Old_Data_2(){
        try {
            FileReader fr = new FileReader("C://Users//zafor//Desktop//Presentation//Final_presentation//src//GUI_Project//Order.txt");
            BufferedReader br  =new BufferedReader(fr);
            while(br.ready()){
                String data = br.readLine();
                System.out.println(data);
                String str1[] = data.split(",");
                System.out.println(str1.length);
                Library_Gui.orders.add(new Order(str1[0],str1[1],Integer.parseInt(str1[2]),str1[3],str1[4]));
            }
        }
        catch(Exception e){
            System.out.println("There Order File is Empty");

        }
    }
    public static void Update_Old_Data_3(){
        try {
            FileReader fr = new FileReader("C://Users//zafor//Desktop//Presentation//Final_presentation//src//GUI_Project//User.txt");
            BufferedReader br  =new BufferedReader(fr);
            while(br.ready()){
                String data = br.readLine();
                System.out.println(data);
                String str1[] = data.split(",");
                System.out.println(str1.length);
                Library_Gui.User_List.add(new User(str1[0],str1[1],str1[2]));
            }
        }
        catch(Exception e){
            System.out.println("There Order File is Empty");

        }
    }
}
