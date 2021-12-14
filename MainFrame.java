package com.lab2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;

@SuppressWarnings("serial")

public class MainFrame extends JFrame {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;
    double sum = 0;
    double result;
    private static final JTextArea textArea1 = new JTextArea(1, 20);
    private static final JTextArea textArea2 = new JTextArea(1, 20);
    private static final JTextArea textArea3 = new JTextArea(1, 20);
    private static final JButton button1 = new JButton("formula 1");
    private static final JButton button2 = new JButton("formula 2");
    private static final JButton button3 = new JButton("M+");
    private static final JButton button4 = new JButton("MC");
    private static final JLabel label1 = new JLabel();
    private static final JLabel label2 = new JLabel();

    public Double calculate1(Double x, Double y, Double z) {
        return (Math.sin(y) + y * y + Math.exp(Math.sin(y)) * Math.pow((Math.log(z) + Math.sin(Math.PI * x * x)), 0.25));
    }

    public Double calculate2(Double x, Double y, Double z) {
        return (Math.tan(x * x) + Math.pow(y, 0.5)) / (z * Math.log10(x + y));
    }


    public MainFrame() throws HeadlessException {
        super("mainFrame");
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        setVisible(true);
        add(textArea1);
        add(textArea2);
        add(textArea3);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(label1);
        add(label2);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double firstNumber = Double.parseDouble(textArea1.getText());
                double secondNumber = Double.parseDouble(textArea2.getText());
                double thirdNumber = Double.parseDouble(textArea3.getText());
                result = calculate1(firstNumber,secondNumber,thirdNumber);
                label1.setText(result + "");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double firstNumber = Double.parseDouble(textArea1.getText());
                double secondNumber = Double.parseDouble(textArea2.getText());
                double thirdNumber = Double.parseDouble(textArea3.getText());
                result = calculate2(firstNumber,secondNumber,thirdNumber);
                label1.setText(result + "");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sum += result;
                label2.setText(sum+"");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sum = 0;
                label2.setText(sum+"");
            }
        });
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}