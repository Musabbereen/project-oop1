package GUI_Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class ViewOrder extends Library_Gui{
    JScrollPane js ;
    JTable jt;
    String[]col;
    Object[][] data;
    JFrame jf;
    public ViewOrder(){
        jf = new JFrame();
        col  =new String[]{"Borrower_Name","Book_Name","Quantity","Borrow_Date","Return_Date"};
        data = getData();
        jt = new JTable(data,col);
        js = new JScrollPane(jt);
        jf.add(js);
        jf.setDefaultCloseOperation(3);
        jf.pack();
        jf.setVisible(true);

    }
    Object[][] getData(){
        try{
            FileReader fr= new FileReader("C://Users//zafor//Desktop//Presentation//Final_presentation//src//GUI_Project//Order.txt");
            BufferedReader br =new BufferedReader(fr);
            ArrayList<String> list = new ArrayList<>();
            String str = "";
            while((str = br.readLine())!=null){
                list.add(str);
                System.out.println(str);
            }
            int n = list.get(0).split(",").length;
            Object[][]data = new Object[list.size()][n];
            for(int i=0;i< list.size();i++){
                data[i] = list.get(i).split(",");
            }
            br.close();
            return data;
        }
        catch(Exception e){
            System.out.println("Error everywhere");
            return null;
        }
    }


}
