package relational_Operations;
// Display all records of customer and products table
import java.sql.*;

public class RO_2 {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt =  null;
        ResultSet rs = null;

        String query = "SELECT * FROM customer c INNER JOIN products p ON p.customer_ref=c.customer_id";

        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
            stmt= con.createStatement();
            rs=stmt.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t");
                System.out.println(rs.getInt(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getDouble(7)+"\t"+rs.getInt(8));
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
