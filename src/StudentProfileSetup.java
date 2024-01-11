import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class StudentProfileSetup extends JFrame{
    private String email;
    private String selectedImagePath;
    public void setEmail(String email){
        this.email = email;
    }
    public StudentProfileSetup(){
        setTitle("Setup your Student Account");
        setSize(1236, 769);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        // Create a JPanel to hold the background image
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("./Assets/student_profile_setup_background.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);


        JLabel image = new JLabel();
        image.setBounds(570,165,100,100);
        image.setIcon(new ImageIcon("./Assets/insert_image_icon.png"));
//        image.setVisible(false);


        JButton imageButton = new JButton();
        imageButton.setBounds(580,175,70,70);
        imageButton.setOpaque(false);
        imageButton.setContentAreaFilled(false);
        imageButton.setBorderPainted(false);

        imageButton.addActionListener(e -> {
            // Open a file chooser dialog to select an image
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
            fileChooser.setFileFilter(filter);

            int result = fileChooser.showOpenDialog(image);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
              // Store the selected image path

                selectedImagePath = selectedFile.getPath();


                // Set the selected image on the button
                ImageIcon icon = new ImageIcon(selectedFile.getPath());
                Image scaledImage = icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);

                image.setIcon(new ImageIcon(scaledImage));
                image.setVisible(true);
                imageButton.setVisible(false);
            }
        });

        JTextField name = new JTextField();
        name.setBorder(null);
        name.setBounds(274, 294, 250, 30); // Adjust the position and size

        JTextField phoneNo = new JTextField();
        phoneNo.setBorder(null);
        phoneNo.setBounds(674, 294, 250, 30); // Adjust the position and size


        JTextField education = new JTextField();
        education.setBorder(null);
        education.setBounds(470, 392, 250, 30); // Adjust the position and size

        JButton submit = new JButton();
        submit.setBounds(500,485,228,44);
        submit.setOpaque(false);
        submit.setContentAreaFilled(false);
        submit.setBorderPainted(false);
        submit.addActionListener(e->{
            String enteredName = name.getText();
            String enteredPhoneNo = phoneNo.getText();
            String enteredEducation = education.getText();
            String enteredImage ="";
            if(image.isVisible()) {
                enteredImage = selectedImagePath;
            }


            //Implement Database Logic

            DatabaseConnectivity db = new DatabaseConnectivity();
            if(db.insertStudentDetails(email,enteredName,enteredEducation,enteredPhoneNo,enteredImage)){
                JOptionPane.showMessageDialog(panel,"Account Setup Successfully!","Success", JOptionPane.INFORMATION_MESSAGE);

            }else{
                JOptionPane.showMessageDialog(panel,"Not Valid Credentials","Error", JOptionPane.INFORMATION_MESSAGE);

            }


            Login lg = new Login();
            ((Window) SwingUtilities.getWindowAncestor(panel)).dispose();


        });


        panel.add(imageButton);
        panel.add(image);
        panel.add(name);
        panel.add(phoneNo);
        panel.add(education);
        panel.add(submit);
        add(panel);

        // Make the frame visible
        setVisible(true);
    }


}
