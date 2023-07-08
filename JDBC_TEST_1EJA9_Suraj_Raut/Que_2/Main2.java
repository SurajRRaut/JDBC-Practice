package JDBC_TEST_1EJA9_Suraj_Raut.Que_2;

import java.sql.*;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER SUBJECT NAME");
        String sub_Name = sc.next();
        String query = "SELECT id,roll_no,NAMES,address,class marks_scored FROM student stu,subjects sub WHERE sub.marks_scored_ref=stu.marks_scored AND subject_name='"+sub_Name+"'";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt=con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
