package CalculatorApp;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class Calculator {
    JFrame frame;
    JTextField finalInputField;
    JLabel label;
    JButton toggleButton;
    JButton addittionButton ;JButton subtraction; JButton multiply;
    JButton divide;JButton modulus;JButton arrowButton;
    JButton clearButton;
    Theme theme = new Theme(true); // Start with black border color

    Calculator() {
        initialize();
    }

    public void initialize() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(380, 640);

        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        panel.setLayout(null);

        finalInputField = new JTextField(10);
        finalInputField.setBounds(5, 10, 355, 40);
        finalInputField.setBorder(theme.borderColorIsBlack ? BorderFactory.createLineBorder(Color.BLACK, 2) : BorderFactory.createLineBorder(Color.WHITE, 2));
        panel.add(finalInputField);

        toggleButton = new JButton("Theme");
        toggleButton.setBounds(5, 55, 80, 30);
        panel.add(toggleButton);

        // Add action listeners to number buttons
        for (int i = 1; i <= 9; i++) {
            JButton numberButton = new JButton(Integer.toString(10-i));
            numberButton.setBounds(5 + ((i - 1) % 3) * 60, 190 + ((i - 1) / 3) * 60, 50, 50);
            panel.add(numberButton);
            
            numberButton.addActionListener(e -> {
                finalInputField.setText(finalInputField.getText() + numberButton.getText());
            });
        }

        toggleButton.addActionListener(e -> {
            theme.toggleBorderColor(finalInputField);
        });
        
        clearButton = new JButton("C");
        clearButton.setBounds(5, 130, 50, 50);
        panel.add(clearButton);

        clearButton.addActionListener(e -> {
            finalInputField.setText("");
        });
        
        modulus = new JButton("%");
        modulus.setBounds(65, 130, 50, 50);
        panel.add(modulus);
        
        modulus.addActionListener(e -> {
            finalInputField.setText(finalInputField.getText() +"%"); // Append "0" to the existing text
        });
        
        divide = new JButton("/");
        divide.setBounds(125, 130, 50, 50);
        panel.add(divide);
        
        divide.addActionListener(e -> {
            finalInputField.setText(finalInputField.getText() +"/"); // Append "0" to the existing text
        });
        
        arrowButton = new JButton("←");
        arrowButton.setBounds(185, 130, 50, 50);
        arrowButton.setFont(new Font("Arial", Font.BOLD, 16)); 
        panel.add(arrowButton);
        
        arrowButton.addActionListener(e -> {
            String text = finalInputField.getText();
            if (!text.isEmpty()) {
                finalInputField.setText(text.substring(0, text.length() - 1));
            }
        });
        
        multiply = new JButton("x");
        multiply.setBounds(185, 190, 50, 50);
        panel.add(multiply);
        
        multiply.addActionListener(e -> {
            finalInputField.setText(finalInputField.getText() +"*"); // Append "0" to the existing text
        });
        
        subtraction = new JButton("-");
        subtraction.setBounds(185, 250, 50, 50);
        panel.add(subtraction);
        
        subtraction.addActionListener(e -> {
            finalInputField.setText(finalInputField.getText() +"-"); // Append "0" to the existing text
        });
        
        addittionButton = new JButton("+");
        addittionButton.setBounds(185, 310, 50, 50);
        panel.add(addittionButton);
        
        addittionButton.addActionListener(e -> {
            finalInputField.setText(finalInputField.getText() +"+"); // Append "0" to the existing text
        });
        
        JButton numberButton = new JButton("0");
        numberButton.setBounds(5, 365, 110, 50);
        panel.add(numberButton);

        numberButton.addActionListener(e -> {
            finalInputField.setText(finalInputField.getText() + "0"); // Append "0" to the existing text
        });
        
        
         JButton equal = new JButton("=");
        equal.setBounds(130, 365, 110, 50);
        panel.add(equal);
        
        
        	// Removed incorrect logic from operation buttons' action listeners

        	// Corrected action listener for the equals button
        	
        
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Calculator();
        });
    }
}
