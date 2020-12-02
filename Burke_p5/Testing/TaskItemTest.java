
import org.junit.jupiter.api.Test;
import p5.TaskItem;
import p5.TaskList;

import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskItemTest {

    @Test
    void constructorFailsWithInvalidDueDate() {
        assertThrows(DateTimeException.class, () -> new TaskItem("Hey", "22222-10-09", "Description", false),
                "Invalid Due Date");

    }
    @Test
    void constructorFailsWithInvalidTitle() {
        assertThrows(NullPointerException.class, () -> new TaskItem("", "2021-08-01", "Nothing", false),
                "Invalid Title");
    }
    @Test
    void constructorSucceedsWithValidDueDate() {
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task", "2022-08-23", "Description", false);
        list.taskList.add(newItem);
        assertEquals("2022-08-23", list.taskList.get(0).getDueDate());
    }
    @Test
    void constructorSucceedsWithValidTitle() {
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task is a good title", "2022-08-23", "Description", false);
        list.taskList.add(newItem);
        assertEquals("Task is a good title", list.taskList.get(0).getName());
    }
    @Test
    void editingDescriptionSucceedsWithExpectedValue() {
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task", "2022-08-23", "fdjskaf", false);
        list.taskList.add(newItem);
        TaskItem editedItem = new TaskItem("Task", "2022-08-23", "Description", false);
        list.taskList.set(0, editedItem);
        assertEquals(editedItem.toString(), list.taskList.get(0).toString());
    }
    @Test
    void editingDueDateFailsWithInvalidDateFormat() {
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task", "2022-08-23", "Description", false);
        list.taskList.add(newItem);
        assertThrows(NullPointerException.class, () -> list.taskList.set(0, new TaskItem("Task", "2022-08888888-23", "Description", false)));
    }
    @Test
    void editingDueDateSucceedsWithExpectedValue() {
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task", "2022-08-23", "Description", false);
        list.taskList.add(newItem);
        TaskItem editItem = new TaskItem("Task", "2022-08-24", "Description", false);
        list.taskList.set(0, editItem);
        assertEquals("2022-08-24", list.taskList.get(0).getDueDate());
    }
    @Test
    void editingTitleFailsWithEmptyString() {
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Task", "2022-08-24", "Description", false);
        list.taskList.add(newItem);
        assertThrows(NullPointerException.class, () -> list.taskList.set(0, new TaskItem("", "2020-08-24", "Description", false)
                ));
    }
    @Test
    void editingTitleSucceedsWithExpectedValue() {
        TaskList list = new TaskList();
        TaskItem newItem = new TaskItem("Guess What", "2022-08-23", "Description", false);
        list.taskList.add(newItem);
        TaskItem editedItem = new TaskItem("Chicken Butt", "2022-08-23", "Description", false);
        list.taskList.set(0, editedItem);
        assertEquals("Chicken Butt", list.taskList.get(0).getName());
    }
}
