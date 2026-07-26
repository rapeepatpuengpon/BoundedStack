public class Price {
    /**
     * ฟังก์ชัยคำนวณค่าโดยสาร
     * 
     * @param start สถานีเริ่มต้น
     * @param stop สถานนีปลายทาง
     * @return ส่งค่าโดยสารกลับ
     */
    static int Calprice(int start, int stop) {
        int all_station = 20;
        int distence = Math.abs(start - stop);
        int train_loop = all_station - distence;
        int count_station = Math.min(distence, train_loop);
        int sum = 0 ; 
        if(count_station == 0){ 
            sum = 0;
        }
            else if(count_station <= 5) {
                sum = 20;
            }
                else {
                  sum = 20 +((count_station - 5) * 2 );  
                }
        return sum ;
    }
}
