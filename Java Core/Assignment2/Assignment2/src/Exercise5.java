import java.time.LocalDate;
import java.util.Scanner;

public class Exercise5 {
    public static void Question1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào 3 số nguyên");
        System.out.println("Nhập vào số 1: ");
        int a = sc.nextInt();

        System.out.println("Nhập vào số 2: ");
        int b = sc.nextInt();

        System.out.println("Nhập vào số 3: ");
        int c = sc.nextInt();

        System.out.println("Bạn vừa nhập vào các số: " + a + "  " + b + "  " + c);

    }

    public static void Question2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào 2 số thực");
        System.out.println("Nhập vào số 1: ");
        float f1 = sc.nextFloat();

        System.out.println("Nhập vào số 2: ");
        float f2 = sc.nextFloat();
        System.out.println("Bạn vừa nhập vào các số: " + f1 + "  " + f2);

    }

    public static void Question3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập Họ: ");
        String a = sc.next();
        System.out.println("Mời bạn nhập vào Tên: ");
        String b = sc.next();
        System.out.println("Fullname của bạn là: " + a + " " + b);
    }

    public static void Question4(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào năm sinh: ");
        int year = sc.nextInt();

        System.out.println("Mời bạn nhập vào tháng sinh: ");
        int month = sc.nextInt();

        System.out.println("Mời bạn nhập vào ngày sinh: ");
        int day = sc.nextInt();
        LocalDate dateBirth = LocalDate.of(year, month, day);
        System.out.println("Ngày sinh của bạn là: " + dateBirth);
    }

    public static void Question5(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào thông tin account cân tạo: ");
        Account acc = new Account();
        System.out.println("Nhập ID: ");
        acc.id = sc.nextInt();
        System.out.println("Nhập email: ");
        acc.email = sc.next();
        System.out.println("Nhập userName: ");
        acc.userName = sc.next();
        System.out.println("Nhập fullName: ");
        acc.fullName = sc.next();
        System.out.println("Nhập position (Nhập các số từ 1 đến 4 tương ứng với: 1.Dev, 2.Test, 3.Scrum_Master, 4.PM): ");
        int posNum = sc.nextInt();
        switch (posNum) {
            case 1:
                Position pos1 = new Position();
                pos1.name = Position.PositionName.Dev;
                acc.position = pos1;
                break;
            case 2:
                Position pos2 = new Position();
                pos2.name = Position.PositionName.Test;
                acc.position = pos2;
                break;
            case 3:
                Position pos3 = new Position();
                pos3.name = Position.PositionName.Scrum_Master;
                acc.position = pos3;
                break;
            case 4:
                Position pos4 = new Position();
                pos4.name = Position.PositionName.PM;
                acc.position = pos4;
                break;
        }

        System.out.println("Thông tin Acc vừa nhập, ID: " + acc.id + " Email: " + acc.email + " UserName: "
                + acc.userName + " FullName: " + acc.fullName + " Position: " + acc.position.name);
    }

    public static void Question6(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào thông tin Department cân tạo: ");
        Department dep = new Department();
        System.out.println("Nhập ID: ");
        dep.id = sc.nextInt();
        System.out.println("Nhập Name: ");
        dep.name = sc.next();

        System.out.println("Thông tin Department vừa nhập, ID: " + dep.id + " Name: " + dep.name);
    }

    public static void Question7(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Hãy nhập vào 1 số chẵn: ");
            int a = sc.nextInt();
            if (a % 2 == 0) {
                System.out.println("Bạm vừa nhập vào:" + a);
                return;
            } else {
                System.out.println("Nhập sai, đây không phải là số chẵn");
            }
        }
    }

    public static void Question8(){
        Scanner sc = new Scanner(System.in);
        int choose;
        while (true) {
            System.out.println("Mời bạn chọn chức năng: 1. Tạo Account, 2. Tạo Department");
            choose = sc.nextInt();
            if (choose == 1 || choose == 2) {
                switch (choose) {
                    case 1:
                        Question5();
                        break;

                    case 2:
                        Question6();
                        break;
                }
                return;
            } else {
                System.out.println("Nhập lại: ");
            }
        }

    }

    public static void Question9() {
        Group group1 = new Group();
        group1.id = 1;
        group1.name = "Testing";
        group1.createDate = LocalDate.now();

        Group group2 = new Group();
        group2.id = 2;
        group2.name = "Development";
        group2.createDate = LocalDate.of(2020, 5, 6);

        Group group3 = new Group();
        group3.id = 3;
        group3.name = "BOD";
        group3.createDate = LocalDate.of(2025, 01, 27);

        Account acc1 = new Account();
        acc1.id = 1;
        acc1.email = "phucdh141";
        acc1.userName = "phucdh141";
        acc1.fullName = "Do Huy Phuc";
        acc1.createDate = LocalDate.now();

        Account acc2 = new Account();
        acc2.id = 2;
        acc2.email = "phucdh142";
        acc2.userName = "phucdh142";
        acc2.fullName = "Do Huy Phuc 2";
        acc2.createDate = LocalDate.of(2020, 11,14);

        Account acc3 = new Account();
        acc3.id = 3;
        acc3.email = "phucdh143";
        acc3.userName = "phucdh143";
        acc3.fullName = "Do Huy Phuc 3";
        acc3.createDate = LocalDate.now();

        Account[] accArray = { acc1, acc2, acc3 };
        Group[] groupArray = { group1, group2, group3 };


        Scanner sc = new Scanner(System.in);
        System.out.println("Danh sách User: ");
        for(int i = 0; i < accArray.length; i++){
            System.out.println(accArray[i].userName);
        }
        System.out.println("Nhập vào username của Account: ");
        String userName = sc.next();

        System.out.println("Danh sách các Group: ");
        for(int i = 0; i < groupArray.length; i++){
            System.out.println(groupArray[i].name);
        }
        System.out.println("Nhập tên các Group cần thêm: ");
        String groupName =  sc.next();
        int indexGroup = -1;
        for (int i = 0; i < groupArray.length; i++) {
            if (groupArray[i].name.equals(groupName)) {
                indexGroup = i;
            }
        }
        int indexAccount = -1;
        for (int j = 0; j < accArray.length; j++) {
            if (accArray[j].userName.equals(userName)) {
                indexAccount = j;
            }
        }

        if (indexAccount < 0 || indexGroup < 0) {
            System.out.println("Kiểm tra lại thông tin bạn nhập, không có Account hoặc group này trên hệ thống");
        } else {
            for (int j = 0; j < accArray.length; j++) {
                if (accArray[j].userName.equals(userName)) {
                    Group[] gpAdd = { groupArray[indexGroup] };
                    accArray[j].groups = gpAdd;
                    System.out.println("Bạn vừa Add group: " + accArray[indexAccount].groups[0].name + " cho Account: "
                            + accArray[indexAccount].userName);
                }
            }
        }
    }

    public static void Question10(){
        Scanner sc = new Scanner(System.in);
        int choose;
        while (true)
        {
            System.out.println("Mời bạn chọn chức năng: 1. Tạo Account, 2. Tạo Department, 3. Add Group in Account");
            choose = sc.nextInt();
            if (choose == 1 || choose == 2 || choose == 3) {
                switch (choose) {
                    case 1:
                        Question5();
                        break;

                    case 2:
                        Question6();
                        break;

                    case 3:
                        Question9();
                        break;
                }
                System.out.println("Hãy chọn menu để tiếp tục, nhấn 0 để thoát");
                int out = sc.nextInt();
                if (out == 0) {
                    return;
                }
            } else {
                System.out.println("Nhập lại: ");
            }
        }
    }

    public static void Question11(){
        Scanner sc = new Scanner(System.in);
        int choose;
        while (true) {
            System.out.println("Mời bạn chọn chức năng: 1. Tạo Account, 2. Tạo Department, " +
                    "3. Add Group in Account, 4.Thêm Account vào 1 nhóm ngẫu nhiên");
            choose = sc.nextInt();
            if (choose == 1 || choose == 2 || choose == 3 || choose == 4) {
                switch (choose) {
                    case 1:
                        Question5();
                        break;

                    case 2:
                        Question6();
                        break;

                    case 3:
                        Question9();
                        break;

                    case 4:

                }
                System.out.println("Hãy chọn menu để tiếp tục, nhấn 0 để thoát");
                int out = sc.nextInt();
                if (out == 0) {
                    return;
                }
            } else {
                System.out.println("Nhập lại: ");
            }
        }
    }

}
