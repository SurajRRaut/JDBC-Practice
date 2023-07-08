package basics_Of_JDBC.display;
// FETCH ALL DATA FRO EMPLOYEE TABLE
import java.sql.*;

public class D_1 {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "select * from employee";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            System.out.println("ID\tNAME\tSALARY");
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double salary = rs.getDouble(3);
                System.out.println(id+"\t"+name+"\t"+salary);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
