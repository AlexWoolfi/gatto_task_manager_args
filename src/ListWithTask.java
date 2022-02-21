import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListWithTask {

//    -addTask -un='имя_пользователя' -tt='Название задачи' -td='Описание задачи'

    public static void createTask(String[] args) throws FileNotFoundException {
        List<Task> tasks = new ArrayList<>();
        User user = foundUser(args);
        Task task = new Task();
        task.setTitle(Patterns.cleanWorldArgs(args[2]));
        task.setDiscription(Patterns.cleanWorldArgs(args[3]));

        tasks.add(task);
        System.out.println(tasks);

        user.setTasks(tasks);
        System.out.println(user);

        writeTaskInFile(tasks, task);

        changeUser(user);


//             FOR TEST
//        try {
//            Thread.sleep(3000);
//            getAllTasks();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

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
        System.out.println("User not found, try again please");
        return null;
    }

    public static void writeTaskInFile(List<Task> t, Task task) throws FileNotFoundException {
        List<Task> tasks = new ArrayList<>();
        if (PathConstant.pathListFileAllTasks.isFile() && PathConstant.pathListFileAllTasks.length() > 0)
            tasks = getAllTasks();
            try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(PathConstant.pathListFileAllTasks))) {
                tasks.add(task);
                obj.writeObject(tasks);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    public static List<Task> getAllTasks() throws FileNotFoundException {
        List<Task> tasks = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PathConstant.pathListFileAllTasks))) {
            while(in.available()>0){
                List<Task> deserialTsks = (List<Task>) in.readObject();
                for (Task t : deserialTsks) {
                    tasks.add(t);
                }
                System.out.println(tasks);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public static void showAllTasksForUserNAme(String[] args) throws FileNotFoundException {
        String s = Patterns.cleanWorldArgs(args[1]);
        List<User> users = ListWithUsers.getAllShowUsers();
        List<Task> tasks = new ArrayList<>();
        User user = new User();
        for (User u : users) {
            if (u.getUserName().equals(s))
                tasks = u.getTasks();
            user = u;
        }
        System.out.println("Your user = " + "\\" + user.getUserName() + "\\" + " " + tasks);
    }

    public static void changeUser(User user) {
        List<User> users = ListWithUsers.getAllShowUsers();
        users.removeIf(u->u.getUserName().equals(user.getUserName()));
        users.add(user);
        if (PathConstant.pathListFileAllUsers.isFile()) {
            try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(PathConstant.pathListFileAllUsers))) {
                obj.writeObject(users);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}



