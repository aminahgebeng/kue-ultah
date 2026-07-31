public class Materi {
    private String mataKuliah;
    private String judul;
    private String isi;
    private EkspresiWajah ekspresiRekomendasi;

    public Materi(String mataKuliah, String judul, String isi, EkspresiWajah ekspresiRekomendasi) {
        this.mataKuliah = mataKuliah;
        this.judul = judul;
        this.isi = isi;
        this.ekspresiRekomendasi = ekspresiRekomendasi;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public String getJudul() {
        return judul;
    }

    public String getIsi() {
        return isi;
    }

    public EkspresiWajah getEkspresiRekomendasi() {
        return ekspresiRekomendasi;
    }
}