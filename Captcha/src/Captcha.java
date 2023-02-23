import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Captcha extends JFrame {
    private JFrame frame;
    private int random;
    private String correctAnswer;
    private JTextField textField;
    public Captcha() {
        frame = new JFrame("Picture Viewer");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        random = (int)(Math.random() * 5);

        if (random == 0) {
            try {
                // Open image file
                File imageFile = new File("C:\\Users\\Admin\\Desktop\\OOP\\image1.png");
                ImageIcon icon = new ImageIcon(imageFile.getAbsolutePath());
                Image image = icon.getImage();
                Image newimg = image.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(newimg);
                JLabel label = new JLabel();
                label.setIcon(icon);
                frame.add(label);
                correctAnswer = "J5OUK";
            } catch (Exception e) {
                System.out.println("Error displaying image: " + e.getMessage());
            }
        } else if (random == 1) {
            try {
                // Open image file
                File imageFile = new File("C:\\Users\\Admin\\Desktop\\OOP\\image2.png");
                ImageIcon icon = new ImageIcon(imageFile.getAbsolutePath());
                Image image = icon.getImage();
                Image newimg = image.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(newimg);
                JLabel label = new JLabel();
                label.setIcon(icon);
                frame.add(label);
                correctAnswer = "h51ekt";
            } catch (Exception e) {
                System.out.println("Error displaying image: " + e.getMessage());
            }
        } else if (random == 2) {
            try {
                // Open image file
                File imageFile = new File("C:\\Users\\Admin\\Desktop\\OOP\\image3.png");
                ImageIcon icon = new ImageIcon(imageFile.getAbsolutePath());
                Image image = icon.getImage();
                Image newimg = image.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(newimg);
                JLabel label = new JLabel();
                label.setIcon(icon);
                frame.add(label);
                correctAnswer = "Z25p76";
            } catch (Exception e) {
                System.out.println("Error displaying image: " + e.getMessage());
            }
        }
        else if (random == 3) {
            try {
                // Open image file
                File imageFile = new File("C:\\Users\\Admin\\Desktop\\OOP\\image4.png");
                ImageIcon icon = new ImageIcon(imageFile.getAbsolutePath());
                Image image = icon.getImage();
                Image newimg = image.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(newimg);
                JLabel label = new JLabel();
                label.setIcon(icon);
                frame.add(label);
                correctAnswer = "2iKL59";
            } catch (Exception e) {
                System.out.println("Error displaying image: " + e.getMessage());
            }
        }
        else if (random == 4) {
            try {
                // Open image file
                File imageFile = new File("C:\\Users\\Admin\\Desktop\\OOP\\image5.png");
                ImageIcon icon = new ImageIcon(imageFile.getAbsolutePath());
                Image image = icon.getImage();
                Image newimg = image.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(newimg);
                JLabel label = new JLabel();
                label.setIcon(icon);
                frame.add(label);
                correctAnswer = "OOP100";
            } catch (Exception e) {
                System.out.println("Error displaying image: " + e.getMessage());
            }
        }

        textField = new JTextField(20);
        frame.add(textField);

        JButton verifyButton = new JButton("Verify");
        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();

                if (input.equals(correctAnswer)) {
                    JOptionPane.showMessageDialog(frame, "Verification successful!");
                    System.out.print("Welcome");
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(frame, "Incorrect verification, please try again.");
                }
            }
        });
        frame.add(verifyButton);
        frame.setVisible(true);
    }

}





