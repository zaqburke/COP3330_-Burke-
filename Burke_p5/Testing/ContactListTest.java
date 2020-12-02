import org.junit.jupiter.api.Test;
import p5.ContactItem;
import p5.ContactList;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {
    @Test
    void addingItemsIncreasesSize(){
        ContactList list = new ContactList();
        ContactItem newItem = new ContactItem("Zach", "Burke", "352-777-7777", "zachybear@ucf.com");
        list.ContactList.add(newItem);
        assertEquals(1, list.ContactList.size());
    }

    @Test
    void editingItemsFailsWithAllBlankValues(){
        ContactList list = new ContactList();
        ContactItem newItem = new ContactItem("Zach", "Burke", "352-777-7777", "zachybear@ucf.com");
        list.ContactList.add(newItem);
        assertThrows(IllegalArgumentException.class, ()-> list.ContactList.set(0, new ContactItem("", "", "", "")));
    }

    @Test
    void editingItemsFailsWithInvalidIndex(){
        ContactList list = new ContactList();
        ContactItem newItem = new ContactItem("Peter", "Parker", "888-888-8888", "spidey@websling.com");
        list.ContactList.add(newItem);
        ContactItem editItem = new ContactItem("Gwen", "Stacey", "", "");
        assertThrows(IndexOutOfBoundsException.class, ()-> list.ContactList.set(4, editItem));
    }

    @Test
    void editingSucceedsWithBlankFirstName(){
        ContactList list = new ContactList();
        ContactItem newItem = new ContactItem("Peter", "Parker", "888-888-8888", "spidey@websling.com");
        list.ContactList.add(newItem);
        ContactItem editItem = new ContactItem("", "Parker", "888-888-8888", "spidey@websling.com");
        list.ContactList.set(0, editItem);
        assertEquals("", list.ContactList.get(0).getfirstname());
    }

    @Test
    void editingSucceedsWithBlankLastName(){
        ContactList list = new ContactList();
        ContactItem newItem = new ContactItem("Peter", "Parker", "888-888-8888", "spidey@websling.com");
        list.ContactList.add(newItem);
        ContactItem editItem = new ContactItem("Peter", "", "888-888-8888", "spidey@websling.com");
        list.ContactList.set(0, editItem);
        assertEquals("", list.ContactList.get(0).getlastname());
    }

    @Test
    void editingSucceedsWithBlankPhone(){
        ContactList list = new ContactList();
        ContactItem newItem = new ContactItem("Peter", "Parker", "888-888-8888", "spidey@websling.com");
        list.ContactList.add(newItem);
        ContactItem editItem = new ContactItem("Peter", "Parker", "", "spidey@websling.com");
        ContactItem set = list.ContactList.set(0, editItem);
        assertEquals("", list.ContactList.get(0).getphonenumber());
    }

    @Test
    void editingSucceedsWithNonBlankValues(){
        ContactList list = new ContactList();
        ContactItem newItem = new ContactItem("Peter", "Parker", "888-888-8888", "spidey@websling.com");
        list.ContactList.add(newItem);
        ContactItem editItem = new ContactItem("Mary", "Jane", "444-444-4444", "hatesgwen@gogetemtiger.com");
        list.ContactList.set(0, editItem);
        assertEquals("Mary Jane: " + "444-444-4444" + " hatesgwen@gogetemtiger.com", list.ContactList.get(0).toString());
    }

    @Test
    void newListIsEmpty(){
        ContactList list = new ContactList();
        assertEquals(0,list.ContactList.size());
    }

    @Test
    void removingItemsDecreasesSize(){
        ContactList list = new ContactList();
        ContactItem newItem = new ContactItem("Peter", "Parker", "888-888-8888", "spidey@websling.com");
        list.ContactList.add(newItem);
        ContactItem editItem = new ContactItem("Peter", "Parker", "888-888-8888", "spidey@websling.com");
        list.ContactList.add(editItem);
        list.ContactList.remove(1);
        assertEquals(1, list.ContactList.size());
    }

    @Test
    void removingItemsFailsWithInvalidIndex(){
        ContactList list = new ContactList();
        ContactItem newItem = new ContactItem("Peter", "Parker", "888-888-8888", "spidey@websling.com");
        list.ContactList.add(newItem);
        ContactItem editItem = new ContactItem("Peter", "Parker", "888-888-8888", "spidey@websling.com");
        list.ContactList.add(editItem);
        assertThrows(IndexOutOfBoundsException.class, ()-> list.ContactList.remove(4));
    }

    @Test
    void savedContactListCanBeLoaded(){
        ContactList list = new ContactList();
        File listFile = new File("testingcontactlist.txt");
        assertTrue(listFile.exists());
    }
}
