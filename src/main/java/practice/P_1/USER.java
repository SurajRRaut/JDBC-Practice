package practice.P_1;

import java.sql.*;

public class USER {
    static String name = null;

    private static Connection con = null;
    static{
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean userLogin(String uName,String uPass){
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        String query = "select user_name,user_pass from redbuslogin where user_name=? and user_pass=?";
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,uName);
            pstmt.setString(2,uPass);
            rs=pstmt.executeQuery();
            if(rs.next()){
                name = rs.getString(1);
                String pass =rs.getString(2);
                if(name.equals(uName)&&pass.equals(uPass)){
                    return true;
                }
                else {
                    System.out.println("WRONG USERNAME OR PASSWORD");
                    return false;
                }
            }
            else {
                System.out.println("WRONG PASSWORD OR USER NAME");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void bookTicket(String bType, int sNumber, String gender, int age, int bRef) {
        PreparedStatement pstmt =null;
        String query = "insert into redbusapp values(?,?,?,?,?,?)";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,0);
            pstmt.setString(2,bType);
            pstmt.setInt(3,sNumber);
            pstmt.setString(4,gender);
            pstmt.setInt(5,age);
            pstmt.setInt(6,bRef);
            int count = pstmt.executeUpdate();
            if (count>0){
                System.out.println(count + " : TICKET CONFIRM BY "+name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
