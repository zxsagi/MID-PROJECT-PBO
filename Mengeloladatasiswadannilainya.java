import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Kelas Siswa - Anggota 1: Mengelola data siswa dan nilainya
class Siswa {
    private String nama;
    private String id;
    private List<Double> nilai;
    private List<String> catatanGuru;

    public Siswa(String nama, String id) {
        this.nama = nama;
        this.id = id;
        this.nilai = new ArrayList<>();
        this.catatanGuru = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public String getId() {
        return id;
    }

    // Anggota 1: Input nilai siswa
    public void tambahNilai(double nilai) {
        this.nilai.add(nilai);
    }

    public List<Double> getNilai() {
        return nilai;
    }

    public List<String> getCatatanGuru() {
        return catatanGuru;
    }
}

// Kelas PengelolaSiswa - Anggota 1: Mengelola data siswa dan fungsi lainnya
class PengelolaSiswa {
    private List<Siswa> siswaList;

    public PengelolaSiswa() {
        this.siswaList = new ArrayList<>();
    }

    // Getter untuk daftar siswa
    public List<Siswa> getSiswaList() {
        return siswaList;
    }

    // Anggota 1: Input data siswa
    public void tambahSiswa(Siswa siswa) {
        siswaList.add(siswa);
    }

    // Anggota 1: Tampilkan data siswa dan nilainya
    public void tampilkanDataSiswa() {
        for (Siswa siswa : siswaList) {
            System.out.println("Nama: " + siswa.getNama() + ", ID: " + siswa.getId());
            System.out.println("Nilai: " + siswa.getNilai());
        }
    }

    // Anggota 1: Export data siswa
    public void exportData() {
        // Implementasi untuk mengekspor data siswa (misalnya ke file CSV)
        System.out.println("Data siswa berhasil diekspor (fungsi belum diimplementasikan).");
    }
}

// Kelas Utama - Mengelola interaksi pengguna
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PengelolaSiswa pengelola = new PengelolaSiswa();

        // Contoh input siswa - Anggota 1
        System.out.print("Masukkan Nama Siswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan ID Siswa: ");
        String id = scanner.nextLine();
        Siswa siswa = new Siswa(nama, id);
        pengelola.tambahSiswa(siswa);

        // Input nilai - Anggota 1
        System.out.print("Masukkan Nilai Siswa: ");
        double nilai = scanner.nextDouble();
        siswa.tambahNilai(nilai);
        scanner.nextLine(); // Membersihkan newline dari nextDouble()

        // Tampilkan data siswa - Anggota 1
        pengelola.tampilkanDataSiswa();

        // Export data - Anggota 1
        pengelola.exportData();
    }
}
