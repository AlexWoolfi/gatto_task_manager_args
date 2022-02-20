import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListWithTask {

//    -addTask -un='имя_пользователя' -tt='Название задачи' -td='Описание задачи'

    public static void createTask(String[] args) throws FileNotFoundException {
             List <Task> tasks = new ArrayList<>();
             User user = foundUser(args);

             Task task = new Task();
             task.setTitle(Patterns.cleanWorldArgs(args[2]));
             task.setDiscription(Patterns.cleanWorldArgs(args[3]));


             tasks.add(task);
             System.out.println(tasks);

             user.setTasks(tasks);
             System.out.println(user);

    }

    public static User foundUser(String[] args) {

        String userName = Patterns.cleanWorldArgs(args[1]);
        List<User> users = ListWithUsers.getAllShowUsers();
        for (User u : users) {
            if (u.getUserName().equals(userName)) {
                System.out.println("User is found = " + u);
                return u;
            }
        }
        return null;
    }

    public static void writeTaskInFile() throws FileNotFoundException {

    }


    public static void getAllTasks() throws FileNotFoundException {

    }

    public static void showAllTasksForUserNAme() throws FileNotFoundException {

    }

}



