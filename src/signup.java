import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signup extends JFrame {

    public signup() {
        setTitle("Create a new account to LearnSphere");
        setSize(1236, 769);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        // Create a JPanel to hold the background image
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("./Assets/signup.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        JTextField email = new JTextField();
        email.setBorder(null);
        email.setBounds(459, 190, 250, 30); // Adjust the position and size
        panel.add(email);

        JPasswordField password = new JPasswordField();
        password.setBorder(null);
        password.setBounds(465, 250, 250, 30); // Adjust the position and size
        panel.add(password);

        JPasswordField Conpassword = new JPasswordField();
        Conpassword.setBorder(null);
        Conpassword.setBounds(465, 310, 250, 30); // Adjust the position and size
        panel.add(Conpassword);

        JButton signup = new JButton();
        signup.setBounds(490,430,225,30);
        signup.setOpaque(false);
        signup.setContentAreaFilled(false);
        signup.setBorderPainted(false);
        signup.addActionListener(e -> System.out.println("Signup Clicked"));
        JButton Googlesignup = new JButton();
        Googlesignup.setBounds(490,495,225,30);
        Googlesignup.setOpaque(false);
        Googlesignup.setContentAreaFilled(false);
        Googlesignup.setBorderPainted(false);
        Googlesignup.addActionListener(e -> System.out.println("Google Signup Clicked"));
        panel.add(signup);
        panel.add(Googlesignup);
        // Add the panel to the frame
        add(panel);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new signup());
    }
}


