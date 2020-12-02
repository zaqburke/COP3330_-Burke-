package p5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class TaskList extends App implements TaskApp {
    public void listOptions(){
        int Choice = 1;
        Scanner input = new Scanner(System.in);
        while(Choice != 8) {
            System.out.println("List Operation Menu");
            System.out.println("---------");
            System.out.println("1) view the list");
            System.out.println("2) add an item");
            System.out.println("3) edit an item");
            System.out.println("4) remove an item");
            System.out.println("5) mark an item as completed");
            System.out.println("6) unmark an item as completed");
            System.out.println("7) save the current list");
            System.out.println("8) quit to the task list main menu");
            System.out.println("> ");
            Choice = input.nextInt();
            switch(Choice){
                case 1:
                    displayList(this.taskList);
                    listOptions();
                    break;
                case 2:
                    addTask(this.taskList);
                    listOptions();
                    break;
                case 3:
                    int choice;
                    displayList(this.taskList);
                    System.out.println("Which task would you like to edit (use the index number on the far left):");
                    Scanner taskChoice = new Scanner(System.in);
                    if(!taskChoice.hasNextInt()){
                        System.out.println("Invalid input, task not marked");
                        return;
                    }else {
                        choice = taskChoice.nextInt();
                        editTask(this.taskList, choice);
                    }
                    listOptions();
                    break;
                case 4:
                    displayList(taskList);
                    int removeChoice;
                    System.out.println("Which task would you like to remove (use the index number on the far left):");
                    Scanner taskChoice2 = new Scanner(System.in);
                    if(!taskChoice2.hasNextInt()){
                        System.out.println("Invalid input, task not removed.");
                    }else {
                        removeChoice = taskChoice2.nextInt();
                        removeTask(this.taskList, removeChoice);
                    }
                    listOptions();
                    break;
                case 5:
                    int counter = UncompletedList(this.taskList);
                    int markChoice;
                    if(counter == 0){System.out.println("You have no completed tasks");}
                    else {
                        System.out.println("Which task would you like to mark as completed (enter the index number listed on the left):");
                        Scanner completeChoice = new Scanner(System.in);
                        if (!completeChoice.hasNextInt()) {
                            System.out.println("Invalid input, task not marked as completed");
                            return;
                        } else {
                            markChoice = completeChoice.nextInt();
                            markCompleted(this.taskList, markChoice);
                        }
                    }
                    listOptions();
                    break;
                case 6:
                    int unMarkChoice;
                    int unMarkCounter = CompletedList(this.taskList);
                    if(unMarkCounter == 0){System.out.println("Error in input, task is not marked");}
                    else {
                        System.out.println("Which task would you like to remove completion status from (enter the index number listed on the left):");
                        Scanner incompleteChoice = new Scanner(System.in);
                        if (!incompleteChoice.hasNextInt()) {
                            System.out.println("Invalid input, no task was marked for incompletion");
                            return;
                        }
                        else {
                            unMarkChoice = incompleteChoice.nextInt();
                            unmarkCompleted(this.taskList, unMarkChoice);
                        }
                    }
                    listOptions();
                    break;
                case 7:
                    saveFile(this.taskList);
                    listOptions();
                    break;
                case 8:
                    Choice = 8;
                    int mainmenu = 1;
                    while(mainmenu != 3){
                        System.out.println("Task List Main Menu");
                        System.out.println("---------");
                        System.out.println("         ");
                        System.out.println("1) create a new task list");
                        System.out.println("2) load an existing task list");
                        System.out.println("3) quit to the main menu");
                        System.out.println("4) close the application");
                        System.out.print(">");
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
                                TaskList loadedList = new TaskList();
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
    public final ArrayList<TaskItem> taskList;
    public TaskList() {
        this.taskList = new ArrayList<>();
    }
    public void displayList(ArrayList<TaskItem> taskList){
        System.out.println("Current Tasks");
        System.out.println("---------");
        if(taskList.size() == 0){
            System.out.println("The list is currently empty");
        }
        for(int i = 0; i < taskList.size(); i++){
            if(taskList.get(i).isCompleted()){
                System.out.println(i + ") Complete - " + taskList.get(i).toString());
            }
            else {
                System.out.println(i + ") Incomplete - " + taskList.get(i).toString());
            }
        }
    }
    public void addTask(ArrayList<TaskItem> taskList) {
        String taskName;
        String duedate;
        String description;
        System.out.println("Task title: ");
        Scanner nameIn = new Scanner(System.in);
        taskName = nameIn.nextLine();
        if (!(taskName.length() >= 1)) {
            System.out.println("Title must be at least 2 characters");
            return;
        }
        System.out.println("Task description: ");
        Scanner descriptionIn = new Scanner(System.in);
        description = descriptionIn.nextLine();
        System.out.println("Task due date (YYYY-MM-DD): ");
        Scanner duedateIn = new Scanner(System.in);
        duedate = duedateIn.nextLine();
        if (!(duedate.matches("....-..-.."))) {
            System.out.println("Incorrect date format, please use YYYY-MM-DD when entering the date.");
            return;
        }
        Date inputdate = null;
        try {
            inputdate = new SimpleDateFormat("yyyy-mm-dd").parse(duedate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TaskItem newItem = new TaskItem(taskName, duedate, description, false);
        taskList.add(newItem);
    }
    public void editTask(ArrayList<TaskItem> taskList, int choice){
        String taskName;
        String duedate;
        String description;
        try{
            taskList.get(choice);
        }catch (IndexOutOfBoundsException exc) {
            System.out.println("Invalid selection; task does not exist.");
            throw exc;
        }
        finally{
            if(choice > taskList.size() || choice < 0){
                return;
            }
            System.out.println("Enter a new title for task " + choice + " :" );
            Scanner nameIn = new Scanner(System.in);
            taskName = nameIn.nextLine();
            if(!(taskName.length() >= 1)){
                System.out.println("Title must be at least 2 characters, please retry the edit.");
                return;
            }
            System.out.println("Enter a new description for task " + choice + " :");
            Scanner descriptionInput = new Scanner (System.in);
            description = descriptionInput.nextLine();

            System.out.println("Enter a new task due date (YYYY-MM-DD) for task " + choice + " :");
            Scanner duedateInput = new Scanner(System.in);
            duedate = duedateInput.nextLine();

            if (!(duedate.matches("....-..-.."))) {
                System.out.println("Invalid date format, please use YYYY-MM-DD");
                return;
            }
            Date inputdate = null;
            try {
                inputdate = new SimpleDateFormat("yyyy-MM-dd").parse(duedate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            TaskItem editedItem = new TaskItem(taskName, duedate, description, false);
            taskList.set(choice, editedItem);
        }
    }
    public void removeTask(ArrayList<TaskItem> taskList, int choice) throws IndexOutOfBoundsException{
        try{
            taskList.get(choice);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Invalid task name, task does not exist in arhive, therefore nothing was removed.");
            throw ex;
        }
        finally{
            if(choice > taskList.size() || choice < 0){
                return;
            }
            taskList.remove(choice);
        }
    }
    public void markCompleted(ArrayList<TaskItem> taskList, int choice){
        try{
            taskList.get(choice);
        }
        catch (IndexOutOfBoundsException ex){
            System.out.println("Invalid task name, task does not exist in archive and could not be marked as complete.");
            throw ex;
        }
        finally{
            if(choice > taskList.size() || choice < 0){
                return;
            }
            taskList.get(choice).setCompleted();
        }
    }
    public int UncompletedList(ArrayList<TaskItem> taskList){
        int counter = 0;
        System.out.println("Incomplete Tasks");
        System.out.println("-------------\n");
        for(int i = 0; i < taskList.size(); i++){
            if (!taskList.get(i).isCompleted()) {
                System.out.println(i + ") " + taskList.get(i));
                counter++;
            }
        }
        if(counter == 0){System.out.println("You have no incomplete tasks.");}
        return counter;
    }
    public int CompletedList(ArrayList<TaskItem> taskList){
        int counter = 0;
        System.out.println("Completed Tasks");
        System.out.println("-------------\n");

        for(int i = 0; i < taskList.size(); i++){
            if (taskList.get(i).isCompleted()) {
                System.out.println(i + ") Completed - " + taskList.get(i));
                counter++;
            }
        }
        if(counter == 0){System.out.println("You have no completed tasks.");}

        return counter;
    }
    public void unmarkCompleted(ArrayList<TaskItem> taskList, int choice){
        try{
            taskList.get(choice);
        }
        catch (IndexOutOfBoundsException ex){
            System.out.println("Invalid task name, task does not exist in arhive and could not be marked as incomplete.");
            throw ex;
        }
        finally{
            if(choice > taskList.size() || choice < 0){
                return;
            }
            taskList.get(choice).unsetCompleted();
        }
    }
    public void saveFile(ArrayList<TaskItem> taskList){
        String fileName;
        if(taskList.size() == 0){
            System.out.println("Current list is empty");
            return;
        }
        System.out.println("Please enter file name (file type at the end helps but is not required): ");
        Scanner input = new Scanner(System.in);
        fileName = input.nextLine();
        File saveFile = new File(fileName);
        try {
            FileWriter taskWriter = new FileWriter(fileName);
            int listSize = taskList.size();
            taskWriter.write(listSize + "\n");
            for(int i = 0; i < taskList.size(); i++){
                taskWriter.write(taskList.get(i).toStringFile() + "\n");
            }
            taskWriter.close();
        } catch (IOException save) {
            System.out.println("Save unsuccessful, file did not save properly.");
        }
        System.out.println("Successfully saved the current task list.");
    }
    public void loadFile(File listFile){
        boolean Complete;
        int listSize;
        String taskName;
        String duedate;
        String description;
        String isCompleted;
        try {
            Scanner fileReader = new Scanner(listFile);
            listSize = fileReader.nextInt();
            fileReader.nextLine();
            for(int i = 0; i < listSize; i++){
                taskName = fileReader.nextLine();
                description = fileReader.nextLine();
                duedate = fileReader.nextLine();
                isCompleted = fileReader.nextLine();
                if(taskName.length() == 0){
                    System.out.println("Invalid task name, file did not load.");
                    return;
                }
                if(isCompleted.contains("true")){
                    Complete = true;
                }
                else{
                    Complete = false;
                }
                TaskItem newItem = new TaskItem(taskName, duedate, description, Complete);
                taskList.add(newItem);
            }
            listOptions();
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



