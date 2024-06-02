package Final_Try;

import static Final_Try.Library.RemoveBook;
import static Final_Try.Start.sc;

public class NormalUser extends User{

    public NormalUser(String name, String Mobile_Number) {
        super(name, Mobile_Number);
    }
    public NormalUser(String name,String Mobile_Number,String ID) {
        super(name,Mobile_Number,ID);
    }

    public static void menu(String name,String number){
        int n = 1;
        while(n!=0) {
            System.out.println("1:View Books");
            System.out.println("2:Search Book");
            System.out.println("3:Borrow Book");
            System.out.println("4:Return Book");
            System.out.println("0:Exit");
            n = sc.nextInt();
            switch (n) {
                case 0:
                    break;
                case 1:
                    Library.ViewBooks();
                    break;
                case 2:
                    Library.SearchBook();
                    break;
                case 3:
                    BorrowBook.Find_Validity(name);
                    break;
                case 4:
                    Return_Book.Find_Order(name);



            }
        }

    }
}
