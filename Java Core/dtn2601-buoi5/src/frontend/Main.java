package frontend;

import backend.QLAccount;
import backend.QLDepartment;
import backend.QLPosition;
public class Main {
    public static void main(String[] args) {
        QLAccount.printAccounts();
        QLDepartment.printDepartment();
        QLPosition.printPosition();
    }
}
