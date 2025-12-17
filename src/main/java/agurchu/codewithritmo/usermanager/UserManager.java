package agurchu.codewithritmo.usermanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UserManager {
    private final ArrayList<User> users = new ArrayList<>(
            Arrays.asList(new StudentUser(), new StaffUser(), new AdminUser()));
    private final String[] menu = {
            "List Users",
            "Add User",
            "Remove User",
            "Edit User",
            "Exit"
    };
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("=== User Manager ===");
        boolean exit = false;
        while (!exit) {
            exit = showMenu();
        }
        System.out.println("Goodbye!");
    }

    private boolean showMenu() {
        listUsers(false);
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.printf("\t[%d] %s%n", i + 1, menu[i]);
        }
        int choice = readInt("Choose an option: ");
        switch (choice) {
            case 1 -> listUsers(true);
            case 2 -> addUserMenu();
            case 3 -> removeUserMenu();
            case 4 -> editUserMenu();
            case 5 -> { return true; }
            default -> { return false; }
        }
        return false;
    }

    private void listUsers(boolean withNumbers) {
        System.out.println("\n--- Users ---");
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if (withNumbers) System.out.print("[" + (i + 1) + "] ");
            System.out.printf("%s (%s) – %s – age %d%n",
                    u.getUsername(), u.getRole(), u.getEmail(), u.getAge());
        }
        System.out.println();
    }

    private void addUserMenu() {
        System.out.println("\nAdd New User");
        String username = readString("Username: ");
        String email    = readString("Email: ");
        int age         = readInt("Age: ");
        System.out.println("User type? (Student / Staff / Admin)");
        String type = readString("Type: ").trim().toLowerCase();

        addUser(username, email, age, type);
        System.out.println("User added.\n");
    }

    private void removeUserMenu() {
        System.out.println("\nRemove User");
        listUsers(true);
        String name = readString("Enter username to remove: ");
        removeUser(name);
    }

    private void editUserMenu() {
        System.out.println("\nEdit User");
        listUsers(true);
        int idx = readInt("Select user number: ") - 1;
        if (idx < 0 || idx >= users.size()) {
            System.out.println("Invalid selection.");
            return;
        }
        User u = users.get(idx);
        System.out.println("Leave blank to keep current value.");
        String newName  = readString("New username [" + u.getUsername() + "]: ");
        String newEmail = readString("New email    [" + u.getEmail()    + "]: ");
        int    newAge   = readInt ("New age      [" + u.getAge()       + "]: ");

        if (!newName.isBlank()) u.setUsername(newName);
        if (!newEmail.isBlank()) u.setEmail(newEmail);
        if (newAge >= 0) u.setAge(newAge);

        System.out.println("User updated.\n");
    }

    /* ---------- public API used by tests ---------- */
    public ArrayList<User> getUsers() { return users; }

    public void addUser(String username, String email, int age, String type) {
        User newUser;
        if (type.contains("student")) {
            newUser = username.isBlank() ? new StudentUser() : new StudentUser(username, email, age);
        } else if (type.contains("staff")) {
            newUser = username.isBlank() ? new StaffUser() : new StaffUser(username, email, age);
        } else if (type.contains("admin")) {
            newUser = username.isBlank() ? new AdminUser() : new AdminUser(username, email, age);
        } else {
            newUser = new StudentUser("NewUser", email, age);
        }
        users.add(newUser);
    }

    public void removeUser(String username) {
        users.removeIf(u -> u.getUsername().equalsIgnoreCase(username));
    }

    /* ---------- helper I/O methods ---------- */
    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
    private boolean isInteractive(){return System.console() != null;}
    private int readInt(String prompt) {
//        if (!isInteractive()){
//            System.out.println("\nRunning in non-interactive mode - skipping input.");
//            return 5;
//        }
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number.");
            scanner.next();
            System.out.print(prompt);
        }
        int val = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return val;
    }
}