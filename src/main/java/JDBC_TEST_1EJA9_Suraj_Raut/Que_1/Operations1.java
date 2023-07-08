package JDBC_TEST_1EJA9_Suraj_Raut.Que_1;

import java.sql.*;
import java.util.Scanner;

public class Operations1 {
    static Connection con = null;
    static{
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/3datab","root","Suraj12345");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void insert(int roll_no,String name,String address,String clas,double marks_scored,String scode,String subject_name,double marks_scored_ref) {
        String query = "insert into student values(?,?,?,?,?)";
        String query2 ="insert into subjects values(?,?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt=con.prepareStatement(query);
            int count = pstmt.executeUpdate();
            if(count>0){
                System.out.println("DATA INSERTED IN STUDENT TABLE SUCCESSFULLY");
            }else {
                System.out.println("DATA NOT INSERTED IN STUDENT TABLE");
            }
            pstmt=con.prepareStatement(query2);
            int count2 = pstmt.executeUpdate();
            if(count>0){
                System.out.println("DATA INSERTED IN SUBJECTS TABLE SUCCESSFULLY");
            }else {
                System.out.println("DATA NOT INSERTED IN SUBJECTS TABLE");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void display() {
        String query = "SELECT * FROM student stu,subjects sub WHERE stu.marks_scored=sub.marks_scored_ref";
        PreparedStatement pstmt = null;
        ResultSet rs;
        try {
            pstmt=con.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()){
                System.out.print(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+" ");
                System.out.println(rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getDouble(9));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
