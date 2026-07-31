import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RobotGUI extends JFrame {
    private LayarLED layarLED;
    private JLabel labelWajah;
    private JLabel labelStatus;
    private JLabel labelBaterai;
    private JLabel labelTimer;

    // --- Komponen Display Materi (Dada Robot) ---
    private BankMateri bankMateri;
    private JLabel labelMatkul;
    private JLabel labelJudulMateri;
    private JTextArea areaIsiMateri;

    // --- Komponen Kaki Robot (Footer & Jam) ---
    private JLabel labelJam;
    private JLabel labelMotivasi;

    private Timer timerBaterai;
    private Timer timerPomodoro;
    private Timer timerJam;
    private int baterai = 100;
    private int sisaDetikPomodoro = 0;

    public RobotGUI() {
        layarLED = new LayarLED();
        bankMateri = new BankMateri();

        // Setup Frame Utama
        setTitle("Aplikasi Robot A.M.I.N.A.H");
        setSize(520, 730); // Ditinggikan sedikit agar Kaki Robot muat pas
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(40, 44, 52));

        // ==========================================
        // 1. PANEL ATAS (Baterai & Timer)
        // ==========================================
        JPanel panelAtas = new JPanel(new GridLayout(1, 2));
        panelAtas.setBackground(new Color(30, 34, 42));

        labelBaterai = new JLabel("🔋 Baterai: 100%", SwingConstants.CENTER);
        labelBaterai.setForeground(Color.GREEN);
        labelBaterai.setFont(new Font("Monospaced", Font.BOLD, 14));

        labelTimer = new JLabel("⏱️ Timer: OFF", SwingConstants.CENTER);
        labelTimer.setForeground(Color.CYAN);
        labelTimer.setFont(new Font("Monospaced", Font.BOLD, 14));

        panelAtas.add(labelBaterai);
        panelAtas.add(labelTimer);

        // ==========================================
        // 2. PANEL KEPALA ROBOT (Layar Wajah LED)
        // ==========================================
        JLabel labelAntena = new JLabel("📡   ||   📡", SwingConstants.CENTER);
        labelAntena.setFont(new Font("Monospaced", Font.BOLD, 18));
        labelAntena.setForeground(Color.LIGHT_GRAY);

        JPanel panelLayar = new JPanel(new GridLayout(2, 1));
        panelLayar.setBackground(Color.BLACK);
        panelLayar.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));

        labelWajah = new JLabel("( ^o^ )", SwingConstants.CENTER);
        labelWajah.setFont(new Font("Monospaced", Font.BOLD, 32));
        labelWajah.setForeground(Color.GREEN);

        labelStatus = new JLabel("Status: SENANG", SwingConstants.CENTER);
        labelStatus.setFont(new Font("Monospaced", Font.BOLD, 14));
        labelStatus.setForeground(Color.WHITE);

        panelLayar.add(labelWajah);
        panelLayar.add(labelStatus);

        JPanel panelKepalaUtuh = new JPanel(new BorderLayout(5, 5));
        panelKepalaUtuh.setBackground(new Color(70, 80, 95));

        TitledBorder borderKepala = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.CYAN, 2, true), 
            " KEPALA ROBOT A.M.I.N.A.H ", 
            TitledBorder.CENTER, 
            TitledBorder.TOP
        );
        borderKepala.setTitleColor(Color.CYAN);
        panelKepalaUtuh.setBorder(borderKepala);

        JLabel telingaKiri = new JLabel(" 🎛️ ");
        JLabel telingaKanan = new JLabel(" 🎛️ ");
        telingaKiri.setForeground(Color.LIGHT_GRAY);
        telingaKanan.setForeground(Color.LIGHT_GRAY);

        panelKepalaUtuh.add(labelAntena, BorderLayout.NORTH);
        panelKepalaUtuh.add(telingaKiri, BorderLayout.WEST);
        panelKepalaUtuh.add(panelLayar, BorderLayout.CENTER);
        panelKepalaUtuh.add(telingaKanan, BorderLayout.EAST);

        // ==========================================
        // 3. PANEL DADA ROBOT (Layar Tampil Materi)
        // ==========================================
        JPanel panelDada = new JPanel(new BorderLayout(8, 8));
        panelDada.setBackground(new Color(50, 56, 66));

        TitledBorder borderDada = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.ORANGE, 2, true),
            " DADA ROBOT (DISPLAY MATERI) ",
            TitledBorder.CENTER,
            TitledBorder.TOP
        );
        borderDada.setTitleColor(Color.ORANGE);
        panelDada.setBorder(borderDada);

        JPanel panelHeaderMateri = new JPanel(new GridLayout(2, 1));
        panelHeaderMateri.setOpaque(false);

        labelMatkul = new JLabel("MATA KULIAH", SwingConstants.CENTER);
        labelMatkul.setFont(new Font("SansSerif", Font.BOLD, 16));
        labelMatkul.setForeground(Color.YELLOW);

        labelJudulMateri = new JLabel("Judul Materi", SwingConstants.CENTER);
        labelJudulMateri.setFont(new Font("SansSerif", Font.BOLD, 13));
        labelJudulMateri.setForeground(Color.CYAN);

        panelHeaderMateri.add(labelMatkul);
        panelHeaderMateri.add(labelJudulMateri);

        areaIsiMateri = new JTextArea(4, 20);
        areaIsiMateri.setWrapStyleWord(true);
        areaIsiMateri.setLineWrap(true);
        areaIsiMateri.setEditable(false);
        areaIsiMateri.setBackground(new Color(25, 28, 34));
        areaIsiMateri.setForeground(Color.WHITE);
        areaIsiMateri.setFont(new Font("SansSerif", Font.PLAIN, 13));
        areaIsiMateri.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JScrollPane scrollMateri = new JScrollPane(areaIsiMateri);
        scrollMateri.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        panelDada.add(panelHeaderMateri, BorderLayout.NORTH);
        panelDada.add(scrollMateri, BorderLayout.CENTER);

        // ==========================================
        // 4. PANEL TANGAN / NAVIGASI (Tombol-Tombol)
        // ==========================================
        JPanel panelKontrol = new JPanel(new GridLayout(2, 2, 8, 8));
        panelKontrol.setOpaque(false);
        panelKontrol.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JButton btnSebelumnya = new JButton("◀️ Sebelumnya");
        JButton btnBerikutnya = new JButton("Berikutnya ▶️");
        JButton btnPomodoro = new JButton("⏳ Pomodoro (10s)");
        JButton btnIsiBaterai = new JButton("⚡ Isi Baterai");

        btnSebelumnya.addActionListener(e -> {
            hentikanPomodoro();
            tampilkanMateri(bankMateri.sebelumnya());
        });

        btnBerikutnya.addActionListener(e -> {
            hentikanPomodoro();
            tampilkanMateri(bankMateri.berikutnya());
        });

        btnPomodoro.addActionListener(e -> mulaiPomodoro());

        btnIsiBaterai.addActionListener(e -> {
            baterai = 100;
            labelBaterai.setText("🔋 Baterai: 100%");
            labelBaterai.setForeground(Color.GREEN);
            bip();
            ubahEkspresi(EkspresiWajah.SENANG, "(^o^)", "Status: BATERAI PENUH!");
        });

        panelKontrol.add(btnSebelumnya);
        panelKontrol.add(btnBerikutnya);
        panelKontrol.add(btnPomodoro);
        panelKontrol.add(btnIsiBaterai);

        // ==========================================
        // 5. PANEL KAKI ROBOT (Footer & Jam Digital)
        // ==========================================
        JPanel panelKaki = new JPanel(new BorderLayout(5, 5));
        panelKaki.setBackground(new Color(25, 28, 34));
        panelKaki.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(2, 0, 0, 0, Color.DARK_GRAY),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        labelMotivasi = new JLabel("🚀 Semangat Persiapan Semester 3!", SwingConstants.LEFT);
        labelMotivasi.setFont(new Font("SansSerif", Font.ITALIC, 12));
        labelMotivasi.setForeground(Color.LIGHT_GRAY);

        labelJam = new JLabel("🕒 00:00:00", SwingConstants.RIGHT);
        labelJam.setFont(new Font("Monospaced", Font.BOLD, 13));
        labelJam.setForeground(Color.YELLOW);

        panelKaki.add(labelMotivasi, BorderLayout.WEST);
        panelKaki.add(labelJam, BorderLayout.EAST);

        // ==========================================
        // SUSUN SEMUA BAGIAN KE FRAME UTAMA
        // ==========================================
        JPanel panelTengah = new JPanel(new BorderLayout(5, 5));
        panelTengah.setOpaque(false);
        panelTengah.add(panelKepalaUtuh, BorderLayout.NORTH);
        panelTengah.add(panelDada, BorderLayout.CENTER);

        JPanel panelBawahUtuh = new JPanel(new BorderLayout(5, 5));
        panelBawahUtuh.setOpaque(false);
        panelBawahUtuh.add(panelKontrol, BorderLayout.CENTER);
        panelBawahUtuh.add(panelKaki, BorderLayout.SOUTH);

        add(panelAtas, BorderLayout.NORTH);
        add(panelTengah, BorderLayout.CENTER);
        add(panelBawahUtuh, BorderLayout.SOUTH);

        // Tampilkan Materi Pertama & Jalankan Sistem Latar Belakang
        tampilkanMateri(bankMateri.getMateriSekarang());
        mulaiSistemBaterai();
        mulaiJamDigital(); // Jalankan Jam Kaki Robot
    }

    private void tampilkanMateri(Materi m) {
        labelMatkul.setText("📚 " + m.getMataKuliah());
        labelJudulMateri.setText(m.getJudul());
        areaIsiMateri.setText(m.getIsi());

        if (m.getEkspresiRekomendasi() == EkspresiWajah.POMODORO) {
            ubahEkspresi(EkspresiWajah.POMODORO, "( •_•)>⌐■-■", "Status: FOKUS BELAJAR");
        } else if (m.getEkspresiRekomendasi() == EkspresiWajah.ISTIRAHAT) {
            ubahEkspresi(EkspresiWajah.ISTIRAHAT, "( ˘ω˘ )zzZ", "Status: REHAT SEJENAK");
        } else {
            ubahEkspresi(EkspresiWajah.SENANG, "(^o^)", "Status: MENJELASKAN MATERI");
        }
    }

    private void ubahEkspresi(EkspresiWajah ekspresi, String simbol, String statusTeks) {
        layarLED.setEkspresi(ekspresi);
        labelWajah.setText(simbol);
        labelStatus.setText(statusTeks);
        bip();
    }

    private void bip() {
        Toolkit.getDefaultToolkit().beep();
    }

    private void mulaiSistemBaterai() {
        timerBaterai = new Timer(10000, e -> {
            if (baterai > 0) {
                baterai -= 1;
                labelBaterai.setText("🔋 Baterai: " + baterai + "%");

                if (baterai <= 20) {
                    labelBaterai.setForeground(Color.RED);
                    if (baterai == 20) {
                        ubahEkspresi(EkspresiWajah.BATERE_LEMAH, "(x_x)", "Status: BATERAI LEMAH!");
                    }
                }
            }
        });
        timerBaterai.start();
    }

    private void mulaiJamDigital() {
        // Timer memperbarui teks jam setiap 1 detik (1000 ms)
        timerJam = new Timer(1000, e -> {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String waktuSekarang = sdf.format(new Date());
            labelJam.setText("🕒 " + waktuSekarang);
        });
        timerJam.start();
    }

    private void mulaiPomodoro() {
        sisaDetikPomodoro = 10;
        ubahEkspresi(EkspresiWajah.POMODORO, "( •_•)>⌐■-■", "Status: FOKUS POMODORO");

        if (timerPomodoro != null && timerPomodoro.isRunning()) {
            timerPomodoro.stop();
        }

        timerPomodoro = new Timer(1000, e -> {
            if (sisaDetikPomodoro > 0) {
                labelTimer.setText("⏱️ Timer: " + sisaDetikPomodoro + "s");
                sisaDetikPomodoro--;
            } else {
                timerPomodoro.stop();
                labelTimer.setText("⏱️ Timer: SELESAI!");
                bip();
                ubahEkspresi(EkspresiWajah.ISTIRAHAT, "( ˘ω˘ )zzZ", "Status: WAKTUNYA ISTIRAHAT!");
            }
        });
        timerPomodoro.start();
    }

    private void hentikanPomodoro() {
        if (timerPomodoro != null && timerPomodoro.isRunning()) {
            timerPomodoro.stop();
            labelTimer.setText("⏱️ Timer: OFF");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RobotGUI().setVisible(true);
        });
    }
}