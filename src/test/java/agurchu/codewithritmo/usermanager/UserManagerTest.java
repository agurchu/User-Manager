package agurchu.codewithritmo.usermanager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Optional;

public class UserManagerTest {
    @Test void addUserIncreasesSize() {
        UserManager m = new UserManager();
        m.addUser("newbie", "n@temp.com", 19, "student");
        assertEquals(4, m.getUsers().size());
    }

    @Test void removeUserDecreasesSize() {
        UserManager m = new UserManager();
        List<User> list = m.getUsers();
        int start = list.size();

        Optional<User> firstStudent = list.stream()
                .filter(u -> u instanceof StudentUser)
                .findFirst();

        firstStudent.ifPresent(u -> m.removeUser(u.getUsername()));
        assertEquals(start - 1, m.getUsers().size());
    }
}