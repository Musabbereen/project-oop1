package Final_Try;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static Final_Try.Start.sc;
import static Final_Try.Start.st;

public class Return_Book extends Order{
    public Return_Book(String ISBN, String Borrower_ID, String Borrow_Date, String Return_Date) {
        super(ISBN, Borrower_ID, Borrow_Date, Return_Date);
    }
    public static void Find_Order(String name){
        System.out.println("Enter the Book_ISBN");
        String ISBN = st.nextLine();
        for(int i=0;i<Order_List.size();i++){
            if(Order_List.get(i).getISBN().equals(ISBN)){
                System.out.println("The order is valid and found");
                System.out.println(Order_List.get(i).toString());
                Return_Ordered_Book(ISBN, Order_List.get(i).getQuantity());
                 CalculateFine(name,Order_List.get(i).getReturn_Date());
                 Order_List.remove(i);
                break;
            }
        }
    }
    public static void Return_Ordered_Book(String ISBN,int quantity){
        for(int i=0;i<Return_Book.Book_List.size();i++){
            if(ISBN.equals(Book_List.get(i).ISBN)){
                int q = Book_List.get(i).Quantity;

                Book_List.get(i).Quantity = q+quantity;
            }
        }
    }
    public static void CalculateFine(String name,String deadline){
        String format = "yyyy-MM-dd";
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("Enter the Return Date of the Book in "+format+" Format");
        String Return_date = st.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        try {
            LocalDate date1 = LocalDate.parse(Return_date, formatter);
            LocalDate date2 = LocalDate.parse(deadline, formatter);


            if (date1.isAfter(date2)) {
                System.out.println("You will be fined");
                Library.Fine.add(new Calculate_Fine(name, deadline, Return_date));
            }
        }
        catch(Exception e){
            System.out.println("The format is invalid");
            e.printStackTrace();
            return ;
        }


    }

}
