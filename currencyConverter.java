// Here we import the Java utilities that will help us with our program.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.*;
//Here is where we declare the class with extension used within our program.
public class currencyConverter extends JApplet implements ActionListener
{
// Here we create the text fields for our returned values in Euros, UK Sterling, US Dollars and
//Japanese Yen.
	JTextField jtEuro = new JTextField();
	JTextField jtUKSterling = new JTextField();
	JTextField jtUSDollar = new JTextField();
	JTextField jtJapaneseYen = new JTextField();
// Here we create the text fields for our exchange rates.
	JTextField jtUKSterlingRate = new JTextField();
	JTextField jtUSDollarRate = new JTextField();
	JTextField jtJapaneseYenRate = new JTextField();
// Here we create the button to convert our currencies.
	JButton currencyConvert = new JButton("Convert");
// Here we add a number formatter which will return our converted value with the correct
//currency symbol.
	NumberFormat nfUKSterling = NumberFormat.getCurrencyInstance(Locale.UK);
	NumberFormat nfUSDollar = NumberFormat.getCurrencyInstance(Locale.US);
	NumberFormat nfJapaneseYen = NumberFormat.getCurrencyInstance(Locale.JAPAN);
	public void init()
	{
// Here we create panel 1 which will hold the text field for our Euro value along with our
//Convert button, all in a border layout.
	JPanel panel1 = new JPanel();
	panel1.setLayout(new BorderLayout());
	panel1.add(new JLabel("Enter Euro Amount"), BorderLayout.WEST);
	panel1.add(jtEuro, BorderLayout.CENTER);
	panel1.add(currencyConvert, BorderLayout.EAST);
// Here we create panel 2 which will hold the text fields for UK Sterling, US Dollar and
//Japanese Yen conversion rates and converted values.
	JPanel panel2 = new JPanel();
	panel2.setLayout(new GridLayout(4, 3));
	panel2.add(new JLabel());
	panel2.add(new JLabel("Exchange Rate"));
	panel2.add(new JLabel("Converted Amount"));
	panel2.add(new JLabel("UK Sterling"));
	panel2.add(jtUKSterlingRate);
	panel2.add(jtUKSterling);
	panel2.add(new JLabel("US Dollars"));
	panel2.add(jtUSDollarRate);
	panel2.add(jtUSDollar);
	panel2.add(new JLabel("Japanese Yen"));
	panel2.add(jtJapaneseYenRate);
	panel2.add(jtJapaneseYen);
// Here we add the panels to the frame and decide on layout.
	this.getContentPane().add(panel1, BorderLayout.NORTH);
	this.getContentPane().add(panel2, BorderLayout.CENTER);
// Here we assign our listener.
		currencyConvert.addActionListener(this);
	}
// Here we handle our action event.
	public void actionPerformed(ActionEvent e)
	{
	if (e.getSource() == currencyConvert)
		{
		double Euro = new Double(jtEuro.getText().trim()).doubleValue();
		double rateUKSterling = new Double(jtUKSterlingRate.getText().trim()).doubleValue();
		double rateUSDollar = new Double(jtUSDollarRate.getText().trim()).doubleValue();
		double rateJapaneseYen = new Double(jtJapaneseYenRate.getText().trim()).doubleValue();
// Here our conversion calculations are performed.
		jtUKSterling.setText(nfUKSterling.format(Euro*rateUKSterling));
		jtUSDollar.setText(nfUSDollar.format(Euro*rateUSDollar));
		jtJapaneseYen.setText(nfJapaneseYen.format(Euro*rateJapaneseYen));
	}
}