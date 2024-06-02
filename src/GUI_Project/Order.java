package GUI_Project;

public class Order {
    String User_name;
    String Book_Name;
    int Quantity;
    String Borrow_Date;
    String Return_Date;
    public Order(String user_name, String book_Name, int quantity, String borrow_Date, String return_Date) {
        User_name = user_name;
        Book_Name = book_Name;
        Quantity = quantity;
        Borrow_Date = borrow_Date;
        Return_Date = return_Date;
    }

    public Order() {

    }

    public String toString(){
        return User_name+","+Book_Name+","+Quantity+","+Borrow_Date+","+Return_Date;

    }
}
