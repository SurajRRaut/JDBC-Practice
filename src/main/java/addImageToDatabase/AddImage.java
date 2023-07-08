package addImageToDatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class AddImage {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            FileInputStream fs = new FileInputStream("C:\\Users\\mulan\\OneDrive\\Desktop\\temp.jpg");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/2datab","root","Suraj12345");
            pstmt=con.prepareStatement("insert into addimage values(?,?,?)");
            pstmt.setInt(1,0);
            pstmt.setString(2,"TAJMAHAL");
            pstmt.setBlob(3,fs);
            int count =pstmt.executeUpdate();
            if(count>0){
                System.out.println("RECORD INSERTED SUCCESSFULLY");
            }
            else {
                System.out.println("RECORD NOT INSERTED SUCCESSFULLY");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
