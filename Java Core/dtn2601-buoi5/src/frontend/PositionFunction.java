package frontend;

import backend.QLPosition;
import entity.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static backend.QLPosition.*;

public class PositionFunction {
    private static Scanner sc = new Scanner(System.in);

    public static void run() throws ClassNotFoundException {
        List<Position> positions = new ArrayList<>();
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Xem danh sách position");
            System.out.println("2. Thêm mới position");
            System.out.println("3. Xóa position theo tên");
            System.out.println("4. Update position theo ID");
            System.out.println("5. Tìm kiếm position theo ID và tên phòng ban");
            System.out.println("6. Tìm kiếm position có số nhân viên nhiều nhất");
            System.out.println("7. Tìm kiếm position có số nhân viên ít nhất");
            System.out.println("8. Thoát");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    positions = QLPosition.getPosition();
                    QLPosition.printPosition(positions);
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
                    getPositionHasMaxEmployee();
                    break;
                case "7":
                    getPositionHasMinEmployee();
                    break;
                case "8":
                    return;
                default:
                    System.out.println("Nhập sai, nhập lại.");
            }
        }
    }

    public static void findByIdAndName() throws ClassNotFoundException {
        System.out.println("Nhập tên ID phòng ban cần tìm: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập tên phòng ban cần tìm: ");
        String name = sc.nextLine();

        List<Position> positions = QLPosition.findByPositionIdAndName(id, name);
        QLPosition.printPosition(positions);
    }

    public static void insertPosition() {
        System.out.println("Nhập tên phòng ban: ");
        String name = sc.nextLine();
        boolean check = QLPosition.insertPositionName(name);
        if (check) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm mới thất bại");
        }
    }

    public static void deletePosition() {
        System.out.println("Nhập tên phòng ban cần xóa: ");
        String name = sc.nextLine();
        boolean check = QLPosition.deletePosition(name);
        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }


    public static void updatePosition() {
        System.out.println("Nhập tên ID phòng ban cần sửa: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập tên phòng ban muốn thay đổi: ");
        String name = sc.nextLine();

        boolean check = QLPosition.updatePosition(id, name);
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update thất bại");
        }
    }
}
