import java.io.IOException;

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
//                    ListWithUsers.showAllUsers();
                    break;
                case "addTask":
                    User.addTask();
                    break;
                case "showTasks":
                    User.showTasks();
                    break;
                default:
                    System.out.println("Command not use, try again");

            }
        }

    }

