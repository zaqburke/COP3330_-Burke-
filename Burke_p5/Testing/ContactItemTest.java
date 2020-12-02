import org.junit.jupiter.api.Test;
import p5.ContactItem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class ContactItemTest {
    @Test
    void creationFailsWithAllBlankValues() {
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "", ""));
    }

    @Test
    void creationSucceedsWithBlankEmail() {
        ContactItem newItem = new ContactItem("John", "Appleseed", "999-999-9999", "");
        assertEquals("John Appleseed: " + "111-111-1111" + " ", newItem.toString());
    }

    @Test
    void creationSucceedsWithBlankFirstName() {
        ContactItem newItem = new ContactItem("", "Appleseed", "999-999-9999", "johnappleseed@yougotmail.com");
        assertEquals(" Appleseed: " + "111-111-1111" + " johnappleseed@google.com", newItem.toString());
    }

    @Test
    void creationSucceedsWithBlankLastName() {
        ContactItem newItem = new ContactItem("John", "", "999-999-9999", "johnappleseed@yougotmail.com");
        assertEquals("John : " + "999-999-9999" + " johnappleseed@yougotmail.com", newItem.toString());
    }

    @Test
    void creationSucceedsWithBlankPhone() {
        ContactItem newItem = new ContactItem("John", "Appleseed", "", "johnappleseed@hotmail.com");
        assertEquals("John Appleseed: " + "" + " johnappleseed@hotmail.com", newItem.toString());
    }

    @Test
    void creationSucceedsWithNonBlankValues() {
        ContactItem newItem = new ContactItem("John", "Appleseed", "999-999-9999", "johnappleseed@google.com");
        assertEquals("John Appleseed: " + "111-111-1111" + " johnappleseed@google.com", newItem.toString());
    }

    @Test
    void editingFailsWithAllBlankValues() {
        ContactItem newItem = new ContactItem("", "", "", "");
        assertThrows(IllegalArgumentException.class, () -> newItem.setemail(""));
    }

    @Test
    void editingSucceedsWithBlankEmail() {
        ContactItem newItem = new ContactItem("John", "Appleseed", "999-999-9999", "johnappleseed@gmail.com");
        newItem.setemail("");
        assertEquals("", newItem.getemail());
    }

    @Test
    void editingSucceedsWithBlankFirstName() {
        ContactItem newItem = new ContactItem("John", "Appleseed", "111-111-1111", "johnappleseed@ucf.com");
        newItem.setfirstname("");
        assertEquals("", newItem.getfirstname());
    }

    @Test
    void editingSucceedsWithBlankLastName() {
        ContactItem newItem = new ContactItem("John", "Appleseed", "111-111-1111", "johnappleseed@yes.gov");
        newItem.setlastname("");
        assertEquals("", newItem.getlastname());
    }

    @Test
    void editingSucceedsWithBlankPhone() {
        ContactItem newItem = new ContactItem("John", "Appleseed", "111-111-1111", "johnappleseed@imagination.com");
        newItem.setphonenumber("");
        assertEquals("", newItem.getphonenumber());
    }

    @Test
    void editingSucceedsWithNonBlankValues() {
        ContactItem newItem = new ContactItem("John", "Appleseed", "111-111-1111", "johnappleseed@redbone.com");
        newItem.setfirstname("Johnny");
        assertEquals("Johnny", newItem.getfirstname());
    }

    @Test
    void testToString() {
        ContactItem newItem = new ContactItem("John", "Appleseed", "111-111-1111", "johnappleseed@brazzers.com");
        assertEquals("John Appleseed: " + "111-111-1111" + " johnappleseed@brazzers.com", newItem.toString());
    }

    @Test
    void testToStringFile() {
        ContactItem newItem = new ContactItem("John", "Appleseed", "111-111-1111", "johnappleseed@yougotmail.com");
        assertEquals("John\n" + "Appleseed\n" + "111-111-1111\n" + "johnappleseed@yougotmail.com", newItem.toStringFile());
    }


}

