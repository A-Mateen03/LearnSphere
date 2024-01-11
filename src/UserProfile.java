import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;


public class UserProfile extends  JFrame{

    public  UserProfile (String email){

        DatabaseConnectivity db = new DatabaseConnectivity();
         userDataModel ud =   db.getUserData(email);

        setTitle("Profile");
        setSize(1236, 769);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("./Assets/user_profile_background.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        JLabel name = new JLabel("Hi " + ud.getName());
        name.setForeground(Color.WHITE); // Set text color to white
        name.setFont(new Font("Poppins", Font.BOLD, 30)); // Set font, size, and style
        name.setBounds(45, 25, 250, 45); // Adjust the position and size


//        JLabel ImageEllipse = new JLabel();
//        ImageIcon EllipseImageIcon = new ImageIcon("./Assets/profile_image_ellipse.png"); // Replace with the actual path to the user's image
//        Image ellipseImage = EllipseImageIcon.getImage();
//        Image scaledEllipseImage = ellipseImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH); // Adjust the size as needed
//        ImageEllipse.setIcon(new ImageIcon(scaledEllipseImage));
//        ImageEllipse.setBounds(1100, 20, 90, 90); // Adjust the position and size

        JLabel userProfileImage = new JLabel();
        if(ud.getProfileImage()!=null && ud.getProfileImage().length>0){
            ImageIcon userImageIcon = new ImageIcon(ud.getProfileImage()); // Replace with the actual path to the user's image
            Image userImage = userImageIcon.getImage();
            Image scaledUserImage = userImage.getScaledInstance(70, 70, Image.SCALE_SMOOTH); // Adjust the size as needed
            userProfileImage.setIcon(new ImageIcon(scaledUserImage));
            userProfileImage.setBounds(1110, 30, 70, 70); // Adjust the position and size

        }else{
            ImageIcon userImageIcon = new ImageIcon("./Assets/tester_avatar.png"); // Replace with the actual path to the user's image
            Image userImage = userImageIcon.getImage();
            Image scaledUserImage = userImage.getScaledInstance(70, 70, Image.SCALE_SMOOTH); // Adjust the size as needed
            userProfileImage.setIcon(new ImageIcon(scaledUserImage));
            userProfileImage.setBounds(1110, 30, 70, 70); // Adjust the position and size

        }

        JButton myCourses = new JButton();
        myCourses.setBounds(843,175,116,30);
        myCourses.setOpaque(false);
        myCourses.setContentAreaFilled(false);
        myCourses.setBorderPainted(false);
        myCourses.addActionListener(e -> System.out.println("My Courses Button Clicked"));

        JLabel timeScoreRemaining = new JLabel("46min");
        timeScoreRemaining.setForeground(Color.BLACK); // Set text color to white
        timeScoreRemaining.setFont(new Font("Poppins", Font.BOLD, 25)); // Set font, size, and style
        timeScoreRemaining.setBounds(278, 180, 165, 40); // Adjust the position and size

        JLabel totalTimeScore = new JLabel(" / 60min");
        totalTimeScore.setForeground(new Color(133, 133, 151)); // Set text color to white
        totalTimeScore.setFont(new Font("Poppins", Font.PLAIN, 18)); // Set font, size, and style
        totalTimeScore.setBounds(350, 185, 165, 40); // Adjust the position and size

        JButton allCourses = new JButton();
        allCourses.setBounds(485,275,73,28);
        allCourses.setOpaque(false);
        allCourses.setContentAreaFilled(false);
        allCourses.setBorderPainted(false);
        allCourses.addActionListener(e -> System.out.println("All Courses Button Clicked"));

        JButton popularCourses = new JButton();
        popularCourses.setBounds(575,275,73,28);
        popularCourses.setOpaque(false);
        popularCourses.setContentAreaFilled(false);
        popularCourses.setBorderPainted(false);
        popularCourses.addActionListener(e -> System.out.println("Popular Courses Button Clicked"));

        JButton newCourses = new JButton();
        newCourses.setBounds(665,275,73,28);
        newCourses.setOpaque(false);
        newCourses.setContentAreaFilled(false);
        newCourses.setBorderPainted(false);
        newCourses.addActionListener(e -> System.out.println("New Courses Button Clicked"));

        //Left Scrollpanel
        ScrollBarCustom sp = new ScrollBarCustom();
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane();
        scroll.setBounds(371,362,520,390);
        DefaultListModel<JLabel> listModel = new DefaultListModel<>();
        JList jList1 =  new javax.swing.JList<>();
        sp.setForeground(new Color(110, 183, 22));
        scroll.setBorder(null);


        for (int i = 0; i < 20; i++) {
            JLabel productBackground = new JLabel();
            ImageIcon productBackgroundIcon = new ImageIcon("./Assets/product_background.jpg");
            Image productBackgroundImage = productBackgroundIcon.getImage();
            Image scaledProductBackgroundImage = productBackgroundImage.getScaledInstance(500, 121, Image.SCALE_SMOOTH);
            productBackground.setIcon(new ImageIcon(scaledProductBackgroundImage));
            productBackground.setBounds(50, 0, 500, 121);
            listModel.addElement(productBackground);
        }
        jList1.setModel(listModel);
        jList1.setCellRenderer(new LabelListRenderer());
        jList1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Handle the selected item here
                    int selectedIndex = jList1.getSelectedIndex();
                    if (selectedIndex != -1) {
                        System.out.println("Item clicked: " + selectedIndex);
                        // Add your logic for handling the selected item
                    }
                }
            }
        });

        scroll.setViewportView(jList1);
        scroll.setVerticalScrollBar(sp);




        panel.add(name);
        panel.add(userProfileImage);
//        panel.add(ImageEllipse);
        panel.add(timeScoreRemaining);
        panel.add(totalTimeScore);
        panel.add(myCourses);
        panel.add(allCourses);
        panel.add(popularCourses);
        panel.add(scroll);
        panel.add(newCourses);


        add(panel);
        setVisible(true);
    }
    private class LabelListRenderer implements ListCellRenderer<JLabel> {
        @Override
        public Component getListCellRendererComponent(JList<? extends JLabel> list, JLabel value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            value.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 0)); // Add left margin to JLabel
            return value;
        }
    }




}

