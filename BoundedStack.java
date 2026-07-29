import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Station ฟังก์ชัน รับค่า String ของ ชื่อ สถานี
 * รพีภัทร พึ่งผล 6821651698
 * ภาณุเดช อดิสรวรวุฒิ 6821651639
 */
public class BoundedStack {
    private final int capacity;
    private final List<String> nameStation;

    /**
     * Abstraction Fucntion
     * AF(nameStation) = ชื่อสถานี
     * 
     * 
     * Representation Invariant
     * nameStation ต้องไม่เป็น null
     * nameStation ต้องไม่เป็นข้อความเปล่าๆ
     * nameStation มีจำนวนไม่เกิน 20 สถานี
     * 
     * 
     * Safety from rep exposure
     * nameStation เป็น final
     * คัดลอกทั้งขาเข้า และขาออก
     */

    private void checkRep() {
        assert nameStation != null : "nameStation is not null";
        assert nameStation.size() <= capacity;
        assert capacity >= 0;

        Set<String> seen = new HashSet<>();
        for (String s : nameStation) {
            assert s != null;
            assert s != "";
            assert seen.add(s);
        }
    }

    /**
     * ทำชื่อสถานีว่าง
     */
    public BoundedStack(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException();
        this.capacity = capacity;
        this.nameStation = new ArrayList<>();
        checkRep();
    }

    /**
     * สร้างหมวดสถานีจากชื่อที่ให้
     * 
     * @param name ชื่อสถานีที่ให้ ต้องไม่เป็น null สถานีต้องไม่เกิน 20 สถานี
     * @throws IllegalArgumentException เมื่อ name = null
     */
    public BoundedStack(int capacity, List<String> name) {
        if (capacity < 0)
            throw new IllegalArgumentException();
        if (name == null)
            throw new IllegalArgumentException("name is null");
        if (name.size() > capacity)
            throw new IllegalArgumentException("name is full");
        this.capacity = capacity;

        Set<String> seen = new HashSet<>();
        for (String s : name) {
            if (s == null)
                throw new IllegalArgumentException();
            if (s == "")
                throw new IllegalArgumentException();
            if (!seen.add(s))
                throw new IllegalArgumentException();
        }

        this.nameStation = new ArrayList<>(name);
        checkRep();
    }

    /**
     * รับค่าขนาดของชื่อสถานี
     * @return ขนาดสถานี
     */
    public int getcapacity() {
        return this.capacity;
    }

    /**
     * รับค่าขนาดสถานี
     * @return ส่งขนาดสถานีกลับ
     */
    public int size() {
        return nameStation.size();
    }

    /**
     * ฟังก์ชัน ตรวจสอบการมีอยู่ของสถานี
     */
    public boolean contains(String name) {
        return nameStation.contains(name);
    }

    /**
     * เอาชื่อสถานีและลบชื่อสถานีบนสุดออก
     * 
     * @return ชื่อสถานีที่อยู่บนสุด
     * @throws IllegalArgumentException เมื่อว่าง
     */
    public String pop() {
        if (isEmpty())
            throw new IllegalArgumentException();
        String top = nameStation.remove(nameStation.size() - 1);
        checkRep();
        return top;
    }

    /**
     * 
     * @param name ชื่อสถานีที่ต้องการเพิ่ม
     * @throws IllegalArgumentException เมื่อ name = null เป็นข้อความเปล่าๆ
     *                                  มีชื่อซ้ำและใส่จนเต็ม
     */
    public void push(String name) {
        if (name == null || name.equals(""))
            throw new IllegalArgumentException();
        if (nameStation.contains(name))
            throw new IllegalArgumentException();
        if (isFull())
            throw new IllegalArgumentException();
        nameStation.add(name);
        checkRep();
    }

    /**
     * ฟังชันเช็คว่าสถานีมีชื่อว่างไหม
     * 
     * @return true เมื่อชื่อว่าง
     */
    public boolean isEmpty() {
        return nameStation.isEmpty();
    }

    /***
     * ฟังชันเช็คว่าสถานีมีชื่อเต็มรึยัง
     *
     * @return true เมื่อชื่อเต็ม
     */
    public boolean isFull() {
        return nameStation.size() >= capacity;
    }

    /***
     * อ่านชื่อสถานี โดยไม่ลบชื่อออก
     * 
     * @return ส่งชื่อของ namestation กลับ โดยลบขาดออก 1 เพื่ออ่านค่า array
     */
    public String peek() {
        if (isEmpty())
            throw new IllegalArgumentException();
        return nameStation.get(nameStation.size() - 1);
    }

    /**
     * ฟังชันเรียงชื่อสถานีจากหน้าไปหลัง
     * @return ชื่อสถานีที่เรียงใหม่แล้ว
     */
    public BoundedStack reversed() {
        List<String> copy = new ArrayList<>(nameStation);
        Collections.reverse(copy);
        BoundedStack finish = new BoundedStack(capacity);
        for (String s : copy) {
            finish.push(s);
        }
        return finish;
    }

}