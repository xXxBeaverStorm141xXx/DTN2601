import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
public class Exercise3 {
    public static void Question1(Exam exam) {
        Locale locale = new Locale("vi", "VN");
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd MMMM yyyy", locale);
        String date = exam.createDate.format(formatter);
        System.out.println(date);
    }

    public static void Question2(Exam[] exams) {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (Exam exam : exams) {
            String date = exam.createDate.format(formatter);
            System.out.println(exam.code + ": " + date);
        }
    }
    public static void Question3(Exam[] exams){
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy");
        for (Exam exam : exams) {
            String date = exam.createDate.format(formatter);
            System.out.println(exam.code + ": " + date);
        }
    }

    public static void Question4(Exam[] exams){
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM");

        for (Exam exam : exams) {
            String date = exam.createDate.format(formatter);
            System.out.println(exam.code + ": " + date);
        }
    }

    public static void Question5(Exam[] exams){
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("MM-dd");

        for (Exam exam : exams) {
            String date = exam.createDate.format(formatter);
            System.out.println(exam.code + ": " + date);
        }
    }
}
