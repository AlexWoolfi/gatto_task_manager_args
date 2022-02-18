import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListWithUsers implements Serializable {


    public static void createUser(String[] args) throws IOException {
        User user = new User();
        user.setName(Patterns.cleanWorldArgs(args[1]));
        user.setLastName(Patterns.cleanWorldArgs(args[2]));
        user.setUserName(Patterns.cleanWorldArgs(args[3]));
        addUser(user);


    }
    public static void addUser(User user) throws FileNotFoundException {
        List<User> users = new ArrayList<>();

        if(PathConstant.pathListFileAllUsers.isFile()) {
            users = getAllUsers();
            System.out.println(users);
         }
        try(ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(PathConstant.pathListFileAllUsers))){
               users.add(user);
               obj.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(PathConstant.pathListFileAllUsers))) {
             List<User> deseriasable = (List<User>) in.readObject();
             for(User u:deseriasable) {
                 users.add(u);
             }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}
