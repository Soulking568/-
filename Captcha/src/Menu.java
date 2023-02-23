import javax.swing.*;
import java.awt.event.*;

public class Menu extends JFrame {
    private JButton loginButton, iinButton, cancelButton;
    private JPanel OOP;

    public Menu(JFrame parent) {
        setContentPane(OOP);
        setTitle("Menu");
        setSize(450, 480);
        setLocationRelativeTo(parent);

        // add action listeners to the Login and IIN buttons
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create a new LoginPassword form
                new LoginPassword(null);
            }
        });

        iinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new IINpassword(null);
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

    public static void main(String[] args) {
        // create and show the menu form
        Menu menu = new Menu(null);

    }
}
