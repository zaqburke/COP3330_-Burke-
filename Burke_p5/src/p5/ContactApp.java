package p5;

import java.io.File;
import java.util.Scanner;
public interface ContactApp {
    public static void contactmenu(){
        Scanner input = new Scanner(System.in);
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
                    ContactList loadList = new ContactList();
                    File listFile = new File(fileName);
                    loadList.loadFile(listFile);
                    break;
                case 3:
                    mainmenu = 3;
                    break;
                case 4:
                    mainmenu = 4;
                    System.exit(mainmenu);
                default:
                    System.out.println("Invalid Selection");
            }
        }
    }
}