package org.example.frontend;

import java.util.Scanner;

public class Menu {

    public static void menu(){
        AccountFunction accountFunction = new AccountFunction();
        DepartmentFunction departmentFunction = new DepartmentFunction();
        PositionFunction positionFunction = new PositionFunction();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Các chức năng liên quan đến Account");
            System.out.println("2. Các chức năng liên quan đến Department");
            System.out.println("3. Các chức năng liên quan đến Position");
            System.out.println("4. Thoát");
            String choice = sc.nextLine();
            switch(choice){
                case "1":
                    accountFunction.run();
                    break;
                case "2":
                    departmentFunction.run();
                    break;
                case "3":
                    positionFunction.run();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Nhập sai, mời nhập lại.");
                    break;
            }
        }
    }
}
