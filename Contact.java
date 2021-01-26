import java.util.ArrayList;

public class Contact {
    String firstName, lastName;
    ArrayList<Telephone> telList = new ArrayList<Telephone>();

    public Contact(String firstName, String lastName, ArrayList<Telephone> telList){
        this.firstName = firstName;
        this.lastName = lastName;
        this.telList = telList;
    }
}
