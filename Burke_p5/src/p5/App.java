package p5;

import java.util.Scanner;
public class App implements TaskApp, ContactApp {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int mainmenu = 1;
        while(mainmenu != 3){
            System.out.println("Main Menu");
            System.out.println("---------");
            System.out.println("         ");
            System.out.println("1) Task List");
            System.out.println("2) Contact List");
            System.out.println("3) Quit");
            System.out.print("> ");
            mainmenu = input.nextInt();
            switch(mainmenu){
                case 1:
                    TaskApp.taskmenu();
                    break;
                case 2:
                    ContactApp.contactmenu();
                    break;
                case 3:
                    System.exit(mainmenu);
                default:
                    System.out.println("Invalid Selection");
            }
        }
    }
}
