package agurchu.codewithritmo.usermanager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StaffUserTest {
    @Test void defaultValues() {
        StaffUser u = new StaffUser();
        assertEquals("StaffUser", u.getUsername());
        assertEquals("staff@example.com", u.getEmail());
        assertEquals(30, u.getAge());
        assertEquals("Staff", u.getRole());
    }

    @Test void parameterizedConstructor() {
        StaffUser u = new StaffUser("carol", "c@company.com", 35);
        assertEquals("carol", u.getUsername());
        assertEquals("c@company.com", u.getEmail());
        assertEquals(35, u.getAge());
        assertEquals("Staff", u.getRole());
    }

    @Test void setters() {
        StaffUser u = new StaffUser();
        u.setUsername("dave");
        u.setEmail("dave@org.net");
        u.setAge(40);
        assertEquals("dave", u.getUsername());
        assertEquals("dave@org.net", u.getEmail());
        assertEquals(40, u.getAge());
    }

    @Test void negativeAge() {
        StaffUser u = new StaffUser();
        u.setAge(-1);
        assertEquals(1, u.getAge());
    }
}