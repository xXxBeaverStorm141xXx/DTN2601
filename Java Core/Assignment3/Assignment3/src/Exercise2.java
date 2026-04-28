import java.time.LocalDate;
import java.time.LocalDateTime;

public class Exercise2 {
    public static void Question1() {
        System.out.println("Khởi tạo 5 Account: ");
        Account[] arrayAccount = new Account[5];
        for (int i = 0; i < arrayAccount.length; i++) {
            arrayAccount[i] = new Account();
            arrayAccount[i].email = "Email " + (i + 1);
            arrayAccount[i].userName = "UserName " + (i + 1);
            arrayAccount[i].fullName = "FullName " + (i + 1);
            arrayAccount[i].createDate = LocalDate.now();
            System.out.println("Email: " + arrayAccount[i].email + "\nUserName: " + arrayAccount[i].userName
            + "\nFullName: " + arrayAccount[i].fullName + "\nCreateDate: " + arrayAccount[i].createDate);
        }
    }

}
