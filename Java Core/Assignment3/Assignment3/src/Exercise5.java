public class Exercise5 {
    public static void Question1(Department department)
    {
        System.out.println(department.toString());

    }

    public static void Question2(Department[] departments)
    {
        for (Department department : departments)
        {
            System.out.println(department.toString());
        }
    }

    public static void Question3(Department department)
    {
        System.out.println(department.hashCode());
    }

    public static void Question4(Department department)
    {
        if (department.name.equals("Phòng A"))
        {
            System.out.println("Phòng này là Phòng A");
        } else
        {
            System.out.println("Không phải phòng A");
        }
    }


    public static void Question5(Department department1, Department department2)
    {
        if(department1.equals(department2))
        {
            System.out.println("Có bằng nhau");
        }
        else
        {
            System.out.println("Không bằng");
        }
    }

    public static void Question6(Department[] departments)
    {
        for(int i = 0; i < departments.length; i++)
        {
            for(int j = 0; j < departments.length - 1; j++)
            {
                if(departments[i].name.compareToIgnoreCase(departments[j].name) < 0)
                {
                    Department temp = departments[i];
                    departments[i] = departments[j];
                    departments[j] = temp;
                }
            }
        }
    }

    public static void Question7()
    {

    }

    public static void Question8()
    {

    }

    public static void Question9()
    {

    }

    public static void Question10()
    {

    }

    public static void Question11()
    {

    }

    public static void Question12()
    {

    }


    public static void Question13()
    {

    }

    public static void Question14()
    {

    }

    public static void Question15()
    {

    }

    public static void Question16()
    {

    }

}
