package mao.practice;

/**
 * Created by liwei on 5/26/2016.
 */
public class Contacts {

    String ID,name,number,email;

    public Contacts(String ID, String name, String number, String email){
        this.ID = ID;
        this.name = name;
        this.number = number;
        this.email = email;
    }


    public String get_ID(){return ID;}
    public String get_name(){
        return name;
    }
    public String set_number(){
        return number;
    }
    public String set_email(){return email;}
}
