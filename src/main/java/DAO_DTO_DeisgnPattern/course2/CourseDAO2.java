package DAO_DTO_DeisgnPattern.course2;

import with_prepareStatement.Array_1;

import java.sql.*;
import java.util.ArrayList;

public class CourseDAO2 {
    static Connection con;
    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static final String insert ="insert into Courses values(?,?,?)";
    private static final String update ="update courses set course_name=?,course_id=? where course_id=1";
    private static final String delete = "delete from courses where course_id=?";
    private static final String display = "select * from courses where course_id =?";
    public static void insertRecord(CourseDTO2 cdto){
        ArrayList arr= new ArrayList<>();
        arr.add(cdto);
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            if(arr.contains("JAVA")){
                pstmt=con.prepareStatement(insert);
                pstmt.setInt(1,0);
                pstmt.setString(2,cdto.getCourse_name());
                pstmt.setDouble(3,cdto.getCourse_fees());
                int count = pstmt.executeUpdate();
                System.out.println("COURSE IS INSERTED");
            }
            else{
                System.out.println("COURSE NOT FOUND");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int updateRecord(CourseDTO2 cdto) {
        PreparedStatement pstmt;
        try {
            pstmt=con.prepareStatement(update);
            pstmt.setString(1,cdto.getCourse_name());
            pstmt.setDouble(2,cdto.getCourse_id());
            int count = pstmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteRecord(CourseDTO2 cdto) {
        PreparedStatement pstmt;
        try {
            pstmt=con.prepareStatement(delete);
            pstmt.setDouble(1,cdto.getCourse_id());
            int count = pstmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void display(CourseDTO2 cdto){
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            pstmt=con.prepareStatement(display);
            pstmt.setInt(1,cdto.getCourse_id());
            rs=pstmt.executeQuery();
            while(rs.next()){
                int cId = rs.getInt(1);
                String cName = rs.getString(2);
                double cFees = rs.getDouble(3);

                System.out.println(cId+"\t"+cName+"\t"+cFees);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
