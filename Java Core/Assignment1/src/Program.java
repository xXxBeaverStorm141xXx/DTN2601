import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
        // Create Department
        Department dep1 = new Department();
        dep1.id = 1;
        dep1.name = "Development";

        Department dep2 = new Department();
        dep2.id = 2;
        dep2.name = "Testing";

        Department dep3 = new Department();
        dep3.id = 3;
        dep3.name = "BOD";

        // Create Position
        Position pos1 = new Position();
        pos1.id = 1;
        pos1.name = Position.PositionName.Test;

        Position pos2 = new Position();
        pos2.id = 2;
        pos2.name = Position.PositionName.Dev;

        Position pos3 = new Position();
        pos3.id = 3;
        pos3.name = Position.PositionName.PM;

        // Create Group
        Group group1 = new Group();
        group1.id = 1;
        group1.name = "Testing";

        Group group2 = new Group();
        group2.id = 2;
        group2.name = "Development";

        Group group3 = new Group();
        group3.id = 3;
        group3.name = "BOD";

        // Create Account
        Account account1 = new Account();
        account1.id = 1;
        account1.email = "phucdh141";
        account1.userName = "phucdh141";
        account1.fullName = "Do Huy Phuc";
        account1.department = dep1;
        account1.position = pos1;
        account1.createDate = LocalDate.now();
        Group[] groupAcc1 = {group1, group2, group3};
        account1.groups = groupAcc1;

        Account account2 = new Account();
        account2.id = 2;
        account2.email = "phucdh142";
        account2.userName = "phucdh142";
        account2.fullName = "Do Huy Phuc 2";
        account2.department = dep2;
        account2.position = pos2;
        account2.createDate = LocalDate.of(2020, 11,14);
        Group[] groupAcc2 = {group2, group3};
        account2.groups = groupAcc2;

        Account account3 = new Account();
        account3.id = 3;
        account3.email = "phucdh143";
        account3.userName = "phucdh143";
        account3.fullName = "Do Huy Phuc 3";
        account3.department = dep3;
        account3.position = pos3;
        account3.createDate = LocalDate.now();
        Group[] groupAcc3 = {group1, group3};
        account3.groups = groupAcc3;


        System.out.println("Thông tin các Account trên hệ thống:");
        
        System.out.println("Account 1: ID : " + account1.id + ", Email: " + account1.email + ", UserName: " + account1.userName
                + ", FullName: " + account1.fullName + ", Department: " + account1.department.name + ", Position: "
                + account1.position.name + ", Group: "+ account1.groups[0].name +" "+ account1.groups[1].name  + ", CreateDate: " + account1.createDate);

        System.out.println("Account 2: ID : " + account2.id + ", Email: " + account2.email + ", UserName: " + account2.userName
                + ", FullName: " + account2.fullName + ", Department: " + account2.department.name + ", Position: "
                + account2.position.name + ", Group: "+ account2.groups[0].name +", "+ account2.groups[1].name + ", CreateDate: " + account2.createDate);

        System.out.println("Account 3: ID : " + account3.id + ", Email: " + account3.email + ", UserName: " + account3.userName
                + ", FullName: " + account3.fullName + ", Department: " + account3.department.name + ", Position: "
                + account3.position.name + ", Group: "+ account3.groups[0].name +", "+ account3.groups[1].name + ", CreateDate: " + account3.createDate);


    }
}
