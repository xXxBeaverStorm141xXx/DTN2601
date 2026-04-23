import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

        Group[] groups = {group1, group2, group3};

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


        group1.accounts = new Account[] {account1, account3};
        group2.accounts = new Account[] {account1, account2};
        group3.accounts = new Account[] {account1, account2, account3};


//        System.out.println("Thông tin các Account trên hệ thống:");
//
//        System.out.println("Account 1: ID : " + account1.id + ", Email: " + account1.email + ", UserName: " + account1.userName
//                + ", FullName: " + account1.fullName + ", Department: " + account1.department.name + ", Position: "
//                + account1.position.name + ", Group: "+ account1.groups[0].name +" "+ account1.groups[1].name  + ", CreateDate: " + account1.createDate);
//
//        System.out.println("Account 2: ID : " + account2.id + ", Email: " + account2.email + ", UserName: " + account2.userName
//                + ", FullName: " + account2.fullName + ", Department: " + account2.department.name + ", Position: "
//                + account2.position.name + ", Group: "+ account2.groups[0].name +", "+ account2.groups[1].name + ", CreateDate: " + account2.createDate);
//
//        System.out.println("Account 3: ID : " + account3.id + ", Email: " + account3.email + ", UserName: " + account3.userName
//                + ", FullName: " + account3.fullName + ", Department: " + account3.department.name + ", Position: "
//                + account3.position.name + ", Group: "+ account3.groups[0].name +", "+ account3.groups[1].name + ", CreateDate: " + account3.createDate);


        Account[] accounts = {account1, account2, account3};
        Department[] dep =  {dep1, dep2, dep3};




        // Tạo Category
        CategoryQuestion cat1 = new CategoryQuestion();
        cat1.id = 1;
        cat1.name = "Java";

        CategoryQuestion cat2 = new CategoryQuestion();
        cat2.id = 2;
        cat2.name = "SQL";

        CategoryQuestion cat3 = new CategoryQuestion();
        cat3.id = 3;
        cat3.name = "Testing";

        // Tạo TypeQuestion
        TypeQuestion type1 = new TypeQuestion();
        type1.id = 1;
        type1.name = TypeQuestion.TypeName.Essay;

        TypeQuestion type2 = new TypeQuestion();
        type2.id = 2;
        type2.name = TypeQuestion.TypeName.Multiple_Choice;

        //Tạo Question
        Question question1 = new Question();
        question1.id = 1;
        question1.content = "Java là gì?";
        question1.type = type1;
        question1.creator = account1;
        question1.createDate = LocalDate.now();

        Question question2 = new Question();
        question2.id = 2;
        question2.content = "SQL dùng để làm gì?";
        question2.type = type2;
        question2.creator = account2;
        question2.createDate = LocalDate.of(2024, 6, 10);

        Question question3 = new Question();
        question3.id = 3;
        question3.content = "OOP gồm những tính chất nào?";
        question3.type = type2;
        question3.creator = account3;
        question3.createDate = LocalDate.now();

        Question[] questions = {question1, question2, question3};


        //Tạo Exam
        Exam exam1 = new Exam();
        exam1.id = 1;
        exam1.code = "EX001";
        exam1.title = "Java Basic Test";
        exam1.category = new CategoryQuestion[] {cat1};
        exam1.duration = 60;
        exam1.creator = account1;
        exam1.createDate = LocalDateTime.now();
        exam1.question = new Question[] {question1, question2};

        Exam exam2 = new Exam();
        exam2.id = 2;
        exam2.code = "EX002";
        exam2.title = "Database Test";
        exam2.category = new CategoryQuestion[] {cat2};
        exam2.duration = 45;
        exam2.creator = account2;
        exam2.createDate = LocalDateTime.of(2024, 4, 22, 14, 30, 15);
        exam2.question = new Question[] {question2};

        Exam exam3 = new Exam();
        exam3.id = 3;
        exam3.code = "EX003";
        exam3.title = "Full IT Test";
        exam3.category = new CategoryQuestion[] {cat1, cat2, cat3};
        exam3.duration = 90;
        exam3.creator = account3;
        exam3.createDate = LocalDateTime.now();
        exam3.question = new Question[] {question1, question2, question3};

        Exam[] exams = {exam1, exam2, exam3};

        // Exercise 1
        Exercise1.Question1(account2);
        Exercise1.Question2(account2);
        Exercise1.Question3(account2);
        Exercise1.Question4(account1);
        Exercise1.Question5(group1);
        Exercise1.Question6(account2);
        Exercise1.Question7(account1);
        Exercise1.Question8(accounts);
        Exercise1.Question9(dep);
        Exercise1.Question10(accounts);
        Exercise1.Question11(dep);
        Exercise1.Question12(dep);
        Exercise1.Question13(accounts);
        Exercise1.Question14(accounts);
        Exercise1.Question15();
        Exercise1.Question16(accounts, dep);
        System.out.println();
        Exercise1.Question17(accounts, dep);
        System.out.println();

        // Exercise 2
        Exercise2.Question1();
        Exercise2.Question2();
        Exercise2.Question3();
        Exercise2.Question4();
        Exercise2.Question5();
        Exercise2.Question6(accounts);

        // Exercise 3
        Exercise3.Question1(exam1);
        Exercise3.Question2(exams);
        Exercise3.Question3(exams);
        Exercise3.Question4(exams);
        Exercise3.Question5(exams);

        // Exercise 4
        Exercise4.Question1();
        Exercise4.Question2();
        Exercise4.Question3();
        Exercise4.Question4();
        Exercise4.Question5();
        Exercise4.Question6();
        Exercise4.Question7();

        // Exercise 5
        Exercise5.Question1();
        Exercise5.Question2();
        Exercise5.Question3();
        Exercise5.Question4();
        Exercise5.Question5();
        Exercise5.Question6();
        Exercise5.Question7();
        Exercise5.Question8();
        Exercise5.Question9();
        Exercise5.Question10();

        //Exercise 6
        Exercise6.Question1();
        Exercise6.Question2(accounts);
        Exercise6.Question3();
    }
}
