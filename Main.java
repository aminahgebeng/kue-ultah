public class Main {
    public static void main(String[] args) {
        System.out.println("=== MENYALAKAN ROBOT A.M.I.N.A.H ===");
        
        // Memunculkan komponen Layar LED
        LayarLED layar = new LayarLED();
        
        // Tes ganti-ganti ekspresi robot!
        layar.setEkspresi(EkspresiWajah.SENANG);
        layar.setEkspresi(EkspresiWajah.POMODORO);
        layar.setEkspresi(EkspresiWajah.ISTIRAHAT);
    }
}