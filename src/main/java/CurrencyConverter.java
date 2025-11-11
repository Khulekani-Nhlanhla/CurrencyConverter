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
    private JComboBox<String> fromCurrencyComboBox, toCurrencyCombo;
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

}
