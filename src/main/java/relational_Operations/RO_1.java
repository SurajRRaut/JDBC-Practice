package relational_Operations;
// DISPLAY ALL CUSTOMER DETAILS IN ASCENDING ORDER FROM CUSTOMER TABLE
import java.sql.*;
public class RO_1 {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt =  null;
        ResultSet rs = null;

        String query = "select * from customer order by customer_name desc";

        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
            stmt= con.createStatement();
            rs=stmt.executeQuery(query);
            System.out.println("CUST_ID\tCUST_NAME\tCUST_ADD");
            while (rs.next()){
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
