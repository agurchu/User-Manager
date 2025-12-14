package agurchu.codewithritmo.usermanager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdminUserTest {
    @Test void defaultValues() {
        AdminUser u = new AdminUser();
        assertEquals("AdminUser", u.getUsername());
        assertEquals("admin@example.com", u.getEmail());
        assertEquals(25, u.getAge());
        assertEquals("Admin", u.getRole());
    }

    @Test void parameterizedConstructor() {
        AdminUser u = new AdminUser("root", "root@system.org", 28);
        assertEquals("root", u.getUsername());
        assertEquals("root@system.org", u.getEmail());
        assertEquals(28, u.getAge());
        assertEquals("Admin", u.getRole());
    }

    @Test void setters() {
        AdminUser u = new AdminUser();
        u.setUsername("super");
        u.setEmail("super@domain.com");
        u.setAge(32);
        assertEquals("super", u.getUsername());
        assertEquals("super@domain.com", u.getEmail());
        assertEquals(32, u.getAge());

    }

    @Test void negativeAge() {
        AdminUser u = new AdminUser();
        u.setAge(-10);
        assertEquals(1, u.getAge());
    }
}