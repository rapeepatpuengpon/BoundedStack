public class TestRunner {
    static int pass = 0, fail = 0;

    static void check(String name , boolean ok) {
        if (ok) {pass++; System.out.println(" [pass] " + name);}
        else    {fail++; System.out.println(" [fail] " + name);}
    }
}
