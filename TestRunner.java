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

        System.out.println("=== test Price ===");
        check("price = 20", Price.Checkprice(20));
        check("price > 20", Price.Checkprice(30));
        check("price = 50", Price.Checkprice(50));
        check("price < 50", Price.Checkprice(40));

        System.out.println("==========");
        System.out.println(" [pass] = " + pass );
        System.out.println(" [fail] = " + fail );

        
    }

    // test ชื่อสถานีว่าง , สามารถสร้างสถานีได้ ,  สถานีไม่เป็น null
    private static void testCreater() {
        System.out.println("=== test Creater ===");
        Station empty = new Station();
        check("name = empty", empty.size() == 0 );
        check("name = notthing", !empty.contains("anything"));

        Station name = new Station(Arrays.asList("ratchaburi","kanchanaburi","phetburi"));
        check("name size = 3", name.size() == 3);
        check("have name station", name.contains("ratchaburi"));
        
        boolean namenull = false;
        try {
            new Station(null);
        } catch (IllegalArgumentException e) {
           namenull = true;
        }
        check("name = null", namenull);
    }

    private static void testAdd() {
        System.out.println("Test Add");
        Station add = new Station();
        check("can add", add.add("bangkok"));
        check("size when add", add.size() == 1);
        check("found station", add.contains("bangkok"));
    }

    private static void testRemove() {
        System.out.println("=== test Remove ===");
        Station remove = new Station(Arrays.asList("ratchaburi", "kanchanaburi", "phetburi")); 
        check("can remove", remove.remove("kanchanaburi"));
        check("size delete", remove.size() == 2);
        check("remove song", !remove.contains("kanchanaburi"));
    }

    private static void testObservers() {
        System.out.println("=== test Observers===");
        Station obser = new Station(Arrays.asList("ratchaburi" , "kanchanaburi"));
        check("size is 2", obser.size() == 2);
        check("find a station", obser.contains("kanchanaburi"));
        check("can't find station", !obser.contains("phetburi"));
    }

    private static void testProducer() {

    }

}
