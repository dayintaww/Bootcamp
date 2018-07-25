/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bootcamp;

import java.util.Scanner;
/**
 *
 * @author Dayinta Warih Wulandari
 */
public class Converter {
    /**
     * membuat 4 variabel array untuk menampung bilangan binner, desimal, oktal, dan heksa
     */
    String binner[] = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
    int desimal[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int oktal[] = {0, 1, 2, 3, 4, 5, 6, 7};
    String heksa[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
    
    /**
     * Fungsi untuk mengkonversi bilangan desimal menjadi bilangan oktal
     * @param des inputan berupa bilangan desimal dengan tipe data integer
     * @return hasil konversi yaitu bilangan oktal dengan tipe data String
     */
    public String desToOktal(int des) {
        String hslfix = "";
        int sisa = des;
        int temp = 0;
        do {
            temp = des / 8;
            sisa = des % 8;
            des = temp;
            hslfix += sisa;
            if (temp == 1) {
                hslfix += temp;
            }
        } while (temp > 2);
        StringBuffer balik;
        balik = new StringBuffer(hslfix);
        String hslfinal = balik.reverse().toString();
        return hslfinal;
    }

    /**
     * Fungsi untuk mengkonversi bilangan desimal menjadi bilangan biner
     * @param des inputan berupa bilangan desimal dengan tipe data integer
     * @return hasil konversi yaitu bilangan binner dengan tipe data String
     */
    public String desToBiner(int des) {
        String hslfix = "";
        int sisa = des;
        int temp = 0;
        int i = 0;
        do {
            temp = des / 2;
            sisa = des % 2;
            des = temp;
            if (temp == 1) {
                hslfix += sisa;
            }
            hslfix += sisa;
        } while (temp > 2);
        StringBuffer balik;
        balik = new StringBuffer(hslfix);
        String hslfinal = balik.reverse().toString();
        return hslfinal;
    }

    /**
     * Fungsi untuk mengkonversi bilangan desimal menjadi bilangan Hexa
     * @param des inputan berupa bilangan desimal dengan tipe data integer
     * @return hasil konversi yaitu bilangan hexa dengan tipe data String
     */
    public String desToHexa(int des) {
        String hslfix = "";
        int sisa = des;
        int temp = 0;
        int i = 1;
        String sisaFix = "";
        do {
            temp = des / 16;
            sisa = des % 16;
            des = temp;
            if (sisa == 10) {
                sisaFix = "A";
            } else if (sisa == 11) {
                sisaFix = "B";
            } else if (sisa == 12) {
                sisaFix = "C";
            } else if (sisa == 13) {
                sisaFix = "D";
            } else if (sisa == 14) {
                sisaFix = "E";
            } else if (sisa == 15) {
                sisaFix = "F";
            } else {
                sisaFix = Integer.toString(sisa);
            }
            hslfix += sisaFix;
            if (temp == 1) {
                hslfix += temp;
            }
        } while (temp > 2);
        StringBuffer balik;
        balik = new StringBuffer(hslfix);
        String hslfinal = balik.reverse().toString();
        return hslfinal;
    }

    /**
     * Fungsi untuk mengkonversi bilangan oktal menjadi bilangan binner
     * @param okt inputan berupa bilangan oktal dengan tipe data integer
     * @return hasil konversi yaitu bilangan binner dengan tipe data String
     */
    public String oktalToBiner(int okt) {
        String num = String.valueOf(okt);
        int hasilOtoB[] = new int[num.length()];
        String hsl[] = new String[num.length()];
        String hslfix = "";
        for (int i = 0; i < num.length(); i++) {
            hasilOtoB[i] = Character.digit(num.charAt(i), 10);
        }
        for (int i = 0; i < hasilOtoB.length; i++) {
            for (int j = 0; j < oktal.length; j++) {
                if (hasilOtoB[i] == oktal[j]) {
                    hsl[i] = binner[j];
                }
            }
            hslfix += hsl[i];
        }
        return hslfix;
    }

    /**
     * Fungsi untuk mengkonversi bilangan oktal menjadi bilangan desimal
     * @param okt inputan berupa bilangan oktal dengan tipe data integer
     * @return hasil konversi yaitu bilangan desimal dengan tipe data integer
     */
    public int oktalToDesimal(int okt) {
        int basis = 8;
        String num = String.valueOf(okt);
        int hsl[] = new int[num.length()];
        int hasilBtoD[] = new int[num.length()];
        int hslfix = 0;
        for (int i = 0; i < num.length(); i++) {
            hasilBtoD[i] = Character.digit(num.charAt(i), 10);
        }
        int a = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            hsl[i] = hasilBtoD[i] * ((int) Math.pow(basis, 0 + a));
            hslfix += hsl[i];
            a++;
        }
        return hslfix;
    }

    /**
     * Fungsi untuk mengkonversi bilangan oktal menjadi bilanganhexa
     * @param okt inputan berupa bilangan oktal dengan tipe data integer
     * @return hasil konversi yaitu bilangan hexa dengan tiped ata String
     */
    public String oktalToHexa(int okt) {
        Converter c = new Converter();
        int temp = c.oktalToDesimal(okt);
        String hslfinal = c.desToHexa(temp);
        return hslfinal;
    }

    /**
     * Fungsi untuk mengkonversi bilangan hexa menjadi bilangan desimal
     * @param hex inputan berupa bilangan hexa dengan tipe data String
     * @return hasil konversi yaitu bilangan desima dengan tipe data integer
     */
    public int hexaToDesimal(String hex) {
        int basis = 16;
        String ch[] = hex.split("");
        String hasilHtoD[] = new String[ch.length];
        int hslfix = 0;
        int temp = 0;
        for (int i = 0; i < ch.length; i++) {
            hasilHtoD[i] = ch[i];
        }
        int hsl[] = new int[hasilHtoD.length];
        int a = 0;
        for (int i = hasilHtoD.length - 1; i >= 0; i--) {
            if (hasilHtoD[i].equals("A")) {
                temp = 10;
            } else if (hasilHtoD[i].equals("B")) {
                temp = 11;
            } else if (hasilHtoD[i].equals("C")) {
                temp = 12;
            } else if (hasilHtoD[i].equals("D")) {
                temp = 13;
            } else if (hasilHtoD[i].equals("E")) {
                temp = 14;
            } else if (hasilHtoD[i].equals("F")) {
                temp = 15;
            } else {
                temp = Integer.parseInt(hasilHtoD[i]);
            }
            hsl[i] = temp * ((int) Math.pow(basis, 0 + a));
            hslfix += hsl[i];
            a++;
        }
        return hslfix;
    }

    /**
     * Fungsi untuk mengkonversi bilangan hexa menjadi bilangan biner
     * @param hex inputan berupa bilangan hexa dengan tipe data String
     * @return hasil konversi yaitu bilangan biner dengan tipe data String
     */
    public String hexaToBiner(String hex) {
        String ch[] = hex.split("");
        String hsl[] = new String[ch.length];
        String hasilHtoB[] = new String[ch.length];
        String hslfix = "";
        for (int i = 0; i < ch.length; i++) {
            hasilHtoB[i] = ch[i];
        }
        for (int i = 0; i < hasilHtoB.length; i++) {
            for (int j = 0; j < heksa.length; j++) {
                if (hasilHtoB[i].equals(heksa[j])) {
                    hsl[i] = binner[j];
                }
            }
            hslfix += hsl[i];
        }
        return hslfix;
    }

    /**
     * Fungsi untuk mengkonversi bilangan hexa menjadi bilangan oktal
     * @param hex inputan berupa bilangan hexa dengan tipe data String
     * @return hasil konversi yaitu bilangan oktal dengan tipe data String
     */
    public String hexaToOktal(String hex) {
        Converter c = new Converter();
        int temp = c.hexaToDesimal(hex);
        String hslfinal = c.desToOktal(temp);
        return hslfinal;
    }

    /**
     * Fungsi untuk mengkonversi bilangan biner menjadi bilangan hexa
     * @param bin inputan berupa bilangan biner dengan tipe data String
     * @return hasil konversi yaitu bilangan hexa dengan tipe data String
     */
    public String binerToHexa(String bin) {
        String hslfix = "";
        for (int j = 0; j < heksa.length; j++) {
            if (bin.equalsIgnoreCase(binner[j])) {
                hslfix = heksa[j];
            }
        }
        return hslfix;
    }

    /**
     * Fungsi untuk mengkonversi bilangan biner menjadi bilangan desimal
     * @param bin inputan berupa bilangan biner dengan tipe data String
     * @return hasil konversi yaitu bilangan desimal dengan tipe data integer
     */
    public int binerToDes(String bin) {
        int basis = 2;
        String num = String.valueOf(bin);
        int hsl[] = new int[num.length()];
        int hasilBtoD[] = new int[num.length()];
        int hslfix = 0;
        for (int i = 0; i < num.length(); i++) {
            hasilBtoD[i] = Character.digit(num.charAt(i), 10);
        }
        int a = hasilBtoD.length - 1;
        for (int i = 0; i <= hasilBtoD.length - 1; i++) {
            hsl[i] = hasilBtoD[i] * ((int) Math.pow(basis, 0 + a));
            hslfix += hsl[i];
            a--;
        }
        return hslfix;
    }

    /**
     * Fungsi untuk mengkonversi bilangan biner menjadi bilangan oktal
     * @param bin inputan berupa bilangan biner dengan tipe data String
     * @return  hasil konversi yaitu bilangan oktal dengan tipe data String
     * Membuat objek dari kelas Converter untuk memanggil method binerToDes dan desToOktal
     */
    public String binerToOktal(String bin) {
        Converter c = new Converter();
        int temp = c.binerToDes(bin);
        String hslfinal = c.desToOktal(temp);
        return hslfinal;
    }
    
    public static void main(String[] args) {
        Converter converter = new Converter();
        Scanner input = new Scanner(System.in);
        System.out.println("SISTEM CONVERTE");
        System.out.println("--------------------");
        System.out.println("1. Biner");
        System.out.println("2. Desimal");
        System.out.println("3. Oktal");
        System.out.println("4. Hexa");
        System.out.println("--------------------");
        System.out.print("Masukkan Pilihan: ");
        int pilih = input.nextInt();
        System.out.println("--------------------");
        switch (pilih) {
            case 1:
                System.out.print("Masukkan bilangan biner: ");
                String binner = input.next();
                System.out.println("Bilangan Desimal: " + converter.binerToDes(binner));
                System.out.println("Bilangan Oktal: " + converter.binerToOktal(binner));
                System.out.println("Bilangan Hexa: " + converter.binerToHexa(binner));
                break;
            case 2:
                System.out.print("Masukkan bilangan desimal: ");
                int des = input.nextInt();
                System.out.println("Bilangan Oktal: " + converter.desToOktal(des));
                System.out.println("Bilangan Biner: " + converter.desToBiner(des));
                System.out.println("Bilangan Hexa: " + converter.desToHexa(des));
                break;
            case 3:
                System.out.print("Masukkan bilangan oktal: ");
                int okt = input.nextInt();
                System.out.println("Bilangan Binner: " + converter.oktalToBiner(okt));
                System.out.println("Bilangan Desimal: " + converter.oktalToDesimal(okt));
                System.out.println("Bilangan Hexa: " + converter.oktalToHexa(okt));
                break;
            case 4:
                System.out.print("Masukkan bilangan hexa: ");
                String hex = input.next();
                System.out.println("Bilangan Binner: " + converter.hexaToBiner(hex));
                System.out.println("Bilangan Desimal: " + converter.hexaToDesimal(hex));
                System.out.println("Bilangan Oktal: " + converter.hexaToOktal(hex));
                break;
            default:
                System.out.println("Pilihan tidak ada");
                break;
        }
    }
}