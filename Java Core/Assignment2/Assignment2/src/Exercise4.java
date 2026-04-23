import java.time.LocalDate;
import java.util.Random;

public class Exercise4 {
    public static void Question1() {
        Random random = new Random();
        int n = random.nextInt();
        System.out.println("Số ngẫu nhiên: " + n);

    }

    public static void Question2() {
        Random random = new Random();
        float f = random.nextFloat();
        System.out.println("Số ngẫu nhiên: " + f);
    }

    public static void Question3(){
        Random random = new Random();
        String[] nameArr = { "A", "B", "D", "E", "F" };
        int i = random.nextInt(nameArr.length);
        System.out.println("Tên ngẫu nhiên 1 bạn trong lớp: " + nameArr[i]);

    }

    public static void Question4(){
        Random random = new Random();
        int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay(); // Lấy ra số ngày nhỏ nhất tính từ 24-07-1995
        int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay(); // Lấy ra số ngày lớn nhất tính từ 20-12- 1995
        System.out.println("minday:" + minDay);
        System.out.println("maxday:" + maxDay);
        long randomInt = minDay + random.nextInt(maxDay - minDay); // Lấy ra số ngày ngẫu nhiên trong khoảng thời gian cần lấy
        LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
        System.out.println(randomDay);

    }

    public static void Question5(){
        Random random = new Random();
        int now = (int) LocalDate.now().toEpochDay();
        int randomDate = now - random.nextInt(365);
        LocalDate reusultDate = LocalDate.ofEpochDay(randomDate);
        System.out.println("Ngày ngẫu nhiên là: " + reusultDate);
    }
    public static void Question6(){
        Random random = new Random();
        int maxDay1 = (int) LocalDate.now().toEpochDay();
        long randomDay1 = random.nextInt(maxDay1);
        LocalDate resultDate1 = LocalDate.ofEpochDay(randomDay1);
        System.out.println("1 Ngày ngẫu nhiên trong quá khứ: " + resultDate1);
    }

    public static void Question7(){
        Random random = new Random();
        int z = random.nextInt(999 - 100 + 1) + 100;  // Công thức: (số max - số min + 1) + số min
        System.out.println(z);
    }
}
