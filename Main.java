package Calculator;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setResizable(false);

        JTextField textfield = new JTextField();
        textfield.setPreferredSize(new Dimension(500, 150));
        textfield.setFont(new Font("Consolas", Font.PLAIN, 30));
        textfield.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(textfield, BorderLayout.NORTH);

        ButtonPanel buttonPanel = new ButtonPanel(textfield);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}