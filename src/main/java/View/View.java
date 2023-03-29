package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class View extends JFrame{
    private JLabel name;
    private JLabel firstPolynomial;
    private JLabel secondPolynomial;
    private JLabel result;

    private JTextField firstField;
    private JTextField secondField;

    private JTextArea resultArea;

    private JButton add;
    private JButton multiplicate;
    private JButton divide;
    private JButton substract;
    private JButton derivation;
    private JButton integration;


    public View() {
        this.name = new JLabel("Polynomial Calculator");
        name.setFont(new Font("Ariel", Font.BOLD, 20));
        this.firstPolynomial = new JLabel("First polynomial:");
        firstPolynomial.setFont(new Font("Ariel", Font.BOLD, 16));
        this.secondPolynomial = new JLabel("Second polynomial:");
        secondPolynomial.setFont(new Font("Ariel", Font.BOLD, 16));
        this.result = new JLabel("Result:");
        result.setFont(new Font("Ariel", Font.BOLD, 16));

        this.firstField = new JTextField();
        this.firstField.setPreferredSize(new Dimension(200, 20));
        this.secondField = new JTextField();
        this.secondField.setPreferredSize(new Dimension(200, 20));
        this.resultArea = new JTextArea();
        this.resultArea.setPreferredSize(new Dimension(200, 20));


        Dimension size = new Dimension(350, 30);
        add = new JButton ("Add");
        add.setMinimumSize(size);
        add.setMaximumSize(size);
        multiplicate = new JButton("Multiplicate");
        multiplicate.setMinimumSize(size);
        multiplicate.setMaximumSize(size);
        divide = new JButton("Divide");
        divide.setMinimumSize(size);
        divide.setMaximumSize(size);
        substract = new JButton("Substract");
        substract.setMinimumSize(size);
        substract.setMaximumSize(size);
        derivation = new JButton("Derivation");
        derivation.setMinimumSize(size);
        derivation.setMaximumSize(size);
        integration = new JButton("Integration");
        integration.setMinimumSize(size);
        integration.setMaximumSize(size);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(this.firstPolynomial);
        panel1.add(Box.createRigidArea(getPreferredSize()));
        panel1.add(this.secondPolynomial);
        panel1.add(Box.createRigidArea(getPreferredSize()));
        panel1.add(this.result);
        panel1.add(Box.createRigidArea(getPreferredSize()));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(Box.createRigidArea(getPreferredSize()));
        panel2.add(this.firstField);
        panel2.add(Box.createRigidArea(getPreferredSize()));
        panel2.add(this.secondField);
        panel2.add(Box.createRigidArea(getPreferredSize()));
        panel2.add(this.resultArea);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.add(add);
        panel3.add(substract);
        panel3.add(derivation);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
        panel4.add(multiplicate);
        panel4.add(divide);
        panel4.add(integration);

        JPanel maxPanel1 = new JPanel();
        maxPanel1.add(this.name);

        JPanel maxPanel2 = new JPanel();
        maxPanel2.add(panel1);
        maxPanel2.add(panel2);

        JPanel maxPanel3 = new JPanel();
        maxPanel3.add(panel3);
        maxPanel3.add(panel4);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(maxPanel1);
        mainPanel.add(maxPanel2);
        mainPanel.add(maxPanel3);

        this.setContentPane(mainPanel);
        this.setSize(400, 300);
        this.setTitle("Polynomial Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public String getFirstField() {
        return this.firstField.getText();
    }

    public String getSecondField() {
        return this.secondField.getText();
    }

    public String getResultArea() {
        return this.resultArea.getText();
    }

    public void setResultArea(String resultArea) {
        this.resultArea.setText(resultArea);
    }

    public void addAddListener(ActionListener ac) {
        add.addActionListener(ac);
    }

    public void addMultiplicateListener(ActionListener ac) {
        multiplicate.addActionListener(ac);
    }

    public void addDivideListener(ActionListener ac) {
        divide.addActionListener(ac);
    }

    public void addSubstractListener(ActionListener ac) {
        substract.addActionListener(ac);
    }

    public void addDerivationListener(ActionListener ac) {
        derivation.addActionListener(ac);
    }

    public void addIntegrationListener(ActionListener ac) {
        integration.addActionListener(ac);
    }

    public void cleanAll() {
        firstField.setText(null);
        secondField.setText(null);
        resultArea.setText(null);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "INCORECT POLYNOMIAL", JOptionPane.ERROR_MESSAGE);
        cleanAll();
    }
}
