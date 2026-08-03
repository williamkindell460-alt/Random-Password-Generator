import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class RandomPasswordGenerater
{

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Password Generater");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300,200,300,200);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setBackground(Color.black);
        placeComponents(panel);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel1 = new JLabel("How many characters do you want?");
        userLabel1.setForeground(Color.white);
        userLabel1.setBounds(10, 20, 300, 25);
        panel.add(userLabel1);
        
        JTextField userText = new JTextField();
        userText.setForeground(Color.black);
        userText.setBounds(10, 50, 100, 25);
        panel.add(userText);

        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(Color.blue);
        submitButton.setForeground(Color.yellow);
        submitButton.setBounds(10, 80, 80, 25);
        panel.add(submitButton);

        JButton copyButton = new JButton("Copy Password");
        copyButton.setBackground(Color.blue);
        copyButton.setForeground(Color.yellow);
        copyButton.setBounds(130, 50, 80, 25);
        panel.add(copyButton);
        copyButton.setVisible(false);

        submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String user = userText.getText();
                    boolean isValid = isNumber(user);
                    if(isValid){
                        int userstr = Integer.parseInt(user);
                        Pass = PasswordGenerator.generatePassword(userstr);
                        JOptionPane.showMessageDialog(panel, "Your new randomly generated password is \n" + Pass);
                    } else {
                        JOptionPane.showMessageDialog(panel, "That was not a number! Try Again.");
                    }
                    copyButton.setVisible(true);
                }
            });
        copyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Pass != "1"){
                        String str = Pass.toString();
                        StringSelection stringSelection = new StringSelection(str);
                        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clpbrd.setContents(stringSelection, null);
                        JOptionPane.showMessageDialog(panel, "Copied to Clipboard");
                    } else {
                        JOptionPane.showMessageDialog(panel, "There is Nothing to Copy! Try Again.");
                    }
                }
            });
    }

    public static Object Pass = "1";

    public static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
