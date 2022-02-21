import java.io.IOException;
import java.util.List;
import java.util.Set;

public class FiltrArgs {
   static String s = null;
    public static void filtrFromArgs(String[] args) throws IOException {
        for(int i=0;i<args.length;i++) {
            s = Patterns.cleanWorldForFirstArgs(args[0]);
        }
            switch (s){
                case "createUser":
                    ListWithUsers.createUser(args);


                    break;
                case "showAllUsers":
                    List<User> showAllUsers =  ListWithUsers.getAllShowUsers();
                    System.out.println(showAllUsers);
                    break;
                case "addTask":
                    ListWithTask.createTask(args);
                    break;
                case "showTasks":
                  ListWithTask.showAllTasksForUserNAme(args);
                    break;
                default:
                    System.out.println("Command not use, try again");

            }
        }

    }

