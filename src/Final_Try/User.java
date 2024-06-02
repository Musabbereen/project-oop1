package Final_Try;

public class User {
    private String name;
    private String Mobile_Number;
    private String ID;

    public User(String name,String Mobile_Number){
        this.name = name;
        this.Mobile_Number = Mobile_Number;

    }
    public User(String name,String Mobile_Number,String ID){
        this.name = name;
        this.Mobile_Number = Mobile_Number;
        this.ID = ID;

    }
    public String getMobile_Number() {
        return Mobile_Number;
    }

    public void setMobile_Number(String mobile_Number) {
        Mobile_Number = mobile_Number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString(){
        return "Name: "+getName()+","+" Mobile_Number:  "+getMobile_Number();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
