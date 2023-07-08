package addImageToDatabase;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class DisplayImage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        System.out.println("ENTER FILE NAME");
        String fileName = sc.next();
        try {
            FileOutputStream fout = new FileOutputStream("C:\\Users\\mulan\\OneDrive\\Desktop\\"+fileName+".jpg");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/2datab","root","Suraj12345");
            pstmt=con.prepareStatement("select * from addimage");
            rs = pstmt.executeQuery();
            Blob blob;
            byte [] b = new byte[0];
            if(rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                blob=rs.getBlob(3);
                b=blob.getBytes(1,(int)blob.length());
                fout.write(b);
                fout.close();
            }
            System.out.println(b.length);
            System.out.println(Arrays.toString(b));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
