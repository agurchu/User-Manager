package agurchu.codewithritmo.usermanager;

import java.util.Objects;

public class StaffUser extends User {
    private String username;
    private String email;
    private int age;
    private final String role = "Staff";


    public StaffUser() {
        username = "StaffUser";
        email = "staff@example.com";
        age = 30;

    }

    public StaffUser(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age =age;
    }

    @Override
    public String getUsername() {

        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email=email;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = Math.max(age,1);
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StaffUser that)) return false;
        return age == that.age && Objects.equals(username, that.username) && Objects.equals(email, that.email) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, age, role);
    }
}