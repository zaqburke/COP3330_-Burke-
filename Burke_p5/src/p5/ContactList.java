package p5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class ContactList extends App implements ContactApp {
    public void contactlistOptions(){
        int Choice = 1;
        Scanner input = new Scanner(System.in);
        while(Choice != 6) {
            System.out.println("Contact List Operation Menu");
            System.out.println("---------");
            System.out.println("1) view the current contact list");
            System.out.println("2) add a contact");
            System.out.println("3) edit a contact");
            System.out.println("4) remove a contact");
            System.out.println("5) save the current contact list");
            System.out.println("6) quit to the contact list main menu");
            System.out.println("> ");
            Choice = input.nextInt();
            switch(Choice){
                case 1:
                    displayList(this.ContactList);
                    contactlistOptions();
                    break;
                case 2:
                    addContact(this.ContactList);
                    contactlistOptions();
                    break;
                case 3:
                    int choice;
                    displayList(this.ContactList);
                    System.out.println("Which contact would you like to edit (use the index number on the far left):");
                    Scanner contactChoice = new Scanner(System.in);
                    if(!contactChoice.hasNextInt()){
                        System.out.println("Invalid input, contact not marked");
                        return;
                    }else {
                        choice = contactChoice.nextInt();
                        editContact(this.ContactList, choice);
                    }
                    contactlistOptions();
                    break;
                case 4:
                    displayList(ContactList);
                    int removeChoice;
                    System.out.println("Which contact would you like to remove (use the index number on the far left):");
                    Scanner ContactChoice2 = new Scanner(System.in);
                    if(!ContactChoice2.hasNextInt()){
                        System.out.println("Invalid input, contact not removed.");
                    }else {
                        removeChoice = ContactChoice2.nextInt();
                        removeContact(this.ContactList, removeChoice);
                    }
                    contactlistOptions();
                    break;
                case 5:
                    saveFile(this.ContactList);
                    contactlistOptions();
                    break;
                case 6:
                    Choice = 6;
                    int mainmenu = 1;
                    while(mainmenu != 3){
                        System.out.println("Contact List Main Menu");
                        System.out.println("---------");
                        System.out.println("         ");
                        System.out.println("1) create a new contact list");
                        System.out.println("2) load an existing contact list");
                        System.out.println("3) quit to the main menu");
                        System.out.println("4) close the application");
                        System.out.print("> ");
                        mainmenu = input.nextInt();
                        switch(mainmenu){
                            case 1:
                                System.out.println("A new contact list has been created!");
                                System.out.println("---------");
                                ContactList list = new ContactList();
                                list.contactlistOptions();
                                break;
                            case 2:
                                System.out.println("Enter the file you would like to load, please include the file type at the end: ");
                                Scanner userInputFile = new Scanner(System.in);
                                String fileName = userInputFile.nextLine();
                                ContactList loadedList = new ContactList();
                                File listFile = new File(fileName);
                                loadedList.loadFile(listFile);
                                break;
                            case 3:
                                main(null);
                            case 4:
                                mainmenu = 4;
                                System.exit(mainmenu);
                        }
                    }
            }
        }
    }
    public final ArrayList<ContactItem> ContactList;
    public ContactList() {
        this.ContactList = new ArrayList<>();
    }
    public void displayList(ArrayList<ContactItem> ContactList){
        System.out.println("Current Contacts");
        System.out.println("---------");
        if(ContactList.size() == 0){
            System.out.println("The list is currently empty.");
            System.out.println("         ");
        }
        for(int i = 0; i < ContactList.size(); i++){
            System.out.println(i + ") " + ContactList.get(i).toString());
        }
    }
    public void addContact(ArrayList<ContactItem> ContactList) {
        String firstname;
        String lastname;
        String phonenumber;
        String email;
        System.out.println("First name: ");
        Scanner firstnamein = new Scanner(System.in);
        firstname = firstnamein.nextLine();
        System.out.println("Last name: ");
        Scanner lastnamein = new Scanner(System.in);
        lastname = lastnamein.nextLine();
        System.out.println("Phone number (xxx-xxx-xxxx): ");
        Scanner phonenumberIn = new Scanner(System.in);
        phonenumber = phonenumberIn.nextLine();
        System.out.println("E-mail (x@y.z): ");
        Scanner emailIn = new Scanner(System.in);
        email = emailIn.nextLine();
        ContactItem newItem = new ContactItem(firstname, lastname, phonenumber, email);
        ContactList.add(newItem);
    }
    public void editContact(ArrayList<ContactItem> ContactList, int choice){
        String firstname;
        String lastname;
        String phonenumber;
        String email;
        try{
            ContactList.get(choice);
        }catch (IndexOutOfBoundsException exc) {
            System.out.println("Invalid selection; Contact does not exist.");
            throw exc;
        }
        finally{
            if(choice > ContactList.size() || choice < 0){
                return;
            }
            System.out.println("Enter a new first name for this contact " + " :" );
            Scanner firstnameIn = new Scanner(System.in);
            firstname = firstnameIn.nextLine();
            System.out.println("Enter a new last name for this contact " + " :");
            Scanner lastnameIn = new Scanner (System.in);
            lastname = lastnameIn.nextLine();
            System.out.println("Enter a new phone number for this contact " + " :");
            Scanner phonenumberIn = new Scanner(System.in);
            phonenumber = phonenumberIn.nextLine();
            System.out.println("Enter a new email for this contact " + " :" );
            Scanner emailIn = new Scanner(System.in);
            email = emailIn.nextLine();
            Date inputdate = null;
            ContactItem editedItem = new ContactItem(firstname, lastname, phonenumber, email);
            ContactList.set(choice, editedItem);
        }
    }
    public void removeContact(ArrayList<ContactItem> ContactList, int choice) throws IndexOutOfBoundsException{
        try{
            ContactList.get(choice);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Invalid index number; contact does not exist in current arhive, therefore nothing was removed.");
            throw ex;
        }
        finally{
            if(choice > ContactList.size() || choice < 0){
                return;
            }
            ContactList.remove(choice);
        }
    }
    public void saveFile(ArrayList<ContactItem> ContactList){
        String fileName;
        if(ContactList.size() == 0){
            System.out.println("Current list is empty");
            return;
        }
        System.out.println("Please enter file name (file type at the end helps but is not required): ");
        Scanner input = new Scanner(System.in);
        fileName = input.nextLine();
        File saveFile = new File(fileName);
        try {
            FileWriter ContactWriter = new FileWriter(fileName);
            int listSize = ContactList.size();
            ContactWriter.write(listSize + "\n");
            for(int i = 0; i < ContactList.size(); i++){
                ContactWriter.write(ContactList.get(i).toStringFile() + "\n");
            }
            ContactWriter.close();
        } catch (IOException save) {
            System.out.println("Save unsuccessful, file did not save properly.");
        }
        System.out.println("Successfully saved the current contact list.");
    }
    public void loadFile(File listFile){
        int listSize;
        String firstname;
        String lastname;
        String phonenumber;
        String email;
        try {
            Scanner fileReader = new Scanner(listFile);
            listSize = fileReader.nextInt();
            fileReader.nextLine();
            for(int i = 0; i < listSize; i++){
                firstname = fileReader.nextLine();
                lastname = fileReader.nextLine();
                phonenumber = fileReader.nextLine();
                email = fileReader.nextLine();
                ContactItem newItem = new ContactItem(firstname, lastname, phonenumber, email);
                ContactList.add(newItem);
            }
            contactlistOptions();
        }catch (FileNotFoundException load) {
            System.out.println("File load error, please make sure to add the file type extension.");
            try {
                throw load;
            } catch (FileNotFoundException fileNotFoundException) {
                return;
            }
        }
    }
}

