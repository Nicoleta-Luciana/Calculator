package Calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	static double num1 = 0, num2 = 0;
    static String operator = "";
    static boolean resultShown = false;
    
    public ButtonPanel(JTextField textfield) {
        setLayout(new GridLayout(4, 4, 3, 3));

        String[] buttons = {
            "C", "÷", "x", "=",
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "0"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Consolas", Font.PLAIN, 30));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String btnText = button.getText();

                    switch (btnText) {
                        case "C":
                            textfield.setText(""); 
                            break;

                        case "+": 
                        case "-":
                        case "x":
                        case "÷":
                            if (resultShown) {
                                num1 = Double.parseDouble(textfield.getText());
                                resultShown = false;
                                textfield.setText(textfield.getText() + " " + btnText + " ");
                            } else {
                                num1 = Double.parseDouble(textfield.getText());
                                operator = btnText;
                                textfield.setText(textfield.getText() + " " + operator + " ");
                            }
                            break;

                        case "=":
                            String[] parts = textfield.getText().split(" "); 
                            if (parts.length == 3) {
                                num1 = Double.parseDouble(parts[0]);
                                operator = parts[1];
                                num2 = Double.parseDouble(parts[2]);
                            }

                            double rezultat = 0;

                            switch (operator) {
                                case "+":
                                    rezultat = num1 + num2;
                                    break;
                                case "-":
                                    rezultat = num1 - num2;
                                    break;
                                case "x":
                                    rezultat = num1 * num2;
                                    break;
                                case "÷":
                                    if (num2 != 0) {
                                        rezultat = num1 / num2;
                                    } else {
                                        textfield.setText("Eroare!");
                                        return;
                                    }
                                    break;
                            }

                            textfield.setText(String.valueOf(rezultat));
                            resultShown = true;
                            break;

                        default:
                            if (resultShown) {
                                textfield.setText(btnText);
                                resultShown = false;
                            } else {
                                textfield.setText(textfield.getText() + btnText);
                            }
                            break;
                    }
                }
            });
            add(button);
        }
    }
}