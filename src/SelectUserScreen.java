import javax.swing.*;
import java.awt.*;

public class SelectUserScreen extends JFrame {
    private String email;
    public void setEmail(String email){
        this.email = email;
    }
    public SelectUserScreen(){

        setTitle("Setup your Account");
        setSize(1236, 769);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        // Create a JPanel to hold the background image
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("./Assets/setup_account_background.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        JButton Educator = new JButton();
        Educator.setBounds(455,265,305,110);
        Educator.setOpaque(false);
        Educator.setContentAreaFilled(false);
        Educator.setBorderPainted(false);

        Educator.addActionListener(e->{
            System.out.println("Educator Button Clicked");
        });

        JButton Learner = new JButton();
        Learner.setBounds(455,403,305,110);
        Learner.setOpaque(false);
        Learner.setContentAreaFilled(false);
        Learner.setBorderPainted(false);

        Learner.addActionListener(e->{
            StudentProfileSetup sp = new StudentProfileSetup();
            sp.setEmail(email);
            ((Window) SwingUtilities.getWindowAncestor(panel)).dispose();
            System.out.println("Learner Button Clicked");
        });

        panel.setLayout(null);
        panel.add(Educator);
        panel.add(Learner);


        add(panel);
        setVisible(true);

    }


}
