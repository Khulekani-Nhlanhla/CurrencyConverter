import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter extends JFrame implements ActionListener {

    //API CONFIG
    private static final String API_KEY = "dbe5ed09bcaefb9378619979";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    //UI COMPONENTS
    private JComboBox<String> fromCurrencyCombo, toCurrencyCombo;
    private JTextField amountField, resultField;
    private JButton convertButton, swapButton;
    private JLabel timeLabel;

    //SUPPORTED CURRENCIES
    private final String[] currencies = {
            "USD", "EUR", "GBP", "JPY", "CAD",
            "AUD", "CHF", "CNY", "INR", "SGD",
            "MYR", "KRW", "THB", "IDR", "VND"
    };

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout(10, 10));

        initializeComponents();
        setupLayout();
        setVisible(true);
    }

    private void initializeComponents() {
        //CURRENCY DROPDOWN
        fromCurrencyCombo = new JComboBox<>(currencies);
        toCurrencyCombo = new JComboBox<>(currencies);
        toCurrencyCombo.setSelectedItem("EUR");

        //TEXT FIELDS
        amountField = new JTextField(15);
        amountField.setFont(new Font("Arial", Font.PLAIN, 16));

        resultField = new JTextField(15);
        resultField.setFont(new Font("Arial", Font.BOLD, 16));
        resultField.setEditable(false);
        resultField.setBackground(Color.LIGHT_GRAY);

        //BUTTONS
        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        convertButton.setBackground(new Color(70, 130, 180));
        convertButton.setForeground(Color.WHITE);
        convertButton.setFont(new Font("Arial", Font.BOLD, 14));

        swapButton = new JButton("⇆ Swap");
        swapButton.addActionListener(this);
        swapButton.setBackground(new Color(34, 139, 34));
        swapButton.setForeground(Color.WHITE);

        //TIME TABLE
        timeLabel = new JLabel("Exchange rates will be fetched on conversion");
        timeLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        timeLabel.setForeground(Color.GRAY);

    }

}
