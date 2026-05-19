package org.example.frontend;

import org.example.backend.controller.PositionController;
import org.example.entity.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PositionFunction {
    PositionController positionController = new PositionController();
    private Scanner sc = new Scanner(System.in);

    public void run(){
        List<Position> positions = new ArrayList<>();
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Xem danh sách position");
            System.out.println("2. Thêm mới position");
            System.out.println("3. Xóa position theo tên");
            System.out.println("4. Update position theo ID");
            System.out.println("5. Tìm kiếm position theo ID và tên chức vụ");
            System.out.println("6. Tìm kiếm position có số nhân viên nhiều nhất");
            System.out.println("7. Tìm kiếm position có số nhân viên ít nhất");
            System.out.println("8. Thoát");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    positions = positionController.findAllPosition();
                    this.showPosition(positions);
                    break;
                case "2":
                    insertPosition();
                    break;
                case "3":
                    deletePosition();
                    break;
                case "4":
                    updatePosition();
                    break;
                case "5":
                    findByIdAndName();
                    break;
                case "6":
                    getPosition(positionController.getPositionHasMaxEmployee());
                    break;
                case "7":
                    getPosition(positionController.getPositionHasMinEmployee());
                    break;
                case "8":
                    return;
                default:
                    System.out.println("Nhập sai, mời nhập lại.");
            }
        }
    }
    public void findByIdAndName() {
        System.out.println("Nhập tên ID phòng ban cần tìm: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập tên phòng ban cần tìm: ");
        String name = sc.nextLine();

        List<Position> positions = positionController.findByPositionIdAndName(id, name);
        showPosition(positions);
    }


    public void showPosition(List<Position> positions) {
        System.out.println("+-----+--------------------+");
        System.out.printf("|%5s|%20s|\n", "ID", "Tên Chức vụ");
        System.out.println("+-----+-------------------+");
        for (Position position : positions) {
            System.out.printf("|%5s|%20s|\n", position.getId(), position.getName());
        }
        if (positions.size() == 0) {
            System.out.println("Không tìm thấy");
        }
        System.out.println("+-----+--------------------+");
    }

    public void getPosition(List<Position> positions){
        System.out.println("+---------------+----------+");
        System.out.printf("|%-15s|%-10s|\n", "Tên Chức vụ", "Số lượng");
        System.out.println("+---------------+----------+");
        for (Position position : positions) {
            System.out.printf("|%20s|%5s|\n", position.getName(), position.getCount());
        }
        if (positions.size() == 0) {
            System.out.println("Không tìm thấy");
        }
        System.out.println("+---------------+----------+");
    }


    public void insertPosition() {
        String name;
        while (true) {
            boolean check = true;
            System.out.println("Nhập tên chức vụ: ");
            name = sc.nextLine();
            // kiem tra tinh dung dan cua ten phong ban
            if (Objects.isNull(name) || name.trim().isEmpty()) {//name.isEmpty() check xem đọ dài = 0
                System.out.println("Ko đc để trống. Nhập lại tên");
                check = false;
            }
            if (positionController.checkExistName(name, null)) {// kiem tra xem ten da ton tai chua
                System.out.println("Tên này đã tồn tại. Nhập lại tên khác");
                check = false;
            }
            if (check) {
                break;
            }
        }
        boolean check = positionController.insertPositionName(name);
        if (check) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm mới thất bại");
        }
    }

    public void deletePosition() {
        System.out.println("Nhập id phòng ban cần xóa: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean check = positionController.deletePosition(id);
        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }


    public void updatePosition() {
        System.out.println("Nhập tên ID chức vụ cần sửa: ");
        int id = sc.nextInt();
        sc.nextLine();
        String name;
        while (true) {
            boolean check = true;
            System.out.println("Nhập tên chức vụ muốn thay đổi: ");
            name = sc.nextLine();
            // kiem tra tinh dung dan cua ten phong ban
            if (Objects.isNull(name) || name.trim().isEmpty()) {//name.isEmpty() check xem đọ dài = 0
                System.out.println("Ko đc để trống. Nhập lại tên");
                check = false;
            }
            if (positionController.checkExistName(name, id)) {// kiem tra xem ten da ton tai chua
                System.out.println("Tên này đã tồn tại. Nhập lại tên khác");
                check = false;
            }
            if (check) {
                break;
            }
        }

        boolean check = positionController.updatePosition(id, name);
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update thất bại");
        }
    }
}
