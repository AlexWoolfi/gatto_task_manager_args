import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListWithUsers implements Serializable {

    public static List<User> users = new ArrayList<>();

    public static void writeListUser(User user) throws FileNotFoundException {
        if (isFileEmpty(PathConstant.pathListFileAllUsers)) {
            try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(PathConstant.pathListFileAllUsers))) {
                obj.writeObject(user);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!isFileEmpty(PathConstant.pathListFileAllUsers)) {
          try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(PathConstant.pathListFileAllUsers));
              ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(PathConstant.pathListFileAllUsers))) {

              users = (List<User>) in.readObject();
              users.add(user);
              obj.writeObject(users);

          }catch (IOException | ClassNotFoundException e) {
              e.printStackTrace();
          }
        }
    }

    public static boolean isFileEmpty(File file) {

        return file.length() == 0;
    }

}
