package Final_Try;

public class Order extends Library{
    private static String ISBN;
    private static String ID;
    private String Borrow_Date;
    private String Return_Date;
    private static int Quantity;
    public Order(String ISBN,String Borrower_ID,String Borrow_Date,String Return_Date,int Quantity){
            this.ISBN  = ISBN;
            this.Borrow_Date = Borrow_Date;
            this.Return_Date = Return_Date;
            this.ID = Borrower_ID;
            this.Quantity = Quantity;
    }
    public Order(String ISBN,String Borrower_ID,String Borrow_Date,String Return_Date){
            this.ISBN  = ISBN;
            this.Borrow_Date = Borrow_Date;
            this.Return_Date = Return_Date;
            this.ID = Borrower_ID;

    }
    public Order(String ISBN,String Borrower_ID,String Return_Date){
            this.ISBN  = ISBN;
            this.Return_Date = Return_Date;
            this.ID = Borrower_ID;
    }
    public Order(String ISBN,String Borrow_ID){
        this.ISBN = ISBN;
        this.ID = Borrow_ID;
    }

    public static String getISBN() {
        return ISBN;
    }

    public static void setISBN(String ISBN) {
        Order.ISBN = ISBN;
    }

    public static String getID() {
        return ID;
    }

    public void setID(String ID) {
        Order.ID = ID;
    }

    public String getBorrow_Date() {
        return Borrow_Date;
    }

    public void setBorrow_Date(String borrow_Date) {
        Borrow_Date = borrow_Date;
    }

    public String getReturn_Date() {
        return Return_Date;
    }

    public void setReturn_Date(String return_Date) {
        Return_Date = return_Date;
    }
    public String toString(){
        return "ISBN: "+getISBN()+"  User ID: "+getID()+"  Borrow_Date: "+getBorrow_Date()+"  Return_Date:  "+getReturn_Date();
    }

    public static int getQuantity() {
        return Quantity;
    }

    public static void setQuantity(int quantity) {
        Order.Quantity = quantity;
    }
}
