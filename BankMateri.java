import java.util.ArrayList;
import java.util.List;

public class BankMateri {
    private List<Materi> daftarMateri;
    private int indeksSekarang;

    public BankMateri() {
        daftarMateri = new ArrayList<>();
        indeksSekarang = 0;

        // --- MATERI KURIKULUM SEMESTER 3 ---

        // 1. Data Mining
        daftarMateri.add(new Materi(
            "Data Mining",
            "Konsep Klasifikasi vs Klasterisasi",
            "Klasifikasi menggunakan data berlabel (Supervised Learning, contoh: Decision Tree), sedangkan Klasterisasi mengelompokkan data tanpa label (Unsupervised Learning, contoh: K-Means).",
            EkspresiWajah.POMODORO
        ));

        // 2. Metode Numerik
        daftarMateri.add(new Materi(
            "Metode Numerik",
            "Penyelesaian Persamaan Non-Linier",
            "Metode Numerik digunakan untuk mencari solusi pendekatan (aproksimasi) secara matematis ketika rumus analitis/persamaan sulit atau tidak bisa diselesaikan secara presisi.",
            EkspresiWajah.POMODORO
        ));

        // 3. Pemrograman Berorientasi Objek
        daftarMateri.add(new Materi(
            "Pemrograman Berorientasi Objek",
            "4 Pilar Utama PBO",
            "OOP bertumpu pada 4 pilar: Encapsulation (pembungkusan data), Inheritance (pewarisan sifat), Polymorphism (banyak bentuk), dan Abstraction (penyembunyian detail rumit).",
            EkspresiWajah.SENANG
        ));

        // 4. Pemrograman Web Native
        daftarMateri.add(new Materi(
            "Pemrograman Web Native",
            "Segitiga Emas Web Native",
            "HTML bertugas membangun struktur halaman, CSS mengatur tampilan visual & desain layout, sedangkan JavaScript memberikan fungsionalitas interaktif pada website.",
            EkspresiWajah.SENANG
        ));

        // 5. Rekayasa Perangkat Lunak
        daftarMateri.add(new Materi(
            "Rekayasa Perangkat Lunak",
            "Model Pengembangan SDLC",
            "Software Development Life Cycle (SDLC) mencakup tahapan analisis, desain, koding, pengujian, dan perawatan. Metode populer meliputi Waterfall (sekuensial) dan Agile (fleksibel).",
            EkspresiWajah.SENANG
        ));

        // 6. Sistem Mikrokontroler
        daftarMateri.add(new Materi(
            "Sistem Mikrokontroler",
            "Prinsip Kerja GPIO & Sensor",
            "Mikrokontroler adalah komputer kecil dalam satu chip. Pin GPIO (General Purpose Input/Output) digunakan untuk membaca data dari sensor dan mengendalikan aktuator (seperti LED/Motor).",
            EkspresiWajah.POMODORO
        ));

        // 7. Sistem Operasi Komputer
        daftarMateri.add(new Materi(
            "Sistem Operasi Komputer",
            "Manajemen Proses & Deadlock",
            "Sistem Operasi mengelola eksekusi program (proses) dan alokasi memori. Deadlock terjadi ketika dua atau lebih proses saling menunggu sumber daya yang sedang dikunci satu sama lain.",
            EkspresiWajah.SENANG
        ));

        // 8. Teknologi Jaringan Komputer
        daftarMateri.add(new Materi(
            "Teknologi Jaringan Komputer",
            "Model Layer OSI vs TCP/IP",
            "OSI Model membagi komunikasi jaringan menjadi 7 layer (Application hingga Physical), sedangkan TCP/IP menyederhanakannya menjadi 4 layer utama untuk standar transmisi internet.",
            EkspresiWajah.POMODORO
        ));
    }

    public Materi getMateriSekarang() {
        return daftarMateri.get(indeksSekarang);
    }

    public Materi berikutnya() {
        indeksSekarang = (indeksSekarang + 1) % daftarMateri.size();
        return getMateriSekarang();
    }

    public Materi sebelumnya() {
        indeksSekarang = (indeksSekarang - 1 + daftarMateri.size()) % daftarMateri.size();
        return getMateriSekarang();
    }
}