import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterGUI {

    private JTextField amountField;
    private JComboBox<String> sourceCurrencyComboBox;
    private JComboBox<String> targetCurrencyComboBox;
    private JLabel resultLabel; 

    public CurrencyConverterGUI() {
        JFrame frame = new JFrame("Currency Converter");
        frame.setSize(450, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(20, 20, 80, 25);
        panel.add(amountLabel);

        amountField = new JTextField(20);
        amountField.setBounds(150, 20, 200, 25);
        panel.add(amountField);

        JLabel sourceCurrencyLabel = new JLabel("Source Currency:");
        sourceCurrencyLabel.setBounds(20, 50, 120, 25);
        panel.add(sourceCurrencyLabel);

        String[] currencies = {null,"United States Dollar(USD)", "Euro(EUR)", "Pound sterling(GBP)","Indian Rupee(INR)","Japanese Yen(JPY)"};
        sourceCurrencyComboBox = new JComboBox<>(currencies);
        sourceCurrencyComboBox.setBounds(150, 50, 200, 25);
        panel.add(sourceCurrencyComboBox);

        JLabel targetCurrencyLabel = new JLabel("Target Currency:");
        targetCurrencyLabel.setBounds(20, 80, 120, 25);
        panel.add(targetCurrencyLabel);

        targetCurrencyComboBox = new JComboBox<>(currencies);
        targetCurrencyComboBox.setBounds(150, 80, 200, 25);
        panel.add(targetCurrencyComboBox);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(20, 120, 80, 25);
        panel.add(convertButton);

        resultLabel = new JLabel("Converted Amount:");
        resultLabel.setBounds(110, 120, 300, 25);
        panel.add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertAndDisplay();
            }
        });
    }

    private void convertAndDisplay() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String sourceCurrency = (String) sourceCurrencyComboBox.getSelectedItem();
            String targetCurrency = (String) targetCurrencyComboBox.getSelectedItem();

            double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency);

            resultLabel.setText("Converted Amount: " + convertedAmount + " " + targetCurrency);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    private double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
        double usdToEurRate = 0.93;
        double usdToGbpRate = 0.77;
        double usdToInrRate = 83.01;
        double usdToJpyRate = 149.94;

        double eurToUsdRate = 1.12;
        double eurToGbpRate = 0.88;
        double eurToInrRate = 89.39;
        double eurToJpyRate = 161.45;

        double gbpToUsdRate = 1.30;
        double gbpToEurRate = 1.14;
        double gbpToInrRate = 104.57;
        double gbpToJpyRate = 188.90;

        double inrToUsdRate = 0.012;
        double inrToEurRate = 0.011;
        double inrToGbpRate = 0.0096;
        double inrToJpyRate = 1.81;

        double jpyToUsdRate = 0.0067;
        double jpyToEurRate = 0.0062;
        double jpyToInrRate = 0.55;
        double jpyToGbpRate = 0.0053;

        double convertedAmount;

        if (sourceCurrency.equals("United States Dollar(USD)")) {
            if (targetCurrency.equals("Euro(EUR)")) {
                convertedAmount = amount * usdToEurRate;
            } else if (targetCurrency.equals("Pound sterling(GBP)")) {
                convertedAmount = amount * usdToGbpRate;
            } else if (targetCurrency.equals("Indian Rupee(INR)")) {
                convertedAmount = amount * usdToInrRate;
            } else if (targetCurrency.equals("Japanese Yen(JPY)")) {
                convertedAmount = amount * usdToJpyRate;
            } else {
                convertedAmount = amount; // Same currency
            }
        } else if (sourceCurrency.equals("Euro(EUR)")) {
            if (targetCurrency.equals("United States Dollar(USD)")) {
                convertedAmount = amount * eurToUsdRate;
            } else if (targetCurrency.equals("Pound sterling(GBP)")) {
                convertedAmount = amount * eurToGbpRate;
            } else if (targetCurrency.equals("Indian Rupee(INR)")) {
                convertedAmount = amount * eurToInrRate;
            } else if (targetCurrency.equals("Japanese Yen(JPY)")) {
                convertedAmount = amount * eurToJpyRate;
            } else {
                convertedAmount = amount; // Same currency
            }
        } else if (sourceCurrency.equals("Pound sterling(GBP)")) {
            if (targetCurrency.equals("United States Dollar(USD)")) {
                convertedAmount = amount * gbpToUsdRate;
            } else if (targetCurrency.equals("Euro(EUR)")) {
                convertedAmount = amount * gbpToEurRate;
            } else if (targetCurrency.equals("Indian Rupee(INR)")) {
                convertedAmount = amount * gbpToInrRate;
            } else if (targetCurrency.equals("Japanese Yen(JPY)")) {
                convertedAmount = amount * gbpToJpyRate;
            }else {
                convertedAmount = amount; // Same currency
            }
        } else if (sourceCurrency.equals("Indian Rupee(INR)")) {
            if (targetCurrency.equals("United States Dollar(USD)")) {
                convertedAmount = amount * inrToUsdRate;
            } else if (targetCurrency.equals("Euro(EUR)")) {
                convertedAmount = amount * inrToEurRate;
            } else if (targetCurrency.equals("Pound sterling(GBP)")) {
                convertedAmount = amount * inrToGbpRate;
            } else if (targetCurrency.equals("Japanese Yen(JPY)")) {
                convertedAmount = amount * inrToJpyRate;
            }else {
                convertedAmount = amount; // Same currency
            }
        } else if (sourceCurrency.equals("Japanese Yen(JPY)")) {
            if (targetCurrency.equals("United States Dollar(USD)")) {
                convertedAmount = amount * jpyToUsdRate;
            } else if (targetCurrency.equals("Euro(EUR)")) {
                convertedAmount = amount * jpyToEurRate;
            } else if (targetCurrency.equals("Pound sterling(GBP)")) {
                convertedAmount = amount * jpyToGbpRate;
            } else if (targetCurrency.equals("Indian Rupee(INR)")) {
                convertedAmount = amount * jpyToInrRate;
            }else {
                convertedAmount = amount; // Same currency
            }
        } else {
            convertedAmount = amount; // Same currency
        }

        return convertedAmount;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CurrencyConverterGUI());
    }
}

