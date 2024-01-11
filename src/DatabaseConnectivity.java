
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

public class DatabaseConnectivity {
    public  boolean createUser(String email,String password){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12674980", "sql12674980", "LsV86DNGuQ");
            System.out.println("Connection Established Successfully!");
            Statement stm = conn.createStatement();
//            String query = "INSERT INTO users (email, password) VALUES ('" + email + "', '" + password + "')";
            String query = "INSERT INTO users (email, password, name, education, phoneNo, profileImage) " +
                    "VALUES ('" + email + "', '" + password + "', NULL, NULL, NULL, NULL)";

            stm.execute(query);
            System.out.println("Data Inserted Successfully!");
            conn.close();
            return  true;
        }
        catch (Exception e){
            System.out.println(e);

            System.out.println("Error!");
            return false;
        }
    }
    public boolean authUser(String email,String password) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12674980", "sql12674980","LsV86DNGuQ");
            System.out.println("Connection Established Successfully!");
            Statement stm = conn.createStatement();
            String query = "SELECT * FROM users WHERE email = '" + email + "' AND password = '" + password + "'";
            ResultSet result = stm.executeQuery(query);
            String DBemail = "",DBpassword = "";
            while (result.next()) {
                 DBemail = result.getString(2);
                 DBpassword = result.getString(3);
            }
            conn.close();
            if(DBemail.equals(email) && DBpassword.equals(password)){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error!");
            return false;
        }
    }
    public boolean insertStudentDetails(String email, String name, String education, String phoneNo, String imageUrl) {
              String DB_URL = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12674980";
              String DB_USER = "sql12674980";
              String DB_PASSWORD = "LsV86DNGuQ";
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                System.out.println("Connection Established Successfully!");

                File imageFile = new File(imageUrl);
                byte[] imageBytes = new byte[(int) imageFile.length()];
                try (FileInputStream fis = new FileInputStream(imageFile)) {
                    fis.read(imageBytes);
                }

                // Update data in the database
                String sql = "UPDATE users SET name = ?, education = ?, phoneNo = ?, profileImage = ? WHERE email = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, education);
                    preparedStatement.setString(3, phoneNo);
                    preparedStatement.setBytes(4, imageBytes);
                    preparedStatement.setString(5, email);

                    int rowsUpdated = preparedStatement.executeUpdate();

                    if (rowsUpdated > 0) {
                        System.out.println("Data updated successfully.");
                        return true;

                    } else {
                        System.out.println("No record found with the specified email.");
                        return false;

                    }

                }
            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    public userDataModel getUserData(String email){
        System.out.println(email);

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12674980", "sql12674980","LsV86DNGuQ");
            System.out.println("Connection Established Successfully!");
            Statement stm = conn.createStatement();
            String query = "SELECT * FROM users WHERE email = '" + email + "'";
            ResultSet result = stm.executeQuery(query);
            int DBid=0;
            String DBemail = "",DBpassword = "",DBname="",DBeducation="",DBphoneNo="";
            byte[] imageBytes=null;
            while (result.next()) {
                DBid = result.getInt(1);
                DBemail = result.getString(2);
                DBpassword = result.getString(3);
                DBname = result.getString(4);
                DBeducation = result.getString(5);
                DBphoneNo =result.getString(6);
                imageBytes = result.getBytes(7);

            }
            conn.close();

                userDataModel ud = new userDataModel();
                ud.setId(DBid);
                ud.setName(DBname);
                ud.setEmail(DBemail);
                ud.setPassword(DBpassword);
                ud.setEducation(DBeducation);
                ud.setPhoneNo(DBphoneNo);
                ud.setProfileImage(imageBytes);
                return ud;


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error!");

        }
       return null;
    }


}

