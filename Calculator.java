/*
Title: Calculator.java
 * 
 * 	Abstract: this program is a calculator that has simple 
					 functions + - sin clear and Neg
 * 
 * 	Author: Stephan Dubuke
 * 
 * 	ID: 0484
 * 
 * 	Date: 10-6-15
 * 
 * */
package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Calculator extends JFrame implements 
ActionListener {
	private static final int WIDTH = 300;
	private static final int HIEGHT = 300;
	//privates
	private JButton [] numbers = new JButton [10];
	private JButton plus, minus, clear, equals, neg, sin;
	 private JLabel answerLabel, answerLabel1;	
	 private JPanel answerPannel, numberPannel;
	 private String imput = "";
	 private DecimalFormat df = new DecimalFormat("0.00"); 
	 private Double  answer;
	 private Boolean negative = true, addation = false, sub = false;
	 private double num1;
	 
	 //main
	 public static void main(String[] args)
	    {
	        Calculator gui = new Calculator( );
	        gui.setVisible(true);
	    }
	 
	 public Calculator()
	 {
		 //constructor
		 super("Calculator");
		 setSize(WIDTH, HIEGHT);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 centerWindow(this);
		 //borderLayout
		 setLayout( new BorderLayout());
		 //making the menu and putting a menuItem on the menu bar
			JMenuItem help = new JMenuItem("Help");
			JMenuBar bar = new JMenuBar();
			bar.add(help);
			setJMenuBar(bar);
			// action listener for the menuItem
			help.addActionListener(this);
			setBackground(Color.GRAY);
			// making the Labels that will go into the answer pannel
			answerLabel = new JLabel("0");
			answerLabel1 = new JLabel("");
			answerPannel = new JPanel();
			// answerPannel set to a flowLayout
			answerPannel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			answerPannel.setBackground(Color.LIGHT_GRAY);
			// adding the two labels
			answerPannel.add(answerLabel1);
			answerPannel.add(answerLabel);
			numberPannel = new JPanel();
			//making the button layout gridstyle
			numberPannel.setLayout(new GridLayout(5,5));
			add(answerPannel, BorderLayout.NORTH);
			// number buttons, doing an array for it
			for(int i = 0; i < 10; i++)
			{
				numbers[i] = new JButton(String.valueOf(i));
				numbers[i].addActionListener(this);
			}
			// blank buttons to make it look like a calculator 
			// and then i am setting up all the other buttons 
			// and all of thier listeners
			numberPannel.add(new JButton(""));
			numberPannel.add(new JButton(""));
			clear = new JButton("C");
			clear.addActionListener(this);
			numberPannel.add(clear);
			neg = new JButton("Neg");
			neg.addActionListener(this);
			numberPannel.add(neg);
			numberPannel.add(new JButton(""));
			numberPannel.add(numbers[7]);
			numberPannel.add(numbers[8]);
			numberPannel.add(numbers[9]);
			sin = new JButton("sin");
			sin.addActionListener(this);
			numberPannel.add(sin);
			numberPannel.add(new JButton(""));
			numberPannel.add(numbers[4]);
			numberPannel.add(numbers[5]);
			numberPannel.add(numbers[6]);
			numberPannel.add(new JButton(""));
			numberPannel.add(new JButton(""));
			numberPannel.add(numbers[1]);
			numberPannel.add(numbers[2]);
			numberPannel.add(numbers[3]);
			minus = new JButton("-");
			minus.addActionListener(this);
			numberPannel.add(minus);
			numberPannel.add(new JButton(""));
			numberPannel.add(numbers[0]);
			numberPannel.add(new JButton(""));
			numberPannel.add(new JButton(""));
			plus = new JButton("+");
			plus.addActionListener(this);
			numberPannel.add(plus);
			equals = new JButton("=");
			equals.addActionListener(this);
			numberPannel.add(equals);
			// adding the panel to the center of the screen
			add(numberPannel, BorderLayout.CENTER);
			
			
		 
	 }
	 // making the window pop up in the center of the screen
	   private void centerWindow(Window w)
	    {
	        Toolkit tk = Toolkit.getDefaultToolkit();
	        Dimension d = tk.getScreenSize();
	        setLocation((d.width-w.getWidth())/2, (d.height-w.getHeight())/2);
	    }
	   
	   // action listener 
		public void actionPerformed(ActionEvent e) {
			String buttonString = e.getActionCommand( );
			String msg = "Title: TicTacToe.java  \n"
					+ "	Abstract: this program is a calculator that has simple "
					+ "functions + - sin clear and Neg \n "
					+ "Author: Stephan Dubuke \n"
					+ "	ID: 0484\n" +
					"date: 10 - 6 - 14";
			// the reading function for the # buttonsusing a for loop 
			for(int i = 0; i < 10; i ++)
			{
			if(buttonString.equals((numbers[i].getText())))
			{
				if(answerLabel.equals("0"))
				{
				imput = numbers[i].getText();
				answerLabel.setText(imput);
				}
				else
					imput = imput + buttonString;
					answerLabel.setText(imput);
			}
			}
			// the clear sets everything back to how it starts
			if(buttonString.equals("C"))
			{
				answerLabel1.setText("");
				answerLabel.setText("0");
				imput = "";
				addation = false;
				sub = false;
				num1 = 0;
			}
			// the plus stores the string into a double as a double 
			// sets the addition boolean to true for the "=" function
			else if(buttonString.equals("+"))
			{
				num1 = Double.parseDouble(imput);
				answerLabel1.setText(imput + " + ");
				imput = "";
				addation = true;
				answerLabel.setText("0");
			}
			// the plus stores the string into a double as a double 
			// sets the sub boolean to true for the "=" function
			else if(buttonString.equals("-"))
			{
				num1 = Double.parseDouble(imput);
				answerLabel1.setText(imput + " - ");
				sub = true;
				imput = "";
				answerLabel.setText("0");
			}
			// the = uses the booleans to do the math 
			else if (buttonString.equals("="))
			{
				if(addation){
				answer = Double.parseDouble(imput) + num1;
				}
				else if (sub){
					answer = num1 - Double.parseDouble(imput);
				}
				answerLabel.setText(answer.toString());
				answerLabel1.setText("");
			}
			// sin does does the sin using math library 
			else if(buttonString.equals("sin"))
			{
				imput = df.format(Math.sin(Double.parseDouble(imput)));
				answerLabel.setText(imput);
			}
			// the neg one uses a negative boolean to set the negative sin there if 
			// it wasnt already there, and takes it away if you press again 
			else if (buttonString.equals("Neg"))
			{
				if(!negative)
				{
					imput = imput.substring(1);
					answerLabel.setText(imput);
					negative = !negative;
				}
				else{
					imput = "-" + imput;
					negative = !negative;
				answerLabel.setText(imput);
				}
			}
			// this opens up the message if you press help haha yay
			else if(buttonString.equals("Help"))
			{
				JOptionPane.showMessageDialog(this, msg);
			}
		}
}
		
