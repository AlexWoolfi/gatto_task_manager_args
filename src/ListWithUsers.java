import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

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

        if (PathConstant.pathListFileAllUsers.isFile() && PathConstant.pathListFileAllUsers.length() > 0) {
            users = getAllUsers(user);
        }
            try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(PathConstant.pathListFileAllUsers))) {
                users.add(user);
                obj.writeObject(users);


            } catch (IOException e) {
                e.printStackTrace();
            }



    }

    public static List<User> getAllUsers(User user) {
        List<User> users = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PathConstant.pathListFileAllUsers))) {
            List<User> deseriasable = (List<User>) in.readObject();
            for (User u : deseriasable) {
                if(!u.getUserName().equals(user.getUserName()))
                users.add(u);
                System.out.println(u + "Filtr");
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

    public static List<User> getAllShowUsers() {
        List<User> users = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PathConstant.pathListFileAllUsers))) {
            List<User> deseriasable = (List<User>) in.readObject();
            for (User u : deseriasable) {
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

    public static List<User> chek(List<User> users) {
        List<User> copy = new ArrayList<>();
        for (User u : users) {
            if (u.equals(users)) {
                System.out.println("ER");
                break;
            } else {
                copy.add(u);
            }
        }
        return copy;
    }
}