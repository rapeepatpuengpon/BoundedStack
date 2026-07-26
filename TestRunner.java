public class TestRunner {
    static int pass = 0, fail = 0;

    static void check(String name , boolean ok) {
        if (ok) {pass++; System.out.println(" [pass] " + name);}
        else    {fail++; System.out.println(" [fail] " + name);}
    }

    public static void main() {
        System.out.println("=== Test ===");

        testCreater();
        testAdd();
        testRemove();
        testObservers();
        testProducer();
        testExposure();

        System.out.println(" [pass] = " + pass );
        System.out.println(" [fail] = " + fail );
        
    }

    private static void testCreater() {
        
    }
    
    private static void testAdd() {
        
    }

    private static void testRemove() {
        
    }

    private static void testObservers() {
        
    }

    private static void testProducer() {
        
    }

    private static void testExposure() {
        
    }

}
