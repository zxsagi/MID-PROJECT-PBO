import java.util.*;

class Siswa {
    private String nama;
    private List<Integer> nilaiList = new ArrayList<>();
    private List<String> riwayatPerubahan = new ArrayList<>();

    public Siswa(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public List<Integer> getNilaiList() {
        return nilaiList;
    }

    public void tambahNilai(int nilai) {
        nilaiList.add(nilai);
        riwayatPerubahan.add("Nilai " + nilai + " ditambahkan.");
    }

    public List<String> getRiwayatPerubahan() {
        return riwayatPerubahan;
    }

    @Override
    public String toString() {
        return "Siswa{" +
                "nama='" + nama + '\'' +
                ", nilai=" + nilaiList +
                '}';
    }
}

class PengelolaanSiswa {
    private List<Siswa> siswaList = new ArrayList<>();