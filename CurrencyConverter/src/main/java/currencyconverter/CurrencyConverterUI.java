package currencyconverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverterUI extends JFrame {

    private JPanel moneyConverterJPanel;
    private JComboBox fromCurrencyComboBox;
    private JComboBox toCurrencyComboBox;

    public CurrencyConverterUI(){
    }

    public void MainFrame() {
        setContentPane(moneyConverterJPanel);
        setTitle("Currency Converter");
        setSize(700, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);

        moneyConverterJPanel.setLayout(null);
        ImageIcon background=new ImageIcon("src\\main\\java\\currencyconverter\\background.JPG");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(700, 500, Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(null);
        back.setBounds(0, 0, 700, 500);
        moneyConverterJPanel.add(back);

        JComboBox fromCurrencyCB;
        JComboBox toCurrencyCB;
        //=new JComboBox();
        fromCurrencyCB=generateComboBoxWithIcons();
        toCurrencyCB=generateComboBoxWithIcons();
        moneyConverterJPanel.add(fromCurrencyCB);
        moneyConverterJPanel.add(toCurrencyCB);

        Insets insets=moneyConverterJPanel.getInsets();
        Dimension size=fromCurrencyComboBox.getPreferredSize();
        fromCurrencyComboBox.setBounds(250+insets.left, 150+insets.top, size.width, size.height);
        size=toCurrencyComboBox.getPreferredSize();
        toCurrencyComboBox.setBounds(100+insets.left, 200+insets.top, size.width, size.height);
        toCurrencyComboBox.setVisible(false);
        fromCurrencyComboBox.setVisible(false);

        size=fromCurrencyCB.getPreferredSize();
        fromCurrencyCB.setBounds(100+insets.left, 150+insets.top, size.width, size.height);
        fromCurrencyCB.setVisible(true);

        size=toCurrencyCB.getPreferredSize();
        toCurrencyCB.setBounds(300+insets.left, 150+insets.top, size.width, size.height);
        toCurrencyCB.setVisible(true);
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

