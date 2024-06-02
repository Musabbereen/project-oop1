package Final_Try;

import java.sql.SQLOutput;
import java.time.LocalDate;

import static Final_Try.Start.sc;
import static Final_Try.Start.st;

public class BorrowBook extends Order{
    private final int Borrow_Time = 10;
    private static String Borrow_Date;
    private static String Return_Date;
    static int isavailable=0;
    static int index_value;
    private static String ISBN;


    public BorrowBook(String ISBN, String Borrower_ID) {
        super(ISBN, Borrower_ID);
    }
    public BorrowBook(String ISBN, String Borrower_ID,String Borrow_date,String Return_Date,int Quantity) {
        super(ISBN, Borrower_ID,Borrow_date,Return_Date,Quantity);
    }
    public static void Find_Validity(String name){
       isavailable=0;
        Find_Book();
        if(isavailable==1) {

            Borrow_Date = LocalDate.now().toString();
            Return_Date = LocalDate.now().plusDays(10).toString();
            BorrowBook.AddOrders(new BorrowBook(Book_List.get(index_value).ISBN,name, Borrow_Date, Return_Date,getQuantity()));
        }
        }
    public static void Find_Book(){
        System.out.println("Enter the name of the Book");
        String Book_name = st.nextLine();
        System.out.println("Enter the name of the Author");
        String Author = st.nextLine();
        for(int i=0;i<Book_List.size();i++){
            if(Book_name.equals(Book_List.get(i).Name) && Author.equals(Book_List.get(i).Author)){
                System.out.println("                               The Book is Available     ");
                System.out.println("Enter the Quantity");
                int q = sc.nextInt();
                if(q>Book_List.get(i).Quantity){
                    System.out.println("The quantity is not valid");
                }
                else{
                    int n = Book_List.get(i).Quantity;
                    Book_List.get(i).Quantity = n-q;
                    Order.setQuantity(q);
                    System.out.println("The Book is successfully borrowed");
                    isavailable =1;
                    index_value = i;

                }

            }
        }

    }


    public static String getISBN() {
        return ISBN;
    }

    public static void setISBN(String ISBN) {
        BorrowBook.ISBN = ISBN;
    }
}
