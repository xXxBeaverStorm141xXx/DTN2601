public class Exercise6 {
    public static void Question1() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void Question2(Account[] accounts) {
        for (int i = 0; i < accounts.length; i++)
        {
            System.out.println("ID: " + accounts[i].id + " Email: " + accounts[i].email + " Username: " + accounts[i].userName
                                + " FullName: " + accounts[i].fullName + " Department: " + accounts[i].department
                                + " Position: " + accounts[i].position + " CreateDate: " + accounts[i].createDate);
        }
    }

    public static void Question3(){
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + i);
        }
    }
}
