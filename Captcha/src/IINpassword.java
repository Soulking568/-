import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class IINpassword extends JFrame{

    private JPanel IIN;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton submitButton;
    private JButton cancelButton;
    IIN iin = new IIN();
    public IINpassword(JFrame parent){
        setTitle("IIN");
        setContentPane(IIN);
        setMinimumSize(new Dimension(450, 474));
        setLocationRelativeTo(parent);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    iin.check_iin(textField1.getText(), String.valueOf(passwordField1.getPassword()));
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (NoSuchAlgorithmException ex) {
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
