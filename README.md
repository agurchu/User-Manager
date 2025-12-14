# User Manager – OOP Practice Project

## Goal
Implement the three concrete user classes (`StudentUser`, `StaffUser`, `AdminUser`) so that **all JUnit tests pass** and the console application works.

---

## Project Layout
```
src/main/java/za/co/wethinkcode/usermanager/
    User.java
    StudentUser.java   ← IMPLEMENT THIS
    StaffUser.java     ← IMPLEMENT THIS
    AdminUser.java     ← IMPLEMENT THIS
    UserManager.java
    Main.java
src/test/java/za/co/wethinkcode/usermanager/
    StudentUserTest.java
    StaffUserTest.java
    AdminUserTest.java
    UserManagerTest.java
```

---

## What You Must Fill In

| Class | Default values (constructor with no args) | Parameterised constructor |
|-------|-------------------------------------------|---------------------------|
| **StudentUser** | username=`"StudentUser"` <br>email=`"student@example.com"` <br>age=`18` | `username, email, age` |
| **StaffUser**   | username=`"StaffUser"` <br>email=`"staff@example.com"` <br>age=`30` | `username, email, age` |
| **AdminUser**   | username=`"AdminUser"` <br>email=`"admin@example.com"` <br>age=`25` | `username, email, age` |

* `setAge(int)` must **reject negative values** (store `0` instead).
* `getRole()` returns the **fixed string** (`"Student"`, `"Staff"` or `"Admin"`).

---

## Running the Application

```bash
javac -d out src/main/java/za/co/wethinkcode/usermanager/*.java
java -cp out za.co.wethinkcode.usermanager.Main

Menu options:List Users – show all users.
Add User – create a new user (choose type).
Remove User – delete by username.
Edit User – change username/email/age of an existing user.
Exit

```bash
# Maven example (add JUnit 5 dependency)
mvn test
# or with Gradle
gradle test
# or with plain javac + JUnit on classpath
java -jar junit-platform-console-standalone-1.9.3.jar -cp out --scan-classpath
```

# Tips
Look at the test files – they tell you exactly what values are expected.
Implement one method at a time, run the corresponding test, fix, repeat.
UserManager already works with any correct implementation of the three user classes.

# Optional Extensions (extra credit)
Email validation – reject malformed e-mail addresses.
Unique usernames – prevent adding a user whose username already exists.
Search – menu option to find users by partial username.
Persistence – save/load users to a JSON file.

