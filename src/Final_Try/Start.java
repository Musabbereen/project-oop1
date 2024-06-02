package Final_Try;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Start extends Library {
    static String Admin_name;
    static String Admin_number;
    static int n;
    static Scanner sc = new Scanner(System.in);
    static Scanner st  = new Scanner(System.in);
    public static void Begin(){
        Library lib = new Library();
        System.out.println("Welcome to Library management System");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("1:Login");
        System.out.println("2:NewUser");
        System.out.println("0:Exit");
        try{
            n = sc.nextInt();
        if(n==0){
            return ;
        }
        else {
                while(n!=0){
            switch (n) {
                case 0:
                    break;
                case 1:
                    Login();
                    break;
                case 2:
                    NewUser();
                    break;
                default:
                    throw new Wrong_Input("The input is not valid");
            }
                    System.out.println("1:Login");
                    System.out.println("2:NewUser");
                    System.out.println("0:Exit");
                    n = sc.nextInt();
                    if(n==0){
                        System.out.println("Stored All Data");
                        Library.Store_All_Data();
                    }

            }
        }


        }
        catch(InputMismatchException e){
            System.out.println("The input is Invalid");

        }
        catch(Wrong_Input e){
            System.out.println(e.getMessage());
        }


    }
    public static void Login(){
        System.out.println("Enter your name: ");
        String name = st.nextLine();
        System.out.println("Enter your mobile_Numeber");
        String Mobile_Number = st.nextLine();
        System.out.println("Enter your ID");
        String ID = st.nextLine();
        if(name.equals(Start.Admin_name) && Mobile_Number.equals(Admin_number)){
            Admin.menu();
        }
        else {

            Library.SearchUser(name, Mobile_Number);
        }
    }
    public static void NewUser(){
        System.out.println("1:Admin");
        System.out.println("2:NormalUser");
        System.out.println("0:Exit");
        n = sc.nextInt();
        System.out.println("Enter your name: ");
        String name = st.nextLine();
        System.out.println("Enter your mobile_Number");
        String number = st.nextLine();
        System.out.println("Enter your ID");
        String ID = st.nextLine();
        try {
            if (n == 2) {
                NormalUser nu = new NormalUser(name,number,ID);
                Library.User_list.add(nu);
                System.out.println("User is successfully added");
                NormalUser.menu(name,number);
            }
            else if (n == 1) {
                 Admin_name = name;
                 Admin_number = number;
                 Admin.menu();

            }
            else if (n == 0) {
                return;
            }
            else {
                throw new InputMismatchException("The input is invalid");
            }
        }
        catch(InputMismatchException e){
            System.out.println(e.getMessage());
        }

    }

}
