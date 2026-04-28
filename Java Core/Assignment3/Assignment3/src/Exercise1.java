import java.util.Random;
import java.util.Scanner;

public class Exercise1 {
    public static void Question1()
    {
        float salary1 = 5240.5f;
        float salary2 = 10970.055f;
        int roundUpSalary1 = (int) salary1;
        int roundUpSalary2 = (int) salary2;
        System.out.printf("Salary 1: %d\n", roundUpSalary1);
        System.out.printf("Salary 2: %d\n", roundUpSalary2);
    }

    public static int Question2()
    {
        Random rand = new Random();
        int number = rand.nextInt(100000);

        String value = String.format("%05d", number);
        System.out.println("Số ngẫu nhiên là: " + value);
        return number;
    }

    public static void Question3()
    {
        int twoLast = Question2() % 100;
        System.out.println("2 số cuối là: " + twoLast);
    }

    public static void Question4()
    {
        int a, b;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập a: ");
        a = input.nextInt();
        System.out.println("Nhập b: ");
        b = input.nextInt();
        while (b == 0)
        {
            System.out.println("Vui lòng nhập lại b (b khác 0): ");
            b =  input.nextInt();
        }
        System.out.println("a/b = " + (float) a / (float) b);


    }

    public static void Question5()
    {

    }

}
