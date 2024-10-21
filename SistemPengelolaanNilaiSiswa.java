import java.util.*;

class Siswa {
    private String nama;
    private String NIS;
    private String kelas;
    private List<Double> nilai;
    private List<Double> riwayatNilai;
    private List<String> catatanGuru;

    public Siswa(String nama, String NIS, String kelas) {
        this.nama = nama;
        this.NIS = NIS;
        this.kelas = kelas;
        this.nilai = new ArrayList<>();
        this.riwayatNilai = new ArrayList<>();
        this.catatanGuru = new ArrayList<>();
    }

    public void tambahNilai(double nilaiBaru) {
        if (!nilai.isEmpty()) {
            riwayatNilai.add(nilai.get(nilai.size() - 1)); // Simpan nilai terakhir ke riwayat
        }
        nilai.add(nilaiBaru);
    }

    public List<Double> getNilai() {
        return nilai;
    }

    public String getNIS() {
        return NIS;
    }

    public String getNama() {
        return nama;
    }

    public String getKelas() {
        return kelas;
    }

    public List<Double> getRiwayatNilai() {
        return riwayatNilai;
    }

    public List<String> getCatatanGuru() {
        return catatanGuru;
    }
}

public class SistemPengelolaanNilaiSiswa {
    private static List<Siswa> daftarSiswa = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Input Data Siswa");
            System.out.println("2. Input Nilai Siswa");
            System.out.println("3. Hitung Rata-rata Keseluruhan Siswa");
            System.out.println("4. Tentukan Ranking Siswa");
            System.out.println("5. Input Catatan Guru");
            System.out.println("6. Tampilkan Data Siswa");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (pilihan) {
                case 1:
                    // Input Data Siswa
                    System.out.print("Masukkan Nama Siswa: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIS Siswa: ");
                    String NIS = scanner.nextLine();
                    System.out.print("Masukkan Kelas Siswa: ");
                    String kelas = scanner.nextLine();
                    daftarSiswa.add(new Siswa(nama, NIS, kelas));
                    System.out.println("Data berhasil di input\n");
                    break;

                case 2:
                    // Input Nilai Siswa
                    System.out.print("Masukkan NIS Siswa: ");
                    NIS = scanner.nextLine();
                    Siswa siswa = cariSiswa(NIS);
                    if (siswa != null) {
                        System.out.print("Masukkan Nilai: ");
                        double nilai = scanner.nextDouble();
                        siswa.tambahNilai(nilai);
                        System.out.println("Data berhasil di input\n");
                    } else {
                        System.out.println("Siswa tidak ditemukan.");
                    }
                    break;

                case 3:
                    // Hitung Rata-rata Keseluruhan Siswa
                    double totalRata = 0;
                    int totalNilai = 0;

                    for (Siswa s : daftarSiswa) {
                        for (double n : s.getNilai()) {
                            totalRata += n;
                            totalNilai++;
                        }
                    }

                    double rataKeseluruhan = totalNilai > 0 ? totalRata / totalNilai : 0;
                    System.out.printf("Rata-rata keseluruhan siswa: %.1f%n", rataKeseluruhan);
                    break;

                case 4:
                    // Tentukan Ranking Siswa
                    daftarSiswa.sort((s1, s2) -> {
                        double rata1 = s1.getNilai().stream().mapToDouble(Double::doubleValue).average().orElse(0);
                        double rata2 = s2.getNilai().stream().mapToDouble(Double::doubleValue).average().orElse(0);
                        return Double.compare(rata2, rata1); // Descending order
                    });
                    System.out.println("Ranking Siswa:");
                    for (int i = 0; i < daftarSiswa.size(); i++) {
                        double rataRata = daftarSiswa.get(i).getNilai().stream().mapToDouble(Double::doubleValue).average().orElse(0);
                        System.out.printf("%d. %s - Rata-rata: %.1f%n", (i + 1), daftarSiswa.get(i).getNama(), rataRata);
                    }
                    break;

                case 5:
                    // Input Catatan Guru
                    System.out.print("Masukkan NIS Siswa: ");
                    NIS = scanner.nextLine();
                    siswa = cariSiswa(NIS);
                    if (siswa != null) {
                        System.out.print("Masukkan Catatan Guru: ");
                        String catatan = scanner.nextLine();
                        siswa.getCatatanGuru().add(catatan);
                        System.out.println("Data berhasil di input\n");
                    } else {
                        System.out.println("Siswa tidak ditemukan.");
                    }
                    break;

                case 6:
                    // Tampilkan Data Siswa
                    for (Siswa s : daftarSiswa) {
                        System.out.println("Nama: " + s.getNama() +
                                ", NIS: " + s.getNIS() +
                                ", Kelas: " + s.getKelas());
                        System.out.println("Nilai: " + s.getNilai());
                        System.out.println("Riwayat Perubahan Nilai: " + s.getRiwayatNilai());
                        System.out.println("Catatan Guru: " + s.getCatatanGuru() + "\n");
                    }
                    break;

                case 7:
                    // Keluar
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
        scanner.close();
    }

    private static Siswa cariSiswa(String input) {
        for (Siswa s : daftarSiswa) {
            if (s.getNIS().equals(input) || s.getNama().equalsIgnoreCase(input)) {
                return s;
            }
        }
        return null;
    }
}
