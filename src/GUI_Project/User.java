package GUI_Project;

public class User {
    public String name ;
    public String mobile_no;
    public String ID;
    public  User(String name,String mobile_no,String ID){
        this.name = name;
        this.mobile_no = mobile_no;
        this.ID = ID;
    }
    public User(String name,String ID){
        this.name =name;
        this.ID = ID;
    }
    public String toString(){
        return "Name: "+name+" mobile_no: "+mobile_no+"ID: "+ID;
    }
    public String toStringFile(){
        return name+","+mobile_no+","+ID;
    }
    public User(){

    }

}
