public class LayarLED {
    private EkspresiWajah ekspresiSekarang;

    public LayarLED() {
        this.ekspresiSekarang = EkspresiWajah.SENANG;
    }

    public void setEkspresi(EkspresiWajah ekspresiBaru) {
        this.ekspresiSekarang = ekspresiBaru;
        tampilkanKeLayar();
    }

    private void tampilkanKeLayar() {
        System.out.println("----------------------------------------");
        System.out.println("[LAYAR LED] Ekspresi Berubah menjadi: " + ekspresiSekarang);
        System.out.println("Wajah Robot: " + ekspresiSekarang.getTampilan());
        System.out.println("----------------------------------------");
    }
}