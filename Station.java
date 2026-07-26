import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Station {

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

    /**
     * ทำชื่อสถานีว่าง
    */
    public Station() {
        this.nameStation = new ArrayList<>();
    }
    /**
     * สร้างหมวดสถานีจากชื่อที่ให้
     * @param name ชื่อสถานีที่ให้ ต้องไม่เป็น null สถานีต้องไม่เกิน 20 สถานี
     * @throws IllegalArgumentException เมื่อ name = null
     */
    public Station(List<String> name) {
        this.nameStation = new ArrayList<>();    }

    /**
     * ฟังก์ชันคืนค่า จำนวนสถานี
     */
    public int size() {
        return 0;
    }

    /**
     * ฟังก์ชัน ตรวจสอบการมีอยู่ของสถานี
     */
    public boolean contains(String name) {
        return false;
    }
    public boolean remove(String name) {
        return false;
    }

}