package frontend;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=== Mời bạn chọn thư mục ===");
            System.out.println("1. Account");
            System.out.println("2. Department");
            System.out.println("3. Position");
            System.out.println("4. Thoát");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    AccountFunction.run();
                    break;
                case "2":
                    DepartmentFunction.run();
                    break;
                case "3":
                    PositionFunction.run();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Nhập sai, nhập lại.");
            }
        }
    }
}

