import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class LoginPassword extends JFrame {
    private JLabel LoginLabel, passwordLabel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton submitButton, cancelButton;
    private JPanel oop;
    Login login = new Login();
    public LoginPassword(JFrame parent){
        setTitle("Login");
        setContentPane(oop);
        setMinimumSize(new Dimension(450, 474));
        setLocationRelativeTo(parent);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    login.check_login(loginField.getText(), String.valueOf(passwordField.getPassword()));
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
}

