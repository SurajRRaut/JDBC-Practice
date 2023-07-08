package basics_Of_JDBC.apply_JDBC;
// CREATE DATABASE APPLICATION...
import java.sql.*;

public class AddConnection {
    public static void main(String[] args) {
        // The Connection and Statement are the interfaces So we can not make the object of this So we are Take as a Reference (type of object)
        Connection con = null;
        Statement stmt =  null;
        // This is for When Display The Data(ResultSet Is a interface) >>
        ResultSet rc = null;
        String query = "insert into employee values(4,'RAJ',12.23)";
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
            // Create Platform> >
            stmt= con.createStatement();
            int count = stmt.executeUpdate(query);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
