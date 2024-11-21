import java.util.Scanner;

public class Kuis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Data wilayah dan kategori
        String[] wilayah = {"Jakarta", "Malang", "Surabaya"};
        String[] kategori = {"Makanan", "Pakaian", "Obat-obatan"};

        // Donasi
        int[][] donasi = new int[wilayah.length][kategori.length];

        // Input donasi
        System.out.println("=============================================");
        System.out.println("Masukkan data donasi per wilayah dan kategori:");
        System.out.println("=============================================");
        System.out.println("                                             ");
        for (int i = 0; i < wilayah.length; i++) {
            System.out.println("Wilayah: " + wilayah[i]);
            for (int j = 0; j < kategori.length; j++) {
                System.out.print("  Donasi untuk kategori " + kategori[j] + ": ");
                donasi[i][j] = scanner.nextInt();
            }
        }

        // Tabel donasi
        System.out.println("\nTabel Donasi:");
        System.out.println("----------------------------------------------------");
        System.out.print("Wilayah           ");
        for (String k : kategori) {
            System.out.print(k + "       ");
        }
        System.out.println();

        for (int i = 0; i < wilayah.length; i++) {
            System.out.print(wilayah[i]);
            int spaces = 17 - wilayah[i].length(); 
            for (int s = 0; s < spaces; s++) {
                System.out.print(" ");
            }
            for (int j = 0; j < kategori.length; j++) {
                System.out.print(donasi[i][j] + "           ");
            }
            System.out.println();
        }

        // Total donasi per kategori
        System.out.println("\nPersentase donasi per kategori:");
        System.out.println("----------------------------------------------------");
        int totalDonasi = 0;
        int[] totalPerKategori = new int[kategori.length];
        for (int i = 0; i < wilayah.length; i++) {
            for (int j = 0; j < kategori.length; j++) {
                totalDonasi += donasi[i][j];
                totalPerKategori[j] += donasi[i][j];
            }
        }

        for (int j = 0; j < kategori.length; j++) {
            System.out.println("  " + kategori[j] + ": " + (totalPerKategori[j] * 100 / totalDonasi) + "%");
        }

        // Total kontribusi per wilayah
        System.out.println("\nTotal kontribusi per wilayah:");
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < wilayah.length; i++) {
            int totalWilayah = 0;
            for (int j = 0; j < kategori.length; j++) {
                totalWilayah += donasi[i][j];
            }
            System.out.println("  " + wilayah[i] + ": " + totalWilayah);
        }

        // Menentukan wilayah
        System.out.println("\nWilayah dengan kontribusi terbesar per kategori:");
        System.out.println("----------------------------------------------------");
        for (int j = 0; j < kategori.length; j++) {
            int maxDonasi = 0;
            String wilayahTerbesar = "";
            for (int i = 0; i < wilayah.length; i++) {
                if (donasi[i][j] > maxDonasi) {
                    maxDonasi = donasi[i][j];
                    wilayahTerbesar = wilayah[i];
                }
            }
            System.out.println("  " + kategori[j] + ": " + wilayahTerbesar + " (" + maxDonasi + ")");
        }
    }
}
