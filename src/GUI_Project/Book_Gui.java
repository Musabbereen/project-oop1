package GUI_Project;

public class Book_Gui {
    public String Name;
    public String ISBN;
    public String Author;
    public int  Quantity;
    public int  price;
    public Book_Gui(String name,String Author,String ISBN,int Quantity,int price){
        this.Name  = name;
        this.Author= Author;
        this.Quantity = Quantity;
        this.price = price;
        this.ISBN = ISBN;
    }
    public String toString(){
        return Name+","+ISBN+","+Author+","+Quantity+","+price;
    }
}
