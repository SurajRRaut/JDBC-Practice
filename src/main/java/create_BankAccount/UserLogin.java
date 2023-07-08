package create_BankAccount;
// LOGIN
import java.sql.*;
import java.util.Scanner;
public class UserLogin {
    static Scanner sc = new Scanner(System.in);
    static String userName=null;
    static int accountnumber =0;
    static double accBalance = 0.0;
    static Connection con = null;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean validateLogin(String username, String pass) {
        String query = "select * from userlogin where user_name=? and user_passward = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,username);
            pstmt.setString(2,pass);
            rs=pstmt.executeQuery();
            if(rs.next()){
                userName=rs.getString(2);
                String userPaas =rs.getString(3);
                accountnumber=rs.getInt(1);
                if(userName.equals(username) && userPaas.equals(pass)){
                    return true;
                }
                else {
                    return false;
                }
            }else{
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static double checkBalance(){
        String query = "SELECT total_amount FROM bankptrassbook FULL JOIN userlogin ON account_no=acc_no WHERE account_no = ? ORDER BY transaction_id DESC LIMIT 1";
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,accountnumber);
            rs=pstmt.executeQuery();
            if(rs.next()){
                accBalance=rs.getDouble(1);
                System.out.println("ACCOUNT BALANCE IS "+rs.getDouble(1));
            }
            else{
                System.out.println("SOMETHING WENT WRONG");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accBalance;
    }

    public static void withdraw(double amt1) {
        accBalance=checkBalance();
        String query = "insert into pankptrassbook values(?,?,?,?,?)";
        PreparedStatement pstmt = null;

        try {
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,0);
            pstmt.setDouble(2,amt1-accBalance);
            pstmt.setDouble(3,0);
            pstmt.setDouble(4,amt1);
            pstmt.setInt(5,accountnumber);
            int count =pstmt.executeUpdate();
            if (count>0){
                System.out.println(amt1 + "Withdraw successfully");
            }
            else{
                System.out.println("SOMETHING WENT WRONG");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deposite(double amt) {
        accBalance=checkBalance();
        String query = "insert into bankptrassbook values(?,?,?,?,?)";
        PreparedStatement pstmt = null;

        try {
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,0);
            pstmt.setDouble(2,(amt+accBalance));
            pstmt.setDouble(3,amt);
            pstmt.setDouble(4,0);
            pstmt.setInt(5,accountnumber);
            int count =pstmt.executeUpdate();
            if (count>0){
                System.out.println(amt + " deposted successfully");
            }
            else{
                System.out.println("SOMETHING WENT WRONG");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void statement() {
        String query = "SELECT * FROM bankptrassbook where acc_no="+accountnumber;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        try {
            pstmt=con.prepareStatement(query);
            rs=pstmt.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt(1)+"\t"+rs.getDouble(2)+"\t"+rs.getDouble(3)+"\t"+rs.getDouble(4)+"\t"+rs.getInt(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
