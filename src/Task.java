import java.io.Serializable;
import java.time.LocalDateTime;

public class Task implements Serializable {
    public static final String PATH = "C:\\Users\\Admin\\Desktop\\Tasks.txt";

    private String title;
    private String discription;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Task(String title, String discription) {
     this.title = title;
        this.discription = discription;
}

    public Task() {
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", discription='" + discription + '\'' +
                '}';
    }
}
