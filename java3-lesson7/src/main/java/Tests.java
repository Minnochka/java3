public class Tests {

    @BeforeSuite
    public static void start() {
        System.out.println("start");
    }

    /*@BeforeSuite
    public static void start2() {
        System.out.println("start");
    }*/

    @AfterSuite
    public static void finish() {
        System.out.println("finish");
    }

    /*@AfterSuite
    public static void finish2() {
        System.out.println("finish");
    }*/

    /*@Test(priority = 50)
    public static void pr50() {
        System.out.println("priority = 5");
    }*/

    @Test(priority = 5)
    public static void pr5() {
        System.out.println("priority = 5");
    }

    @Test(priority = 4)
    public static void pr4() {
        System.out.println("priority = 4");
    }

    @Test
    public static void pr1() {
        System.out.println("priority = 1");
    }

    @Test(priority = 3)
    public static void pr3() {
        System.out.println("priority = 3");
    }

    @Test(priority = 2)
    public static void pr2() {
        System.out.println("priority = 2");
    }

}
