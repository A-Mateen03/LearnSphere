import javax.swing.*;
import java.awt.*;

public class Signup extends JFrame {
    public Signup() {
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

        JPasswordField password = new JPasswordField();
        password.setBorder(null);
        password.setBounds(465, 250, 250, 30); // Adjust the position and size

        JPasswordField Conpassword = new JPasswordField();
        Conpassword.setBorder(null);
        Conpassword.setBounds(465, 310, 250, 30); // Adjust the position and size




        JButton signup = new JButton();
        signup.setBounds(490,430,225,30);
        signup.setOpaque(false);
        signup.setContentAreaFilled(false);
        signup.setBorderPainted(false);

        signup.addActionListener(e -> {
            String enteredEmail = email.getText();
            char[] enteredPassword = password.getPassword();
            char[] enteredConPassword = Conpassword.getPassword();

            String passwordStr = new String(enteredPassword);
            String conPasswordStr = new String(enteredConPassword);

            if (passwordStr.equals(conPasswordStr)) {
                System.out.println("Signup Clicked");
                System.out.println("Email: " + enteredEmail);
                System.out.println("Password: " + passwordStr);

                DatabaseConnectivity db = new DatabaseConnectivity();
                if(db.createUser(enteredEmail,passwordStr)) {
                    JOptionPane.showMessageDialog(panel,"Account Created Successfully!","Success", JOptionPane.INFORMATION_MESSAGE);
//                    Login RedirectToLogin = new Login();
                    SelectUserScreen su = new SelectUserScreen();
                    su.setEmail(enteredEmail);
                    ((Window) SwingUtilities.getWindowAncestor(panel)).dispose();
                }

            }else {
                System.out.println("Passwords do not match. Please re-enter.");
                JOptionPane.showMessageDialog(panel,"Password Does not Match","Error", JOptionPane.INFORMATION_MESSAGE);

            }



        });



        JButton Googlesignup = new JButton();
        Googlesignup.setBounds(490,495,225,30);
        Googlesignup.setOpaque(false);
        Googlesignup.setContentAreaFilled(false);
        Googlesignup.setBorderPainted(false);
        Googlesignup.addActionListener(e -> System.out.println("Google Signup Clicked"));

        JButton RedirectToLogin = new JButton();
        RedirectToLogin.setBounds(640,565,50,30);
        RedirectToLogin.setOpaque(false);
        RedirectToLogin.setContentAreaFilled(false);
        RedirectToLogin.setBorderPainted(false);
        RedirectToLogin.addActionListener(e->{

            Login RedirectToLoginScreen = new Login();
            ((Window) SwingUtilities.getWindowAncestor(panel)).dispose();


        });

        panel.add(email);
        panel.add(password);
        panel.add(Conpassword);
        panel.add(signup);
        panel.add(Googlesignup);
        panel.add(RedirectToLogin);
        add(panel);

        setVisible(true);
    }

}


