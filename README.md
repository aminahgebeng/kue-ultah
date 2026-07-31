# Laporan Proyek Robot A.M.I.N.A.H
**Pembuat:** Aminah  
**Tanggal:** 30 Juli 2026  

---

## 1. Deskripsi Proyek
Proyek ini adalah simulasi sistem robot belajar A.M.I.N.A.H menggunakan konsep Object-Oriented Programming (OOP) dengan bahasa pemrograman Java.

## 2. Struktur Class (UML)
* **EkspresiWajah**: Modul Enum untuk menyimpan daftar pilihan ekspresi robot.
* **LayarLED**: Modul Class untuk mengubah dan menampilkan ekspresi visual robot.
* **Main**: Program utama untuk menjalankan dan menguji fungsi sistem robot.

## 3. Hasil Pengujian (Terminal Output)
```text
=== MENYALAKAN ROBOT A.M.I.N.A.H ===

[LAYAR LED] Ekspresi Berubah menjadi: SENANG
Wajah Robot: (^o^)
------------------------------------
[LAYAR LED] Ekspresi Berubah menjadi: POMODORO
Wajah Robot: ( •_•)>⌐■-■
------------------------------------
[LAYAR LED] Ekspresi Berubah menjadi: ISTIRAHAT
Wajah Robot: ( ˘ω˘ )zzZ

# Laporan Proyek Robot A.M.I.N.A.H
**Pembuat:** Aminah  
**Tanggal:** 31 Juli 2026  

---

## 1. Deskripsi Proyek
Proyek ini adalah simulasi asisten belajar virtual berbasis GUI (Graphical User Interface) bernama **Robot A.M.I.N.A.H**. Aplikasi ini dirancang menggunakan konsep *Object-Oriented Programming* (OOP) dengan bahasa pemrograman Java Swing untuk membantu manajemen waktu belajar (Pomodoro) serta menampilkan materi perkuliahan Semester 3.

---

## 2. Struktur Class (UML / Arsitektur Program)
* **`EkspresiWajah`**: Enum untuk menyimpan daftar pilihan ekspresi robot (`SENANG`, `POMODORO`, `ISTIRAHAT`, dll).
* **`Robot`**: Class logika utama untuk mengelola status baterai dan ekspresi robot.
* **`RobotGUI`**: Tampilan visual utama (Java Swing) yang mencakup indikator baterai, timer Pomodoro, serta bingkai kepala dan wajah LED robot.
* **`Materi`**: Model data untuk menyimpan atribut mata kuliah, judul, isi materi, dan ekspresi rekomendasi.
* **`BankMateri`**: Pengelola koleksi materi perkuliahan Semester 3 (Data Mining, PBO, Web Native, RPL, dll) beserta fungsi navigasinya.
* **`Main`**: Program utama untuk menjalankan dan menginisialisasi GUI Robot A.M.I.N.A.H.

---

## 3. Fitur Utama & Hasil Tampilan (GUI)
* **Visual Kepalan Robot & Layar LED:** Antarmuka bergaya cyberpunk/neon yang menampilkan ekspresi ASCII dinamis.
* **Sistem Baterai & Sound Indicator:** Simulasi pengisian daya baterai dan sinyal audio (*beep*).
* **Timer Pomodoro (10s Mode):** Fitur pengingat waktu fokus belajar.
* **Modul Materi Semester 3:** Integrasi 8 mata kuliah utama untuk persiapan belajar interaktif.

---

## 4. Hasil Pengujian GUI & Terminal
```text
=== MENYALAKAN ROBOT A.M.I.N.A.H ===
[SISTEM] GUI Berhasil Dimuat.
[BATERAI] Status: 97% | Charging...
[LAYAR LED] Ekspresi Berubah menjadi: SENANG
Wajah Robot: (^o^)

[TIMER] Pomodoro Aktif (10 Detik)
[LAYAR LED] Ekspresi Berubah menjadi: POMODORO
Wajah Robot: ( •_•)>⌐■-■

[STATUS] Timer Selesai - Beep Sound Fired!

# Laporan Proyek Robot A.M.I.N.A.H
**Pembuat:** Aminah  
**Tanggal:** 1 Agustus 2026  

---

## 1. Deskripsi Proyek
Proyek ini adalah simulasi asisten belajar virtual berbasis GUI (Graphical User Interface) bernama **Robot A.M.I.N.A.H**. Aplikasi ini dibangun menggunakan konsep *Object-Oriented Programming* (OOP) dengan bahasa pemrograman Java Swing untuk membantu manajemen waktu belajar (Pomodoro) serta menampilkan materi perkuliahan Semester 3 secara interaktif.

---

## 2. Struktur Class (UML / Arsitektur Program)
* **`EkspresiWajah`**: Enum untuk menyimpan daftar pilihan ekspresi visual robot (`SENANG`, `POMODORO`, `ISTIRAHAT`, `BATERE_LEMAH`).
* **`LayarLED`**: Class modul visual untuk mengelola dan merender ekspresi ASCII pada layar robot.
* **`Materi`**: Model data yang menyimpan informasi mata kuliah, judul, rangkuman isi materi, serta rekomendasi ekspresi robot.
* **`BankMateri`**: Pengelola koleksi 8 mata kuliah Semester 3 (Data Mining, PBO, Web Native, RPL, dll) lengkap dengan fungsi navigasi (*Next/Previous*).
* **`RobotGUI`**: Class antarmuka utama (Java Swing) yang merender struktur fisik robot secara utuh (Kepala, Dada, Tangan/Navigasi, Kaki/Status Footer, Timer Pomodoro, Indikator Baterai, dan Jam Digital Real-Time).
* **`Main`**: Program utama untuk menginisialisasi dan menjalankan aplikasi.

---

## 3. Komponen Fisik & Fitur Utama Robot
1. **Atas (Status System):**
   * Indikator Baterai (*Battery Drain Simulation*) & Timer Pomodoro (10 detik).
2. **Kepala Robot (Layar LED Wajah):**
   * Bingkai cyan berdesain cyberpunk dengan ekspresi ASCII dinamis dan sinyal audio (*beep sound*).
3. **Dada Robot (Display Utama Materi):**
   * Layar khusus untuk menampilkan judul mata kuliah dan rangkuman materi pembelajaran Semester 3.
4. **Tangan Robot (Panel Kontrol Navigasi):**
   * Tombol `Sebelumnya`, `Berikutnya`, `Pomodoro`, dan `Isi Baterai` untuk interaksi pengguna.
5. **Kaki Robot (Status Bar / Footer):**
   * Berisi teks motivasi belajar di sisi kiri serta **Jam Digital Real-Time** di sisi kanan yang berdetik secara *live*.

---

## 4. Hasil Pengujian GUI & Terminal Output
```text
=== MENYALAKAN ROBOT A.M.I.N.A.H ===
[SISTEM] GUI Berhasil Dimuat.
[SISTEM] Jam Digital Real-Time Aktif di Kaki Robot.
[BATERAI] Status: 100% | Normal
[LAYAR LED] Ekspresi Berubah: SENANG -> (^o^)

[NAVIGASI] Berpindah ke Materi: Data Mining
[LAYAR LED] Ekspresi Berubah: POMODORO -> ( •_•)>⌐■-■
[DADA] Tampil Rangkuman: Klasifikasi vs Klasterisasi

[TIMER] Pomodoro Aktif (10s Mode)
[STATUS] Timer Selesai - Beep Sound Fired!
[LAYAR LED] Ekspresi Berubah: ISTIRAHAT -> ( ˘ω˘ )zzZ
