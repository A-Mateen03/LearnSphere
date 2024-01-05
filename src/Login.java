import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    public Login() {
        setTitle("Login to LearnSphere");
        setSize(1236, 769);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        // Create a JPanel to hold the background image
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("./Assets/login.jpg");
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

        JButton login = new JButton();
        login.setBounds(490,340,225,30);
        login.setOpaque(false);
        login.setContentAreaFilled(false);
        login.setBorderPainted(false);
        login.addActionListener(e -> System.out.println("Login Clicked"));
        JButton Googlelogin = new JButton();
        Googlelogin.setBounds(490,400,225,30);
        Googlelogin.setOpaque(false);
        Googlelogin.setContentAreaFilled(false);
        Googlelogin.setBorderPainted(false);
        Googlelogin.addActionListener(e -> System.out.println("Google Login Clicked"));
        panel.add(login);
        panel.add(Googlelogin);
        // Add the panel to the frame
        add(panel);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login());
    }
}


