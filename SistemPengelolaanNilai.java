import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//Kelas Siswa- Anggota 3; Mengelola data siswa dan menampilkan grafik
class Siswa {
  private String nama;
  private String id;
  private List<Double> nilai;

  public Siswa(String nama,String id}){
  this.nama = nama;
    this.id = id;
    this.nilai = new ArrayList<>0;
}
  public String getNama(){
    return nama;
  }
  public String getld(){
    return id;
  }
  public void tambahNIlai(doublenilai){
    this.nilai.add(nilai);
  }
  public List<Double> getNilai(){
    return nilai;
  }
}

//Kelas PengelolaSiswa - Anggota 3; Mengelola siswa untuk grafik 
class Pengelola Siswa{
  private List<siswa> = new
  ArrayList<>0;
}

 public void tambahSiswa(Siswa siswa) {
        siswaList.add(siswa);
    }

    public List<Siswa> getSiswaList() {
        return siswaList;
    }
}
// Kelas GrafikPerkembangan - Anggota 3: Tampilkan grafik dan notifikasi
class GrafikPerkembangan {
    // Anggota 3: Tampilkan grafik perkembangan nilai siswa
    public void tampilkanGrafik(List<Siswa> siswaList) {
      
        // Implementasi untuk menampilkan grafik perkembangan nilai siswa
        System.out.println("Grafik perkembangan nilai siswa (fungsi belum diimplementasikan).");
    }

    // Anggota 3: Notifikasi perkembangan siswa
    public void notifikasiPerkembangan(Siswa siswa) {
      
        // Implementasi untuk memberikan notifikasi perkembangan
        System.out.println("Notifikasi perkembangan untuk " + siswa.getNama() + " (fungsi belum diimplementasikan).");
    }
}

// Kelas Utama - Mengelola interaksi pengguna
public class Main {
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
        System.out.print("Masukkan Nilai Siswa: ");
        double nilai = scanner.nextDouble();
        siswa.tambahNilai(nilai);

        // Tampilkan grafik perkembangan dan notifikasi - Anggota 3
        GrafikPerkembangan grafik = new GrafikPerkembangan();
        grafik.tampilkanGrafik(pengelola.getSiswaList());
        grafik.notifikasiPerkembangan(siswa);
    }
}

  
