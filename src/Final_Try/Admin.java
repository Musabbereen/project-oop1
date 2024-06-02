package Final_Try;

import static Final_Try.Start.sc;

public class Admin extends User{

    public Admin(String name, String Mobile_Number) {
        super(name, Mobile_Number);
    }

    public static void menu(){
        int n =1;
        while(n!=0) {
            System.out.println("1:View Books");
            System.out.println("2:Add Books");
            System.out.println("3:Remove Books");
            System.out.println("4:View Orders");
            System.out.println("5:View Fines");
            System.out.println("0:Exit");
            n = sc.nextInt();
            switch (n) {
                case 0:
                    break;
                case 1:
                    Library.ViewBooks();
                    break;
                case 2:
                    Library.AddBook();
                    break;
                case 3:
                    Library.RemoveBook();
                    break;
                case 4:
                    Library.ViewOrders();
                    break;
                case 5:
                    Library.ViewFines();
                    break;
                default:
                    System.out.println("The input is invalid");


            }
        }
    }
}
