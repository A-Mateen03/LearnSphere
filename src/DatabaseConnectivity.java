
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DatabaseConnectivity {
    public  boolean createUser(String email,String password){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12674980", "sql12674980", "LsV86DNGuQ");
            System.out.println("Connection Established Successfully!");
            Statement stm = conn.createStatement();
            String query = "INSERT INTO users (email, password) VALUES ('" + email + "', '" + password + "')";
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
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error!");
            return false;
        }
        return false;
    }
}
