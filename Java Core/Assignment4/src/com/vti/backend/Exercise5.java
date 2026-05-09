package com.vti.backend;

import com.vti.entity.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise5 {
    private ArrayList<CanBo> canBoList;
    private Scanner scan;

    public Exercise5()
    {
        canBoList = new ArrayList<CanBo>();
        scan = new Scanner(System.in);
    }
    public void Question2(){
        menu();
    }
    public void menu()
    {
        while (true) {
            System.out.println("(\"=================Lựa chọn chức năng bạn muốn sử dụng==================");
            System.out.println("1. Thêm mới cán bộ.");
            System.out.println("2. Tìm kiếm theo họ tên.");
            System.out.println("3. Hiện thị thông tin về danh sách các cán bộ.");
            System.out.println("4. Nhập vào tên của cán bộ và delete cán bộ đó");
            System.out.println("5. Thoát khỏi chương trình.");
            int menuChoose = scan.nextInt();
            switch (menuChoose) {
                case 1:
                    addCanBo();
                    break;

                case 2:
                    findByName();
                    break;
                case 3:
                    printListCanBo();
                    break;
                case 4:
                    deleteByName();
                    break;
                case 5:
                    return;

                default:
                    System.out.println("Lựa chọn đúng số trên menu");
                    break;
            }
        }
    }
    private void deleteByName()
    {
        System.out.println("Nhập tên cần xóa: ");
        String delName  = scan.next();
        canBoList.removeIf(canBo -> canBo.getName().equals(delName));
        printListCanBo();
    }

    private void findByName()
    {
        System.out.println("Nhập tên muốn tìm: ");
        String findName  = scan.next();
        for (CanBo canBo : canBoList){
            if (canBo.getName().equals(findName)){
                System.out.println(canBo);
            }
        }
    }

    private void printListCanBo()
    {
        for (CanBo canBo : canBoList){
            System.out.println(canBo);
        }
    }

    private void addCanBo()
    {
        System.out.println("Lựa chọn chức năng muốn sử dụng");
        System.out.println("1. Thêm Kỹ sư ");
        System.out.println("2. Thêm Công Nhân ");
        System.out.println("3. Thêm Nhân Viên ");
        int  choice = scan.nextInt();
        switch (choice)
        {
            case 1:
                System.out.println("Nhập vào tên Kỹ sư: ");
                String nameKySu = scan.next();
                System.out.println("Nhập vào tuổi Kỹ sư: ");
                int ageKySu = scan.nextInt();
                System.out.println("Nhập vào giới tính: 1. Male, 2.Female, 3. Unknown ");
                int flagKySu = scan.nextInt();
                CanBo.Gender genderName1 = null;
                switch(flagKySu)
                {
                    case 1:
                        genderName1 = CanBo.Gender.MALE;
                        break;
                    case 2:
                        genderName1 = CanBo.Gender.FEMALE;
                        break;
                    case 3:
                        genderName1 = CanBo.Gender.UNKNOWN;
                        break;
                }
                System.out.println("Nhập vào địa chỉ: ");
                String addKySu = scan.next();
                System.out.println("Nhập vào chuyên ngành: ");
                String specializedEngineer = scan.next();
                CanBo kySu = new KySu(nameKySu, ageKySu, genderName1, addKySu, specializedEngineer);
                canBoList.add(kySu);
                break;

            case 2:
                System.out.println("Nhập vào tên Công nhân: ");
                String nameCongNhan = scan.next();
                System.out.println("Nhập vào tuổi Công nhân: ");
                int ageCongNhan = scan.nextInt();
                System.out.println("Nhập vào giới tính: 1. Male, 2.Female, 3. Unknown ");
                int flagCongNhan = scan.nextInt();
                CanBo.Gender genderName2 = null;
                switch(flagCongNhan)
                {
                    case 1:
                        genderName2 = CanBo.Gender.MALE;
                        break;
                    case 2:
                        genderName2 = CanBo.Gender.FEMALE;
                        break;
                    case 3:
                        genderName2 = CanBo.Gender.UNKNOWN;
                        break;
                }
                System.out.println("Nhập vào địa chỉ: ");
                String addCongNhan = scan.next();
                System.out.println("Nhập vào chuyên ngành: ");
                int rankCongNhan = scan.nextInt();
                CanBo congNhan = new CongNhan(nameCongNhan, ageCongNhan, genderName2, addCongNhan, rankCongNhan);
                canBoList.add(congNhan);
                break;
            case 3:
                System.out.println("Nhập vào tên Nhân Viên: ");
                String nameNhanVien = scan.next();
                System.out.println("Nhập vào tuổi Nhân Viên: ");
                int ageNhanVien = scan.nextInt();
                System.out.println("Nhập vào giới tính: 1. Male, 2.Female, 3. Unknown ");
                int flagNhanVien = scan.nextInt();
                CanBo.Gender genderName3 = null;
                switch(flagNhanVien)
                {
                    case 1:
                        genderName3 = CanBo.Gender.MALE;
                        break;
                    case 2:
                        genderName3 = CanBo.Gender.FEMALE;
                        break;
                    case 3:
                        genderName3 = CanBo.Gender.UNKNOWN;
                        break;
                }
                System.out.println("Nhập vào địa chỉ: ");
                String addNhanVien = scan.next();
                System.out.println("Nhập vào chuyên ngành: ");
                String taskNhanVien = scan.next();
                CanBo nhanVien = new NhanVien(nameNhanVien, ageNhanVien, genderName3, addNhanVien, taskNhanVien);
                canBoList.add(nhanVien);
                break;
            default:
                break;
        }
    }
    public void Question3()
    {
        HighSchoolStudent highSchoolStudent = new HighSchoolStudent("Phúc", 1, "Nhúng", "KMA");
        System.out.println(highSchoolStudent);
    }
}
