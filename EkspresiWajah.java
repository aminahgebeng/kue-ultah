public enum EkspresiWajah {
    SENANG("(^o^)"),
    POMODORO("( •_•)>⌐■-■"),
    ISTIRAHAT("( ˘ω˘ )zzZ"),
    BATERE_LEMAH("(x_x)");

    private final String tampilan;

    EkspresiWajah(String tampilan) {
        this.tampilan = tampilan;
    }

    public String getTampilan() {
        return tampilan;
    }
}