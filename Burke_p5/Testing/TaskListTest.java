
import org.junit.jupiter.api.Test;
import p5.TaskItem;
import p5.TaskList;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
class TaskListTest {
    @Test
    void addingTaskItemsIncreasesSize(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Test", "1998-08-23", "testing", false);
        list.taskList.add(newItem);
        assertEquals(1, list.taskList.size());
    }
    @Test
    void completingTaskItemChangesStatus(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Test", "1998-08-23", "testing", false);
        list.taskList.add(newItem);
        newItem.setCompleted();
        assertTrue(newItem.isCompleted());
    }
    @Test
    void completingTaskItemFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Test", "1998-08-23", "testing", false);
        TaskItem newItem2 = new TaskItem("Testing 123", "2020-12-16", "description test", false);
        list.taskList.add(newItem);
        list.taskList.add(newItem2);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.markCompleted(list.taskList, 2);});
    }
    @Test
    void editingTaskItemChangesValues(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Test", "1998-08-23", "testing", false);
        list.taskList.add(newItem);
        TaskItem editItem = new TaskItem("Task 4", "1776-07-04", "desc", false);
        list.taskList.set(0,editItem);
        assertEquals(editItem, list.taskList.get(0));
    }
    @Test
    void editingTaskItemDescriptionChangesValue(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2022-10-31", "Desc 1", false);
        list.taskList.add(newItem);
        TaskItem editItem = new TaskItem("Task 2", "2021-10-31", "Desc 2", false);
        list.taskList.set(0,editItem);
        assertEquals("Desc 2", list.taskList.get(0).getDescription());
    }
    @Test
    void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Test", "2019-01-15", "Old Desc", false);
        list.taskList.add(newItem);
        assertThrows(IndexOutOfBoundsException.class, () -> { list.taskList.get(5).setDescription("New Desc");});
    }
    @Test
    void editingTaskItemDueDateChangesValue(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2023-08-23", "Task Desc 1", false);
        list.taskList.add(newItem);
        TaskItem editItem = new TaskItem("Task 2", "2022-08-23", "Task Desc 2", false);
        list.taskList.set(0,editItem);
        assertEquals("2022-08-23", list.taskList.get(0).getDueDate());
    }
    @Test
    void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task 1", "2011-04-28", "Description", false);
        list.taskList.add(newItem);
        assertThrows(IndexOutOfBoundsException.class, () -> { list.taskList.get(-1).setDueDate("not a date");});
    }

    @Test
    void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("", "2050-08-23", "Test Description", false);
        list.taskList.add(newItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.taskList.get(89).getDescription();});
    }
    @Test
    void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Test", "2050-08-23", "Test Desc", false);
        list.taskList.add(newItem);
        assertEquals("Test Desc", list.taskList.get(0).getDescription());
    }
    @Test
    void gettingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Test", "2050-08-23", "", false);
        list.taskList.add(newItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.taskList.get(1).getDueDate();});
    }
    @Test
    void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task Item", "2050-08-23", "Task Description", false);
        list.taskList.add(newItem);
        assertEquals("2050-08-23", list.taskList.get(0).getDueDate());
    }
    @Test
    void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task Item", "2050-08-23", "Task Description", false);
        list.taskList.add(newItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.taskList.get(1).getName();});
    }
    @Test
    void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task Item", "2050-08-23", "Task Description", false);
        list.taskList.add(newItem);
        assertEquals("Task Item", list.taskList.get(0).getName());
    }
    @Test
    void newTaskListIsEmpty(){
        TaskList list = new TaskList();
        assertEquals(0,list.taskList.size());
    }
    @Test
    void removingTaskItemsDecreasesSize(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task Item 1", "2021-08-23", "Task Description 1", false);
        list.taskList.add(newItem);
        TaskItem newItem2 = new TaskItem("Task Item 2", "2015-08-23", "Task Description 2", false);
        list.taskList.add(newItem2);
        TaskItem newItem3 = new TaskItem("Task Item 3", "2035-08-23", "Task Description 3", false);
        list.taskList.add(newItem3);
        list.removeTask(list.taskList, 1);
        assertEquals(2, list.taskList.size());
    }
    @Test
    void removingTaskItemsFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task Item 1", "2012-08-23", "Task Description 1", false);
        list.taskList.add(newItem);
        TaskItem newItem2 = new TaskItem("Task Item 2", "2013-08-23", "Task Description 2", false);
        list.taskList.add(newItem2);
        TaskItem newItem3 = new TaskItem("Task Item 3", "2014-08-23", "Task Description 3", false);
        list.taskList.add(newItem3);
        list.removeTask(list.taskList, 4);
        assertEquals(3, list.taskList.size());
    }
    @Test
    void savedTaskListCanBeLoaded(){
        new TaskList();
        File listFile = new File("testingtasklist.txt");
        assertTrue(listFile.exists());
    }
    @Test
    void savedTaskListCannotBeLoaded(){
        new TaskList();
        File listFile = new File("This is obviously not a file name.");
        assertFalse(listFile.exists());
    }
    @Test
    void uncompletingTaskItemChangesStatus(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task Item", "2050-08-23", "Task Description", false);
        list.taskList.add(newItem);
        list.markCompleted(list.taskList, 0);
        list.unmarkCompleted(list.taskList, 0);
        assertFalse(list.taskList.get(0).isCompleted());
    }
    @Test
    void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task Item", "2050-08-23", "Task Description", false);
        list.taskList.add(newItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.taskList.get(9).unsetCompleted();});
    }
    @Test
    void getDescriptiongetsCorrectDescription(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task Item", "2050-08-23", "Task Description", false);
        list.taskList.add(newItem);
        assertEquals("Task Description", list.taskList.get(0).getDescription());
    }
    @Test
    void creatingTaskItemFailsWithInvalidDueDate(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task Item", "yes", "Task Description", false);
        list.taskList.add(newItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.taskList.get(1).getDueDate();});
    }
    @Test
    void creatingTaskItemSucceedsWithValidDueDate(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task Item", "2050-08-23", "Task Description", false);
        list.taskList.add(newItem);
        assertEquals("2050-08-23", list.taskList.get(0).getDueDate());
    }
    @Test
    void creatingTaskItemSucceedsWithValidTitle(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task Item", "2050-08-23", "Task Description", false);
        list.taskList.add(newItem);
        assertEquals("Task Item", list.taskList.get(0).getName());
    }
    @Test
    void creatingTaskItemFailsWithInvalidTitle(){
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("", "2050-08-23", "Task Description", false);
        list.taskList.add(newItem);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.taskList.get(1).getName();});
    }
}