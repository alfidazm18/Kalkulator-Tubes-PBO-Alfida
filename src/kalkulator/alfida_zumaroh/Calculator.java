package kalkulator.alfida_zumaroh;

/*
Nama: Alfida Zumaroh
NIM: 32602200039

Berikan penjelasan kode ini baris perbaris dengan komentar, bagian polimorfisme, getter setter, constructor, inheritance
*/

// Kelas Calculator merupakan kelas utama yang digunakan untuk melakukan perhitungan menggunakan operasi matematika tertentu.

public class Calculator {
    private double operand1;               // Variabel untuk menyimpan operand pertama
    private double operand2;               // Variabel untuk menyimpan operand kedua
    private CalculatorOperation operation;  // Variabel untuk menyimpan objek operasi matematika

    // Konstruktor default tanpa parameter
    public Calculator() {
        this.operand1 = 0;                            // Inisialisasi operand1 dengan nilai 0
        this.operand2 = 0;                            // Inisialisasi operand2 dengan nilai 0
        this.operation = new AdditionOperation();    // Inisialisasi operasi dengan operasi penjumlahan (Default operation)
    }

    // Getter untuk operand1
    public double getOperand1() {
        return operand1;
    }

    // Setter untuk operand1
    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    // Getter untuk operand2
    public double getOperand2() {
        return operand2;
    }

    // Setter untuk operand2
    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    // Getter untuk operasi
    public CalculatorOperation getOperation() {
        return operation;
    }

    // Setter untuk operasi
    public void setOperation(CalculatorOperation operation) {
        this.operation = operation;
    }

    // Metode untuk melakukan perhitungan menggunakan operasi yang sudah diatur
    public double performCalculation() {
        return operation.calculate(operand1, operand2);
    }
}
