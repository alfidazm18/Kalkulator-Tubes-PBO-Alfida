package kalkulator.alfida_zumaroh;

/*
Nama: Alfida Zumaroh
NIM: 32602200039

Berikan penjelasan kode ini baris perbaris dengan komentar, bagian polimorfisme, getter setter, constructor, inheritance
*/

// Kelas DivisionOperation merupakan implementasi dari antarmuka CalculatorOperation untuk operasi pembagian.

public class DivisionOperation implements CalculatorOperation {

    // Implementasi metode calculate untuk melakukan operasi pembagian
    @Override
    public double calculate(double num1, double num2) {
        // Melakukan pembagian num1 dengan num2
        // Mengecek apakah num2 bukan nol, jika nol, lempar IllegalArgumentException
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
    }

    // Implementasi metode getOperator untuk mendapatkan simbol operator
    @Override
    public String getOperator() {
        // Mengembalikan simbol operator division
        return "/";
    }
}
