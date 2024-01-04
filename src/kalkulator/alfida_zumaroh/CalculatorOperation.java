package kalkulator.alfida_zumaroh;

/*
Nama: Alfida Zumaroh
NIM: 32602200039

Berikan penjelasan kode ini baris perbaris dengan komentar, bagian interface
*/

// Interface CalculatorOperation menyediakan kontrak untuk operasi kalkulator.

public interface CalculatorOperation {

    // Metode calculate digunakan untuk melakukan operasi kalkulasi pada dua angka.
    // Implementasi akan disediakan oleh kelas yang mengimplementasikan antarmuka ini.
    double calculate(double num1, double num2);

    // Metode getOperator digunakan untuk mendapatkan simbol operator.
    // Implementasi akan memberikan simbol operator yang sesuai untuk operasi tertentu.
    String getOperator();
}
