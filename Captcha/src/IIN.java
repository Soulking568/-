import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.security.MessageDigest;

public class IIN extends JFrame {

    public void check_iin(String iin, String password) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Login", "postgres", "mother1978");

        // Hash the provided password using MD5
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        String hashedPassword = sb.toString();

        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM test1 WHERE IIN_user = ? and Password_user = ?");

        ps.setString(1, iin);
        ps.setString(2, password);

        ResultSet result = ps.executeQuery();
        if (result.next()) {
            // Compare the provided password hash with the stored hash in the database
            String storedHashedPassword = result.getString("Password_user");
            if (password.equals(storedHashedPassword)) {
                // Create a new JFrame object
                JFrame welcomeFrame = new JFrame("Checking Page");

                // Add a JLabel with the "Welcome" message to the JFrame
                JLabel welcomeLabel = new JLabel("Welcome");
                welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
                welcomeFrame.getContentPane().add(welcomeLabel);

                // Set the size of the JFrame and make it visible
                welcomeFrame.setSize(200, 100);
                welcomeFrame.setLocationRelativeTo(null);
                welcomeFrame.setVisible(true);

                // Create a new Captcha object
                new Captcha();
            }

            /*else {
                JFrame PasswordIncorectFrame = new JFrame("Checking Page");
                // Add a JLabel with the "Password Incorrect" message to the JFrame
                JLabel PasswordIncorectLabel = new JLabel("Password Incorrect");
                PasswordIncorectLabel.setHorizontalAlignment(SwingConstants.CENTER);
                PasswordIncorectFrame.getContentPane().add(PasswordIncorectLabel);

                // Set the size of the JFrame and make it visible
                PasswordIncorectFrame.setSize(200, 100);
                PasswordIncorectFrame.setLocationRelativeTo(null);
                PasswordIncorectFrame.setVisible(true);

            }
            */
        } else {
            JFrame Login_not_foundFrame = new JFrame("Checking Page");

            // Add a JLabel with the "Login not found" message to the JFrame
            JLabel Login_not_foundLabel = new JLabel("Incorrect");
            Login_not_foundLabel.setHorizontalAlignment(SwingConstants.CENTER);
            Login_not_foundFrame.getContentPane().add(Login_not_foundLabel);

            // Set the size of the JFrame and make it visible
            Login_not_foundFrame.setSize(200, 100);
            Login_not_foundFrame.setLocationRelativeTo(null);
            Login_not_foundFrame.setVisible(true);
        }


        con.close();
    }

}




