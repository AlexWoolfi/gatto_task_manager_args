import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User implements Serializable {
    public static List<Set<User>> users = new ArrayList<>();
    public static Set<User> unicUsers = new HashSet<>();
    private List<Task> tasks;
    public static File pathListFileAllUsers = new File("C:\\Users\\Admin\\Desktop\\Users.txt") ;
    public static File pathSETFileAllUsers = new File("C:\\Users\\Admin\\Desktop\\UsersSET.txt");
    private String userName;
    private String name;
    private String lastName;
    public static boolean appendUser = pathListFileAllUsers.exists();
    public static boolean appendSetUsers = pathSETFileAllUsers.exists();


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

        unicUsers.add(user);
        users.add(unicUsers);

        writeOBJUser(user);


    }

    public static void writeOBJUser(User user) throws IOException {
         try(ObjectOutputStream obj = AppendingObjectOutputStream.createStream(pathListFileAllUsers)){
              obj.writeObject(user);
         }
    }

//    public static void writeSetUsers(Set<User> unicUsers) {
//        try(ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(pathSETFileAllUsers))){
//            obj.writeObject(unicUsers);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }






    public static void showAllUsers() throws IOException {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(pathListFileAllUsers))){
            try {
                unicUsers = (Set<User>) in.readObject();
                for(User i:unicUsers){
                    System.out.println(i);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
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
