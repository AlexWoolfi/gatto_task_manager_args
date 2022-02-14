import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User implements Serializable {
    private List<Task> tasks;private String userName;
    private String name;
    private String lastName;


    public User(String UserName, String name, String lastName) {
        this.userName = UserName;
        this.name = name;
        this.lastName = lastName;
      }

    public User() {
    }

    public static void createUser(String[] args) throws IOException {
        User user = new User();
        user.setName(Patterns.cleanWorldArgs(args[1]));
        user.setLastName(Patterns.cleanWorldArgs(args[2]));
        user.setUserName(Patterns.cleanWorldArgs(args[3]));

        ListWithUsers.writeListUser(user);


    }

    public static void showAllUsers() throws IOException {
        for(User s:ListWithUsers.users) {
            System.out.println(s);
        }

    }
    public static void addTask(){}
    public static void showTasks(){}

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

//    public static String getPathListFileAllUsers() {
//        return pathListFileAllUsers;
//    }
//
//    public static void setPathListFileAllUsers(String pathListFileAllUsers) {
//        User.pathListFileAllUsers = pathListFileAllUsers;
//    }

    public String UserName() {
        return userName;
    }

    public void setUserName(String s) {
        this.userName = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "tasks=" + tasks +
                ", UserName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
