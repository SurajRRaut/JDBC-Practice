package DAO_DTO_DeisgnPattern.course;

import java.sql.*;
import java.util.ArrayList;

public class CourseDAO {
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
    private static final String display = "select * from courses";
    public static int insertRecord(CourseDTO cdto){
        PreparedStatement pstmt;
        try {
            pstmt=con.prepareStatement(insert);
            pstmt.setInt(1,0);
            pstmt.setString(2,cdto.getCourse_name());
            pstmt.setDouble(3,cdto.getCourse_fees());
            int count = pstmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int updateRecord(CourseDTO cdto) {
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

    public int deleteRecord(CourseDTO cdto) {
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
//    public ArrayList<CourseDTO> display(){
//        PreparedStatement pstmt;
//        ResultSet rs;
//        ArrayList<CourseDTO> data = new ArrayList<>();
//        CourseDTO cdto =new CourseDTO();
//        try {
//            pstmt=con.prepareStatement(display);
//            rs=pstmt.executeQuery();
//            while(rs.next()){
//                cdto=new CourseDTO();
//                int id = rs.getInt(1);
//                String name = rs.getString(2);
//                double fees = rs.getDouble(3);
//                cdto.setCourse_id(id);
//                cdto.setCourse_name(name);
//                cdto.setCourse_fees(fees);
//                data.add(cdto);
//            }
//            return data;
//        }
//        catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public void display(){
        CourseDTO cdto = new CourseDTO();
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            pstmt=con.prepareStatement(display);
            rs=pstmt.executeQuery();
            while(rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double fees = rs.getDouble(3);
                cdto.setCourse_id(id);
                cdto.setCourse_name(name);
                cdto.setCourse_fees(fees);
                System.out.println(cdto.getCourse_id()+" "+cdto.getCourse_name()+" "+cdto.getCourse_fees());
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
