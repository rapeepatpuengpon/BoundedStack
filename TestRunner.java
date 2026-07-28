import java.util.Arrays;
import java.util.EmptyStackException;

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

    public static void main(String[] args) {
        boolean assertsOn = false;
        assert assertsOn = true;
        if (!assertsOn) {
            System.out.println("WARNING: assertions disabled");
        }
                    
        System.out.println("=== Test ===");

        testCreater();
        testAdd();
        testPop();
        testObservers();
        testProducer();

        System.out.println("=== test Price ===");
        check("price is 20 bath",Price.Calprice(16, 19) == 20 );
        check("price is 20 bath",Price.Calprice(19,3) == 20 );
        check("price is 26 bath",Price.Calprice(19,7) == 26 );
        
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
    /**
     * ฟังชันb test การเพิ่มสถานี
     */
    private static void testAdd() {
        System.out.println("Test Add");
        Station add = new Station();
        check("can add", add.add("bangkok"));
        check("size when add", add.size() == 1);
        check("found station", add.contains("bangkok"));
        check("add duplicate", !add.add("bangkok"));
        
        

        boolean threwemp = false;
        try {
            new Station(Arrays.asList(""));
        } catch (IllegalArgumentException e) {
           threwemp = true;
        }
        check("station is emply", threwemp);

        boolean threwnull = false;
        try {
            new Station(null);
        } catch (IllegalArgumentException e) {
           threwnull = true;
        }
        check("station is null", threwnull);

        Station full = new Station();
        for (int i = 0; i < Station.max_station; i++) {
            full.add("Station" + i);
        }
        check("can fill up to max_station", full.size() == Station.max_station);
        check("add when full ", !full.add("one more"));
        check("full Station stays at max_staion",
        full.size() == Station.max_station);
    }
    

    /**
     * ฟังชั่นสามารถลบได้
     * stack จะลดลงเมื่อ pop 
     * ตัวที่ pop ถูกเอาออกไปแล้วจะไม่เจอใน stack อีก
     * stack จะว่างเมื่อ pop ครบทุกตัว
     */
    private static void testPop() {
        System.out.println("=== test pop ===");
        Station stack = new Station(Arrays.asList("ratchaburi", "kanchanaburi", "phetburi"));
        check("pop return top", stack.pop().equals("phetburi"));
        check("size after pop", stack.size() == 2);
        check("pop station remove", !stack.contains("phetburi"));
        check("pop next top", stack.pop().equals("kanchanaburi"));
        check("pop last remaining", stack.pop().equals("ratchaburi"));
        check("stack empty after pop all", stack.isEmpty());
 
        boolean popOnEmpty = false;
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            popOnEmpty = true;
        }
        check("pop on empty stack throws", popOnEmpty);
    }


    
    
    /**
     * ดึงค่าสถานนี
     */
    private static void testObservers() {
        System.out.println("=== test Observers===");
        Station obser = new Station(Arrays.asList("ratchaburi" , "kanchanaburi"));
        check("size is 2", obser.size() == 2);
        check("find a station", obser.contains("kanchanaburi"));
        check("can't find station", !obser.contains("phetburi"));
    }

    /**
     * แก้ไขชื่อจากชื่อเดิม
     */
    private static void testProducer() {
        System.out.println("=== test Producer ===");
        Station base = new Station(Arrays.asList("ratchaburi", "kanchanaburi", "phetburi"));
        check("new Station is ratchaburiphotharam",base.changeName("ratchaburi","photharam").equals("ratchaburiphotharam"));
    }
}