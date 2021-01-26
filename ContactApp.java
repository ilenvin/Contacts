import java.util.ArrayList;
import java.util.Scanner;

public class ContactApp {
    
    static Scanner sc = new Scanner(System.in);
    ContactList contactList =  new ContactList();


    public void addContact() {
        
        ArrayList<Telephone> telList = new ArrayList<Telephone>();
       // Input name 
        System.out.print("\nInput Contact's First Name: ");
        String firstName = sc.nextLine();
        System.out.print("\nInput Contact's Last Name: ");
        String lastName = sc.nextLine();

       //  Input tel contact

       System.out.println("\nHow many phone number? ");
       System.out.print("Choice: ");
       int count = sc.nextInt();

      // Choice validation
    while(count < 1){
            System.out.println("\nInvalid Choice!");
            System.out.print("\nRe-enter: ");
            count = sc.nextInt();
      }
    
      int phoneNumber;
      String purpose;
    for (int i=0; i<count ; i++){

            System.out.printf("Enter Phone Number[%d]: ", i+1);
            phoneNumber = sc.nextInt();
            System.out.printf("Enter Phone Number's Purpose[%d]: ", i+1);
            purpose = sc.nextLine();  
            purpose = sc.nextLine();  
            
            Telephone tel = new Telephone(phoneNumber, purpose);
            telList.add(tel);
    }

        Contact newContact = new Contact(firstName, lastName, telList);
        contactList.contacts.add(newContact);
    

    }

    public void listContact() {
        ArrayList<Contact> contacts = contactList.contacts;
        int j;
        for (int i=0; i<contacts.size(); i++){

            System.out.printf("\n%d/ First name: %s Last name: %s\n", i+1, contacts.get(i).firstName, contacts.get(i).lastName);
            for(j = 0; j<contacts.get(i).telList.size(); j++){

                ArrayList<Telephone> telList = contacts.get(i).telList;
                System.out.printf("\nTel: 0%d | For: %s", telList.get(j).phoneNumber, telList.get(j).purpose);
            
             }
             System.out.println('\n');
             j=0;
        }
        
    }

   

    public void updateContact() {
        // List all contacts
        listContact();

        System.out.println("------> Updating contact");
        System.out.print("Input index of contact: ");
        int index = sc.nextInt();

        while(index < 1){
            System.out.print("Input index of contact: ");
            index = sc.nextInt();
        }

        for (int i = 0; i<contactList.contacts.size(); i++){

            // Check for same Index

            if(index-1 == i ){
                
                System.out.println("What do you want to update:");
                System.out.println("1. First Name");
                System.out.println("2. Last Name");
                System.out.println("3. Phone Number");
                System.out.print("Choice: ");
                int choice = sc.nextInt();
                String empty = sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("\nEnter new First Name: ");
                        contactList.contacts.get(i).firstName = sc.nextLine();  

                        System.out.println("***Update Successfully\n");                         
                        break;
                    case 2:
                        System.out.print("\nEnter new Last Name: ");
                        contactList.contacts.get(i).lastName = sc.nextLine();   
                        System.out.println("***Update Successfully\n");                         
                        break;
                    case 3:
                        int size = contactList.contacts.get(i).telList.size();
                         for (int j =0; j < size; j++ ){

                            ArrayList<Telephone> telList = contactList.contacts.get(i).telList;
                            System.out.printf("\n%d.  Tel: %d | For: %s", j+1,telList.get(j).phoneNumber, telList.get(j).purpose);

                         } 

                         System.out.print("Choice: ");
                         int opt = sc.nextInt();

                         while (opt < size && opt > size){
                            System.out.println("*****Invalid Input! ");
                            System.out.print("Choice: ");
                            opt = sc.nextInt(); 
                         }

                         for (int j = 0; j < size; j++) {

                             if(opt-1 == j){
                                System.out.print("\nEnter new Phone Number: ");
                                contactList.contacts.get(i).telList.get(j).phoneNumber = sc.nextInt();   
                                System.out.print("\nEnter new Purpose: ");
                                contactList.contacts.get(i).telList.get(j).purpose= sc.nextLine();   
                                System.out.println("***Update Successfully\n");   
                             }

                         }

                        break;

                    default:
                        break;
                }
            }

        }

        
    }

    public void deleteContact() {
        // List all contacts
        listContact();

        System.out.println("------> Deleting contact");
        System.out.print("Input index of contact: ");
        int index = sc.nextInt();

        while(index < 1){
            System.out.print("Input index of contact: ");
            index = sc.nextInt();
        }

        for (int i = 0; i<contactList.contacts.size(); i++){

            // Check for same Index

            if(index-1 == i ){
                contactList.contacts.remove(i);
                System.out.println("***Contact Removed!");
            }
        
    }
}

  





    public static void main(String[] args) {

        ContactApp app = new ContactApp();
        boolean isRunning = true;

        while(isRunning){
        System.out.println("\n-----------> Contact App Management System <------------\n");

       
        System.out.println("1. Add New Contact");
        System.out.println("2. Update Existing Contact");
        System.out.println("3. Delete a Contact");
        System.out.println("4. List All Contacts");
        System.out.println("5. Exit");
        System.out.print("Pick an option: ");
        int option = sc.nextInt();

        String empty = sc.nextLine();

       
            switch (option) {
                case 1:
                    app.addContact();
                    break;
        
                case 2:
                    app.updateContact();
                    break;
    
                case 3:
                  app.deleteContact();

                    break;
                case 4:
                    app.listContact();
                    
                    break;
                case 5: 
                    isRunning = false;
                    break;
                default:
                    break;
            }
        }
        
    }

}

