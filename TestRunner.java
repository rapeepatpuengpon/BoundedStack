import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestRunner {
    static int pass = 0, fail = 0;

    static void check(String name, boolean ok) {
        if (ok) {
            pass++;
            System.out.println(" [pass] " + name);
        } else {
            fail++;
            System.out.println(" [fail] " + name);
        }
    }

    public static void main() {
        boolean assertsOn = false;
        assert assertsOn = true;
        if (!assertsOn) {
            System.out.println("WARNING: assertions disabled");
        }
                    
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

    // test ชื่อสถานีว่าง , สามารถสร้างสถานีได้ ,  สถานีไม่เป็น null
    private static void testCreater() {
        Station empty = new Station();
        check("name = empty", empty.size() == 0 );
        check("name = notthing", !empty.contains("anything"));

        Station name = new Station(Arrays.asList("ratchaburi", "kanchanaburi", "phetburi"));
        check("name size = 3", name.size() == 3);
        check(" have name station", name.contains("ratchaburi"));
        
        boolean namenull = false;
        try {
            new Station(null);
        } catch (IllegalArgumentException e) {
           namenull = true;
        }
        check("name = null", namenull);
    }

    private static void testAdd() {

    }

    private static void testRemove() {
        Station remove = new Station(Arrays.asList("a","b","c")); 
        check("can remove", remove.remove("b"));
        check("size delete", remove.size() == 2);
        check("remove song", !remove.contains("b"));
    }

    private static void testObservers() {
        Station obser = new Station(Arrays.asList("ratchaburi" , "kanchanaburi"));
        check("size is 2", obser.size() == 2);
        check("find a station", obser.contains("kanchanaburi"));
        check("can't find station", !obser.contains("phetburi"));

    }

    private static void testProducer() {

    }

    private static void testExposure() {

    }

}