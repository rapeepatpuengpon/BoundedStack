import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Station ฟังก์ชัน รับค่า String ของ ชื่อ สถานี
 * รพีภัทร พึ่งผล 6821651698
 * ภาณุเดช อดิสรวรวุฒิ 6821651639
 */ 
public class Station {
    public static final int max_station = 20;
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
        assert nameStation != null : "nameStation is not null" ;
        assert nameStation.size() < max_station;

        Set<String> seen = new HashSet<>();
        for(String s : nameStation) {
            assert s != null ;
            assert s !=  "" ;
            assert seen.add(s);
        }
    }


    /**
     * ทำชื่อสถานีว่าง
    */
    public Station() {
        this.nameStation = new ArrayList<>();
        checkRep();
    }
    /**
     * สร้างหมวดสถานีจากชื่อที่ให้
     * @param name ชื่อสถานีที่ให้ ต้องไม่เป็น null สถานีต้องไม่เกิน 20 สถานี
     * @throws IllegalArgumentException เมื่อ name = null
     */
    public Station(List<String> name) {
        if(name == null) throw new IllegalArgumentException("name is null");
        if(name.size() > max_station) throw new IllegalArgumentException("name is full");

        Set<String> seen = new HashSet<>();
        for(String s : name) {
            if(s == null) throw new IllegalArgumentException();
            if(s=="") throw new IllegalArgumentException();
            if(!seen.add(s)) throw new IllegalArgumentException();
        }

        this.nameStation = new ArrayList<>(name);   
        checkRep(); 
    }

    /**
     * ฟังก์ชันคืนค่า จำนวนสถานี
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
     * @return ชื่อสถานีที่อยู่บนสุด
     * @throws EmptyStackException เมื่อว่าง
     */
   public String pop() {
        if (isEmpty()) throw new EmptyStackException();
        String top = nameStation.remove(nameStation.size() - 1);
        checkRep();
        return top;
    }

    /**
     * 
     * @param name ชื่อสถานีที่ต้องการเพิ่ม 
     * @return true เมื่อสามารถเพิ่มได้ false เมื่อมีชื่อสถานีซ้ำ เป็น null และ "" และ สถานีเต็ม
     * @throws IllegalArgumentException เมื่อ name = null เป็นข้อความเปล่าๆ มีชื่อซ้ำและใส่จนเต็ม 
     */
    public void push(String name) {
        if(name == null || name == "") throw new IllegalArgumentException();
        if(nameStation.contains(name)) throw new IllegalArgumentException();
        if(isFull()) throw new IllegalArgumentException();
        nameStation.add(name);
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
        return nameStation.size() >= max_station;
    }

    /***
     * อ่านชื่อสถานี โดยไม่ลบชื่อออก
     * @return ส่งขนาดของ namestation กลับ
     */
    public String peek() {
        if (isEmpty()) throw new EmptyStackException();
        return nameStation.get(nameStation.size());
    }

    /**
     * ฟังชันแก้ชื่อซ้ำสถานนี
     * 
     * @param original ชื่อสถานีเดิม
     * @param change ชื่อสถานีเพิ่มเติม
     * @return ชื่อสถานีที่แก้ไขแล้ว
     */
    public String changeName(String original , String change) {
        String new_name_station = original + change;
        return new_name_station;
    }
    
}