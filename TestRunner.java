import java.util.Arrays;

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
        testpush();
        testPop();
        testpeek();
        testObservers();
        testProducer();

        System.out.println("==========");
        System.out.println(" [pass] = " + pass);
        System.out.println(" [fail] = " + fail);

    }

    // test ชื่อสถานีว่าง , สามารถสร้างสถานีได้ , สถานีไม่เป็น null
    private static void testCreater() {
        System.out.println("=== test Creater ===");
        BoundedStack empty = new BoundedStack(20);
        check("name = empty", empty.size() == 0);
        check("name = notthing", !empty.contains("anything"));

        BoundedStack name = new BoundedStack(20, Arrays.asList("ratchaburi", "kanchanaburi", "phetburi"));
        check("name size = 3", name.size() == 3);
        check("have name station", name.contains("ratchaburi"));

        boolean namenull = false;
        try {
            new BoundedStack(20, null);
        } catch (IllegalArgumentException e) {
            namenull = true;
        }
        check("name = null", namenull);
    }

    /**
     * ฟังชันb test การเพิ่มสถานี
     */
    private static void testpush() {
        System.out.println("=== Test push ===");
        BoundedStack add = new BoundedStack(20, Arrays.asList("bangkok"));
        check("size when add", add.size() == 1);
        check("found station", add.contains("bangkok"));
        check("top after push", add.peek().equals("bangkok"));

        BoundedStack zero = new BoundedStack(0);
        check("capacity is 0", zero.isFull());

        BoundedStack one = new BoundedStack(1);
        one.push("bangkok");
        check("capacity 1 full after 1 push", one.isFull());

        boolean threw = false;
        try {
            new BoundedStack(-1);
        } catch (IllegalArgumentException e) {
            threw = true;
        }
        check("negative capacity throws", threw);

        boolean add_duplicate = false;
        try {
            add.push("bangkok");
        } catch (IllegalArgumentException e) {
            add_duplicate = true;
        }
        check("station is duplicate", add_duplicate);

        boolean threwemp = false;
        try {
            add.push("");
        } catch (IllegalArgumentException e) {
            threwemp = true;
        }
        check("station is emply", threwemp);

        boolean threwnull = false;
        try {
            add.push(null);
        } catch (IllegalArgumentException e) {
            threwnull = true;
        }
        check("station is null", threwnull);

        BoundedStack full = new BoundedStack(20);
        for (int i = 0; i < full.getcapacity(); i++) {
            full.push("Station" + i);
        }
        check("can fill up to capacity", full.size() == full.getcapacity());
        check("add when full ", full.isFull());
        check("full Station stays at max_staion", full.size() == full.getcapacity());

        boolean threwFull = false;
        try {
            full.push("extra");
        } catch (IllegalArgumentException e) {
            threwFull = true;
        }
        check("push when full ", threwFull);
    }

    /**
     * ฟังชั่นสามารถลบได้
     * stack จะลดลงเมื่อ pop
     * ตัวที่ pop ถูกเอาออกไปแล้วจะไม่เจอใน stack อีก
     * stack จะว่างเมื่อ pop ครบทุกตัว
     */
    private static void testPop() {
        System.out.println("=== test pop ===");
        BoundedStack stack = new BoundedStack(20, Arrays.asList("ratchaburi", "kanchanaburi", "phetburi"));
        check("pop return top", stack.pop().equals("phetburi"));
        check("size after pop", stack.size() == 2);
        check("pop station remove", !stack.contains("phetburi"));
        check("pop next top", stack.pop().equals("kanchanaburi"));
        check("pop last remaining", stack.pop().equals("ratchaburi"));
        check("stack empty after pop all", stack.isEmpty());

        boolean popOnEmpty = false;
        try {
            stack.pop();
        } catch (IllegalArgumentException e) {
            popOnEmpty = true;
        }
        check("pop on empty stack throws", popOnEmpty);
    }
    
    /**
     * เทสการอ่านค่าจากด้านบนสุด โดยไม่ลบ
     */
    public static void testpeek() {
        System.out.println("=== test peek ===");
        BoundedStack read = new BoundedStack(20, Arrays.asList("ratchaburi", "kanchanaburi"));
        check("read on top", read.peek() == "kanchanaburi");
        check("read don't remove", read.size() == 2);
    }

    /**
     * ดึงค่าสถานนี
     */
    private static void testObservers() {
        System.out.println("=== test Observers===");
        BoundedStack obser = new BoundedStack(20, Arrays.asList("ratchaburi", "kanchanaburi"));
        check("size is 2", obser.size() == 2);
        check("find a station", obser.contains("kanchanaburi"));
        check("can't find station", !obser.contains("phetburi"));
    }

    /**
     * เทสการกลับค่าจากหลังไปหน้า
     */
    private static void testProducer() {
        System.out.println("=== test Producer ===");
        BoundedStack original = new BoundedStack(20 ,Arrays.asList("ratchaburi", "kanchanaburi", "phetburi")) ;
        BoundedStack change = original.reversed();
        check("same size",original.size() == change.size());
        check("can peek on top before revered", change.peek() == "ratchaburi");
    }
}