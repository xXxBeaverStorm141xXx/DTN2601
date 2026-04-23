import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Exercise2 {
    public static void Question1(){
        int i = 5;
        System.out.printf("%d\n",i);
    }

    public static void Question2(){
        int i = 100000000;
        System.out.printf(Locale.US, "%,d\n",i);
    }

    public static void Question3(){
        float i = 5.567098f;
        System.out.printf("%.4f\n",i);
    }

    public static void Question4(){
        String s = "Nguyễn Văn A";
        System.out.printf("Tên tôi là \"" + s + "\" và tôi đang độc thân \n");
    }

    public static void Question5(){
        String pattern = "dd/MM/yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);
    }

    public static void Question6(Account[] accounts) {
            System.out.printf("+----------------------+----------------------+----------+%n");
            System.out.printf("| %-16s | %-16s | %-16s |%n", "Email", "Full Name", "Department");
            System.out.printf("+----------------------+----------------------+----------+%n");

            for (Account acc : accounts) {
                System.out.printf("| %-16s | %-16s | %-16s |%n",
                        acc.email,
                        acc.fullName,
                        acc.department.name);
            }
            System.out.printf("+------------------+------------------+------------------+%n");
    }

}
