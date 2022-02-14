import java.time.LocalDateTime;

public class Task {
    public static final String PATH = "C:\\Users\\Admin\\Desktop\\Tasks.txt";
    private int id;
    private String title;
    private String discription;
    private LocalDateTime created;



    public Task(int id, String title, String discription, LocalDateTime created) {
        this.id = id;
        this.title = title;
        this.discription = discription;
        this.created = LocalDateTime.now();

    }
}
