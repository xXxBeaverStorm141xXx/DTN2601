public class Exercise1
{
    public static void Question1(Account account){
        if (account.department == null)
        {
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban nhân viên này là: " + account.department.name + "\n");
        }
    }

    public static void Question2(Account account){
        int numberOfGroup = account.groups == null ? 0 : account.groups.length;
        if(numberOfGroup == 0)
        {
            System.out.println("Nhân viên này chưa có group");
        }
        else if(numberOfGroup == 1 || numberOfGroup == 2)
        {
            System.out.print("Group của nhân viên này là: ");
            for(int i = 0; i < numberOfGroup; i++)
            {
                System.out.print(account.groups[i].name);
                if (i < numberOfGroup - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("\n");
        }
        else if (numberOfGroup == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        }
        else {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }
    }

    public  static void Question3(Account account){
        String departmentOfAccount = account.department == null ? "Nhân viên này chưa có phòng ban" : "Phòng ban nhân viên này là:"  + account.department.name;
        System.out.println(departmentOfAccount);
    }

    public static void Question4(Account account){
        String positionOfAccount = (account.position.name.toString() == "Dev") ? "Đây là Developer" : "Người này không phải Developer ";
        System.out.println(positionOfAccount);
    }

    public static void Question5(Group group) {
        if (group.accounts == null) {
            System.out.println("Group chưa có thành viên nào tham gia");
        } else {
            int countAccInGroup = group.accounts.length;
            switch (countAccInGroup) {
                case 1:
                    System.out.println("Nhóm có một thành viên");
                    break;
                case 2:
                    System.out.println("Nhóm có hai thành viên");
                    break;
                case 3:
                    System.out.println("Nhóm có ba thành viên");
                    break;

                default:
                    System.out.println("Nhóm có nhiều thành viên");
                    break;
            }

        }
    }

    public static void Question6(Account account) {
        if (account.groups == null) {
            System.out.println("Nhân viên này chưa có group");
        } else {
            switch (account.groups.length) {
                case 1:
                    System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                    break;

                case 2:
                    System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                    break;

                case 3:
                    System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                    break;
                default:
                    System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
                    break;
            }
        }
    }

    public static void Question7(Account account) {
        String positionName = account.position.name.toString();
        switch (positionName) {
            case "Dev":
                System.out.println("Đây là Developer");
                break;

            default:
                System.out.println("Người này không phải là Developer");
                break;
        }
    }

    public static void Question8(Account[] accounts) {
        for (Account acc : accounts) {
            System.out.println(
                    "Email: " + acc.email +
                            " | FullName: " + acc.fullName +
                            " | Department: " + acc.department.name
            );
        }
    }

    public static void Question9(Department[] departments) {
        for (Department department : departments) {
            System.out.println("ID: " + department.id + "Department name: " + department.name);
        }
    }

    public static void Question10(Account[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + accounts[i].department.name);
        }
    }

    public static void Question11(Department[] departments) {
        for (int i = 0; i < departments.length; i++) {
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("Id: " + departments[i].id);
            System.out.println("Name: " + departments[i].name);
        }
    }

    public static void Question12(Department[] departments) {
        for (int i = 0; i < 2; i++) {
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("Id: " + departments[i].id);
            System.out.println("Name: " + departments[i].name);
        }
    }

    public static void Question13(Account[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            if (i == 1)
            {
                continue;
            }

            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + accounts[i].department.name);
        }
    }

    public static void Question14(Account[] accounts) {
        for (Account acc : accounts) {
            if (acc.id < 4) {
                System.out.println("Email: " + acc.email);
                System.out.println("Full name: " + acc.fullName);
                System.out.println("Phòng ban: " + acc.department.name);
            }
        }
    }

    public static void Question15() {
        for (int i = 2; i <= 20; i += 2) {
            System.out.print(i + " ");
        }
    }

    public static void Question16(Account[] accounts, Department[] departments) {

        // Question 17-10
        int i = 0;
        while(i < accounts.length)
        {
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + accounts[i].department.name);
            i++;
        }
        //Question 16-11
        int j = 0;
        while(j < departments.length)
        {
            System.out.println("Thông tin department thứ " + (j + 1) + " là:");
            System.out.println("Id: " + departments[j].id);
            System.out.println("Name: " + departments[j].name);
            j++;
        }
        //Question 16-12
        int k = 0;
        while (k < 2)
        {
            System.out.println("Thông tin department thứ " + (k + 1) + " là:");
            System.out.println("Id: " + departments[k].id);
            System.out.println("Name: " + departments[k].name);
            k++;
        }
        // Question 16-13
        int l = 0;
        while (l < accounts.length)
        {
            if(l != 1)
            {
                System.out.println("Thông tin account thứ " + (l + 1) + " là:");
                System.out.println("Email: " + accounts[l].email);
                System.out.println("Full name: " + accounts[l].fullName);
                System.out.println("Phòng ban: " + accounts[l].department.name);
            }
            l++;
        }
        // Question 16-14
        int m = 0;
        while (m < accounts.length)
        {
            if(accounts[m].id < 4){
                System.out.println("Thông tin account thứ " + (m + 1) + " là:");
                System.out.println("Email: " + accounts[m].email);
                System.out.println("Full name: " + accounts[m].fullName);
                System.out.println("Phòng ban: " + accounts[m].department.name);
            }
            m++;
        }
        // Question 16-15
        int n = 0;
        while (n <= 20)
        {
            if(n % 2 == 0){
                System.out.print(n + " ");
            }
            n++;
        }

    }
    public static void Question17(Account[] accounts, Department[] departments) {

        // Question 17-10
        int i = 0;
        do{
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + accounts[i].department.name);
            i++;
        } while(i < accounts.length);

        //Question 17-11
        int j = 0;
        do
        {
            System.out.println("Thông tin department thứ " + (j + 1) + " là:");
            System.out.println("Id: " + departments[j].id);
            System.out.println("Name: " + departments[j].name);
            j++;
        }while(j < departments.length);
        //Question 17-12
        int k = 0;
        do
        {
            System.out.println("Thông tin department thứ " + (k + 1) + " là:");
            System.out.println("Id: " + departments[k].id);
            System.out.println("Name: " + departments[k].name);
            k++;
        }while (k < 2);
        // Question 17-13
        int l = 0;
        do
        {
            if(l != 1)
            {
                System.out.println("Thông tin account thứ " + (l + 1) + " là:");
                System.out.println("Email: " + accounts[l].email);
                System.out.println("Full name: " + accounts[l].fullName);
                System.out.println("Phòng ban: " + accounts[l].department.name);
            }
            l++;
        }while (l < accounts.length);
        // Question 17-14
        int m = 0;
        do
        {
            if(accounts[m].id < 4){
                System.out.println("Thông tin account thứ " + (m + 1) + " là:");
                System.out.println("Email: " + accounts[m].email);
                System.out.println("Full name: " + accounts[m].fullName);
                System.out.println("Phòng ban: " + accounts[m].department.name);
            }
            m++;
        }while (m < accounts.length);
        // Question 17-15
        int n = 0;
        do
        {
            if(n % 2 == 0){
                System.out.print(n + " ");
            }
            n++;
        }while (n <= 20);
    }

}
