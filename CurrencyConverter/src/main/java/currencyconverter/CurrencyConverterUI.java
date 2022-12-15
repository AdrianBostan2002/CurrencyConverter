package currencyconverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverterUI extends JFrame {

    private JPanel moneyConverterJPanel;
    private JComboBox fromCurrencyComboBox;
    private JComboBox toCurrencyComboBox;
    private JComboBox fromCurrencyCB;
    private JComboBox toCurrencyCB;
    private JTextArea insertValueToConvert;
    private JButton convertButton;
    private String convertingValue;
    private JTextArea printConversionLabel;
    private Double convertedValue;

    public CurrencyConverterUI(){
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrencyConverterAPI api=new CurrencyConverterAPI();

                int indexFromItemSelectedInFromCurrencyCB=getIndexFromSelectedFromCurrencyCB();
                int indexFromItemSelectedInToCurrencyCB=getIndexFromSelectedToCurrencyCB();

                System.out.println(fromCurrencyCB.getItemAt(indexFromItemSelectedInFromCurrencyCB));
                System.out.println(toCurrencyCB.getItemAt(indexFromItemSelectedInToCurrencyCB));
                convertingValue=insertValueToConvert.getText();
                Double value=0.0;
                convertedValue=0.0;
                try {
                    value=Double.parseDouble(convertingValue);
                    if(value>=0) {
                        try {
                            //System.out.println(api.getConversion(fromCurrencyCB.getItemAt(indexFromItemSelectedInFromCurrencyCB).toString(),
                              //      toCurrencyCB.getItemAt(indexFromItemSelectedInToCurrencyCB).toString(), convertingValue));
                            convertedValue=api.getConversion(fromCurrencyCB.getItemAt(indexFromItemSelectedInFromCurrencyCB).toString(),
                                    toCurrencyCB.getItemAt(indexFromItemSelectedInToCurrencyCB).toString(), convertingValue);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                            JOptionPane.showMessageDialog(moneyConverterJPanel, "Value can't be converted");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(moneyConverterJPanel, "Value should be positive");
                    }
                } catch (NumberFormatException ex) {
                   JOptionPane.showMessageDialog(moneyConverterJPanel, "Please read a valid number");
                }
                printConversionLabel.setText(value+ " " + toCurrencyCB.getItemAt(getIndexFromSelectedToCurrencyCB()));
            }
        });
    }

    public void MainFrame() {
        setContentPane(moneyConverterJPanel);
        setTitle("Currency Converter");
        setSize(700, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);

        moneyConverterJPanel.setLayout(null);


//        JTextArea insertValueToConvert;
//        JButton convertButton;

        //=new JComboBox();
        fromCurrencyCB=generateComboBoxWithIcons();
        toCurrencyCB=generateComboBoxWithIcons();
        insertValueToConvert=new JTextArea(1, 20);
        printConversionLabel =new JTextArea(1, 50);
        printConversionLabel.setEditable(false);

        moneyConverterJPanel.add(fromCurrencyCB);
        moneyConverterJPanel.add(toCurrencyCB);
        moneyConverterJPanel.add(insertValueToConvert);
        moneyConverterJPanel.add(convertButton);
        moneyConverterJPanel.add(printConversionLabel);

        Insets insets=moneyConverterJPanel.getInsets();
        Dimension size=fromCurrencyComboBox.getPreferredSize();
        fromCurrencyComboBox.setBounds(250+insets.left, 150+insets.top, size.width, size.height);
        size=toCurrencyComboBox.getPreferredSize();
        toCurrencyComboBox.setBounds(100+insets.left, 200+insets.top, size.width, size.height);
        toCurrencyComboBox.setVisible(false);
        fromCurrencyComboBox.setVisible(false);

        size=fromCurrencyCB.getPreferredSize();
        fromCurrencyCB.setBounds(100+insets.left, 150+insets.top, size.width, size.height);
        //fromCurrencyCB.setVisible(true);

        size=toCurrencyCB.getPreferredSize();
        toCurrencyCB.setBounds(300+insets.left, 150+insets.top, size.width, size.height);
        //toCurrencyCB.setVisible(true);

        size=insertValueToConvert.getPreferredSize();
        insertValueToConvert.setBounds(400+insets.left, 150+insets.top, size.width, size.height);

        size=convertButton.getPreferredSize();
        convertButton.setBounds(300+insets.left, 300+insets.top, size.width, size.height);

        size=printConversionLabel.getPreferredSize();
        printConversionLabel.setBounds(150+insets.left, 350+insets.top, size.width, size.height);

    }

    public int getIndexFromSelectedToCurrencyCB(){
        return toCurrencyCB.getSelectedIndex();
    }

    public int getIndexFromSelectedFromCurrencyCB(){
        return fromCurrencyCB.getSelectedIndex();
    }

    public JComboBox generateComboBoxWithIcons()
    {
        Map<Object, Icon>icons=new HashMap<Object, Icon>();
        icons.put("RON", new ImageIcon("src\\main\\java\\currencyconverter\\Romania.PNG"));
        icons.put("EUR", new ImageIcon("src\\main\\java\\currencyconverter\\EuropeanUnion.PNG"));
        icons.put("USD", new ImageIcon("src\\main\\java\\currencyconverter\\USA.PNG"));
        icons.put("AUD", new ImageIcon("src\\main\\java\\currencyconverter\\Australia.PNG"));
        icons.put("CAD", new ImageIcon("src\\main\\java\\currencyconverter\\Canada.PNG"));
        icons.put("GBP", new ImageIcon("src\\main\\java\\currencyconverter\\UnitedKindom.PNG"));
        icons.put("CHF", new ImageIcon("src\\main\\java\\currencyconverter\\Switzerland.PNG"));
        icons.put("CZK", new ImageIcon("src\\main\\java\\currencyconverter\\Czech.PNG"));
        icons.put("EGP", new ImageIcon("src\\main\\java\\currencyconverter\\Egypt.PNG"));
        icons.put("HUF", new ImageIcon("src\\main\\java\\currencyconverter\\Hungary.PNG"));
        icons.put("MDL", new ImageIcon("src\\main\\java\\currencyconverter\\Moldova.PNG"));
        icons.put("NOK", new ImageIcon("src\\main\\java\\currencyconverter\\Norway.PNG"));
        icons.put("PLN", new ImageIcon("src\\main\\java\\currencyconverter\\Poland.PNG"));
        JFrame frame=new JFrame("Icon list");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JComboBox combo=new JComboBox(
                new Object[]{
                        "RON",
                        "EUR",
                        "USD",
                        "AUD",
                        "CAD",
                        "GBP",
                        "CHF",
                        "CZK",
                        "EGP",
                        "HUF",
                        "MDL",
                        "NOK",
                        "PLN" });
        combo.setRenderer(new IconListRenderer(icons));
        frame.add(combo);
        return combo;
    }

}

