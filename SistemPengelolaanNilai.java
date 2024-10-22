import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Kelas Siswa - Anggota 3; Mengelola data siswa dan menampilkan grafik
class Siswa {
    private String nama;
    private String id;
    private List<Double> nilai;

    public Siswa(String nama, String id) {
        this.nama = nama;
        this.id = id;
        this.nilai = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public String getId() {
        return id;
    }

    public void tambahNilai(double nilai) {
        this.nilai.add(nilai);
    }

    public List<Double> getNilai() {
        return nilai;
    }

    public double hitungRataRata() {
        if (nilai.isEmpty()) return 0.0;
        double total = 0.0;
        for (double n : nilai) {
            total += n;
        }
        return total / nilai.size();
    }
}

// Kelas PengelolaSiswa - Anggota 3; Mengelola siswa untuk grafik
class PengelolaSiswa {
    private List<Siswa> siswaList = new ArrayList<>();

    public void tambahSiswa(Siswa siswa) {
        siswaList.add(siswa);
    }

    public List<Siswa> getSiswaList() {
        return siswaList;
    }
}

// Kelas GrafikPerkembangan - Anggota 3: Tampilkan grafik dan notifikasi
class GrafikPerkembangan {

    // Tampilkan grafik perkembangan nilai siswa
    public void tampilkanGrafik(List<Siswa> siswaList) {
        System.out.println("Grafik perkembangan nilai siswa:");
        for (Siswa siswa : siswaList) {
            System.out.print(siswa.getNama() + ": ");
            for (double nilai : siswa.getNilai()) {
                System.out.print("*"); // Menampilkan bintang untuk setiap nilai
            }
            System.out.println(" (Nilai: " + siswa.getNilai() + ", Rata-rata: " + siswa.hitungRataRata() + ")");
        }
    }

    // Notifikasi perkembangan siswa
    public void notifikasiPerkembangan(Siswa siswa) {
        double rataRata = siswa.hitungRataRata();
        System.out.println("Notifikasi perkembangan untuk " + siswa.getNama() + ":");
        if (rataRata >= 75) {
            System.out.println("Selamat! Rata-rata Anda adalah " + rataRata + ", sangat baik!");
        } else if (rataRata >= 50) {
            System.out.println("Anda berada di jalur yang benar. Rata-rata Anda adalah " + rataRata + ".");
        } else {
            System.out.println("Perlu perbaikan. Rata-rata Anda adalah " + rataRata + ".");
        }
    }
}

// Kelas Utama - Mengelola interaksi pengguna
public class SistemPengelolaanNilai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PengelolaSiswa pengelola = new PengelolaSiswa();

        // Input data siswa
        System.out.print("Masukkan Nama Siswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan ID Siswa: ");
        String id = scanner.nextLine();

        Siswa siswa = new Siswa(nama, id);
        pengelola.tambahSiswa(siswa);

        // Input nilai siswa
        System.out.print("Masukkan Nilai Siswa (ketik -1 untuk selesai): ");

        while (true) {
            double nilai = scanner.nextDouble();
            if (nilai == -1) break; // Menghentikan input jika pengguna mengetik -1
            siswa.tambahNilai(nilai);
            System.out.println("Nilai " + nilai + " telah ditambahkan.");
        }

        // Tampilkan grafik perkembangan dan notifikasi
        GrafikPerkembangan grafik = new GrafikPerkembangan();
        grafik.tampilkanGrafik(pengelola.getSiswaList());

        for (Siswa s : pengelola.getSiswaList()) {
            grafik.notifikasiPerkembangan(s);
        }

        scanner.close();
    }
}
