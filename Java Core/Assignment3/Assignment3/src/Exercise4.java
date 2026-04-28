import java.util.Scanner;

public class Exercise4 {
    public static void Question1()
    {
        String s1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        s1 = scanner.nextLine();
        String[] words = s1.split(" ");
        System.out.println("Số kí tự: " + words.length);
    }

    public static void Question2()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi 1: ");
        String s1 = sc.next();
        System.out.println("Nhập vào chuỗi 2: ");
        String s2 = sc.next();

        System.out.println("Kết quả sau khi nối chuỗi: " + s1 + " " + s2);

    }

    public static void Question3()
    {
        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.println("Nhập Tên: ");
        name = scanner.nextLine();
        String firstCharacter = name.substring(0, 1).toUpperCase();
        String leftCharacter = name.substring(1);
        System.out.println("char at:"+ name.charAt(1));
        name = firstCharacter + leftCharacter;
        System.out.println(name);

    }

    public static void Question4()
    {
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        name = sc.nextLine();
        name = name.toUpperCase();
        for (int i = 0; i < name.length(); i++) {
            System.out.println("Ký tự thứ " + i + " là: " + name.charAt(i));
        }
    }


    public static void Question5()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập họ: ");
        String firstName = sc.nextLine();
        System.out.println("Nhập tên: ");
        String lastName = sc.nextLine();
        System.out.println("Họ tên đầy đủ: " + firstName.concat(lastName));

    }

    public static void Question6()
    {
        String fullName;
        String lastName = "", middleName = "", firstName = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập họ tên đầy đủ:");
        fullName = sc.nextLine();
        fullName = fullName.trim();
        String[] words = fullName.split(" ");
        lastName = words[0];
        firstName = words[words.length - 1];
        for (int i = 1; i <= words.length - 2; i++) {
            middleName += words[i] + " ";
        }
        System.out.println("Họ là: " + lastName);
        System.out.println("Tên đệm là: " + middleName);
        System.out.println("Tên là: " + firstName);
    }

    public static void Question7()
    {
        Scanner scanner = new Scanner(System.in);
        String fullName;
        System.out.println("Nhập họ tên đầy đủ");
        fullName = scanner.nextLine();
        fullName = fullName.trim();
        fullName = fullName.replaceAll("\\s+", " ");
        System.out.println("test"+ fullName);
        String[] words = fullName.split(" ");
        fullName = "";

        for (String word : words) {
            String firstCharacter = word.substring(0, 1).toUpperCase();
            String leftCharacter = word.substring(1);
            word = firstCharacter + leftCharacter;
            fullName += word + " ";
        }

        System.out.println("Họ tên sau khi chuẩn hóa: " + fullName);

    }

    public static void Question8()
    {
        String[] groupNames = { "Java with me", "Gia Va", "Tất tần tật về Java" };
        for (String groupName : groupNames) {
            if (groupName.contains("Java")) {
                System.out.println(groupName);
            }
        }
    }

    public static void Question9()
    {
        String[] groupNames = { "Java", "C#", "C++" };
        for (String groupName : groupNames) {
            if (groupName.equals("Java")) {
                System.out.println(groupName);
            }
        }
    }

    public static void Question10()
    {
        Scanner sc = new Scanner(System.in);
        String s1, s2, reverseS1 = "";

        System.out.println("Nhập chuỗi 1");
        s1 = sc.nextLine();

        System.out.println("Nhập chuỗi 2");
        s2 = sc.nextLine();

        for (int i = s1.length() - 1; i >= 0; i--) {
            reverseS1 += s1.substring(i, i + 1);
        }

        if (s2.equals(reverseS1)) {
            System.out.println("Đây là chuỗi đảo ngược !");
        }
        else {
            System.out.println("Đây không phải chuỗi đảo ngược");
        }
    }

    public static void Question11()
    {
        Scanner sc = new Scanner(System.in);
        String str;

        System.out.println("Mời bạn nhập vào một chuỗi: ");
        str = sc.nextLine();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if ('a' == str.charAt(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void Question12()
    {
        Scanner sc = new Scanner(System.in);
        String s1, reverseS1 = "";

        System.out.println("Nhập chuỗi 1");
        s1 = sc.nextLine();

        for (int i = s1.length() - 1; i >= 0; i--) {
            reverseS1 += s1.charAt(i);
        }
        System.out.println(reverseS1);
    }


    public static void Question13()
    {
        Scanner sc = new Scanner(System.in);
        String str;

        System.out.println("Nhập chuỗi: ");
        str = sc.nextLine();

        for (int i = 0; i < str.length(); i++) {
            if (checkKeyNumber(str.charAt(i))) {
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }

    public static boolean checkKeyNumber(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        return false;

    }

    public static void Question14()
    {
        Scanner scanner = new Scanner(System.in);
        String str;
        char ch1, ch2;

        System.out.println("Nhập chuỗi: ");
        str = scanner.nextLine();

        System.out.println("Nhập kí tự muốn chuyển: ");
        ch1 = scanner.nextLine().toCharArray()[0];  // chuyển một mảng string sang array char, sau đó lấy phần tử thứ 0

        System.out.println("Nhập kí tự sẽ chuyển: ");
        ch2 = scanner.nextLine().toCharArray()[0];


        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch1) {
                str = str.replace(ch1, ch2);
            }
        }

        System.out.println("Chuoi sau khi chuyen: " + str);

    }

    public static void Question15()
    {
        Scanner scanner = new Scanner(System.in);
        String str;

        System.out.println("Chuỗi: ");
        str = scanner.nextLine();

        str = str.trim();
        str = str.replaceAll("\\s+", " ");

        String[] words = str.split(" ");

        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i] + " ");
        }
    }

    public static void Question16()
    {
        Scanner scanner = new Scanner(System.in);
        String str;
        int n;

        System.out.println("Chuỗi: ");
        str = scanner.nextLine();

        System.out.println("Nhập n: ");
        n = scanner.nextInt();

        if (str == null || str.isEmpty() || str.length() % n != 0) {
            System.out.println("No");
            return;
        }
        for (int i = 0; i < str.length(); i += n) {
            System.out.println(str.substring(i, i + n));
        }
    }
}
