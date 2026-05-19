package org.example.frontend;

import org.example.backend.controller.AccountController;
import org.example.backend.controller.DepartmentController;
import org.example.backend.controller.PositionController;
import org.example.entity.*;
import java.util.*;

public class AccountFunction {
    AccountController accountController = new AccountController();
    DepartmentController departmentController = new DepartmentController();
    PositionController positionController = new PositionController();
    private static Scanner sc = new Scanner(System.in);

    public void run() {
        List<Account> accounts = new ArrayList<>();
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Xem danh sách account");
            System.out.println("2. Thêm mới account");
            System.out.println("3. Xóa account theo tên");
            System.out.println("4. Update account theo ID");
            System.out.println("5. Tìm kiếm account theo ID và user name");
            System.out.println("6. Thoát");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    accounts = accountController.findAllAccounts();
                    this.showAccount(accounts);
                    break;
                case "2":
                    insertAccount();
                    break;
                case "3":
                    deleteAccount();
                    break;
                case "4":
                    updateAccount();
                    break;
                case "5":
                    findByIdAndName();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Nhập sai, nhập lại.");
            }
        }
    }

    public void showAccount(List<Account> accounts) {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    public void findByIdAndName() {
        System.out.println("Nhập tên ID account cần tìm: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập user name account cần tìm: ");
        String name = sc.nextLine();

        List<Account> accounts = accountController.findByAccountIdAndName(id, name);
        showAccount(accounts);
    }


    public void insertAccount() {
        String email;
        while (true) {
            boolean check = true;
            String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            System.out.println("Nhập email: ");
            email = sc.nextLine();
            // kiem tra tinh dung dan cua email
            if (Objects.isNull(email)
                    || email.trim().isEmpty()
                    || !email.matches(regex)) {

                System.out.println("Email không hợp lệ");
                check = false;
            }
            if (accountController.checkExistEmail(email, null)) {// kiem tra email da ton tai chua
                System.out.println("Email này đã tồn tại. Nhập lại email khác");
                check = false;
            }
            if (check) {
                break;
            }
        }
        String userName;
        while (true) {
            boolean check = true;
            System.out.println("Nhập username: ");
            userName = sc.nextLine();
            // kiem tra tinh dung dan cua user name
            if (Objects.isNull(userName) || email.trim().isEmpty()) {
                System.out.println("User Name không hợp lệ");
                check = false;
            }
            if (accountController.checkExistUserName(userName, null)) {// kiem tra user name da ton tai chua
                System.out.println("User Name này đã tồn tại. Nhập lại User Name khác");
                check = false;
            }
            if (check) {
                break;
            }
        }

        System.out.println("Nhập full name: ");
        String fullName = sc.nextLine();
        System.out.println("Nhập id phòng ban theo danh sách phòng ban có sẵn sau: ");
        for (Department department : departmentController.findAllDepartment()) {
            System.out.println(department.getId() + " - " + department.getName());
        }
        System.out.print("Chọn Department ID: ");
        int departmentId = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập id chức vụ theo danh sách chức vụ có sẵn sau: ");
        for (Position position : positionController.findAllPosition()) {
            System.out.println(position.getId() + " - " + position.getName());
        }
        System.out.print("Chọn Position ID: ");
        int positionId = Integer.parseInt(sc.nextLine());

        boolean check = accountController.insertAccount(email, userName, fullName, departmentId, positionId);
        if (check) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm mới thất bại");
        }
    }

    public void deleteAccount() {
        System.out.println("Nhập id của user name cần xóa: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean check = accountController.deleteAccount(id);
        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }


    public void updateAccount() {
        System.out.println("Nhập tên ID account cần sửa: ");
        int id = sc.nextInt();
        sc.nextLine();

        String email;
        while (true) {
            boolean check = true;
            String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            System.out.println("Nhập email cần sửa: ");
            email = sc.nextLine();
            // kiem tra tinh dung dan cua email
            if (Objects.isNull(email)
                    || email.trim().isEmpty()
                    || !email.matches(regex)) {

                System.out.println("Email không hợp lệ");
                check = false;
            }
            if (accountController.checkExistEmail(email, id)) {// kiem tra email da ton tai chua
                System.out.println("Email này đã tồn tại. Nhập lại email khác");
                check = false;
            }
            if (check) {
                break;
            }
        }
        String userName;
        while (true) {
            boolean check = true;
            System.out.println("Nhập username cần sửa: ");
            userName = sc.nextLine();
            // kiem tra tinh dung dan cua user name
            if (Objects.isNull(userName) || email.trim().isEmpty()) {
                System.out.println("User Name không hợp lệ");
                check = false;
            }
            if (accountController.checkExistUserName(userName, id)) {// kiem tra user name da ton tai chua
                System.out.println("User Name này đã tồn tại. Nhập lại User Name khác");
                check = false;
            }
            if (check) {
                break;
            }
        }

        System.out.println("Nhập fullName cần sửa: ");
        String fullName = sc.nextLine();

        System.out.println("Nhập id phòng ban bạn muốn thay đổi trong danh sách sau: ");
        for (Department d : departmentController.findAllDepartment()) {
            System.out.println(d.getId() + " - " + d.getName());
        }
        System.out.print("Chọn Department ID cần sửa: ");
        int departmentId = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập id chức vụ bạn muốn thay đổi trong danh sách sau: ");
        for (Position p : positionController.findAllPosition()) {
            System.out.println(p.getId() + " - " + p.getName());
        }
        System.out.print("Chọn Position ID cần sửa: ");
        int positionId = Integer.parseInt(sc.nextLine());


        boolean check = accountController.updateAccount(id, email, fullName, userName, departmentId, positionId);
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update thất bại");
        }
    }
}
