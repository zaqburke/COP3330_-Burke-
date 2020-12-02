package p5;

import java.io.File;
import java.util.Scanner;
public interface TaskApp {
    public static void taskmenu(){
        Scanner input = new Scanner(System.in);
        int mainmenu = 1;
        while(mainmenu != 3){
            System.out.println("Task List Main Menu");
            System.out.println("---------");
            System.out.println("         ");
            System.out.println("1) create a new task list");
            System.out.println("2) load an existing task list");
            System.out.println("3) quit to the main menu");
            System.out.println("4) close the application");
            System.out.print("> ");
            mainmenu = input.nextInt();
            switch(mainmenu){
                case 1:
                    System.out.println("A new task list has been created!");
                    System.out.println("---------");
                    TaskList list = new TaskList();
                    list.listOptions();
                    break;
                case 2:
                    System.out.println("Enter the file you would like to load, please include the file type at the end: ");
                    Scanner userInputFile = new Scanner(System.in);
                    String fileName = userInputFile.nextLine();
                    TaskList loadList = new TaskList();
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

