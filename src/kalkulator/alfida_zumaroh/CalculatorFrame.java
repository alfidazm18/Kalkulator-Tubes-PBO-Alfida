//buat package direktori
package kalkulator.alfida_zumaroh;

/*

nama : Alfida Zumaroh
nim : 32602200039

*/


// impor library 
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorFrame extends JFrame {

    // Deklarasi variabel dan komponen GUI
    private Calculator calculator;
    private JTextField operandTextField;
    private JComboBox<String> operatorComboBox;
    private JLabel resultLabel;
    private JButton calculateButton;
    private JButton clearButton;

    // Konstruktor untuk inisialisasi frame
    public CalculatorFrame() {
        initComponents();
        calculator = new Calculator();
    }

    // Inisialisasi komponen GUI dan tata letak
    private void initComponents() {
        operandTextField = new JTextField();
        operatorComboBox = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        calculateButton = new JButton("Calculate");
        clearButton = new JButton("Clear");
        resultLabel = new JLabel("Result:");

        // Set layout utama frame menggunakan BorderLayout
        setLayout(new BorderLayout());

        // Panel untuk input operand, operator, dan hasil
        JPanel inputPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        inputPanel.add(operandTextField);
        inputPanel.add(operatorComboBox);
        inputPanel.add(resultLabel);

        // Panel untuk tombol angka dan operasi
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        for (int i = 9; i >= 0; i--) {
            final int digit = i;
            JButton digitButton = new JButton(Integer.toString(i));
            digitButton.addActionListener(evt -> digitButtonActionPerformed(digit));
            buttonPanel.add(digitButton);
        }

        String[] operationSymbols = new String[]{"+", "-", "*", "/"};
        for (String symbol : operationSymbols) {
            JButton operationButton = new JButton(symbol);
            operationButton.addActionListener(evt -> operationButtonActionPerformed(symbol));
            buttonPanel.add(operationButton);
        }

        // Tombol untuk perhitungan dan membersihkan operand
        calculateButton.addActionListener(evt -> calculateButtonActionPerformed());
        clearButton.addActionListener(evt -> clearButtonActionPerformed());

        // Panel kontrol dengan layout BorderLayout
        JPanel controlPanel = new JPanel(new BorderLayout());
        controlPanel.add(calculateButton, BorderLayout.CENTER);
        controlPanel.add(clearButton, BorderLayout.NORTH);

        // Menambahkan panel-panel ke frame menggunakan BorderLayout
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculator");
        pack();
        setLocationRelativeTo(null);
    }

    // Metode untuk menangani klik tombol angka
    private void digitButtonActionPerformed(int digit) {
        operandTextField.setText(operandTextField.getText() + digit);
    }

    // Metode untuk menangani klik tombol operasi
    private void operationButtonActionPerformed(String operation) {
        operandTextField.setText(operandTextField.getText() + " " + operation + " ");
    }

    // Metode untuk menangani klik tombol perhitungan
    private void calculateButtonActionPerformed() {
        try {
            // Mendapatkan ekspresi dari operandTextField
            String expression = operandTextField.getText();
            
            // Memeriksa apakah ekspresi tidak kosong
            if (!expression.isEmpty()) {
                String[] parts = expression.split(" ");
                double operand1 = Double.parseDouble(parts[0]);
                double operand2 = Double.parseDouble(parts[2]);

                // Mengatur nilai operand dan operator di kalkulator
                calculator.setOperand1(operand1);
                calculator.setOperand2(operand2);

                String selectedOperation = parts[1];
                // Memilih operasi berdasarkan operator yang dipilih
                switch (selectedOperation) {
                    case "+":
                        calculator.setOperation(new AdditionOperation());
                        break;
                    case "-":
                        calculator.setOperation(new SubtractionOperation());
                        break;
                    case "*":
                        calculator.setOperation(new MultiplicationOperation());
                        break;
                    case "/":
                        calculator.setOperation(new DivisionOperation());
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator");
                }

                // Melakukan perhitungan dan menampilkan hasil
                double result = calculator.performCalculation();
                resultLabel.setText("Result: " + result);

            } else {
                throw new IllegalArgumentException("Enter a valid expression");
            }

        } catch (NumberFormatException e) {
            // Menangani kesalahan jika input tidak valid
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            // Menangani kesalahan jika operator tidak valid
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Metode untuk menangani klik tombol clear
    private void clearButtonActionPerformed() {
        operandTextField.setText("");
        resultLabel.setText("Result:");
    }

    // Metode utama untuk menjalankan aplikasi
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new CalculatorFrame().setVisible(true));
    }
}
