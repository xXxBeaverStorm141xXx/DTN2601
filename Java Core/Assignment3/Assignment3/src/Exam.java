import java.time.LocalDateTime;

public class Exam {
    int id;
    String code;
    String title;
    CategoryQuestion[] category;
    int duration;
    Account creator;
    LocalDateTime createDate;
    Question[] question;
}
