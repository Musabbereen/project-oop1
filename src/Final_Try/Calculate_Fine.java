package Final_Try;

public class Calculate_Fine {
    public String User_Name;
    public String DeadLine_Date;
    public String Return_Date;
    public Calculate_Fine(String User_Name,String DeadLine_Date,String Return_Date){
        this.User_Name = User_Name;
        this.DeadLine_Date = DeadLine_Date;
        this.Return_Date = Return_Date;
    }
    public String toString(){
        return "Name: "+User_Name+" DeadLine: "+DeadLine_Date+" Return_Date: "+Return_Date;
    }
}
