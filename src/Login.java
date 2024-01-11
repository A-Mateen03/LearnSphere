import javax.swing.*;
import java.awt.*;
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

        JPasswordField password = new JPasswordField();
        password.setBorder(null);
        password.setBounds(465, 250, 250, 30); // Adjust the position and size


        JButton login = new JButton();
        login.setBounds(490,340,225,30);
        login.setOpaque(false);
        login.setContentAreaFilled(false);
        login.setBorderPainted(false);
        login.addActionListener(e -> {
            String enteredEmail = email.getText();
            char[] enteredPassword = password.getPassword();

            String passwordStr = new String(enteredPassword);

            System.out.println("Login Clicked");
            System.out.println("Email: " + enteredEmail);
            System.out.println("Password: " + passwordStr);

            DatabaseConnectivity db = new DatabaseConnectivity();
            if(db.authUser(enteredEmail,passwordStr)){

//                JOptionPane.showMessageDialog(panel,"Login Successfully!","Success", JOptionPane.INFORMATION_MESSAGE);
                UserProfile userProfile = new UserProfile(enteredEmail);
                ((Window) SwingUtilities.getWindowAncestor(panel)).dispose();

            }else{
                JOptionPane.showMessageDialog(panel,"Incorrect Email or Password or Maybe Account Doesnot Exists!","Error", JOptionPane.INFORMATION_MESSAGE);

            }

        });

        JButton Googlelogin = new JButton();
        Googlelogin.setBounds(490,400,225,30);
        Googlelogin.setOpaque(false);
        Googlelogin.setContentAreaFilled(false);
        Googlelogin.setBorderPainted(false);
        Googlelogin.addActionListener(e -> System.out.println("Google Login Clicked"));

        JButton RedirectToSignup = new JButton();
        RedirectToSignup.setBounds(620,480,60,30);
        RedirectToSignup.setOpaque(false);
        RedirectToSignup.setContentAreaFilled(false);
        RedirectToSignup.setBorderPainted(false);
        RedirectToSignup.addActionListener(e->{


            Signup signupScreen = new Signup();
            ((Window) SwingUtilities.getWindowAncestor(panel)).dispose();


        });


        panel.add(password);
        panel.add(email);
        panel.add(login);
        panel.add(Googlelogin);
        panel.add(RedirectToSignup);

        // Add the panel to the frame
        add(panel);

        // Make the frame visible
        setVisible(true);
    }

}


