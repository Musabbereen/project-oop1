package Final_Try;

public class Book {
    public String Name;
    public String ISBN;
    public String Author;
    public int  Quantity;
    public double  price;
    public Book(String name,String Author,String ISBN,int Quantity,double price){
        this.Name  = name;
        this.Author= Author;
        this.Quantity = Quantity;
        this.price = price;
        this.ISBN = ISBN;
    }
    public Book(String name,int quantity){
        this.Name  = name;
        this.Quantity = quantity;
    }
    public String toString(){
        return "Name: "+Name+"  Author: "+Author+"  ISBN "+ISBN+"  Quantity "+Quantity+"  price "+price;
    }
}
