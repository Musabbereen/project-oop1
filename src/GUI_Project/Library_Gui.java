package GUI_Project;

import java.io.*;
import java.util.ArrayList;

public class Library_Gui {
    static ArrayList<User> User_List = new ArrayList<>();
    static ArrayList<Book_Gui> Book_List = new ArrayList<>();
    static ArrayList<Order> orders = new ArrayList<>();
    static ArrayList<Calculate_fine> fine = new ArrayList<>();
    public static int  SearchUser(String name,String Mobile_Number){
        if(User_List.size()==0){
            return 0;
        }
        for(int i=0;i<User_List.size();i++){
            if(User_List.get(i).name.equals(name) && User_List.get(i).mobile_no.equals(Mobile_Number)){
                return 1;
            }
        }
        return 0;
    }
    public static void AddBook(Book_Gui book){
        Book_List.add(book);
        try {
            FileWriter fw = new FileWriter("C://Users//zafor//Desktop//Presentation//Final_presentation//src//GUI_Project//Book.txt",true);
            fw.write(book.Name+","+book.Author+","+book.ISBN+","+book.Quantity+","+book.price);
            fw.write("\n");
            fw.close();
        }
        catch(Exception e){
            System.out.println("There is some error");
        }
    }
    public static void AddOrders(Order order){
        orders.add(order);
        try {
            FileWriter fw = new FileWriter("C://Users//zafor//Desktop//Presentation//Final_presentation//src//GUI_Project//Order.txt",true);
            fw.write(order.User_name+","+order.Book_Name+","+order.Quantity+","+order.Borrow_Date+","+order.Return_Date);
            fw.write("\n");
            fw.close();
        }
        catch(Exception e){
            System.out.println("There is some error");
        }
    }
    public static void AddFine(Calculate_fine cf){
        fine.add(cf);
        try {
            FileWriter fw = new FileWriter("C://Users//zafor//Desktop//Presentation//Final_presentation//src//GUI_Project//Fine.txt",true);
            fw.write(cf.Borrower_name+","+cf.Due_Date+","+cf.Return_date);
            fw.write("\n");
            fw.close();
        }
        catch(Exception e){
            System.out.println("There is some error");
        }
    }
    public static void Update_Book_Data()  {
        try {
            FileWriter fw = new FileWriter("C://Users//zafor//Desktop//Presentation//Final_presentation//src//GUI_Project//Book.txt");
            for (int i=0;i<Library_Gui.Book_List.size();i++){
                fw.write(Library_Gui.Book_List.get(i).toString());
                fw.write("\n");
            }
            fw.close();
        }
        catch(Exception e){
                System.out.println("Done");

        }
    }
}
