package agurchu.codewithritmo.usermanager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentUserTest {
    @Test void defaultValues() {
        StudentUser u = new StudentUser();
        assertEquals("StudentUser", u.getUsername());
        assertEquals("student@example.com", u.getEmail());
        assertEquals(18, u.getAge());
        assertEquals("Student", u.getRole());
    }

    @Test void parameterizedConstructor() {
        StudentUser u = new StudentUser("alice", "a@uni.ac.za", 20);
        assertEquals("alice", u.getUsername());
        assertEquals("a@uni.ac.za", u.getEmail());
        assertEquals(20, u.getAge());
        assertEquals("Student", u.getRole());
    }

    @Test void setters() {
        StudentUser u = new StudentUser();
        u.setUsername("bob");
        u.setEmail("bob@school.com");
        u.setAge(22);
        assertEquals("bob", u.getUsername());
        assertEquals("bob@school.com", u.getEmail());
        assertEquals(22, u.getAge());
    }

    @Test void negativeAge() {
        StudentUser u = new StudentUser();
        u.setAge(-5);
        assertEquals(1, u.getAge());
    }
}