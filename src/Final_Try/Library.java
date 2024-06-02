package Final_Try;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Calendar;

import static Final_Try.Start.sc;
import static Final_Try.Start.st;


public class Library {
    static int available =0;
    static int value=0;
    static ArrayList<User>User_list = new ArrayList<>();
    static ArrayList<Order>Order_List = new ArrayList<>();
    static ArrayList<Book>Book_List = new ArrayList<>();
    static ArrayList<Calculate_Fine>Fine = new ArrayList<>();
    public static void SearchUser(String name,String Mobile_Number){
        try{
            System.out.println(Library.User_list.size());
            if(Library.User_list.size()==0){
                throw new Empty_Array("The List is  Empty");
            }
        for(int i=0;i<User_list.size();i++){
            if(User_list.get(i).getName().equals(name) && User_list.get(i).getMobile_Number().equals(Mobile_Number)){
                System.out.println("Welcome Mr "+ name);
                NormalUser.menu(name,Mobile_Number);
            }
            else{
                System.out.println("The User does not exist");
                return ;
            }
        }
        }
        catch(NullPointerException e){
            System.out.println("The list is Empty");
            return ;
        }
        catch(Empty_Array e){
            System.out.println(e.getMessage());
        }
    }
    public static void AddBook(){
        System.out.println("Enter Name: ");
        String name = st.nextLine();
        System.out.println("Enter Author: ");
        String Author = st.nextLine();
        System.out.println("Enter Quantity: ");
        int  q = sc.nextInt();
        System.out.println("Enter Price: ");
        double price = sc.nextInt();
        System.out.println("Enter ISBN");
        String isbn = st.nextLine();
        for(int i =0;i<Book_List.size();i++) {
                available=0;
            if (name.equals(Book_List.get(i).Name) && Author.equals(Book_List.get(i).Author)) {
                available=1;
                int n =Book_List.get(i).Quantity;
                Book_List.get(i).Quantity = n+q;
                return ;
            }
        }
        if(available ==0){
            Library.Book_List.add(new Book(name,Author,isbn,q,price));
            return ;
        }

        }
    public static void ViewBooks(){
        for(int i =0;i<Book_List.size();i++) {
            System.out.println(Book_List.get(i).toString());
        }
    }
    public static void RemoveBook(){
        System.out.println("Enter Name: ");
        String name = st.nextLine();
        System.out.println("Enter Author: ");
        String Author = st.nextLine();
        for(int i =0;i<Book_List.size();i++) {
            if(name.equals(Book_List.get(i).Name) && Author.equals(Book_List.get(i).Author)){
                    Book_List.remove(i);
                    break;
            }
        }
    }
    public static  void SearchBook(){
        available=0;
        System.out.println("Enter Name: ");
        String name = st.nextLine();
        System.out.println("Enter Author: ");
        String Author = st.nextLine();
        for(int i =0;i<Book_List.size();i++) {
            if(name.equals(Book_List.get(i).Name) && Author.equals(Book_List.get(i).Author)){
                System.out.println("The book is Available");
                Order.setISBN(Book_List.get(i).ISBN);
                value=i;
                available =1;
                break;
            }
        }
        if(available==0){
            System.out.println("The book is not found");
        }
    }
    public static void AddOrders(Order order){
        Order_List.add(order);
    }
    public static void ViewOrders(){
        for(int i=0;i<Order_List.size();i++){
            System.out.println(Order_List.get(i).toString());
        }
    }
    public static void ViewFines(){
        for(int i=0;i<Fine.size();i++){
            System.out.println(Fine.get(i).toString());
        }
    }
    public static void Store_All_Data(){
        try {
            FileWriter wbook = new FileWriter("C://Users//zafor//Desktop//Presentation//Final_presentation//src//Final_Try//Book_Data");
            FileWriter wuser = new FileWriter("C://Users//zafor//Desktop//Presentation//Final_presentation//src//Final_Try//User_Data");
            FileWriter worder = new FileWriter("C://Users//zafor//Desktop//Presentation//Final_presentation//src//Final_Try//Order_Data");
            for (int i = 0; i < Book_List.size(); i++) {
                wbook.write(Book_List.get(i).Name + "," + Book_List.get(i).Author + "," + Book_List.get(i).ISBN + "," + Book_List.get(i).Quantity + "," + Book_List.get(i).price);
            }
            wbook.close();
            for (int i = 0; i < User_list.size(); i++) {
                System.out.println("user done");
                wuser.write(User_list.get(i).getName() + "," + User_list.get(i).getMobile_Number() + User_list.get(i).getID());
            }
            worder.close();
            for(int i=0;i<Order_List.size();i++){
                System.out.println("User done");
                worder.write("ok");
            }
            wuser.close();
        }
        catch(Exception e){
            System.out.println("The File is Faulty");
            e.printStackTrace();
        }
    }public static void Retrieve_All_Data(){
        try {
            FileReader rbook = new FileReader("C://Users//zafor//Desktop//Presentation//Final_presentation//src//Final_Try//Book_Data");
            FileReader ruser = new FileReader("C://Users//zafor//Desktop//Presentation//Final_presentation//src//Final_Try//User_Data");
            FileReader rorder = new FileReader("C://Users//zafor//Desktop//Presentation//Final_presentation//src//Final_Try//Order_Data");
            BufferedReader br1  =new BufferedReader(rbook);
            BufferedReader br2  =new BufferedReader(ruser);
            BufferedReader br3  =new BufferedReader(rorder);
            while(br1.ready()){
                String line = br1.readLine();
                String data[] = line.split("");
            }
        }
        catch(Exception e){
            System.out.println("The File cannot be read");
        }
    }

}
