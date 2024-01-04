package kalkulator.alfida_zumaroh;

/*
Nama: Alfida Zumaroh
NIM: 32602200039

Berikan penjelasan kode ini baris perbaris dengan komentar, bagian polimorfisme, getter setter, constructor, inheritance
*/

// Kelas MultiplicationOperation merupakan implementasi dari antarmuka CalculatorOperation untuk operasi perkalian.

public class MultiplicationOperation implements CalculatorOperation {

    // Implementasi metode calculate untuk melakukan operasi perkalian
    @Override
    public double calculate(double num1, double num2) {
        // Mengalikan num1 dengan num2
        return num1 * num2;
    }

    // Implementasi metode getOperator untuk mendapatkan simbol operator
    @Override
    public String getOperator() {
        // Mengembalikan simbol operator multiplication
        return "*";
    }
}
